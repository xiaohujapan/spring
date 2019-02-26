package org.dxh.spring.website.plugins;

import java.util.List;
import java.util.Properties;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;    
  

public class SerializablePlugin extends PluginAdapter {    
    
    private FullyQualifiedJavaType serializable;    
    private FullyQualifiedJavaType gwtSerializable;    
    private boolean addGWTInterface;    
    private boolean suppressJavaInterface;    
    
    public SerializablePlugin() {    
        super();    
        serializable = new FullyQualifiedJavaType("java.io.Serializable");   
        gwtSerializable = new FullyQualifiedJavaType("com.google.gwt.user.client.rpc.IsSerializable");  
    }    
    
    public boolean validate(List<String> warnings) {    
        // this plugin is always valid    
        return true;    
    }    
    
    @Override    
    public void setProperties(Properties properties) {    
        super.setProperties(properties);    
        addGWTInterface = Boolean.valueOf(properties.getProperty("addGWTInterface")); 
        suppressJavaInterface = Boolean.valueOf(properties.getProperty("suppressJavaInterface")); 
    }    
    
    @Override    
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,IntrospectedTable introspectedTable) {  
        makeSerializable(topLevelClass, introspectedTable);    
          
        return true;    
    }    
    
    @Override    
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {    
        makeSerializable(topLevelClass, introspectedTable);    
        return true;    
    }    
    
    @Override    
    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {    
        makeSerializable(topLevelClass, introspectedTable);    
        return true;    
    }    
    
    @Override    
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,IntrospectedTable introspectedTable){    
        makeSerializable(topLevelClass, introspectedTable);    
    
        for (InnerClass innerClass : topLevelClass.getInnerClasses()) {    
            if ("GeneratedCriteria".equals(innerClass.getType().getShortName())) { //$NON-NLS-1$    
                innerClass.addSuperInterface(serializable);    
            }    
            if ("Criteria".equals(innerClass.getType().getShortName())) { //$NON-NLS-1$    
                innerClass.addSuperInterface(serializable);    
            }    
            if ("Criterion".equals(innerClass.getType().getShortName())) { //$NON-NLS-1$    
                innerClass.addSuperInterface(serializable);  
            }    
        }  
        return true;    
    }    
    
    protected void makeSerializable(TopLevelClass topLevelClass,    
                                    IntrospectedTable introspectedTable) {    
        if (addGWTInterface) {    
            topLevelClass.addImportedType(gwtSerializable);    
            topLevelClass.addSuperInterface(gwtSerializable);    
        }    
    
        if (!suppressJavaInterface) {    
            topLevelClass.addImportedType(serializable);    
            topLevelClass.addSuperInterface(serializable);    
    
            Field field = new Field();    
            field.setFinal(true);    
            field.setInitializationString("1L"); //$NON-NLS-1$    
            field.setName("serialVersionUID"); //$NON-NLS-1$    
            field.setStatic(true);    
            field.setType(new FullyQualifiedJavaType("long")); //$NON-NLS-1$    
            field.setVisibility(JavaVisibility.PRIVATE);    
            context.getCommentGenerator().addFieldComment(field, introspectedTable);    
    
            topLevelClass.addField(field);    
        }    
    }    
}    
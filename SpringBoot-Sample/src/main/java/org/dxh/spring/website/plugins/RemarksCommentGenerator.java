package org.dxh.spring.website.plugins;
  
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;  

/**
 * Class Name		: RemarksCommentGenerator<br>
 * Description		: データベースのコメントの追加<br>
 * @author Link BIt Consulting
 * @version $Id: RemarksCommentGenerator.java,v 1.1 2019/02/26 07:47:51 tou_2 Exp $
 * @see
 * @since   2018/01/05
 */
public class RemarksCommentGenerator extends DefaultCommentGenerator {  
  
    @Override  
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {  
        topLevelClass.addJavaDocLine("/**");  
        topLevelClass.addJavaDocLine(" * Class Name	: " +  " <br />");  
        topLevelClass.addJavaDocLine(" * Description : テーブル" + introspectedTable.getFullyQualifiedTable());  
        topLevelClass.addJavaDocLine(" * @since "+new SimpleDateFormat("yyyy/MM/dd").format(new Date()));  
        topLevelClass.addJavaDocLine(" * @author Link BIt Consulting ");  
        topLevelClass.addJavaDocLine(" */");  
    }  
  
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {  
        String remark = introspectedColumn.getRemarks();  
        String columnName = introspectedColumn.getActualColumnName();  
        List<IntrospectedColumn> primaryKey = introspectedTable.getPrimaryKeyColumns();  
        for (IntrospectedColumn pk : primaryKey) {  
            if(columnName.equals(pk.getActualColumnName())){  
                remark +=" (PK)";  
                continue;   
            }  
            if (StringUtility.stringHasValue(remark)) {  
                remark += introspectedColumn.isNullable() ? "(必須)" : "(非必須)";  
            }  
        }  
        String defaultValue = introspectedColumn.getDefaultValue();  
        remark += null != defaultValue ? "  (デフォルト: "+defaultValue+")" : " (デフォルトなし)";  
        field.addJavaDocLine("/** "+ remark+" */");  
    }  
}  
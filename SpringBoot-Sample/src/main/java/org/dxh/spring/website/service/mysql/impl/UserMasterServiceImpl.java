package org.dxh.spring.website.service.mysql.impl;

import java.util.List;

import javax.sql.DataSource;

import org.dxh.spring.website.annotation.MyDataSource;
import org.dxh.spring.website.constants.DataSourceType;
import org.dxh.spring.website.entity.umajin.UserMaster;
import org.dxh.spring.website.mapper.umajin.UserMasterMapper;
import org.dxh.spring.website.service.mysql.UserMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserMasterServiceImpl implements UserMasterService{
	 
	@Autowired
    private UserMasterMapper userMasterMapper;
	
	@Autowired
	DataSource dataSource;
	
	@MyDataSource(DataSourceType.DB_Master)
	//@Transactional
	public List<UserMaster> listMasterAll(){	
		
		System.out.println(dataSource.toString());
		return userMasterMapper.selectByExample(null);
	};
	
	@MyDataSource(DataSourceType.DB_Slave)
	public List<UserMaster> listSlaveAll(){
		return userMasterMapper.selectByExample(null);
	};
	
	@MyDataSource(DataSourceType.DB_Master)
	@Transactional
	public int insertUserMaster(UserMaster record) {
		UserMaster record2 = new UserMaster();
		record2.setNickname("業務テスト");
		record2.setUser_id(503301);
		userMasterMapper.updateByPrimaryKeySelective(record);
		int result =  userMasterMapper.insert(record);
		return result;
	}
	
	@MyDataSource(DataSourceType.DB_Slave)
	public PageInfo<UserMaster> getListByPage(int pageNum,int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<UserMaster> umajinList = userMasterMapper.selectByExample(null);
		PageInfo<UserMaster>  pageInfo = new PageInfo<UserMaster>(umajinList);
		return pageInfo;
	}
	
}




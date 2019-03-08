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
}




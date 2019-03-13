package org.dxh.spring.website.service.impl;

import java.util.List;

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
	
	@MyDataSource(DataSourceType.DB_Master)
	//@Transactional
	public List<UserMaster> listMasterAll(){
		return userMasterMapper.selectByExample(null);
	};
	
	@MyDataSource(DataSourceType.DB_Slave)
	public List<UserMaster> listSlaveAll(){
		return userMasterMapper.selectByExample(null);
	};
}




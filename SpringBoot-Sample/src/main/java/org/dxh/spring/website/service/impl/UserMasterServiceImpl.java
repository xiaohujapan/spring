package org.dxh.spring.website.service.impl;

import java.util.List;

import org.dxh.spring.website.annotation.TargetDataSource;
import org.dxh.spring.website.configuration.DataSourceKey;
import org.dxh.spring.website.entity.umajin.UserMaster;
import org.dxh.spring.website.mapper.umajin.UserMasterMapper;
import org.dxh.spring.website.service.UserMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userMaster")
public class UserMasterServiceImpl implements UserMasterService{
	@Autowired
    private UserMasterMapper userMasterMapper;
	
	@TargetDataSource(dataSourceKey = DataSourceKey.DB_SLAVE)
	public List<UserMaster> listAll(){
		
		return userMasterMapper.selectByExample(null);
	};
}



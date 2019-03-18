package org.dxh.spring.website.service.mysql;

import java.util.List;

import org.dxh.spring.website.entity.umajin.UserMaster;

import com.github.pagehelper.PageInfo;

public interface UserMasterService {
	List<UserMaster> listMasterAll();
	
	List<UserMaster> listSlaveAll();
	
	int insertUserMaster(UserMaster record);
	
	PageInfo<UserMaster> getListByPage(int pageNum,int pageSize);
}

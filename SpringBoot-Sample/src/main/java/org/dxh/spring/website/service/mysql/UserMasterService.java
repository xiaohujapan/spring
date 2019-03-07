package org.dxh.spring.website.service.mysql;

import java.util.List;

import org.dxh.spring.website.entity.umajin.UserMaster;

public interface UserMasterService {
	List<UserMaster> listMasterAll();
	
	List<UserMaster> listSlaveAll();
}

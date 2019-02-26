package org.dxh.spring.website;

import org.dxh.spring.website.service.UserMasterService;
import org.springframework.beans.factory.annotation.Autowired;

public class Test{
	@Autowired
    private UserMasterService userService;
	
	
    
	public void print() {
		/**
		List<UserMaster> list = userService.listAll();
		for(UserMaster user:list) {
			System.out.println("userId = " + user.getUser_id());
		}
		**/
	}
}


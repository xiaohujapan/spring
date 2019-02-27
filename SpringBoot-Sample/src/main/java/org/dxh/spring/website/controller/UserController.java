package org.dxh.spring.website.controller;

import java.util.List;

import org.dxh.spring.website.entity.umajin.UserMaster;
import org.dxh.spring.website.service.UserMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserMasterService userMasterService;
	
    @RequestMapping(value = "/")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/printM")
    @ResponseBody
    public String showMaster() {
    	String strResult = "Master{";
		List<UserMaster> list = userMasterService.listMasterAll();
		for(UserMaster user:list) {
			strResult = strResult +",[userId=" + user.getUser_id()
					+ ",userName = " + user.getNickname() +  "]";
		}
		strResult = strResult+ "}";
        return strResult;
    }
    
    
    @RequestMapping(value = "/printS")
    @ResponseBody
    public String showSlave() {
    	String strResult = "Slave{";
    	List<UserMaster> list = userMasterService.listSlaveAll();
		for(UserMaster user:list) {
			strResult = strResult +",[userId=" + user.getUser_id()
					+ ",userName = " + user.getNickname() +  "]";
		}		
		strResult = strResult+ "}";
        return strResult;
    }
	
}
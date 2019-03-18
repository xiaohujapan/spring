package org.dxh.spring.website.controller;

import java.util.List;
import java.util.Map;

import org.dxh.spring.website.constants.RedisSourceType;
import org.dxh.spring.website.entity.umajin.UserMaster;
import org.dxh.spring.website.service.mysql.UserMasterService;
import org.dxh.spring.website.service.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

@RestController
public class UserController {
	@Autowired
	private UserMasterService userMasterService;
	
	@Autowired
	private RedisService redisService;
	
    @RequestMapping(value = "/")
    @ResponseBody
    public String hello() {
        return "hello";
    }
    
    @RequestMapping(value = "/printR")
    @ResponseBody
    public String showRedis() {
    	String strResult = "Redis{";
    	List<Map<Object,Object>> userList =  redisService.getList(RedisSourceType.SESSION_DB);
    	for(Map<Object,Object> userMap:userList) {
    		strResult = strResult + "," + userMap.get("loginId");
    	}
    	strResult = strResult + "｝";
        return strResult;
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
    
    @RequestMapping(value = "/updateM")
    @ResponseBody
    public String updateMaster() {
    	String strResult = "Master{";
    	UserMaster record = new UserMaster();
    	record.setUser_id(503377);
    	record.setAge(0);
    	record.setNickname("業務テスト１２３");
    	userMasterService.insertUserMaster(record);
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
    
    @RequestMapping(value = "/printPage")
    @ResponseBody
    public String printPage() {
    	String strResult = "Master{";
    	PageInfo<UserMaster> pageInfo = userMasterService.getListByPage(2, 10);
    	strResult = strResult + pageInfo.toString() + "｝";
        return strResult;
    }
	
}
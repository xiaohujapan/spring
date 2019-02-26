package org.dxh.spring.website.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	//注入Spring容器中的Bean对象
	private UserDAO userDAO;
	
	public List<User> queryUserList(){
		return this.userDAO.queryUserList();
	}
}

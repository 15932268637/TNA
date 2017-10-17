package com.liu.tna.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.tna.dao.UserDAO;
import com.liu.tna.exception.TnaException;
import com.liu.tna.model.User;

@Service
public class UserService {
	@Resource
	private UserDAO userDAO;
	
	//登录
	public User login(String username , String password) throws TnaException {
		return userDAO.selectUser(username, password);
	}
	
	//注册
	public User register(String username , String password, String name , String idnumber , String telno) {
		User user = new User(username, password, name, idnumber, telno);
		int uid = userDAO.saveUser(user);
		user.setUid(uid);
		
		return user;
	}
	
	//修改个人信息
	public User modifyUser(int uid , String username , String password , String name , String idnumber , String telno) {
		User user = new User(uid, username, password, name, idnumber, telno);
		userDAO.updateUser(user);
		
		return user;
	}
}

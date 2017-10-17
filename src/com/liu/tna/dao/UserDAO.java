package com.liu.tna.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.liu.tna.exception.TnaException;
import com.liu.tna.model.User;

@Repository
public class UserDAO {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	//登录
	public User selectUser(String username , String password) throws TnaException {
		List<User> users = hibernateTemplate.find("from User where username=? and password=?" ,new Object[]{username,password} );
	    //登录失败
		if(users.isEmpty()) {
			throw new TnaException("未找到用户");
		}
		
		return users.get(0);
	}
	
	//保存考生信息
	public int saveUser(User user) {
		return (int)hibernateTemplate.save(user);
	}
	
	//修改个人信息
	public void updateUser(User user) {
		hibernateTemplate.update(user);
	}
	
	//查询所有用户信息
	public List<User> selectAll() {
		return hibernateTemplate.find("from User");
	}
}

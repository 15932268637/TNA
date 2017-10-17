package com.liu.tna.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.liu.tna.exception.TnaException;
import com.liu.tna.model.Admin;
import com.liu.tna.model.User;

@Repository
public class AdminDAO {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	//登录
	public Admin selectAdmin(String username , String password) throws TnaException {
		List<Admin> admin = hibernateTemplate.find("from Admin where username=? and password=?" ,new Object[]{username,password} );
	    //登录失败
		if(admin.isEmpty()) {
			throw new TnaException("未找到用户");
		}
		
		return admin.get(0);
	}
	
	//保存考生信息
	public int saveAdmin(Admin admin) {
		return (int)hibernateTemplate.save(admin);
	}
	
	//修改个人信息
	public void updateAdmin(Admin admin) {
		hibernateTemplate.update(admin);
	}
}

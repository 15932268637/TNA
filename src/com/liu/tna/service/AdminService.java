package com.liu.tna.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.tna.dao.AdminDAO;
import com.liu.tna.exception.TnaException;
import com.liu.tna.model.Admin;

@Service
public class AdminService {
	@Resource
	private AdminDAO adminDAO;
	
	//��¼
	public Admin login(String username , String password) throws TnaException {
		return adminDAO.selectAdmin(username, password);
	}
	
	//ע��
	public Admin register(String username , String password) {
		Admin admin = new Admin(username, password);
		int id = adminDAO.saveAdmin(admin);
		admin.setId(id);
		
		return admin;
	}
	
	//�޸ĸ�����Ϣ
	public Admin modifyUser(int id , String username , String password) {
		Admin admin = new Admin(id, username, password);
		adminDAO.updateAdmin(admin);
		
		return admin;
	}
}

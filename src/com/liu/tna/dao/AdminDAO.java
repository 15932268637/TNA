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
	
	//��¼
	public Admin selectAdmin(String username , String password) throws TnaException {
		List<Admin> admin = hibernateTemplate.find("from Admin where username=? and password=?" ,new Object[]{username,password} );
	    //��¼ʧ��
		if(admin.isEmpty()) {
			throw new TnaException("δ�ҵ��û�");
		}
		
		return admin.get(0);
	}
	
	//���濼����Ϣ
	public int saveAdmin(Admin admin) {
		return (int)hibernateTemplate.save(admin);
	}
	
	//�޸ĸ�����Ϣ
	public void updateAdmin(Admin admin) {
		hibernateTemplate.update(admin);
	}
}

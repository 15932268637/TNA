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
	
	//��¼
	public User selectUser(String username , String password) throws TnaException {
		List<User> users = hibernateTemplate.find("from User where username=? and password=?" ,new Object[]{username,password} );
	    //��¼ʧ��
		if(users.isEmpty()) {
			throw new TnaException("δ�ҵ��û�");
		}
		
		return users.get(0);
	}
	
	//���濼����Ϣ
	public int saveUser(User user) {
		return (int)hibernateTemplate.save(user);
	}
	
	//�޸ĸ�����Ϣ
	public void updateUser(User user) {
		hibernateTemplate.update(user);
	}
	
	//��ѯ�����û���Ϣ
	public List<User> selectAll() {
		return hibernateTemplate.find("from User");
	}
}

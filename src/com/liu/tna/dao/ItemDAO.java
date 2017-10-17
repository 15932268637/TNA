package com.liu.tna.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.liu.tna.model.Item;

@Repository
public class ItemDAO {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	//��ѯ���е���Ŀ
	public List<Item> selectAll() {
		return hibernateTemplate.find("from Item");
	}
	
	//�����Ŀ
	public void addItem(Item item) {
		hibernateTemplate.save(item);
	}
	
	//ɾ����Ŀ
	public void deleteItem(int qid) {
		Item item = hibernateTemplate.get(Item.class, qid);
		hibernateTemplate.delete(item);
	}
	
	//��qid��ѯ��Ŀ
	public Item selectItem(int qid) {
		return hibernateTemplate.get(Item.class, qid);
	}
	
	//�޸���Ŀ
	public void updateItem(Item item) {
		hibernateTemplate.update(item);
	}
}
 
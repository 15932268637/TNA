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
	
	//查询所有的题目
	public List<Item> selectAll() {
		return hibernateTemplate.find("from Item");
	}
	
	//添加题目
	public void addItem(Item item) {
		hibernateTemplate.save(item);
	}
	
	//删除题目
	public void deleteItem(int qid) {
		Item item = hibernateTemplate.get(Item.class, qid);
		hibernateTemplate.delete(item);
	}
	
	//按qid查询题目
	public Item selectItem(int qid) {
		return hibernateTemplate.get(Item.class, qid);
	}
	
	//修改题目
	public void updateItem(Item item) {
		hibernateTemplate.update(item);
	}
}
 
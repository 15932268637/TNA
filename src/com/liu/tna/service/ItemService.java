package com.liu.tna.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.tna.dao.ItemDAO;
import com.liu.tna.model.Item;

@Service
public class ItemService {
	@Resource
	private ItemDAO itemDAO;
	
	//查询所有试题
	public List<Item> getAllItems() {
		return itemDAO.selectAll();
	}
	
	//添加题目
	public Item saveItem(String question , String optionA , String optionB , String optionC , String optionD , String answer) {
		Item item = new Item(question, optionA, optionB, optionC, optionD, answer);
		itemDAO.addItem(item);
		return item;
	}
	
	//删除题目
	public void removeItem(int qid) {
		itemDAO.deleteItem(qid);
	}
	
	//按qid查询题目
	public Item getItem(int qid) {
		return itemDAO.selectItem(qid);
	}
	
	//修改题目
	public void modifyItem(int qid,String question , String optionA , String optionB , String optionC , String optionD , String answer) {
		Item item = new Item(qid, question, optionA, optionB, optionC, optionD, answer);
		itemDAO.updateItem(item);
		
	}
}

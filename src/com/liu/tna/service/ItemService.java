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
	
	//��ѯ��������
	public List<Item> getAllItems() {
		return itemDAO.selectAll();
	}
	
	//�����Ŀ
	public Item saveItem(String question , String optionA , String optionB , String optionC , String optionD , String answer) {
		Item item = new Item(question, optionA, optionB, optionC, optionD, answer);
		itemDAO.addItem(item);
		return item;
	}
	
	//ɾ����Ŀ
	public void removeItem(int qid) {
		itemDAO.deleteItem(qid);
	}
	
	//��qid��ѯ��Ŀ
	public Item getItem(int qid) {
		return itemDAO.selectItem(qid);
	}
	
	//�޸���Ŀ
	public void modifyItem(int qid,String question , String optionA , String optionB , String optionC , String optionD , String answer) {
		Item item = new Item(qid, question, optionA, optionB, optionC, optionD, answer);
		itemDAO.updateItem(item);
		
	}
}

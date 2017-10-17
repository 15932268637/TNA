package com.liu.tna.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.liu.tna.model.Score;

@Repository
public class ScoreDAO {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	//��score���󱣴浽����
	public void addScore(Score sc) {
		hibernateTemplate.save(sc);
	}
	
	//��ѯ���з�����¼
	public List<Score> selectAll() {
		return hibernateTemplate.find("from Score");
	}
}

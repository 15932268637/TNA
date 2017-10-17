package com.liu.tna.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.tna.dao.ScoreDAO;
import com.liu.tna.dao.UserDAO;
import com.liu.tna.model.Score;
import com.liu.tna.model.User;

@Service
public class ScoreService {
	@Resource
	private ScoreDAO scoreDAO;
	@Resource
	private UserDAO userDAO;
	
	//获取考生记录
	public List<Score> getAllScores() {
		return scoreDAO.selectAll();
	}
	public List<User> getAllUserScores() {
		return userDAO.selectAll();
	}
}

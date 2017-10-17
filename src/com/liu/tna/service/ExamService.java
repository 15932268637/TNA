package com.liu.tna.service;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.tna.dao.ScoreDAO;
import com.liu.tna.model.Item;
import com.liu.tna.model.Score;
import com.liu.tna.model.User;

@Service
public class ExamService {
	@Resource
	private ScoreDAO scoreDAO;
	public Score getScore(List<String> answers, List<String> sanswers , User user) {
		int score = 0;
		String answer = ""; //考生答案
		String s_answer = ""; //标准答案
		//基于标准答案和考生答案为考试判分
		for(int i = 0 ;i < answers.size() ;i++) {
			//比较标准答案和考生答案
			if(answers.get(i).equals(sanswers.get(i))) {
				score += 10;
			}
 		}
		
		answer = answers.toString().substring(1, answers.toString().length() - 1);
		s_answer = sanswers.toString().substring(1, sanswers.toString().length() - 1);
		
		Date date = new Date(System.currentTimeMillis());
		//创建score对象
		Score sc = new Score(user.getUid(), date, score, answer, s_answer);
		
		//调用ScoreDAO
		scoreDAO.addScore(sc);
		
		return sc;
	}
}

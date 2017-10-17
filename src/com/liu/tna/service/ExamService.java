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
		String answer = ""; //������
		String s_answer = ""; //��׼��
		//���ڱ�׼�𰸺Ϳ�����Ϊ�����з�
		for(int i = 0 ;i < answers.size() ;i++) {
			//�Ƚϱ�׼�𰸺Ϳ�����
			if(answers.get(i).equals(sanswers.get(i))) {
				score += 10;
			}
 		}
		
		answer = answers.toString().substring(1, answers.toString().length() - 1);
		s_answer = sanswers.toString().substring(1, sanswers.toString().length() - 1);
		
		Date date = new Date(System.currentTimeMillis());
		//����score����
		Score sc = new Score(user.getUid(), date, score, answer, s_answer);
		
		//����ScoreDAO
		scoreDAO.addScore(sc);
		
		return sc;
	}
}

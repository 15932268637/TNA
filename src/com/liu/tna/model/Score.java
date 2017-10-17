package com.liu.tna.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Score {
	@Id
	@GeneratedValue
	private int id;
	private int uid;
	private Date date;
	private int score;
	private String answer;
	private String s_answer;
	
	
	public Score() {
	}
	public Score(int uid, Date date, int score, String answer, String s_answer) {
		this.uid = uid;
		this.date = date;
		this.score = score;
		this.answer = answer;
		this.s_answer = s_answer;
	}
	public Score(int id, int uid, Date date, int score, String answer, String s_answer) {
		this.id = id;
		this.uid = uid;
		this.date = date;
		this.score = score;
		this.answer = answer;
		this.s_answer = s_answer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getS_answer() {
		return s_answer;
	}
	public void setS_answer(String s_answer) {
		this.s_answer = s_answer;
	}
	@Override
	public String toString() {
		return "Score [id=" + id + ", uid=" + uid + ", date=" + date + ", score=" + score + ", answer=" + answer
				+ ", s_answer=" + s_answer + "]";
	}
	
	
}

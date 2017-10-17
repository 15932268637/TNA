package com.liu.tna.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private int uid;
	private String username;
	private String password;
	private String name;
	private String idnumber;
	private String telno;
	public User(int uid, String username, String password, String name, String idnumber, String telno) {
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.idnumber = idnumber;
		this.telno = telno;
	}
	public User(String username, String password, String name, String idnumber, String telno) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.idnumber = idnumber;
		this.telno = telno;
	}
	public User() {
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", idnumber=" + idnumber + ", telno=" + telno + "]";
	}
	
	
}

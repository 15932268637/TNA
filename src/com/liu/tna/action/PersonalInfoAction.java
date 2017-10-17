package com.liu.tna.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.liu.tna.model.User;
import com.liu.tna.service.UserService;

@Controller
@Scope("prototype")
@Namespace("/user")
@ParentPackage("struts-default")
@Action("personalInfoAction")
@Results({
	@Result(name="success" , location="/user/index.jsp"),
	@Result(name="input" , location="/user/personalInfo.jsp")
})
public class PersonalInfoAction {
	@Resource
	private UserService userService;
	
	private int uid;
	private String username;
	private String password;
	private String name;
	private String idnumber;
	private String telno;
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
	
	public String execute() {
		User user = userService.modifyUser(uid, username, password, name, idnumber, telno);
		
		
		ServletActionContext.getRequest().getSession().setAttribute("user", user);
		return "success";
	}
}

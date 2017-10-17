package com.liu.tna.action;

import javax.annotation.Resource;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Controller
@Scope("prototype")
@Namespace("/user")
@ParentPackage("struts-default")
@Action("registerAction")
@Results({
	@Result(name="success" , location="/user/index.jsp"),
	@Result(name="input" , location="/user/registration.jsp")
})
public class RegisterAction extends ActionSupport {
	@Resource
	private UserService userService;
	
	private String username;
	private String password;
	private String confirmPass;
	private String name;
	private String idnumber;
	private String telno;
	
	@RequiredStringValidator(
		message = "����������",
		trim = true
	)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@RequiredStringValidator(
		message = "����������",
		trim = true
	)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@RequiredStringValidator(
		message = "������ȷ������",
		trim = true,
		shortCircuit = true
	)
	@FieldExpressionValidator(
		message = "ȷ�����������������ͬ",
		expression = "password==confirmPass"
	)
	public String getConfirmPass() {
		return confirmPass;
	}
	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}
	@RequiredStringValidator(
		message = "��������ʵ����",
		trim = true
	)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@RequiredStringValidator(
		message = "���������֤��",
		trim = true
	)
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	@RequiredStringValidator(
		message = "��������ϵ�绰",
		trim = true
	)
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	
	
	//ע��
	public String execute() {
		User user = userService.register(username, password, name, idnumber, telno);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		return "success";
	}
}

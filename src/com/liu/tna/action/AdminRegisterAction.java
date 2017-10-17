package com.liu.tna.action;

import javax.annotation.Resource;
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

import com.liu.tna.model.Admin;
import com.liu.tna.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Controller
@Scope("prototype")
@Namespace("/admin")
@ParentPackage("struts-default")
@Action("adminRegisterAction")
@Results({
	@Result(name="success" , location="/admin/index.jsp"),
	@Result(name="input" , location="/admin/registration.jsp")
})
public class AdminRegisterAction extends ActionSupport {
	@Resource
	private AdminService adminService;
	
	private String username;
	private String password;
	private String confirmPass;
	
	@RequiredStringValidator(
		message = "请输入姓名",
		trim = true
	)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@RequiredStringValidator(
		message = "请输入密码",
		trim = true
	)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@RequiredStringValidator(
		message = "请输入确认密码",
		trim = true,
		shortCircuit = true
	)
	@FieldExpressionValidator(
		message = "确认密码必须与密码相同",
		expression = "password==confirmPass"
	)
	public String getConfirmPass() {
		return confirmPass;
	}
	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}
	//注册
	public String execute() {
		Admin admin = adminService.register(username, password);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("admin", admin);
		
		return "success";
	}
}

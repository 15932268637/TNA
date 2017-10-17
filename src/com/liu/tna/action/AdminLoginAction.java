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

import com.liu.tna.exception.TnaException;
import com.liu.tna.model.Admin;
import com.liu.tna.model.User;
import com.liu.tna.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Controller
@Scope("prototype")
@Namespace("/admin")
@ParentPackage("struts-default")
@Action("adminLoginAction")
@Results({
	@Result(name="success" , location="/admin/index.jsp"),
	@Result(name="input" , location="/admin/login.jsp")
})
public class AdminLoginAction extends ActionSupport {
	@Resource
	private AdminService adminService;
	
	private String username;
	private String password;
	
	@RequiredStringValidator(
		message = "请输入用户名",
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
	
	//登录
	public String execute() {
		Admin admin = null;
		try {
			admin = adminService.login(username, password);
			
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);			
			
		} catch (TnaException e) {
			this.addActionError(e.getMessage());
			//跳转到input失败页面
			return "input";
		}
		
		return "success";
	}
}

package com.liu.tna.action;

import java.util.ArrayList;
import java.util.List;

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

import com.liu.tna.model.Item;
import com.liu.tna.model.Score;
import com.liu.tna.model.User;
import com.liu.tna.service.ExamService;

@Controller
@Scope("prototype")
@Namespace("/user")
@ParentPackage("struts-default")
@Action("examAction")
@Results({
	@Result(name="success" , location="/user/ShowScore.jsp"),
})
public class ExamAction {
	@Resource
	private ExamService examService;
	public String execute() {
		//从HttpSession中取出集合（包含了标准答案）
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		List<Item> items = (List<Item>)session.getAttribute("items");
		
		List<String> sans = new ArrayList<>();
		List<String> ans = new ArrayList<>();
		//获取考生答案
		for(int i = 0 ;i < items.size() ;i++) {
			String an = request.getParameter("option" + (i + 1));
			ans.add(an);
			sans.add(items.get(i).getAnswer());
		}
		//获取用户对象
		User user = (User)session.getAttribute("user");
		//调用ExamService服务组件
		Score score = examService.getScore(ans, sans, user);
		
		request.setAttribute("score", score);
		request.setAttribute("ans", ans);
		request.setAttribute("sans", sans);
		
		return "success";
	}
}	

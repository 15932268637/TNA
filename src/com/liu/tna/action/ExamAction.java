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
		//��HttpSession��ȡ�����ϣ������˱�׼�𰸣�
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		List<Item> items = (List<Item>)session.getAttribute("items");
		
		List<String> sans = new ArrayList<>();
		List<String> ans = new ArrayList<>();
		//��ȡ������
		for(int i = 0 ;i < items.size() ;i++) {
			String an = request.getParameter("option" + (i + 1));
			ans.add(an);
			sans.add(items.get(i).getAnswer());
		}
		//��ȡ�û�����
		User user = (User)session.getAttribute("user");
		//����ExamService�������
		Score score = examService.getScore(ans, sans, user);
		
		request.setAttribute("score", score);
		request.setAttribute("ans", ans);
		request.setAttribute("sans", sans);
		
		return "success";
	}
}	

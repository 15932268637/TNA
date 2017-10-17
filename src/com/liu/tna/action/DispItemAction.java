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

import com.liu.tna.model.Item;
import com.liu.tna.service.ItemService;

@Controller
@Scope("prototype")
@Namespace("/admin")
@ParentPackage("struts-default")
@Action("dispItemAction")
@Results({
	@Result(name="success" , location="/admin/ModifyItem.jsp"),
})
public class DispItemAction {
	@Resource
	private ItemService itemSerive;
	
	private int qid;

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}
	
	public String execute() {
		Item item = itemSerive.getItem(qid);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("item", item);
		
		return "success";
	}
}

package com.liu.tna.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.liu.tna.service.ItemService;

@Controller
@Scope("prototype")
@Namespace("/admin")
@ParentPackage("struts-default")
@Action("deleteItemAction")
@Results({
	@Result(name="success" , location="/admin/ItemList.jsp"),
})
public class DeleteItemAction {
	@Resource
	private ItemService itemSerivce;
	
	private int qid;

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}
	
	public String execute() {
		itemSerivce.removeItem(qid);
		
		return "success";
	}
}

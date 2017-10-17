<%@page import="com.liu.tna.service.ItemService"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>题目管理</title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    	<style type="text/css">
    		a {
    			color:red;
    		}
    	</style>
    
    </head>

    <body>
        <div id="main_page">
            <div id="header">
                <img src="${pageContext.request.contextPath}/images/image-logo.png"/>
            </div>
            <div id="body">
                <div id="navigation">
                    <div id="inner">
                        <p>当前用户：  ${admin.username}</p>
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/admin/index.jsp" class="index">首&nbsp;&nbsp;&nbsp;&nbsp;页</a><li>
                            <li><a href="${pageContext.request.contextPath}/admin/UserScoreList.jsp" class="personal">用户列表</a><li>
                            <li><a href="${pageContext.request.contextPath}/admin/ScoreList.jsp" class="exam">考试记录</a><li>
                            <li><a href="${pageContext.request.contextPath}/admin/ItemList.jsp" class="examlog">题库管理</a><li>
                            <li><a href="${pageContext.request.contextPath}/admin/adminLogoutAction" class="logout">注&nbsp;&nbsp;&nbsp;&nbsp;销</a><li>
                        </ul>
                    </div>
                </div>
                <div id="content">
                   <!--试题部分-->
                    <div class="title">
                        <p><img src="${pageContext.request.contextPath}/images/icon-itemlib.jpg" /> 管理题库：试题的增加、插入、修改和删除</p>
                    </div>
                    <div class="main">
                    	<input type="button" value="添加题目" onclick="window.location.href='AddItem.jsp'"><br><br>
                        <div class="item">
                        	<%
                        		ApplicationContext context = (ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
                        		ItemService itemService = (ItemService)context.getBean("itemService");
                        		pageContext.setAttribute("items", itemService.getAllItems()) ;
                        	%>
                        	<c:forEach items="${items}" var="item" varStatus="sta">
	                            <p>
	                                <b>${sta.count}. &nbsp;</b>
	                                ${item.question}（答案: 
	                                <span style="font-weight:bold;color:#F80015;">${item.answer}</span>
	                                &nbsp;）&nbsp;&nbsp;&nbsp;
	                                [<!-- <span style="color:#F80015;"> --> <a href="${pageContext.request.contextPath}/admin/dispItemAction?qid=${item.qid}">编辑</a>&nbsp;&nbsp;
	                               <a href="${pageContext.request.contextPath}/admin/deleteItemAction?qid=${item.qid}"> 删除</a> <!-- </span> -->]
	                            </p>
	                            <p class="answer">
	                                ${item.optionA}<br/>
	                                ${item.optionB}<br/>
	                                ${item.optionC}<br/>
	                                ${item.optionD} 
	                            </p>
                            </c:forEach>
                        </div>
                    </div>
                </div>  <!--content-->
            </div>  <!--body-->
        </div>
    </body>
</html>

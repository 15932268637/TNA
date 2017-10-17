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
        <title>添加题目</title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <div id="main_page">
            <div id="header">
                <img src="${pageContext.request.contextPath}/images/image-logo.png"/>
            </div>
            <div id="body">
                <div id="navigation">
                    <div id="inner">
                        <p>当前用户： ${admin.username }</p>
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
                        <p><img src="./images/icon-itemlib.jpg" /> 管理题库：试题的增加、插入、修改和删除</p>
                    </div>
                    <div class="main">
                    	<form action="${pageContext.request.contextPath}/admin/modifyItemAction" method="post">
                    		<input type="hidden" name="qid" value="${item.qid}">
                    		题目：<input type="text" name="question" value="${item.question}"><br>
                    		选项A：<input type="text" name="optionA" value="${item.optionA}"><br>
                    		选项B：<input type="text" name="optionB" value="${item.optionB}"><br>
                    		选项C：<input type="text" name="optionC" value="${item.optionC}"><br>
                    		选项D：<input type="text" name="optionD" value="${item.optionD}"><br>
                    		答案：<input type="text" name="answer" value="${item.answer}"><br>
                    		<input type="submit" value="确定">
                    		<input type="reset" value="重置">
                    	</form>
                        
                    </div>
                </div>  <!--content-->
            </div>  <!--body-->
        </div>
    </body>
</html>

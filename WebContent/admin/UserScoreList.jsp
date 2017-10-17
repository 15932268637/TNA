<%@page import="com.liu.tna.model.User"%>
<%@page import="com.liu.tna.model.Score"%>
<%@page import="java.util.List"%>
<%@page import="com.liu.tna.service.ScoreService"%>
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
        <title>用户列表</title>
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
                   <!--用户列表部分-->
                    <div class="main">
                        <div>
                        	<%
                				ApplicationContext context = (ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
                				ScoreService scoreService = (ScoreService)context.getBean("scoreService");
                				List<User> users = scoreService.getAllUserScores();
                				pageContext.setAttribute("users", users);
                			%>
		                        	<table border="1" width="60%" align="center">
		                		<tr>
		                			<th>用户id</th>
		                			<th>用户名</th>
		                			<th>用户密码</th>
		                			<th>真实姓名</th>
		                			<th>省份证号</th>
		                			<th>电话号</th>
		                		</tr>
		                		<c:forEach items="${users}" var="us" varStatus="uta">
		                			<tr>
		                				<td>${us.uid}</td>
		                				<td>${us.username}</td>
		                				<td>${us.password}</td>
		                				<td>${us.name}</td>
		                				<td>${us.idnumber}</td>
		                				<td>${us.telno}</td>
		                			</tr>
		                		</c:forEach>
                			</table>
                        </div>
                    </div>
                </div>  <!--content-->
            </div>  <!--body-->
        </div>
    </body>
</html>

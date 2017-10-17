<%@page import="com.liu.tna.model.Score"%>
<%@page import="java.util.List"%>
<%@page import="com.liu.tna.service.ScoreService"%>
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
        <title>答题记录</title>
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
                        <p>当前用户： ${user.name}</p>
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/user/index.jsp" class="index">首&nbsp;&nbsp;&nbsp;&nbsp;页</a><li>
                            <li><a href="${pageContext.request.contextPath}/user/personalInfo.jsp" class="personal">个人信息</a><li>
                            <li><a href="${pageContext.request.contextPath}/user/Exam.jsp" class="exam">参加考试</a><li>
                            <li><a href="${pageContext.request.contextPath}/user/ScoreList.jsp" class="examlog">考试记录</a><li>
                            <li><a href="${pageContext.request.contextPath}/user/logoutAction" class="logout">注&nbsp;&nbsp;&nbsp;&nbsp;销</a><li>
                        </ul>
                    </div>
                </div>
                <div id="content">
                	<%
                		ApplicationContext context = (ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
                		ScoreService scoreService = (ScoreService)context.getBean("scoreService");
                		List<Score> scores = scoreService.getAllScores();
                		pageContext.setAttribute("scores", scores);
                	%>
                	<table border="1" width="60%" align="center">
                		<tr>
                			<th>编号</th>
                			<th>考试时间</th>
                			<th>分数</th>
                		</tr>
                		<c:forEach items="${scores}" var="sc" varStatus="sta">
                			<tr>
                				<td>${sta.count}</td>
                				<td>${sc.date}</td>
                				<td>${sc.score}</td>
                			</tr>
                		</c:forEach>
                	</table>
                </div>  <!--content-->
            </div>  <!--body-->
        </div>
    </body>
</html>
    
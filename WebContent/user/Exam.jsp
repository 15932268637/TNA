<%@page import="com.liu.tna.model.Item"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.liu.tna.service.ItemService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>测试</title>
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
                		//获取spring容器对象
                		ApplicationContext context = (ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
                		//从spring容器中获取ItemService对象	
                		ItemService itemService = (ItemService)context.getBean("itemService");
                		List<Item> items = itemService.getAllItems();
                		session.setAttribute("items", items);
                	%>
                	<table>
                		<tr>
                			<td>
	                	<form action="${pageContext.request.contextPath}/user/examAction" method="post">
		                	<c:forEach items="${items}" var="item" varStatus="sta">
		                		${sta.count}.${item.question} <br>
		                		&nbsp;&nbsp;<input type="radio" name="option${sta.count}" value="A">${item.optionA}<br>
		                		&nbsp;&nbsp;<input type="radio" name="option${sta.count}" value="B">${item.optionB}<br>
		                		&nbsp;&nbsp;<input type="radio" name="option${sta.count}" value="C">${item.optionC}<br>
		                		&nbsp;&nbsp;<input type="radio" name="option${sta.count}" value="D">${item.optionD}<br>
		                	</c:forEach>
		                	
		                	<br>
		                	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                	<input type="submit" value="交卷">
	                	</form>
	                		</td>
	                	</tr>
                	</table>
                </div>  <!--content-->
            </div>  <!--body-->
        </div>
    </body>
</html>
    
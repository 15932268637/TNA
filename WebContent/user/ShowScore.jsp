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
        <title>分数</title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    	<style type="text/css">
    		/* table {
    			margin-top:100px;
    		} */
    		p {
    			padding-top:90px;
    			font-size:20px;
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
                			<p>分数：${score.score}</p>
                	<table border="1" width="60%" align="center">
	                	<tr>
	                		<td colspan="3" align="center">考生答案和正确答案对比</td>
	                		
	                	</tr>	
                		<tr>
                			<th>题号</th>
                			<th>标准答案</th>
                			<th>您的选择</th>
                		</tr>
	                	<c:forEach varStatus="sta" begin="0" end="${ans.size()-1}" step="1" var="n">
	                	<tr align="center">
	                		<td>第${sta.count}题</td>
	                		<td>${sans[n]}</td>
	                		<td>
	                			<c:choose>
	                				<c:when test="${sans[n]!= ans[n]}">
	                					<font color="blue">               		
	                						${ans[n]}
	                					</font>	                					
	                				</c:when>
	                				<c:otherwise>
	                					${ans[n]}
	                				</c:otherwise>
	                			</c:choose>
	                			
	                		</td>
	                	</tr>
	                	</c:forEach>
	                	<tr>
	                		<td colspan="2" align="center">总分</td>
	                		<td>${score.score}</td>
	                	</tr>
                	</table>
                </div>  <!--content-->
            </div>  <!--body-->
        </div>
    </body>
</html>
    
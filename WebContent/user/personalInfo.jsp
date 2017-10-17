<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>个人信息</title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
   		<style type="text/css">
   			table{
   				width:300px;
   				height:300px;
   				margin-top:100px;
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
                	<form action="${pageContext.request.contextPath}/user/personalInfoAction" method="post">
                		<input type="hidden" name="uid" value="${user.uid}">
                		<table align="center">
	                		<tr>
	                			<td>用户名：</td>
	                			<td>
	                				<input type="text" name="username" value="${user.username}">
	                			</td>
	                		</tr>
	                		<tr>
	                			<td>密码：</td>
	                			<td>
	                				<input type="password" name="password" value="${user.password}">
	                			</td>
	                		</tr>
	                		<tr>
	                			<td>密码确认：</td>
	                			<td>
	                				<input type="password" name="confirmPass">
	                			</td>
	                		</tr>
	                		<tr>
	                			<td>真实姓名：</td>
	                			<td>
	                				<input type="text" name="name" value="${user.name}">
	                			</td>
	                		</tr>
	                		<tr>
	                			<td>身份证号：</td>
	                			<td>
	                				<input type="text" name="idnumber" value="${user.idnumber}">
	                			</td>
	                		</tr>
	                		<tr>
	                			<td>联系电话：</td>
	                			<td>
	                				<input type="text" name="telno" value="${user.telno}">
	                			</td>
	                		</tr>
	                		<tr>
	                			<td colspan="2">
	                				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                				&nbsp;&nbsp;&nbsp;
	                				<input type="submit" value="修改">
	                				&nbsp;&nbsp;&nbsp;
	                				<input type="reset" value="重置">
	                			</td>
	                		</tr>
                		</table>
                	</form>	
                </div>  <!--content-->
            </div>  <!--body-->
        </div>
    </body>
</html>
    
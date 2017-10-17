<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>主页面</title>
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
                
           		<pre>
                    项目目标
 
   • 实现一个真实的、基于SSH架构的电信网络学院（TNA）系统
             增量式开发，循序渐进完成项目
   • 掌握基于SSH架构的Web应用程序的编程和调试技巧
   • 主要涉及以下主要知识点：
   • 基于SSH框架的Model 2架构的实现
   • 使用Struts2框架OGNL、验证与资源 、拦截器等
   • HttpSession会话管理
   • 可复用表示组件的实际运用
   • Spring框架的Ioc与AOP特征
   • 使用Hibernate框架访问MySQL数据库
   • 三大框架的有机整合
   </pre>
                </div>  <!--content-->
            </div>  <!--body-->
        </div>
    </body>
</html>
    
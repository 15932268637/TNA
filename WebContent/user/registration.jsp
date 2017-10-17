<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>注册模板</title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    	<style type="text/css">
    		#body {
    			background-color:#45a9ff;
    			height:100%;
    			padding-top:200px;
    		}
    		table {
    			height:300px;
    			width:400px;
    		}
    	</style>
    </head>

    <body >
        <div id="main_page">
            <div id="header">
                <img src="${pageContext.request.contextPath}/images/image-logo.png"/>
            </div>
            <div id="body">
                <form action="${pageContext.request.contextPath}/user/registerAction" method="post">
                	<table align="center">
                		<tr>
                			<td>用户名：</td>
                			<td>
                				<input type="text" name="username">
                			</td>
                			<td>
                				<s:fielderror fieldName="username"></s:fielderror>
                			</td>
                		</tr>
                		<tr>
                			<td>密码：</td>
                			<td>
                				<input type="password" name="password">
                			</td>
                			<td>
                				<s:fielderror fieldName="password"></s:fielderror>
                			</td>
                		</tr>
                		<tr>
                			<td>密码确认：</td>
                			<td>
                				<input type="password" name="confirmPass">
                			</td>
                			<td>
                				<s:fielderror fieldName="confirmPass"></s:fielderror>
                			</td>
                		</tr>
                		<tr>
                			<td>真实姓名：</td>
                			<td>
                				<input type="text" name="name">
                			</td>
                			<td>
                				<s:fielderror fieldName="name"></s:fielderror>
                			</td>
                		</tr>
                		<tr>
                			<td>身份证号：</td>
                			<td>
                				<input type="text" name="idnumber">
                			</td>
                			<td>
                				<s:fielderror fieldName="idnumber"></s:fielderror>
                			</td>
                		</tr>
                		<tr>
                			<td>联系电话：</td>
                			<td>
                				<input type="text" name="telno">
                			</td>
                			<td>
                				<s:fielderror fieldName="telno"></s:fielderror>
                			</td>
                		</tr>
                		<tr>
                			<td colspan="3">
                			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                				<input type="submit" value="注册">
                				&nbsp;&nbsp;&nbsp;
                				<input type="reset" value="重置">
                			</td>
                		</tr>
                	</table>	
                </form>
            </div>  <!--body-->
        </div>
    </body>
</html>
    
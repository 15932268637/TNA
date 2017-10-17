<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>登录页面</title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    	<script type="text/javascript">
    		function loginSubmit() {
    			document.myform.submit();
    		}
    	</script>
    </head>

    <body bgcolor="#0591C2" >
        <div id="login">
            <div class="main_body">
                <div class="left">
                    <img src="${pageContext.request.contextPath}/images/image-login-left.jpg"/>
                </div>
                <div class="right">
                    <center><img src="${pageContext.request.contextPath}/images/image-adminlogin.jpg" /></center>
                    <s:actionerror />
                    <form action="${pageContext.request.contextPath}/user/loginAction" method="post" name="myform">
                    	<table>
                    		<tr>
                        		<td><label for="username">用 户 名：</label></td>
                        		<td><input type="text" name="username" id="username" size="10"/></td> 
                        		<td>
                        			<s:fielderror fieldName="username"></s:fielderror>
                        		</td>
                            </tr>
                            <tr>
                       			<td><label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</label></td> 
                        		<td><input type="password" name="password" id="password" size="10"/></td>
                        		<td>
                        			<s:fielderror fieldName="password"></s:fielderror>
                        		</td>
                            </tr>
                        	<tr>
                        		<td colspan="3">
                        			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                            <input type="button" name="que" value="确&nbsp;&nbsp;认" onclick="loginSubmit()" />
		                            <input type="reset" name="qu" value="取&nbsp;&nbsp;消" />
		                            <input type="button" name="zhu" value="注&nbsp;&nbsp;册" onclick="window.location.href='registration.jsp'"/>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

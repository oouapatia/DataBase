<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8"%>

<script type="text/javascript">
    function a() {
        var username = login.username.value;
        var password = login.password.value;

        if (username == "") {
            alert("用户名不能为空！");
            return false;
        } else if (password == "") {
            alert("密码不能为空！");
            return false;
        }
        return true;
    }
</script>

<%
    String username = "";
    String password = "";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("usernameCookie")) {
                username = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
            }
            if (cookies[i].getName().equals("passwordCookie")) {
                password = cookies[i].getValue();
            }
        }
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
        <link href="css/Login.css" rel="stylesheet" type="text/css" />
        <title>登录界面</title>
    </head>

    <body>
        <div class="login-box">
            <h1>欢迎登录<br>人力资源管理系统</h1>
            <form name="login" action="LoginCheck.jsp" method="post" onsubmit="return a()">
                <div class="textbox">
                    <input type="text" placeholder="UserName" name="username" color="black" value="<%=username%>" id="user"/>
                </div>

                <div class="textbox">
                    <input type="password" placeholder="PassWord" name="password" value="<%=password%>" id="password"/>
                </div>

                <input type="checkbox"class="rember" name="remember" value="yes"><font style="color: black">记住密码</font><br>
                <input type="submit" class="btn" name="Submit" value="登录">
                <input type="reset" class="btn" name="Reset" value="重置">
                <p><a href="Register.jsp" class="register"><font>没有账号？点击注册</font></a></p>
            </form>
        </div>
    </body>
</html>


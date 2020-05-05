<%@page import="java.sql.ResultSet"%>
<%@page import="java.net.URLEncoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="DBean" class="com.DBean" />
<%
    String username = request.getParameter("username");     //从前端页面获取用户名
    String password = request.getParameter("password");     //从前端页面获取密码
    String remember = request.getParameter("remember");     //从前端页面获取是否记住密码

    Cookie usernameCookie = new Cookie("usernameCookie", URLEncoder.encode(username, "UTF-8"));
    Cookie passwordCookie = new Cookie("passwordCookie", password);

    String sql_user = "SELECT passWord FROM Login WHERE userName='" + username + "'";
    ResultSet sqlRes  = DBean.Query(sql_user);  // 结果集对象

    while(sqlRes.next()){
        String sqlPassword = sqlRes.getString("passWord").trim();           // 去掉从数据库中取出来的字符串后的空格
        if (password.equals(sqlPassword)) {
            request.getSession().setAttribute("nameSession", username);     //将用户名存入session中
            if ("yes".equals(remember)) {
                usernameCookie.setMaxAge(60 * 60 * 24 * 31);
                passwordCookie.setMaxAge(60 * 60 * 24 * 31);
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
            } else {
                usernameCookie.setMaxAge(0);
                passwordCookie.setMaxAge(0);
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
            }
            response.sendRedirect("../index.jsp");
        } else {
%>                
            <jsp:forward page="LoginFail.jsp">
                <jsp:param value="fail" name="password"/>
            </jsp:forward>
<%
        }
    }
%>
    <jsp:forward page="LoginFail.jsp">
        <jsp:param value="fail" name="username"/>
    </jsp:forward>
<%
    DBean.closeDB (sqlRes);
%>


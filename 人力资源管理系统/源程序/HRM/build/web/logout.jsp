<%@page contentType="text/html" pageEncoding="UTF-8"%>

<style>
    .top-box {
        margin-top: -7px;
        margin-right: 1000px;
        margin-bottom: 5px;
        margin-left: 190px;
        width: 86%;
        background-color: white;
    }
    
    .top-box .logout {
        margin-left: 5px;
        width: 70px;
        height: 39px;
        background: none;
        border: none;
        color: #4caf50;
        padding: 5px;
        cursor: pointer;
    }
    
</style>

<%
    String user = (String)request.getSession().getAttribute("nameSession");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="top-box">
            <form action="http://localhost:8080/HRM/Logout" method="post">
                <font style="margin-left: 920px;">用户&nbsp;</font><%=user%><input type="submit" class="logout" name="logout" value="退出登录">
            </form>
        </div>
    </body>
</html>

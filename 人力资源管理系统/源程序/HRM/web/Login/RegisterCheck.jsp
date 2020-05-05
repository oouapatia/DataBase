<%@page import="java.sql.ResultSet"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="DBean" class="com.DBean" />
<%    
        //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("pwd");

        // 判断用户名是否存在
        boolean juge = false; // 初值为不存在
        String select_user = "SELECT userName FROM Login";
        ResultSet sqlRes = DBean.Query(select_user);
        while(sqlRes.next()){
            String sqlUsername = sqlRes.getString("userName").trim();  // 去掉从数据库中取出来的字符串的空格
            if(username.equals(sqlUsername)){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"用户名已存在！\");");
                out.println("document.location.href=\"Register.jsp\";");
                out.println("</script>");
                juge = true;
                break;
            }
        }

        if(juge == false){
            String insert_user = "INSERT INTO Login(userName,passWord) VALUES(" + username + "," + password + ")";
            int result = DBean.Update(insert_user);
            if(result != 0){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"注册成功！\");");
                out.println("document.location.href=\"Login.jsp\";");
                out.println("</script>");
            }
            else{
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"注册失败！\");");
                out.println("document.location.href=\"Register.jsp\";");
                out.println("</script>");
            }
        }
        DBean.closeDB(sqlRes);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Position.Position_query"%>

<%
    // 获取员工的职位信息数据
    String employeeNo = Position_query.employeeNo_Arr[0];
    String postNo = Position_query.postNo_Arr[0];
    String startDate = Position_query.startDate_Arr[0];
    String endDate = Position_query.endDate_Arr[0];
    
    if(employeeNo == null){
        out.println("<script type=\"text/javascript\">");
        out.println("alert(\"未输入员工编号！\");");
        out.println("document.location.href=\"position_query.jsp\";");
        out.println("</script>");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <link href="../css/view.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/position.js"></script>
        <title><%=employeeNo%>员工职位信息</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="result_view">
            <br><br>
            <center>
                <form name="query" action="../Position_query" method="post" onsubmit="return check();">
                    <input class="input" type="text" placeholder="输入员工编号（*）" name="employeeNo" id="employeeNo"/>
                    <input type="submit" class="btn" name="query" value="查询">
                </form>
            </center>
                
            <center><h3><%=employeeNo%>员工职位信息</h3></center>
            <table align="center" cellspacing="2" cellpadding="10" border="1">
                <tr>
                    <td class="td_title">员工编号</td>          <td class="td_title">职位编号</td>
                    <td class="td_title">入职时间</td>          <td class="td_title">离职时间</td>
                </tr>
                <tr>
                    <td><%=employeeNo%></td>                <td><%=postNo%></td>
                    <td><%=startDate%></td>                  <td><%=endDate%></td>
                </tr>
            </table>
        </div>
    </body>
</html>
 
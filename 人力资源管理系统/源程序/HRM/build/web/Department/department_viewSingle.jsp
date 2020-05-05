<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Department.Department_query"%>

<%
    // 获取该员工的信息数据
    String departmentNo = Department_query.departmentNo_Arr[0];
    String departmentName = Department_query.departmentName_Arr[0];
    String deptLocation = Department_query.deptLocation_Arr[0];
    String managerEmployeeNo = Department_query.managerEmployeeNo_Arr[0];
    
    if(departmentNo == null){
        out.println("<script type=\"text/javascript\">");
        out.println("alert(\"未输入员工编号！\");");
        out.println("document.location.href=\"department_query.jsp\";");
        out.println("</script>");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <link href="../css/view.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/department.js"></script>
        <title><%=departmentName%>信息</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="result_view">
            <br><br>
            <center>
                <form name="query" action="../Department_query" method="post" onsubmit="return check();">
                    <input class="input" type="text" placeholder="输入部门编号（*）" name="departmentNo" id="departmentNo"/>
                    <input type="submit" class="btn" name="query" value="查询">
                </form>
            </center>
            
            <center><h3><%=departmentName%>信息</h3></center>
            <table align="center" cellspacing="2" cellpadding="10" border="1">
                <tr>
                    <td class="td_title">部门编号</td>     <td class="td_title">部门名字</td>
                    <td class="td_title">部门位置</td>     <td class="td_title">管理人员编号</td>
                </tr>
                <tr>
                    <td><%=departmentNo%></td>             <td><%=departmentName%></td>
                    <td><%=deptLocation%></td>             <td><%=managerEmployeeNo%></td>
                </tr>
            </table>
        </div>
    </body>
</html>

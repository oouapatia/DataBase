<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String prevCompanyNo = (String) request.getServletContext().getAttribute("prevCompanyNo");
    String employeeNo = (String) request.getServletContext().getAttribute("employeeNo");
    String prevPosition = (String) request.getServletContext().getAttribute("prevPosition");
    String prevGrade = (String) request.getServletContext().getAttribute("prevGrade");
    String prevSalary = (String) request.getServletContext().getAttribute("prevSalary");
    String prevLocation = (String) request.getServletContext().getAttribute("prevLocation");
    String prevResponsibilities = (String) request.getServletContext().getAttribute("prevResponsibilities");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <link href="../css/view.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/workHistory.js"></script>
        <title>员工工作历史</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />

        <div class="result_view">
            <br><br>
            <center>
                <form name="query" action="../WorkHistory_query" method="post" onsubmit="return check();">
                    <input class="input" type="text" placeholder="输入员工编号（*）" name="employeeNo" id="employeeNo"/>
                    <input type="submit" class="btn" name="query" value="查询">
                </form>
            </center>
            
            <center><h3>员工<%=employeeNo%>工作历史</h3></center>
            <table align="center" cellspacing="2" cellpadding="10" border="1">
                <tr>
                    <td class="td_title">前公司编号</td>        <td class="td_title">员工编号</td>
                    <td class="td_title">前任公司职位</td>      <td class="td_title">前任公司岗位等级</td>
                    <td class="td_title">前任公司薪水</td>      <td class="td_title">前任公司位置</td>	
                    <td class="td_title">在前任公司负责内容</td>
                </tr>
                <tr>
                    <td><%=prevCompanyNo%></td>               <td><%=employeeNo%></td>
                    <td><%=prevPosition%></td>                <td><%=prevGrade%></td>        
                    <td><%=prevSalary%></td>                  <td><%=prevLocation%></td>
                    <td><%=prevResponsibilities%></td>
                </tr>
            </table>
        </div>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Employee.Employee_query"%>

<%
    // 获取该员工的信息数据
    String employeeNo = Employee_query.employeeNo_Arr[0];
    String title = Employee_query.title_Arr[0];
    String name = Employee_query.name_Arr[0];
    String address = Employee_query.address_Arr[0];
    String workTelExt = Employee_query.workTelExt_Arr[0];
    String homeTelNo = Employee_query.homeTelNo_Arr[0];
    String empEmailAddress = Employee_query.empEmailAddress_Arr[0];
    String socialSecurityNumber = Employee_query.socialSecurityNumber_Arr[0];
    String DOB = Employee_query.DOB_Arr[0];
    String position = Employee_query.position_Arr[0];
    String sex = Employee_query.sex_Arr[0];
    String salary = Employee_query.salary_Arr[0];
    String dateStarted = Employee_query.dateStarted_Arr[0];
    String dateLeft = Employee_query.dateLeft_Arr[0];
    String departmentNo = Employee_query.departmentNo_Arr[0];
    String supervisorEmployeeNo = Employee_query.supervisorEmployeeNo_Arr[0];
    
    if(employeeNo == null){
        out.println("<script type=\"text/javascript\">");
        out.println("alert(\"未输入员工编号！\");");
        out.println("document.location.href=\"employee_query.jsp\";");
        out.println("</script>");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <link href="../css/view.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/employee.js"></script>
        <title><%=employeeNo%>员工信息</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="result_view">
            <br>
            <center>
                <form name="query" action="../Employee_query" method="post" onsubmit="return check();">
                    <input class="input" type="text" placeholder="输入员工编号（*）" name="employeeNo" id="employeeNo"/>
                    <input type="submit" class="btn" name="query" value="查询">
                </form>
            </center>
            
            <center><h3><%=employeeNo%>员工信息</h3></center>
            <table align="center" cellspacing="2" cellpadding="10" border="1">
                <tr>
                    <td class="td_title">员工编号</td>     <td class="td_title">职称</td>
                    <td class="td_title">姓名</td>         <td class="td_title">地址</td>
                    <td class="td_title">工作电传</td>     <td class="td_title">家庭电话号码</td>	
                    <td class="td_title">电子邮件地址</td> <td class="td_title">身份证号码</td>
                    <td class="td_title">出生日期</td>     <td class="td_title">职务</td>
                    <td class="td_title">性别</td>         <td class="td_title">薪水</td>
                    <td class="td_title">入职时间</td>     <td class="td_title">离职时间</td>
                    <td class="td_title">部门编号</td>     <td class="td_title">主管员工编号</td>
                </tr>
                <tr>
                    <td><%=employeeNo%></td>                <td><%=title%></td>
                    <td><%=name%></td>                      <td><%=address%></td>
                    <td><%=workTelExt%></td>                <td><%=homeTelNo%></td>
                    <td><%=empEmailAddress%></td>           <td><%=socialSecurityNumber%></td>
                    <td><%=DOB%></td>                       <td><%=position%></td>
                    <td><%=sex%></td>                       <td><%=salary%></td>
                    <td><%=dateStarted%></td>               <td><%=dateLeft%></td>
                    <td><%=departmentNo%></td>              <td><%=supervisorEmployeeNo%></td>
                </tr>
            </table>
        </div>
    </body>
</html>

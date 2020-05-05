<%@page import="java.util.Iterator"%>
<%@page import="com.HRM"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // 将对应的list转化为数组，方便操作
    HRM hrm = new HRM();
    String[] employeeNo = (String[]) hrm.employeeNo_Arr.toArray(new String[0]);
    String[] title = (String[]) hrm.title_Arr.toArray(new String[0]);
    String[] firstName = (String[]) hrm.firstName_Arr.toArray(new String[0]);
    String[] middleName = (String[]) hrm.middleName_Arr.toArray(new String[0]);
    String[] lastName = (String[]) hrm.lastName_Arr.toArray(new String[0]);
    String[] address = (String[]) hrm.address_Arr.toArray(new String[0]);
    String[] workTelExt = (String[]) hrm.workTelExt_Arr.toArray(new String[0]);
    String[] homeTelNo = (String[]) hrm.homeTelNo_Arr.toArray(new String[0]);
    String[] empEmailAddress = (String[]) hrm.empEmailAddress_Arr.toArray(new String[0]);
    String[] socialSecurityNumber = (String[]) hrm.socialSecurityNumber_Arr.toArray(new String[0]);
    String[] DOB = (String[]) hrm.DOB_Arr.toArray(new String[0]);
    String[] position = (String[]) hrm.position_Arr.toArray(new String[0]);
    String[] sex = (String[]) hrm.sex_Arr.toArray(new String[0]);
    String[] salary = (String[]) hrm.salary_Arr.toArray(new String[0]);
    String[] dateStarted = (String[]) hrm.dateStarted_Arr.toArray(new String[0]);
    String[] dateLeft = (String[]) hrm.dateLeft_Arr.toArray(new String[0]);
    String[] departmentNo = (String[]) hrm.departmentNo_Arr.toArray(new String[0]);
    String[] supervisorEmployeeNo = (String[]) hrm.supervisorEmployeeNo_Arr.toArray(new String[0]);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <link href="../css/view.css" rel="stylesheet" type="text/css" />
        <title>员工信息界面</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="result_total">
            <center><h2>员工信息</h2></center>
            <table align="center" cellspacing="2" cellpadding="10" border="1">
                <tr>
                    <td class="td_title">员工编号</td>          <td class="td_title">职称</td>
                    <td class="td_title">姓名</td>              <td class="td_title">地址</td>
                    <td class="td_title">工作电传</td>          <td class="td_title">家庭电话号码</td>	
                    <td class="td_title">员工电子邮件地址</td>   <td class="td_title">身份证号码</td>
                    <td class="td_title">出生日期</td>          <td class="td_title">职务</td>
                    <td class="td_title">性别</td>              <td class="td_title">薪水</td>
                    <td class="td_title">入职时间</td>          <td class="td_title">离职时间</td>
                    <td class="td_title">部门编号</td>          <td class="td_title">主管员工编号</td>
                </tr>
<%                  int i = hrm.employee_view();    // 返回数组大小
                    for (int j = 0; j < i; j++) {                               %>
                        <tr>
                            <td><%=employeeNo[j]%></td>     <td><%=title[j]%></td>
                            <td><%=lastName[j] + middleName[j] + firstName[j]%></td>
                            <td><%=address[j]%></td>        <td><%=workTelExt[j]%></td>
                            <td><%=homeTelNo[j]%></td>      <td><%=empEmailAddress[j]%></td>
                            <td><%=socialSecurityNumber[j]%></td>
                            <td><%=DOB[j]%></td>            <td><%=position[j]%></td>
                            <td><%=sex[j]%></td>            <td><%=salary[j]%></td>
                            <td><%=dateStarted[j]%></td>    <td><%=dateLeft[j]%></td>
                            <td><%=departmentNo[j]%></td>   <td><%=supervisorEmployeeNo[j]%></td>
                        </tr>
<%                  }                                                           %>
            </table>
            <br>
        </div>
    </body>
</html>

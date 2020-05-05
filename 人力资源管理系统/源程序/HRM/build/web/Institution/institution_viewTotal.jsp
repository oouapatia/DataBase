<%@page import="java.util.Iterator"%>
<%@page import="com.HRM"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // 将对应的list转化为数组，方便操作
    HRM hrm = new HRM();
    String[] institutionNo = (String[]) hrm.institutionNo_Arr.toArray(new String[0]);
    String[] institutionName = (String[]) hrm.institutionName_Arr.toArray(new String[0]);
    String[] instAddress = (String[]) hrm.instAddress_Arr.toArray(new String[0]);
    String[] instTelNo = (String[]) hrm.instTelNo_Arr.toArray(new String[0]);
    String[] instFaxNo = (String[]) hrm.instFaxNo_Arr.toArray(new String[0]);
    String[] instWbeAddress = (String[]) hrm.instWbeAddress_Arr.toArray(new String[0]);
    String[] contactName = (String[]) hrm.instcontactName_Arr.toArray(new String[0]);
    String[] contactTelNo = (String[]) hrm.instContactTelNo_Arr.toArray(new String[0]);
    String[] contactFaxNo = (String[]) hrm.instContactFaxNo_Arr.toArray(new String[0]);
    String[] contactEmailAddress = (String[]) hrm.instcontactEmailAddress_Arr.toArray(new String[0]);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <link href="../css/view.css" rel="stylesheet" type="text/css" />
        <title>机构信息界面</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="result_total">
            <center><h2>机构信息</h2></center>
            <table align="center" cellspacing="2" cellpadding="10" border="1">
                <tr>	
                    <td class="td_title">机构编号</td>    <td class="td_title">机构名称</td>
                    <td class="td_title">机构地址</td>      <td class="td_title">机构电话号码</td>
                    <td class="td_title">机构传真号码</td>      <td class="td_title">机构网址</td>	
                    <td class="td_title">联系人姓名</td>   <td class="td_title">联系人电话号码</td>
                    <td class="td_title">联系人传真号码</td>       <td class="td_title">联系人电子邮件地址</td>
                </tr>
<%                  int i = hrm.Institution_view();    // 返回数组大小
                    for (int j = 0; j < i; j++) {                               %>
                    <tr>
                        <td><%=institutionNo[j]%></td>   <td><%=institutionName[j]%></td>
                        <td><%=instAddress[j]%></td>     <td><%=instTelNo[j]%></td>
                        <td><%=instFaxNo[j]%></td>       <td><%=instWbeAddress[j]%></td>
                        <td><%=contactName[j]%></td>     <td><%=contactTelNo[j]%></td>
                        <td><%=contactFaxNo[j]%></td>    <td><%=contactEmailAddress[j]%></td>                
                    </tr>
<%                  }                                                           %>
            </table>
            <br>
        </div>
    </body>
</html>

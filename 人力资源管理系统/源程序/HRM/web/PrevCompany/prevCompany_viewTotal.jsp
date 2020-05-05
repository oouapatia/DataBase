<%@page import="java.util.Iterator"%>
<%@page import="com.HRM"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // 将对应的list转化为数组，方便操作
    HRM hrm = new HRM();
    String[] prevCompanyNo = (String[]) hrm.pCompanyNo_Arr.toArray(new String[0]);
    String[] pCompanyName = (String[]) hrm.pCompanyName_Arr.toArray(new String[0]);
    String[] pCompanyStreet = (String[]) hrm.pCompanyStreet_Arr.toArray(new String[0]);
    String[] pCompanyCity = (String[]) hrm.pCompanyCity_Arr.toArray(new String[0]);
    String[] pCompanyState = (String[]) hrm.pCompanyState_Arr.toArray(new String[0]);
    String[] pCompanyZipCode = (String[]) hrm.pCompanyZipCode_Arr.toArray(new String[0]);
    String[] pCompanyTelNo = (String[]) hrm.pCompanyTelNo_Arr.toArray(new String[0]);
    String[] pCompanyFaxNo = (String[]) hrm.pCompanyFaxNo_Arr.toArray(new String[0]);
    String[] pCompanyWebAddress = (String[]) hrm.pCompanyWebAddress_Arr.toArray(new String[0]);
    String[] contactName = (String[]) hrm.pCompanycontactName_Arr.toArray(new String[0]);
    String[] contactTelNo = (String[]) hrm.pCompanycontactTelNo_Arr.toArray(new String[0]);
    String[] contactFaxNo = (String[]) hrm.pCompanycontactFaxNo_Arr.toArray(new String[0]);
    String[] contactEmailAddress = (String[]) hrm.pCompanycontactEmailAddress_Arr.toArray(new String[0]);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <link href="../css/view.css" rel="stylesheet" type="text/css" />
        <title>公司信息界面</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="result_total">
            <center><h2>公司信息</h2></center>
            <table align="center" cellspacing="2" cellpadding="10" border="1">
                <tr>
                    <td class="td_title">前公司编号</td>    <td class="td_title">公司名称</td>
                    <td class="td_title">所在街道</td>      <td class="td_title">公司所在城市</td>
                    <td class="td_title">所在国家</td>      <td class="td_title">公司邮政编码</td>	
                    <td class="td_title">公司电话号码</td>   <td class="td_title">公司传真号码</td>
                    <td class="td_title">公司网址</td>       <td class="td_title">联系人姓名</td>
                    <td class="td_title">联系人电话</td>     <td class="td_title">联系人传真号码</td>
                    <td class="td_title">联系人电子邮件地址</td>
                </tr>
<%                  int i = hrm.PrevCompany_view();    // 返回数组大小
                    for (int j = 0; j < i; j++) {                               %>
                    <tr>
                        <td><%=prevCompanyNo[j]%></td>       <td><%=pCompanyName[j]%></td>
                        <td><%=pCompanyStreet[j]%></td>      <td><%=pCompanyCity[j]%></td>
                        <td><%=pCompanyState[j]%></td>       <td><%=pCompanyZipCode[j]%></td>
                        <td><%=pCompanyTelNo[j]%></td>       <td><%=pCompanyFaxNo[j]%></td>
                        <td><%=pCompanyWebAddress[j]%></td>  <td><%=contactName[j]%></td>
                        <td><%=contactTelNo[j]%></td>        <td><%=contactFaxNo[j]%></td>
                        <td><%=contactEmailAddress[j]%></td>                   
                    </tr>
<%                  }                                                           %>
            </table>
            <br>
        </div>
    </body>
</html>

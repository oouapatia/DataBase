<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Institution.Institution_query"%>

<%
    // 获取该机构的信息数据
    String institutionNo = Institution_query.institutionNo_Arr[0];
    String institutionName = Institution_query.institutionName_Arr[0];
    String instAddress = Institution_query.instAddress_Arr[0];
    String instTelNo = Institution_query.instTelNo_Arr[0];
    String instFaxNo = Institution_query.instFaxNo_Arr[0];
    String instWbeAddress = Institution_query.instWbeAddress_Arr[0];
    String contactName = Institution_query.contactName_Arr[0];
    String contactTelNo = Institution_query.contactTelNo_Arr[0];
    String contactFaxNo = Institution_query.contactFaxNo_Arr[0];
    String contactEmailAddress = Institution_query.contactEmailAddress_Arr[0];
    
    if(institutionNo == null){
        out.println("<script type=\"text/javascript\">");
        out.println("alert(\"未输入机构编号！\");");
        out.println("document.location.href=\"institution_query.jsp\";");
        out.println("</script>");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <link href="../css/view.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/institution.js"></script>
        <title><%=institutionNo%>机构信息</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />

        <div class="result_view">
            <br><br>
            <center>
                <form name="query" action="../Institution_query" method="post" onsubmit="return check();">
                    <input class="input" type="text" placeholder="输入机构编号（*）" name="institutionNo" id="institutionNo"/>
                    <input type="submit" class="btn" name="query" value="查询">
                </form>
            </center>
            
            <center><h3><%=institutionNo%>机构信息</h3></center>
            <table align="center" cellspacing="2" cellpadding="10" border="1">
                <tr>
                    <td class="td_title">机构编号</td>          <td class="td_title">机构名称</td>
                    <td class="td_title">机构地址</td>          <td class="td_title">机构电话号码（座机）</td>
                    <td class="td_title">机构传真号码</td>      <td class="td_title">机构网址</td>	
                    <td class="td_title">联系人姓名</td>        <td class="td_title">联系人电话号码</td>
                    <td class="td_title">联系人传真号码</td>    <td class="td_title">联系人电子邮件地址</td>
                </tr>
                <tr>
                    <td><%=institutionNo%></td>                <td><%=institutionName%></td>
                    <td><%=instAddress%></td>                  <td><%=instTelNo%></td>
                    <td><%=instFaxNo%></td>                    <td><%=instWbeAddress%></td>
                    <td><%=contactName%></td>                  <td><%=contactTelNo%></td>
                    <td><%=contactFaxNo%></td>                 <td><%=contactEmailAddress%></td>
                </tr>
            </table>
        </div>
    </body>
</html>

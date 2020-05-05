<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="PrevCompany.PrevCompany_query"%>

<%
    // 获取该公司的信息数据
    String prevCompanyNo = PrevCompany_query.prevCompanyNo_Arr[0];
    String pCompanyName = PrevCompany_query.pCompanyName_Arr[0];
    String pCompanyStreet = PrevCompany_query.pCompanyStreet_Arr[0];
    String pCompanyCity = PrevCompany_query.pCompanyCity_Arr[0];
    String pCompanyState = PrevCompany_query.pCompanyState_Arr[0];
    String pCompanyZipCode = PrevCompany_query.pCompanyZipCode_Arr[0];
    String pCompanyTelNo = PrevCompany_query.pCompanyTelNo_Arr[0];
    String pCompanyFaxNo = PrevCompany_query.pCompanyFaxNo_Arr[0];
    String pCompanyWebAddress = PrevCompany_query.pCompanyWebAddress_Arr[0];
    String contactName = PrevCompany_query.contactName_Arr[0];
    String contactTelNo = PrevCompany_query.contactTelNo_Arr[0];
    String contactFaxNo = PrevCompany_query.contactFaxNo_Arr[0];
    String contactEmailAdress = PrevCompany_query.contactEmailAddress_Arr[0];
    
    if(prevCompanyNo == null){
        out.println("<script type=\"text/javascript\">");
        out.println("alert(\"未输入公司编号！\");");
        out.println("document.location.href=\"prevCompany_query.jsp\";");
        out.println("</script>");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <link href="../css/view.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/prevCompany.js"></script>
        <title><%=pCompanyName%>信息</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="result_view">
            <br><br>
            <center>
                <form name="query" action="../PrevCompany_query" method="post" onsubmit="return check();">
                    <input class="input" type="text" placeholder="输入公司编号（*）" name="prevCompanyNo" id="prevCompanyNo"/>
                    <input type="submit" class="btn" name="query" value="查询">
                </form>
            </center>
            
            <center><h3><%=pCompanyName%>信息</h3></center>
            <table align="center" cellspacing="2" cellpadding="10" border="1">
                <tr>
                    <td class="td_title">前公司编号</td>        <td class="td_title">前公司名称</td>
                    <td class="td_title">前公司所在街道</td>    <td class="td_title">前公司所在城市</td>
                    <td class="td_title">前公司所在国家</td>    <td class="td_title">前公司邮政编码</td>	
                    <td class="td_title">前公司电话号码</td>    <td class="td_title">前公司传真号码</td>
                    <td class="td_title">前公司网址</td>        <td class="td_title">联系人姓名</td>
                    <td class="td_title">联系人电话</td>        <td class="td_title">联系人传真号码</td>
                    <td class="td_title">联系人电子邮件地址</td>
                </tr>
                <tr>
                    <td><%=prevCompanyNo%></td>             <td><%=pCompanyName%></td>
                    <td><%=pCompanyStreet%></td>            <td><%=pCompanyCity%></td>
                    <td><%=pCompanyState%></td>             <td><%=pCompanyZipCode%></td>
                    <td><%=pCompanyTelNo%></td>             <td><%=pCompanyFaxNo%></td>
                    <td><%=pCompanyWebAddress%></td>        <td><%=contactName%></td>
                    <td><%=contactTelNo%></td>              <td><%=contactFaxNo%></td>
                    <td><%=contactEmailAdress%></td>
                </tr>
            </table>
        </div>
    </body>
</html>

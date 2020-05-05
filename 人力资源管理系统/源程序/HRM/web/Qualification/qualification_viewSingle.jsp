<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Qualification.Qualification_query"%>

<%
    // 获取该岗位的信息数据
    String qualificationName = Qualification_query.qualificationName_Arr[0];
    String employeeNo = Qualification_query.employeeNo_Arr[0];
    String gradeObtained = Qualification_query.gradeObtained_Arr[0];
    String startQualDate = Qualification_query.startQualDate_Arr[0];
    String endQualDate = Qualification_query.endQualDate_Arr[0];
    String gpa = Qualification_query.gpa_Arr[0];
    String insititutionNo = Qualification_query.insititutionNo_Arr[0];

    if (employeeNo == null) {
        out.println("<script type=\"text/javascript\">");
        out.println("alert(\"未输入员工编号！\");");
        out.println("document.location.href=\"qualification_query.jsp\";");
        out.println("</script>");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <link href="../css/view.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/qualification.js"></script>
        <title>学历信息</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="result_view">
            <br><br>
            <center>    
                <form name="query" action="../Qualification_query" method="post" onsubmit="return check();">
                    <input class="input" type="text" placeholder="输入员工编号（*）" name="employeeNo" id="employeeNo"/>
                    <input type="submit" class="btn" name="query" value="查询">
                </form>
            </center>
            
            <center><h3>员工<%=employeeNo%>学历信息</h3></center>
            <table align="center" cellspacing="2" cellpadding="10" border="1">
                <tr>
                    <td class="td_title">学历</td>              <td class="td_title">员工编号</td>
                    <td class="td_title">获得的等级</td>        <td class="td_title">合格开始时间</td>
                    <td class="td_title">合格结束时间</td>      <td class="td_title">绩点</td>
                    <td class="td_title">机构编号</td>     
                </tr>
                <tr>
                    <td><%=qualificationName%></td>     <td><%=employeeNo%></td>
                    <td><%=gradeObtained%></td>         <td><%=startQualDate%></td>
                    <td><%=endQualDate%></td>           <td><%=gpa%></td>
                    <td><%=insititutionNo%></td>    
                </tr>
            </table>
        </div>
    </body>
</html>

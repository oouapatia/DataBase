<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Grade.Grade_query"%>

<%
    // 获取该等级的信息数据
    String gradeNo = Grade_query.gradeNo_Arr[0];
    String validFromDate = Grade_query.validFromDate_Arr[0];
    String validToDate = Grade_query.validToDate_Arr[0];
    String gradeDescrible = Grade_query.gradeDescrible_Arr[0];
    String gradesalary = Grade_query.gradesalary_Arr[0];
    String noDaysLeaveEntitlement = Grade_query.noDaysLeaveEntitlement_Arr[0];
    String positionTypeNo = Grade_query.positionTypeNo_Arr[0];
    
    if(gradeNo == null){
        out.println("<script type=\"text/javascript\">");
        out.println("alert(\"未输入等级编号！\");");
        out.println("document.location.href=\"grade_query.jsp\";");
        out.println("</script>");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <link href="../css/view.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/grade.js"></script>
        <title><%=gradeNo%>等级信息</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="result_view">
            <br><br>
            <center>
                <form name="query" action="../Grade_query" method="post" onsubmit="return check();">
                    <input class="input" type="text" placeholder="输入职位类型编号（*）" name="positionTypeNo" id="positionTypeNo"/>
                    <input type="submit" class="btn" name="query" value="查询">
                </form>
            </center>
            
            <center><h3><%=gradeNo%>等级信息</h3></center>
            <table align="center" cellspacing="2" cellpadding="10" border="1">
                <tr>
                    <td class="td_title">等级编号</td>      <td class="td_title">正式开始日期</td>
                    <td class="td_title">有效截止日期</td>  <td class="td_title">等级描述</td>
                    <td class="td_title">等级薪水</td>      <td class="td_title">休假时间天数</td>	
                    <td class="td_title">职位类型编号</td> 
                </tr>
                <tr>
                    <td><%=gradeNo%></td>                   <td><%=validFromDate%></td>
                    <td><%=validToDate%></td>               <td><%=gradeDescrible%></td>
                    <td><%=gradesalary%></td>               <td><%=noDaysLeaveEntitlement%></td>
                    <td><%=positionTypeNo%></td>           
                </tr>
            </table>
        </div>
    </body>
</html>

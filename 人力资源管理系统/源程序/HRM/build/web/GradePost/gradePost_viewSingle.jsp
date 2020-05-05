<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="GradePost.GradePost_query"%>

<%
    // 获取该等级的信息数据
    String gradeNo = GradePost_query.gradeNo_Arr[0];
    String validFromDate = GradePost_query.validFromDate_Arr[0];
    String postNo = GradePost_query.postNo_Arr[0];
    String availableFromDate = GradePost_query.availableFromDate_Arr[0];
  
    if(postNo == null){
        out.println("<script type=\"text/javascript\">");
        out.println("alert(\"未输入岗位编号！\");");
        out.println("document.location.href=\"gradePost_query.jsp\";");
        out.println("</script>");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <link href="../css/view.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/gradePost.js"></script>
        <title><%=postNo%>岗位的职等职位信息</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="result_view">
            <br><br>
            <center>
                <form name="query" action="../GradePost_query" method="post" onsubmit="return check();">
                    <input class="input" type="text" placeholder="输入岗位编号（*）" name="postNo" id="postNo"/>
                    <input type="submit" class="btn" name="query" value="查询">
                </form>
            </center>
            
            <center><h3><%=postNo%>岗位的职等职位信息</h3></center>
            <table align="center" cellspacing="2" cellpadding="10" border="1">
                <tr>
                    <td class="td_title">等级编号</td>    <td class="td_title">有效开始日期</td>
                    <td class="td_title">岗位编号</td>    <td class="td_title">开始日期</td>
                </tr>
                <tr>
                    <td><%=gradeNo%></td>              <td><%=validFromDate%></td>
                    <td><%=postNo%></td>               <td><%=availableFromDate%></td>         
                </tr>
            </table>
        </div>
    </body>
</html>

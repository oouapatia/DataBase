<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Review.Review_query"%>

<%
    // 获取员工的评价信息数据
    String revieweeEmployeeNo = Review_query.revieweeEmployeeNo_Arr[0];
    String reviewerEmployeeNo = Review_query.reviewerEmployeeNo_Arr[0];
    String reviewDate = Review_query.reviewDate_Arr[0];
    String comments = Review_query.comments_Arr[0];

    if(reviewerEmployeeNo == null){
        out.println("<script type=\"text/javascript\">");
        out.println("alert(\"未输入评价者编号！\");");
        out.println("document.location.href=\"reviewe_query.jsp\";");
        out.println("</script>");
    }
    if(revieweeEmployeeNo == null){
        out.println("<script type=\"text/javascript\">");
        out.println("alert(\"未输入被评价者编号！\");");
        out.println("document.location.href=\"reviewe_query.jsp\";");
        out.println("</script>");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <link href="../css/view.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/reviewe.js"></script>
        <title><%=revieweeEmployeeNo%>员工评价信息</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="result_view">
            <br><br>
            <center>
                <form name="query" action="../Review_query" method="post" onsubmit="return check();">
                    <input class="input" type="text" placeholder="输入评价者编号（*）" name="reviewerEmployeeNo" id="reviewerEmployeeNo"/><br>
                    <input class="input" type="text" placeholder="输入被评价者编号（*）" name="revieweeEmployeeNo" id="revieweeEmployeeNo"/><br>
                    <input type="submit" class="btn" name="query" value="查询">
                </form>
            </center>
            
            <center><h3><%=revieweeEmployeeNo%>员工评价信息</h3></center>
            <table align="center" cellspacing="2" cellpadding="10" border="1">
                <tr>
                    <td class="td_title">被评价者编号</td>      <td class="td_title">评价者编号</td>
                    <td class="td_title">评价日期</td>          <td class="td_title">评价</td>
                </tr>
                <tr>
                    <td><%=revieweeEmployeeNo%></td>           <td><%=reviewerEmployeeNo%></td>
                    <td><%=reviewDate%></td>                   <td><%=comments%></td>
                </tr>
            </table>
        </div>
    </body>
</html>
 
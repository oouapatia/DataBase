<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Post.Post_query"%>

<%
    // 获取该岗位的信息数据
    String postNo = Post_query.postNo_Arr[0];
    String availableFromDate = Post_query.availableFromDate_Arr[0];
    String availableToDate = Post_query.availableToDate_Arr[0];
    String postDescription = Post_query.postDescription_Arr[0];
    String salariedHourly = Post_query.salariedHourly_Arr[0];
    String fullPartTime = Post_query.fullPartTime_Arr[0];
    String temporaryPermanent = Post_query.temporaryPermanent_Arr[0];
    String freeLaborStandardsActExempt = Post_query.freeLabor_Arr[0];
    String departmentNo = Post_query.departmentNo_Arr[0];

    if (postNo == null) {
        out.println("<script type=\"text/javascript\">");
        out.println("alert(\"未输入岗位编号！\");");
        out.println("document.location.href=\"post_query.jsp\";");
        out.println("</script>");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <link href="../css/view.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/post.js"></script>
        <title>岗位信息</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="result_view">
            <br><br>
            <center>
                <form name="query" action="../Post_query" method="post" onsubmit="return check();">
                    <input class="input" type="text" placeholder="输入岗位编号（*）" name="postNo" id="postNo"/>
                    <input type="submit" class="btn" name="query" value="查询">
                </form>
            </center>
            
            <center><h3>岗位信息</h3></center>
            <table align="center" cellspacing="2" cellpadding="10" border="1">
                <tr>
                    <td class="td_title">岗位编号</td>              <td class="td_title">开始日期</td>
                    <td class="td_title">结束日期</td>              <td class="td_title">岗位描述</td>
                    <td class="td_title">时薪</td>                  <td class="td_title">全职或者兼职</td>
                    <td class="td_title">实习生或者正式员工</td>     <td class="td_title">是否购买五金一险</td>
                    <td class="td_title">部门编号</td>
                </tr>
                <tr>
                    <td><%=postNo%></td>                 <td><%=availableFromDate%></td>
                    <td><%=availableToDate%></td>        <td><%=postDescription%></td>
                    <td><%=salariedHourly%></td>         <td><%=fullPartTime%></td>
                    <td><%=temporaryPermanent%></td>     <td><%=freeLaborStandardsActExempt%></td>
                    <td><%=departmentNo%></td>                
                </tr>
            </table>
        </div>
    </body>
</html>

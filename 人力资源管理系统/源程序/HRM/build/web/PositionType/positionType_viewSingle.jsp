<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="PositionType.PositionType_query"%>

<%
    // 获取该职位类型的信息数据
    String positionTypeNo = PositionType_query.positionTypeNo_Arr[0];
    String positionTypeDescription = PositionType_query.description_Arr[0];
    
    if(positionTypeNo == null){
        out.println("<script type=\"text/javascript\">");
        out.println("alert(\"未输入职位类型编号！\");");
        out.println("document.location.href=\"positionType_query.jsp\";");
        out.println("</script>");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <link href="../css/view.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/positionType.js"></script>
        <title>职位类型信息</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="result_view">
            <br><br>
            <center>
                <form name="query" action="../PositionType_query" method="post" onsubmit="return check();">
                    <input class="input" type="text" placeholder="输入职位类型编号（*）" name="positionTypeNo" id="positionTypeNo"/>
                    <input type="submit" class="btn" name="query" value="查询">
                </form>
            </center>
            
            <center><h3>职位类型信息</h3></center>
            <table align="center" cellspacing="2" cellpadding="10" border="1">
                <tr>
                    <td class="td_title">职位类型编号</td>          <td class="td_title">职位类型描述</td>
                </tr>
                <tr>
                    <td><%=positionTypeNo%></td>                <td><%=positionTypeDescription%></td>
                </tr>
            </table>
        </div>
    </body>
</html>
 
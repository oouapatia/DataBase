<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/qualification.js"></script>
        <title>查询学历</title>          
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="operate-title">&nbsp;&nbsp;查询学历信息</div>
        <div class="result">
            <form name="query" action="../Qualification_query" method="post" onsubmit="return check();">
                <center>
                    <br><br>
                    员工编号：<input class="input" type="text" placeholder="输入员工编号（*）" name="employeeNo" id="employeeNo"/>
                    <br><br>
                    <input type="submit" class="btn" name="query" value="查询">
                </center>
            </form>
        </div>
    </body>
</html>

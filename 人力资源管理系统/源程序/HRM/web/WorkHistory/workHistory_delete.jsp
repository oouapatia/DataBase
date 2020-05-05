<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/workHistory.js"></script>
        <title>工作历史</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />

        <div class="operate-title">&nbsp;&nbsp;删除员工工作历史</div>
        <div class="result">
            <form name="alter" action="../WorkHistory_delete" method="post" onsubmit="return check();">
                <center>
                    <br><br>
                    员工编号：<input class="input" type="text" placeholder="输入员工编号（*）" name="employeeNo" id="employeeNo"/>
                    <br><br>
                    <input type="submit" class="btn" name="alter" value="删除">
                </center>
            </form>
        </div>

    </body>
</html>

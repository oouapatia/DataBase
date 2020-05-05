<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/department.js"></script>
        <title>查询部门信息</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="operate-title">&nbsp;&nbsp;查询部门信息</div>
        <div class="result">
            <form name="query" action="../Department_query" method="post" onsubmit="return check();">
                <center>
                    <div class="operate">
                        <br><br>
                        部门编号：<input class="input" type="text" placeholder="输入部门编号（*）" name="departmentNo" id="departmentNo"/>
                        <br><br>
                        <input type="submit" class="btn" name="query" value="查询">
                    </div>
                </center>
            </form>
        </div>
    </body>
</html>

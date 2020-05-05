<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/department.js"></script>
        <title>删除部门信息</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="operate-title">&nbsp;&nbsp;删除部门</div>
        <div class="result">
            <form name="delete" action="../Department_delete" method="post" onsubmit="return check();">
                <center>
                    <div class="operate">
                        <br><br>
                        部门编号：<input type="text" class="input" placeholder="输入部门编号（*）" name="departmentNo" id="departmentNo"/>
                        <br><br>
                        <input type="submit" class="btn" name="alter" value="删除">
                    </div>
                </center>
            </form>
        </div>
    </body>
</html>

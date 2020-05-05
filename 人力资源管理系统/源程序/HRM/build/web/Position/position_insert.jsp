<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/position.js"></script>
        <title>添加职位信息</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="operate-title">&nbsp;&nbsp;增加职位</div>
        <div class="result">
            <form name="update" action="../Position_insert" method="post" onsubmit="return insert_check();">
                <center>
                    <br><br>
                    员工编号：<input class="input" type="text" placeholder="输入员工编号（*）" name="employeeNo" id="employeeNo"/><br><br>
                    职位编号：<input class="input" type="text" placeholder="输入职位编号（*）" name="postNo" id="postNo"/><br><br>
                    入职时间：<input class="input" type="text" placeholder="输入入职时间（*）" name="startDate" id="startDate"/><br><br>
                    离职时间：<input class="input" type="text" placeholder="输入离职时间" name="endDate" id="endDate"/>
                    <br><br>
                    <input type="submit" class="btn" name="alter" value="添加">
                </center>
            </form>
        </div>
    </body>
</html>

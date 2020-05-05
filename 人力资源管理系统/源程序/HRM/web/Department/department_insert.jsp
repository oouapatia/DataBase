<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/department.js"></script>
        <title>添加部门信息</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="operate-title">&nbsp;&nbsp;添加部门</div>
        <div class="result">
            <form name="update" action="../Department_insert" method="post" onsubmit="return insert_check();">
                <center>
                    <br><br>
                    部门编号：<input class="input" type="text" placeholder="输入部门编号（*）" name="departmentNo" id="departmentNo"/><br><br>
                    部门名字：<input class="input" type="text" placeholder="输入部门名字（*）" name="departmentName" id="departmentName"/><br><br>
                    部门位置：<input class="input" type="text" placeholder="输入部门位置" name="deptLocation" id="deptLocation"/><br><br>
                    管理人员编号：<input class="input" type="text" placeholder="输入管理人员编号（*）" name="managerEmployeeNo" id="managerEmployeeNo"/>
                    <br><br>
                    <input type="submit" class="btn" name="alter" value="添加">
                </center>
            </form>
        </div>
    </body>
</html>

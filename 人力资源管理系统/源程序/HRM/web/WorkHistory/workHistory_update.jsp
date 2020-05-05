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

        <div class="operate-title">&nbsp;&nbsp;修改员工工作历史</div>
        <div class="result">
            <form name="alter" action="../WorkHistory_update" method="post" onsubmit="return check();">
                <center>
                    <br><br>
                    员工编号：<input class="input" type="text" placeholder="输入员工编号（*）" name="employeeNo"id="employeeNo"/><br><br>
                    前公司编号：<input class="input" type="text" placeholder="输入前公司编号" name="prevCompanyNo" id="prevCompanyNo"/><br><br>
                    前任公司职位：<input class="input" type="text" placeholder="输入前任公司职位" name="prevPosition" id="prevPosition"/><br><br>
                    前任公司岗位等级：<input class="input" type="text" placeholder="输入前任公司岗位等级" name="prevGrade" id="prevGrade"/><br><br>
                    前任公司薪水：<input class="input" type="text" placeholder="输入前任公司薪水" name="prevSalary" id="prevSalary"/><br><br>
                    前任公司位置：<input class="input" type="text" placeholder="输入前任公司位置" name="prevLocation" id="prevLocation"/><br><br>
                    在前任公司负责内容：<input class="input" type="text" placeholder="输入在前任公司负责内容" name="prevResponsibilities" id="prevResponsibilities"/>
                    <br><br>
                    <input type="submit" class="btn" name="alter" value="修改">
                </center>
            </form>
        </div>

    </body>
</html>

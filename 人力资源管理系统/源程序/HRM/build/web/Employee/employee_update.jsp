<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/employee.js"></script>
        <title>修改员工信息</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="operate-title">&nbsp;&nbsp;修改员工信息</div>
        <div class="result">
            <form name="alter" action="../Employee_update" method="post" onsubmit="return check();">
                <center>
                    <br><br>
                    员工编号：<input class="input" type="text" placeholder="输入员工编号（*）" name="employeeNo" id="employeeNo"/>
                    职称：<input class="input" type="text" placeholder="输入职称" name="title" id="title"/><br><br>
                    地址：<input class="input" type="text" placeholder="输入地址" name="address" id="address"/>
                    工作电传：<input class="input" type="text" placeholder="输入工作电传（11位）" name="workTelExt" id="workTelExt"/><br><br>
                    家庭电话：<input class="input" type="text" placeholder="输入家庭电话号码（11位）" name="homeTelNo" id="homeTelNo"/>
                    电子邮件地址：<input class="input" type="text" placeholder="输入电子邮件地址" name="empEmailAddress" id="empEmailAddress"/><br><br>
                    出生日期：<input class="input" type="text" placeholder="输入出生日期（例：1999-01-03）" name="DOB" id="DOB"/>
                    职务：<input class="input" type="text" placeholder="输入职务" name="position" id="position"/><br><br>
                    性别：<input class="input" type="text" placeholder="输入性别（男或女）" name="sex" id="sex"/>
                    薪水：<input class="input" type="text" placeholder="输入薪水" name="salary" id="salary"/><br><br>
                    入职时间：<input class="input" type="text" placeholder="输入入职时间" name="dateStarted" id="dateStarted"/>
                    离职时间：<input class="input" type="text" placeholder="输入离职时间" name="dateLeft" id="dateLeft"/>
                    <br><br>
                    <input type="submit" class="btn" name="alter" value="修改">
                </center>
            </form>
        </div>
    </body>
</html>

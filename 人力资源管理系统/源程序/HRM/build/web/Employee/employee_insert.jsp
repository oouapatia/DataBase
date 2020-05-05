<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/employee.js"></script>
        <title>添加员工信息</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />

        <div class="operate-title">&nbsp;&nbsp;增加员工</div>
        <div class="result">
            <form name="update" action="../Employee_insert" method="post" onsubmit="return insert_check();">
                <center>
                    <div class="operate-title"></div>
                    员工编号：<input class="input" type="text" placeholder="输入员工编号（*）" name="employeeNo" id="employeeNo"/>
                    职称：<input class="input" type="text" placeholder="输入职称" name="title" id="title"/><br><br>
                    姓：<input class="input" type="text" placeholder="输入姓（*）" name="lastName" id="lastName"/>
                    教名：<input class="input" type="text" placeholder="输入教名（中间名）" name="middleName" id="middleName"/><br><br>
                    名：<input class="input" type="text" placeholder="输入名（*）" name="firstName" id="firstName"/>
                    地址：<input class="input" type="text" placeholder="输入地址" name="address" id="address"/><br><br>
                    工作电传：<input class="input" type="text" placeholder="输入工作电传" name="workTelExt" id="workTelExt"/>
                    家庭电话号码：<input class="input" type="text" placeholder="输入家庭电话号码" name="homeTelNo" id="homeTelNo"/><br><br>
                    电子邮件地址：<input class="input" type="text" placeholder="输入电子邮件地址" name="empEmailAddress" id="empEmailAddress"/>
                    身份证号码：<input class="input" type="text" placeholder="输入身份证号码（*）" name="socialSecurityNumber" id="socialSecurityNumber"/><br><br>
                    出生日期：<input class="input" type="text" placeholder="输入出生日期" name="DOB" id="DOB"/>
                    职务：<input class="input" type="text" placeholder="输入职务" name="position" id="position"/><br><br>
                    性别：<input class="input" type="text" placeholder="输入性别（*）" name="sex" id="sex"/>
                    薪水：<input class="input" type="text" placeholder="输入薪水（*）" name="salary" id="salary"/><br><br>
                    入职时间：<input class="input" type="text" placeholder="输入入职时间" name="dateStarted" id="dateStarted"/>
                    离职时间：<input class="input" type="text" placeholder="输入离职时间" name="dateLeft" id="dateLeft"/><br><br>
                    部门编号：<input class="input" type="text" placeholder="输入部门编号（*）" name="departmentNo" id="departmentNo"/>
                    主管员工编号：<input class="input" type="text" placeholder="输入主管员工编号（*）" name="supervisorEmployeeNo" id="supervisorEmployeeNo"/>
                    <br><br>
                    <input type="submit" class="btn" name="alter" value="添加">
                </center>
            </form>
        </div>
    </body>
</html>

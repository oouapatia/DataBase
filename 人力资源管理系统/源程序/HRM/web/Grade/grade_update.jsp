<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/grade.js"></script>
        <title>修改等级</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="operate-title">&nbsp;&nbsp;修改等级信息</div>
        <div class="result">
            <form name="alter" action="../Grade_update" method="post" onsubmit="return check();">
                <center>
                    <br><br>
                    职位类型编号：<input class="input" type="text" placeholder="输入职位类型编号（*）" name="positionTypeNo" id="positionTypeNo"/><br><br>
                    等级编号：<input class="input" type="text" placeholder="输入等级编号" name="gradeNo" id="gradeNo"/><br><br>
                    有效开始日期：<input class="input" type="text" placeholder="输入有效开始日期" name="validFromDate" id="validFromDate"/><br><br>
                    有效截止日期：<input class="input" type="text" placeholder="输入有效截止日期" name="validToDate" id="validToDate"/><br><br>
                    等级描述：<input class="input" type="text" placeholder="输入等级描述" name="gradeDescrible" id="gradeDescrible"/><br><br>
                    等级薪水：<input class="input" type="text" placeholder="输入等级薪水" name="gradesalary" id="gradesalary"/><br><br>
                    休假时间天数：<input class="input" type="text" placeholder="输入休假时间天数" name="noDaysLeaveEntitlement" id="noDaysLeaveEntitlement"/>
                    <br><br>
                    <input type="submit" class="btn" name="alter" value="修改">
                </center>
            </form>
        </div>
    </body>
</html>

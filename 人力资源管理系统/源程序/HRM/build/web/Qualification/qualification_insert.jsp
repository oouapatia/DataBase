<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/qualification.js"></script>
        <title>添加学历</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="operate-title">&nbsp;&nbsp;添加学历</div>
        <div class="result">
            <form name="update" action="../Qualification_insert" method="post" onsubmit="return insert_check();">
                <center>
                    <br><br>
                    员工编号：<input class="input" type="text" placeholder="输入员工编号（*）" name="employeeNo" id="employeeNo"/><br><br>
                    学历：<input class="input" type="text" placeholder="输入学历（*）" name="qualificationName" id="qualificationName"/><br><br>
                    获得的等级：<input class="input" type="text" placeholder="输入获得的等级" name="gradeObtained" id="gradeObtained"/><br><br>
                    合格开始时间：<input class="input" type="text" placeholder="输入合格开始时间" name="startQualDate" id="startQualDate"/><br><br>
                    合格结束时间;<input class="input" type="text" placeholder="输入合格结束时间" name="endQualDate" id="endQualDate"/><br><br>
                    绩点:<input class="input" type="text" placeholder="输入绩点" name="gpa" id="gpa"/><br><br>
                    机构编号:<input class="input" type="text" placeholder="输入机构编号（*）" name="institutionNo" id="institutionNo"/>
                    <br><br>
                    <input type="submit" class="btn" name="alter" value="添加">
                </center>
            </form>
        </div>
    </body>
</html>

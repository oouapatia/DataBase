<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/gradePost.js"></script>
        <title>添加职等职位信息</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="operate-title">&nbsp;&nbsp;添加职等职位信息</div>
        <div class="result">
            <form name="update" action="../GradePost_insert" method="post" onsubmit="return insert_check();">
                <center>
                    <br><br>
                    岗位编号：<input class="input" type="text" placeholder="输入岗位编号（*）" name="postNo" id="postNo"/><br><br>
                    等级编号：<input class="input" type="text" placeholder="输入等级编号（*）" name="gradeNo" id="gradeNo"/><br><br>
                    有效开始日期：<input class="input" type="text" placeholder="输入有效开始日期（*）" name="validFromDate" id="validFromDate"/><br><br>
                    开始日期：<input class="input" type="text" placeholder="输入开始日期（*）" name="availableFromDate" id="availableFromDate"/>
                    <br><br>
                    <input type="submit" class="btn" name="alter" value="添加">
                </center>
            </form>
        </div>
    </body>
</html>

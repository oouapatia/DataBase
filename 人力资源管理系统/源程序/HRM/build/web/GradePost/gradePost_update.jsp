<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/gradePost.js"></script>
        <title>修改职等职位信息</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="operate-title">&nbsp;&nbsp;修改职等职位信息</div>
        <div class="result">
            <form name="alter" action="../GradePost_update" method="post" onsubmit="return update_check();">
                <center>
                    <br><br>
                    岗位编号：<input class="input" type="text" placeholder="输入岗位编号（*）" name="postNo" id="postNo"/><br><br>
                    等级编号：<input class="input" type="text" placeholder="输入等级编号（*）" name="gradeNo" id="gradeNo"/><br><br>
                    有效开始日期：<input class="input" type="text" placeholder="输入有效开始日期（*）" name="validFromDate" id="validFromDate"/><br><br>
                    <br><br>
                    <input type="submit" class="btn" name="alter" value="修改">
                </center>
            </form>
        </div>
    </body>
</html>

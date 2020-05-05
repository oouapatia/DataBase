<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/post.js"></script>
        <title>删除岗位</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="operate-title">&nbsp;&nbsp;删除岗位</div>
        <div class="result">
            <form name="delete" action="../Post_delete" method="post" onsubmit="return check();">
                <center>
                    <br><br>
                    职位类型编号：<input class="input" type="text" placeholder="输入职位类型编号（*）" name="postNo" id="postNo"/>
                    <br><br>
                    <input type="submit" class="btn" name="alter" value="删除">
                </center>
            </form>
        </div>
    </body>
</html>

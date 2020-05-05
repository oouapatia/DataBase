<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/reviewe.js"></script>
        <title>修改评价信息</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="operate-title">&nbsp;&nbsp;修改评价信息</div>
        <div class="result">
            <form name="alter" action="../Review_update" method="post" onsubmit="return check();">
                <center>
                    <br><br>
                    评价者编号：<input class="input" type="text" placeholder="输入评价者编号（*）" name="reviewerEmployeeNo" id="reviewerEmployeeNo"/><br><br>
                    被评价者编号：<input class="input" type="text" placeholder="输入被评价者编号（*）" name="revieweeEmployeeNo" id="revieweeEmployeeNo"/><br><br>
                    评价日期：<input class="input" type="text" placeholder="输入评价日期" name="reviewDate" id="reviewDate"/><br><br>
                    评价：<input class="input" type="text" placeholder="输入评价" name="comments" id="comments"/>
                    <br><br>
                    <input type="submit" class="btn" name="alter" value="修改">
                </center>
            </form>
        </div>
    </body>
</html>

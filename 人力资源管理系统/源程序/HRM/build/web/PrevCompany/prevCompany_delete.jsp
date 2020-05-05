<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/prevCompany.js"></script>
        <title>删除公司信息</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="operate-title">&nbsp;&nbsp;删除公司信息</div>
        <div class="result">
            <form name="delete" action="../PrevCompany_delete" method="post" onsubmit="return check();">
                <center>
                    <br><br>
                    前公司编号：<input class="input" type="text" placeholder="输入前公司编号（*）" name="prevCompanyNo" id="prevCompanyNo"/>
                    <br><br>
                    <input type="submit" class="btn" name="alter" value="删除">
                </center>
            </form>
        </div>
    </body>
</html>

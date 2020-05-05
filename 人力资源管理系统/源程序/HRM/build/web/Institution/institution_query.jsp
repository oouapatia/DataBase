<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/institution.js"></script>
        <title>查询机构信息</title>          
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="operate-title">&nbsp;&nbsp;查询机构信息</div>
        <div class="result">
            <form name="query" action="../Institution_query" method="post" onsubmit="return check();">
                <center>
                    <br><br>
                    机构编号：<input class="input" type="text" placeholder="输入机构编号（*）" name="institutionNo" id="institutionNo"/>
                    <br><br>
                    <input type="submit" class="btn" name="query" value="查询">
                </center>
            </form>
        </div>
    </body>
</html>

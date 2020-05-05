<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/post.js"></script>
        <title>修改岗位</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="operate-title">&nbsp;&nbsp;修改岗位信息</div>
        <div class="result">
            <form name="alter" action="../Post_update" method="post" onsubmit="return check();">
                <center>
                    <br><br>
                    岗位编号：<input class="input" type="text" placeholder="输入岗位编号（*）" name="postNo" id="postNo"/><br><br>
                    开始日期：<input class="input" type="text" placeholder="输入开始日期" name="availableFromDate" id="availableFromDate"/><br><br>
                    结束日期：<input class="input" type="text" placeholder="输入结束日期" name="availableToDate" id="availableToDate"/><br><br>
                    岗位描述：<input class="input" type="text" placeholder="输入岗位描述" name="postDescription" id="postDescription"/><br><br>
                    时薪：<input class="input" type="text" placeholder="输入时薪" name="salariedHourly" id="salariedHourly"/><br><br>
                    全职或兼职：<input class="input" type="text" placeholder="全职或兼职" name="fullPartTime" id="fullPartTime"/><br><br>
                    实习或正式：<input class="input" type="text" placeholder="实习生或正式员工" name="temporaryPermanent" id="temporaryPermanent"/><br><br>
                    五金一险：<input class="input" type="text" placeholder="是否购买五金一险" name="freeLaborStandardsActExempt" id="freeLaborStandardsActExempt"/><br><br>
                    部门编号：<input class="input" type="text" placeholder="输入部门编号" name="departmentNo" id="departmentNo"/>
                    <br><br>
                    <input type="submit" class="btn" name="alter" value="修改">
                </center>
            </form>
        </div>
    </body>
</html>

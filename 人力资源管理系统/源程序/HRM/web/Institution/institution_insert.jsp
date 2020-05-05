<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/institution.js"></script>
        <title>添加机构信息</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="operate-title">&nbsp;&nbsp;添加机构</div>
        <div class="result">
            <form name="update" action="../Institution_insert" method="post" onsubmit="return insert_check();">
                <center>
                    <br>
                    机构编号：<input class="input" type="text" placeholder="输入机构编号（*）" name="institutionNo" id="institutionNo"/><br><br>
                    机构名称：<input class="input" type="text" placeholder="输入机构名称（*）" name="institutionName" id="institutionName"/><br><br>
                    机构地址：<input class="input" type="text" placeholder="输入机构地址" name="instAddress" id="instAddress"/><br><br>
                    机构电话：<input class="input" type="text" placeholder="输入机构电话" name="instTelNo" id="instTelNo"/><br><br>
                    机构传真：<input class="input" type="text" placeholder="输入机构传真" name="instFaxNo" id="instFaxNo"/><br><br>
                    机构网址：<input class="input" type="text" placeholder="输入机构网址" name="instWbeAddress" id="instWbeAddress"/><br><br>
                    联系人姓名：<input class="input" type="text" placeholder="输入联系人姓名（*）" name="contactName" id="contactName"/><br><br>
                    联系人电话：<input class="input" type="text" placeholder="输入联系人电话（*）" name="contactTelNo" id="contactTelNo"/><br><br>
                    联系人传真：<input class="input" type="text" placeholder="输入联系人传真" name="contactFaxNo" id="contactFaxNo"/><br><br>
                    联系人电子邮件：<input class="input" type="text" placeholder="输入联系人电子邮件" name="contactEmailAddress" id="contactEmailAddress"/>
                    <br><br>
                    <input type="submit" class="btn" name="alter" value="添加">
                </center>
            </form>
        </div>
    </body>
</html>

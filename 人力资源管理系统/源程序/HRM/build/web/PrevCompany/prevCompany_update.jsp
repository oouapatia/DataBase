<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/operation.css" rel="stylesheet" type="text/css" />
        <script src="../javaScript/prevCompany.js"></script>
        <title>修改公司信息</title>
    </head>
    <body>
        <jsp:include page="../navigate.jsp" />
        <jsp:include page="../logout.jsp" />
        
        <div class="operate-title">&nbsp;&nbsp;修改机构信息</div>
        <div class="result">
            <form name="alter" action="../PrevCompany_update" method="post" onsubmit="return check();">
                <center>
                    <br><br>
                    公司编号：<input class="input" type="text" placeholder="输入公司编号（*）" name="prevCompanyNo" id="prevCompanyNo"/>
                    公司名称：<input class="input" type="text" placeholder="输入公司名称" name="pCompanyName" id="pCompanyName"/><br><br>
                    公司所在街道：<input class="input" type="text" placeholder="输入公司所在街道" name="pCompanyStreet" id="pCompanyStreet"/>
                    公司所在城市：<input class="input" type="text" placeholder="输入公司所在城市" name="pCompanyCity" id="pCompanyCity"/><br><br>
                    公司所在国家：<input class="input" type="text" placeholder="输入公司所在国家" name="pCompanyState" id="pCompanyState"/>
                    公司邮政编码：<input class="input" type="text" placeholder="输入公司邮政编码" name="pCompanyZipCode" id="pCompanyZipCode"/><br><br>
                    公司电话：<input class="input" type="text" placeholder="输入公司电话（座机）" name="pCompanyTelNo" id="pCompanyTelNo"/>
                    公司传真：<input class="input" type="text" placeholder="输入公司传真" name="pCompanyFaxNo" id="pCompanyFaxNo"/><br><br>
                    公司网址：<input class="input" type="text" placeholder="输入公司网址" name="pCompanyWebAddress" id="pCompanyWebAddress"/>
                    联系人姓名：<input class="input" type="text" placeholder="输入联系人姓名" name="contactName" id="contactName"/><br><br>
                    联系人电话：<input class="input" type="text" placeholder="输入联系人电话" name="contactTelNo" id="contactTelNo"/>
                    联系人传真：<input class="input" type="text" placeholder="输入联系人传真" name="contactFaxNo" id="contactFaxNo"/><br><br>
                    联系人电子邮件：<input class="input" type="text" placeholder="输入联系人电子邮件（*）" name="contactEmailAddress" id="contactEmailAddress"/>
                    <br><br>
                    <input type="submit" class="btn" name="alter" value="修改">
                </center>
            </form>
        </div>
    </body>
</html>

function check() {
    var prevCompanyNo = document.getElementById('prevCompanyNo').value;
    if (prevCompanyNo == "") {
        alert("请输入公司编号！");
        document.getElementById('prevCompanyNo').focus();
        return false;
    }
    return true;
}

function insert_check() {
    var prevCompanyNo = document.getElementById('prevCompanyNo').value;
    var pCompanyName = document.getElementById('pCompanyName').value;
    var pCompanyState = document.getElementById('pCompanyState').value;
    var pCompanyZipCode = document.getElementById('pCompanyZipCode').value;
    var contactName = document.getElementById('contactName').value;
    var contactTelNo = document.getElementById('contactTelNo').value;
    var contactEmailAddress = document.getElementById('contactEmailAddress').value;
    
    if (prevCompanyNo == "") {
        alert("请输入公司编号！");
        document.getElementById('prevCompanyNo').focus();
        return false;
    }
    if (pCompanyName == "") {
        alert("请输入公司名称！");
        document.getElementById('pCompanyName').focus();
        return false;
    }
    if (pCompanyState == "") {
        alert("请输入公司所在国家！");
        document.getElementById('pCompanyState').focus();
        return false;
    }   
    if (pCompanyZipCode == "") {
        alert("请输入公司邮政编码！");
        document.getElementById('pCompanyZipCode').focus();
        return false;
    }
    if (contactName == "") {
        alert("请输入联系人姓名！");
        document.getElementById('contactName').focus();
        return false;
    }
    if (contactTelNo == "") {
        alert("请输入联系人电话！");
        document.getElementById('contactTelNo').focus();
        return false;
    }
    if (contactEmailAddress == "") {
        alert("请输入联系人电子邮件地址！");
        document.getElementById('contactEmailAddress').focus();
        return false;
    }
    return true;
}

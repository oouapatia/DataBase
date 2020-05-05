function check() {
    var institutionNo = document.getElementById('institutionNo').value;
    if (institutionNo == "") {
        alert("请输入机构编号！");
        document.getElementById('institutionNo').focus();
        return false;
    }
    return true;
}

function insert_check() {
    var institutionNo = document.getElementById('institutionNo').value;
    var institutionName = document.getElementById('institutionName').value;
    var contactName = document.getElementById('contactName').value;
    var contactTelNo = document.getElementById('contactTelNo').value;
    if (institutionNo == "") {
        alert("请输入机构编号！");
        document.getElementById('institutionNo').focus();
        return false;
    }
    if (institutionName == "") {
        alert("请输入机构名称！");
        document.getElementById('institutionName').focus();
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
    return true;
}

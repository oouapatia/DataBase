function check() {
    var postNo = document.getElementById('postNo').value;
    if (postNo == "") {
        alert("请输入岗位编号！");
        document.getElementById('postNo').focus();
        return false;
    }
    return true;
}

function insert_check() {
    var postNo = document.getElementById('postNo').value;
    var gradeNo = document.getElementById('gradeNo').value;
    var validFromDate = document.getElementById('validFromDate').value;
    var availableFromDate = document.getElementById('availableFromDate').value;
    if (postNo == "") {
        alert("请输入岗位编号！");
        document.getElementById('postNo').focus();
        return false;
    }
    if (gradeNo == "") {
        alert("请输入等级编号！");
        document.getElementById('gradeNo').focus();
        return false;
    }
    if (validFromDate == "") {
        alert("请输入有效开始日期！");
        document.getElementById('validFromDate').focus();
        return false;
    }
    if (availableFromDate == "") {
        alert("请输入开始日期！");
        document.getElementById('availableFromDate').focus();
        return false;
    }
    return true;
}

function update_check() {
    var postNo = document.getElementById('postNo').value;
    var gradeNo = document.getElementById('gradeNo').value;
    var validFromDate = document.getElementById('validFromDate').value;
    if (postNo == "") {
        alert("请输入岗位编号！");
        document.getElementById('postNo').focus();
        return false;
    }
    if (gradeNo == "") {
        alert("请输入等级编号！");
        document.getElementById('gradeNo').focus();
        return false;
    }
    if (validFromDate == "") {
        alert("请输入有效开始日期！");
        document.getElementById('validFromDate').focus();
        return false;
    }
    return true;
}

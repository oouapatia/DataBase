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
    var availableFromDate = document.getElementById('availableFromDate').value;
    var departmentNo = document.getElementById('departmentNo').value;
    if (postNo == "") {
        alert("请输入岗位编号！");
        document.getElementById('postNo').focus();
        return false;
    }
    if (availableFromDate == "") {
        alert("请输入开始日期！");
        document.getElementById('availableFromDate').focus();
        return false;
    }
    if (departmentNo == "") {
        alert("请输入部门编号！");
        document.getElementById('departmentNo').focus();
        return false;
    }
    return true;
}

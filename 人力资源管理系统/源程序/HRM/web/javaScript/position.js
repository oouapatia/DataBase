function check() {
    var employeeNo = document.getElementById('employeeNo').value;
    if (employeeNo == "") {
        alert("请输入员工编号！");
        document.getElementById('employeeNo').focus();
        return false;
    }
    return true;
}

function insert_check() {
    var employeeNo = document.getElementById('employeeNo').value;
    var postNo = document.getElementById('postNo').value;
    var startDate = document.getElementById('startDate').value;
    if (employeeNo == "") {
        alert("请输入员工编号！");
        document.getElementById('employeeNo').focus();
        return false;
    }
    if (postNo == "") {
        alert("请输入职位编号！");
        document.getElementById('postNo').focus();
        return false;
    }
    if (startDate == "") {
        alert("请输入入职时间！");
        document.getElementById('startDate').focus();
        return false;
    }
    return true;
}

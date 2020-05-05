function check(){
    var departmentNo = document.getElementById('departmentNo').value;
    if (departmentNo == "") {
        alert("请输入部门编号！");
        document.getElementById('departmentNo').focus();
        return false;
    }
    return true;
}

function insert_check(){
    var departmentNo = document.getElementById('departmentNo').value;
    var departmentName = document.getElementById('departmentName').value;
    var managerEmployeeNo = document.getElementById('managerEmployeeNo').value;
    if (departmentNo == "") {
        alert("请输入部门编号！");
        document.getElementById('departmentNo').focus();
        return false;
    }
    if (departmentName == "") {
        alert("请输入部门名字！");
        document.getElementById('departmentName').focus();
        return false;
    }
    if (managerEmployeeNo == "") {
        alert("请输入管理人员编号！");
        document.getElementById('managerEmployeeNo').focus();
        return false;
    }
    return true;
}



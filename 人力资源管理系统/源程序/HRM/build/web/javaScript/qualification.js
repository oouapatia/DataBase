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
    var qualificationName = document.getElementById('qualificationName').value;
    var insititutionNo = document.getElementById('insititutionNo').value;
    
    if (employeeNo == "") {
        alert("请输入员工编号！");
        document.getElementById('employeeNo').focus();
        return false;
    }
    if (qualificationName == "") {
        alert("请输入学历！");
        document.getElementById('qualificationName').focus();
        return false;
    }
    if (insititutionNo == "") {
        alert("请输入机构编号！");
        document.getElementById('insititutionNo').focus();
        return false;
    }
    return true;
}

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
    var prevCompanyNo = document.getElementById('prevCompanyNo').value;
    var prevSalary = document.getElementById('prevSalary').value;
    
    if (employeeNo == "") {
        alert("请输入员工编号！");
        document.getElementById('employeeNo').focus();
        return false;
    }
    if (prevCompanyNo == "") {
        alert("请输入前公司编号！");
        document.getElementById('prevCompanyNo').focus();
        return false;
    }
    if (prevSalary == "") {
        alert("请输入薪水！");
        document.getElementById('prevSalary').focus();
        return false;
    }
    return true;
}

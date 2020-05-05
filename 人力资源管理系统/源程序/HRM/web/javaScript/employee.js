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
    var lastName = document.getElementById('lastName').value;
    var firstName = document.getElementById('firstName').value;
    var socialSecurityNumber = document.getElementById('socialSecurityNumber').value;
    var sex = document.getElementById('sex').value;
    var salary = document.getElementById('salary').value;
    var departmentNo = document.getElementById('departmentNo').value;
    var supervisorEmployeeNo = document.getElementById('supervisorEmployeeNo').value;
    if (employeeNo == "") {
        alert("请输入员工编号！");
        document.getElementById('employeeNo').focus();
        return false;
    }
    if (lastName == "") {
        alert("请输入姓！");
        document.getElementById('lastName').focus();
        return false;
    }
    if (firstName == "") {
        alert("请输入名！");
        document.getElementById('firstName').focus();
        return false;
    }
    if (socialSecurityNumber == "") {
        alert("请输入身份证号码！");
        document.getElementById('socialSecurityNumber').focus();
        return false;
    }
    if (sex == "") {
        alert("请输入性别！");
        document.getElementById('sex').focus();
        return false;
    } else if (sex != "男") {
        if (sex != "女") {
            alert("性别只能为男或女！");
            document.getElementById('sex').focus();
            return false;
        }
    }
    if (salary == "") {
        alert("请输入薪水！");
        document.getElementById('salary').focus();
        return false;
    }
    if (departmentNo == "") {
        alert("请输入部门编号！");
        document.getElementById('departmentNo').focus();
        return false;
    }
    if (supervisorEmployeeNo == "") {
        alert("请输入管理人员编号！");
        document.getElementById('supervisorEmployeeNo').focus();
        return false;
    }
    return true;
}

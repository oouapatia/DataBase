function check() {
    var reviewerEmployeeNo = document.getElementById('reviewerEmployeeNo').value;
    var revieweeEmployeeNo = document.getElementById('revieweeEmployeeNo').value;
    if (reviewerEmployeeNo == "") {
        alert("请输入评价者编号！");
        document.getElementById('reviewerEmployeeNo').focus();
        return false;
    }
    if (revieweeEmployeeNo == "") {
        alert("请输入被评价者编号！");
        document.getElementById('revieweeEmployeeNo').focus();
        return false;
    }
    return true;
}

function insert_check() {
    var reviewerEmployeeNo = document.getElementById('reviewerEmployeeNo').value;
    var revieweeEmployeeNo = document.getElementById('revieweeEmployeeNo').value;
    
    var reviewDate = document.getElementById('reviewDate').value;
    var comments = document.getElementById('comments').value;
    if (reviewerEmployeeNo == "") {
        alert("请输入评价者编号！");
        document.getElementById('reviewerEmployeeNo').focus();
        return false;
    }
    if (revieweeEmployeeNo == "") {
        alert("请输入被评价者编号！");
        document.getElementById('revieweeEmployeeNo').focus();
        return false;
    }
    
    if (reviewDate == "") {
        alert("请输入评价日期！");
        document.getElementById('reviewDate').focus();
        return false;
    }
    if (comments == "") {
        alert("请输入评价！");
        document.getElementById('comments').focus();
        return false;
    }
    return true;
}

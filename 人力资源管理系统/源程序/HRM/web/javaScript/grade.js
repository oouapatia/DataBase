function check() {
    var positionTypeNo = document.getElementById('positionTypeNo').value;
    var gradeNo = document.getElementById('gradeNo').value;
    if (positionTypeNo == "") {
        alert("请输入职位类型编号！");
        document.getElementById('positionTypeNo').focus();
        return false;
    }
    if(gardeNo !="" && (gradeNo < 'A' || gradeNo > 'E')){
        alert("等级编号在A~E之间！");
        document.getElementById('gradeNo').focus();
        return false;
    }
    return true;
}

function insert_check() {
    var positionTypeNo = document.getElementById('positionTypeNo').value;
    var gradeNo = document.getElementById('gradeNo').value;
    var validFromDate = document.getElementById('validFromDate').value;
    var validToDate = document.getElementById('validToDate').value;
    
    if (positionTypeNo == "") {
        alert("请输入职位类型编号！");
        document.getElementById('positionTypeNo').focus();
        return false;
    }
    if (gradeNo == "") {
        alert("请输入等级编号！");
        document.getElementById('gradeNo').focus();
        return false;
    }
    if(gardeNo !="" && (gradeNo < 'A' || gradeNo > 'E')){
        alert("等级编号在A~E之间！");
        document.getElementById('gradeNo').focus();
        return false;
    }
    if (validFromDate == "") {
        alert("请输入有效开始日期！");
        document.getElementById('validFromDate').focus();
        return false;
    }
    var fromDate = new Date(validFromDate);
    var toDate = new Date(validToDate);
    if (fromDate >= toDate) {
        alert("有效截止日期应该大于有效开始日期");
        document.getElementById('validToDate').focus();
        return false;
    }
    return true;
}

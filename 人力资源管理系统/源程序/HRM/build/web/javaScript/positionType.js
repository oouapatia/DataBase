function check() {
    var positionTypeNo = document.getElementById('positionTypeNo').value;
    if (positionTypeNo == "") {
        alert("请输入职位类型编号！");
        document.getElementById('positionTypeNo').focus();
        return false;
    }
    return true;
}

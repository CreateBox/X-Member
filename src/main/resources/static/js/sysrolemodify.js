function back() {
    parent.layer.closeAll();
}

function modifyRole() {
    $.ajax({
        //几个参数需要注意一下
        type: "POST",//提交类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/modifyRole" ,//url
        data: $("#form1").serialize(),//序列化表单信息
        success: function (data) {
            console.log(data);//打印服务端返回的数据(调试用)
            if (data == true) {
                layer.msg("修改成功!");
                parent.$("#roleInfo").DataTable().ajax.reload();
            }else{
                layer.msg("修改失败!");
            }
        }
    });
    return false;
}
function back() {
    parent.layer.closeAll();
}

function modifyfaq() {
    $.ajax({
        //几个参数需要注意一下
        type: "POST",//提交类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/modifyFaq",//url
        data: $("#formFaq").serialize(),//序列化表单信息
        success: function (data) {
            console.log(data);//打印服务端返回的数据(调试用)
            if (data == true) {
                layer.msg("修改成功!");
            } else {
                layer.msg("修改失败!");
            }
            parent.$("#datatable").DataTable().ajax.reload();
        }
    });
    return false;
}

function modifydic() {
    $.ajax({
        //几个参数需要注意一下
        type: "POST",//提交类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/modifydic",//url
        data: $("#formFaq").serialize(),//序列化表单信息
        success: function (data) {
            console.log(data);//打印服务端返回的数据(调试用)
            if (data == true) {
                layer.msg("修改成功!");
            } else {
                layer.msg("修改失败!");
            }
            parent.$("#datatable").DataTable().ajax.reload();
        }
    });
    return false;
}

function modifyRole() {
    if (f()) {
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//提交类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/modifySer",//url
            data: $("#formSer").serialize(),//序列化表单信息
            success: function (data) {
                console.log(data);//打印服务端返回的数据(调试用)
                if (data == true) {
                    layer.msg("修改成功!");
                } else {
                    layer.msg("修改失败!");
                }
                parent.$("#datatable").DataTable().ajax.reload();
            }
        });
    }
    return false;
}

function f() {
    var n = $("#phone");
    if (n.val() == "") {
        layer.msg("联系电话不能为空!");
        return false;
    }
    else {
        var re = /^1(?:3\d|4[4-9]|5[0-35-9]|6[67]|7[013-8]|8\d|9\d)\d{8}$/;
        if (re.test(n.val())) {
            return true;
        } else {
            layer.msg("联系电话格式错误！");
            return false;
        }
    }
}

function addfaq() {
    $.ajax({
        //几个参数需要注意一下
        type: "POST",//提交类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/addFaq",//url
        data: $("#formFaq").serialize(),//序列化表单信息
        success: function (data) {
            console.log(data);//打印服务端返回的数据(调试用)
            if (data == true) {
                layer.msg("新增成功!");
            } else {
                layer.msg("新增失败!");
            }
            parent.$("#datatable").DataTable().ajax.reload();
        }
    });
    return false;
}

function dicAdd() {
    $.ajax({
        //几个参数需要注意一下
        type: "POST",//提交类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/dicAdd",//url
        data: $("#formFaq").serialize(),//序列化表单信息
        success: function (data) {
            console.log(data);//打印服务端返回的数据(调试用)
            if (data == true) {
                layer.msg("新增成功!");
            } else {
                layer.msg("新增失败! 数据值已存在");
            }
            parent.$("#datatable").DataTable().ajax.reload();
        }
    });
    return false;
}

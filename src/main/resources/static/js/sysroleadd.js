function back() {
    parent.layer.closeAll();
}

function validationCode() {
    var flag = false;
    if($("#r_Code").val().trim().length!=0){
        $.ajax({
            type:"POST",
            url:"/validationRole",
            async:false,
            data:{r_Code:$("#r_Code").val()},
            dataType:"JSON",
            success:function (data){
                if(data==true){
                    $("#r_CodePrompt").removeAttr("hidden");
                }else{
                    $("#r_CodePrompt").attr("hidden","hidden");
                    flag = true;
                }
            }
        })
    }else{
        $("#r_CodePrompt").attr("hidden","hidden");
    }
    return flag;
}

function validationName() {
    var flag = false;
    if($("#r_Name").val().trim().length!=0){
        $.ajax({
            type:"POST",
            url:"/validationRole",
            async:false,
            data:{r_Name:$("#r_Name").val()},
            dataType:"JSON",
            success:function (data){
                if(data==true){
                    $("#r_NamePrompt").removeAttr("hidden");
                }else{
                    $("#r_NamePrompt").attr("hidden","hidden");
                    flag = true;
                }
            }
        })
    }else{
        $("#r_NamePrompt").attr("hidden","hidden");
    }
    return flag;
}

function addRole(){
    if(validationCode()&&validationName()){
        console.log("a");
        $.ajax({
            type:"POST",
            url:"/addRole",
            data:$("#form1").serialize(),
            dataType:"JSON",
            success:function (data){
                if(data==true){
                    layer.msg("添加成功");
                    parent.$("#roleInfo").DataTable().ajax.reload();
                }else{
                    layer.msg("添加失败");
                }
            }
        });
    }
    return false;
}

$(document).ready(function () {
    $.ajax({
        type:"POST",
        url:"/deptAll",
        dataType:"JSON",
        success:function (data) {
            for (var i = 0; i < data.length; i++) {
                var option = "<option value='"+data[i].d_Id+"'>"+data[i].d_Name+"</option>";
                $("#d_id").append(option);
            }
        }
    })
});
$(document).ready(function () {
    x();
});

function x() {
    $('#employees').dataTable({
        "searching": false,
        "serverSide": true,//是否启用服务器处理数据源
        "language": {
            "lengthMenu": "每页 _MENU_ 条记录",
            "zeroRecords": "没有找到记录",
            "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
            "infoEmpty": "无记录",
            "infoFiltered": "(从 _MAX_ 条记录过滤)",
            "paginate": {
                "previous": "上一页",
                "next": "下一页",
                "processing": "正在处理中...."
            }
        },
        "columnDefs": [
            {"title": "员工姓名", "targets": 0},
            {"title": "性别", "targets": 1},
            {"title": "所在部门", "targets": 2},
            {"title": "角色", "targets": 3},
            {"title": "状态", "targets": 4},
            {"title": "最后修改时间", "targets": 5},
            {"title": "操作人", "targets": 6},
            {"title": "操作", "targets": 7}
        ],
        "ajax": {
            "url": "/employeeList",
            "type": "POST",
            "data":function (d) {
                d.e_RealName = $("#e_RealName").val();
            },
            "dataType": "json"
        },
        "columns": [
            {"data": "e_RealName"},
            {"data": "e_Sex.sex_Name"},
            {"data": "e_DeptId.d_Name"},
            {"data": "e_Role.r_Name"},
            {"data": "e_Status.st_Name"},
            {"data": "e_ModifyTime",defaultContent: ""},
            {"data": "e_ModifyId.e_RealName",defaultContent: ""},
            {
                "data": "e_Id","width":"200px", "render": function (data, type, full, meta) {
                    return "<div class=\"layui-btn-group\">\n" +
                        "    <a class=\"layui-btn layui-btn-sm\" onclick=\"x_admin_show(null,'/getRole/"+data+"/get',600,400)\">\n" +
                        "        <i class=\"layui-icon\">&#xe62a;</i>\n" +
                        "    </a>\n" +
                        "    <a class=\"layui-btn layui-btn-sm\" onclick=\"x_admin_show(null,'/getRole/"+data+"/modify',600,450,true)\">\n" +
                        "        <i class=\"layui-icon\">&#xe642;</i>\n" +
                        "    </a>\n" +
                        "    <a class=\"layui-btn layui-btn-sm\" onclick=\"x_admin_show(null,'/getRole/"+data+"/modify',600,450,true)\">\n" +
                        "        <i class=\"layui-icon\">&#xe672;</i>\n" +
                        "    </a>\n" +
                        "    <a class=\"layui-btn layui-btn-sm\" onclick=\"delEmployees("+data+",'"+full.e_RealName+"')\">\n" +
                        "        <i class=\"layui-icon\">&#xe640;</i>\n" +
                        "    </a>\n" +
                        "</div>";
                }
            }
        ]
    });
    $(".btn-success").on("click", function () {
        $("#employees").DataTable().ajax.reload();
    });

    $("#employeesQuery").on("click", function () {
        $("#employees").DataTable().ajax.reload();
    });
}

function delEmployees(id,name) {
    layer.confirm("确认删除员工:"+name, {icon: 3, title:'提示'},function () {
        $.ajax({
            type:"POST",
            url:"/delOrganization",
            data:{o_Id:id},
            dataType:"JSON",
            success:function (data) {
                if(data == true){
                    layer.msg("删除成功!");
                    $("#organization").DataTable().ajax.reload();
                }else {
                    layer.msg("删除失败!");
                }
            }
        })
    });
}
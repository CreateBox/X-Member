$(document).ready(function () {
    x();
});

function x() {
    $('#roleInfo').dataTable({
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
            },
        },
        "columnDefs": [
            {"title": "角色名称", "targets": 0},
            {"title": "所属部门", "targets": 1},
            {"title": "最后修改时间", "targets": 2},
            {"title": "操作人", "targets": 3},
            {"title": "备注说明", "targets": 4},
            {"title": "操作", "targets": 5}
        ],
        "ajax": {
            "url": "/roleList",
            "type": "POST",
            "data": function (d) {
                d.r_Name = $("#r_name").val();
            },
            "dataType": "json"
        },
        "columns": [
            {"data": "r_Name"},
            {"data": "r_DeptNo.d_Name"},
            {"data": "r_ModifyTime", defaultContent: ""},
            {"data": "r_ModifyId.e_RealName"},
            {"data": "r_Description", defaultContent: ""},
            {
                "data": "r_Id","width":"150px", "render": function (data, type, full, meta) {
                    return "<div class=\"layui-btn-group\">\n" +
                        "    <a class=\"layui-btn layui-btn-sm\" onclick=\"x_admin_show(null,'/getRole/"+data+"/get',600,300)\">\n" +
                        "        <i class=\"layui-icon\">&#xe62a;</i>\n" +
                        "    </a>\n" +
                        "    <a class=\"layui-btn layui-btn-sm\" onclick=\"x_admin_show(null,'/getRole/"+data+"/modify',600,450,true)\">\n" +
                        "        <i class=\"layui-icon\">&#xe642;</i>\n" +
                        "    </a>\n" +
                        "    <a class=\"layui-btn layui-btn-sm\" onclick=\"delRole("+data+",'"+full.r_Name+"')\">\n" +
                        "        <i class=\"layui-icon\">&#xe640;</i>\n" +
                        "    </a>\n" +
                        "</div>";
                }
            }
        ]
    });
    $(".btn-success").on("click", function () {
        $("#roleInfo").DataTable().ajax.reload();
    });

    $("#roleQuery").on("click", function () {
        $("#roleInfo").DataTable().ajax.reload();
    });
}



$(document).ready(function () {
    x();
});

function x() {
    $('#organization').dataTable({
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
            {"title": "名称", "targets": 0},
            {"title": "最后修改时间", "targets": 1},
            {"title": "操作人", "targets": 2},
            {"title": "备注说明", "targets": 3}
        ],
        "ajax": {
            "url": "/organizationList",
            "type": "POST",
            "data":function (d) {
              d.o_Name = $("#o_Name").val();
            },
            "dataType": "json"
        },
        "columns": [
            {"data": "o_Name"},
            {"data": "o_ModifyTime"},
            {"data": "o_ModifyId.e_RealName"},
            {"data": "o_Description"},
            {
                "data": "o_Id","width":"150px", "render": function (data, type, full, meta) {
                    return "<div class=\"layui-btn-group\">\n" +
                        "    <a class=\"layui-btn layui-btn-sm\" onclick=\"x_admin_show(null,'/getOrganization/"+data+"',600,600,true)\">\n" +
                        "        <i class=\"layui-icon\">&#xe642;</i>\n" +
                        "    </a>\n" +
                        "    <a class=\"layui-btn layui-btn-sm\" onclick=\"delOrganization("+data+",'"+full.o_Name+"')\">\n" +
                        "        <i class=\"layui-icon\">&#xe640;</i>\n" +
                        "    </a>\n" +
                        "</div>";
                }
            }
        ]
    });
    $(".btn-success").on("click", function () {
        $("#organization").DataTable().ajax.reload();
    });

    $("#organizationQuery").on("click", function () {
        $("#organization").DataTable().ajax.reload();
    });
}

function delOrganization(id,name) {
    layer.confirm("确认删除组织:"+name, {icon: 3, title:'提示'},function () {
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
$(document).ready(function () {
    x();
});

function x() {
    $('#roleInfo').dataTable({
        "searching":false,
        "serverSide": true,//是否启用服务器处理数据源
        "bStateSave": false,//不缓存数据
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
        ],
        "ajax": {
            "url": "/roleList",
            "type": "POST",
            // "data": function (datas) {
            //     datas.appInfo = JSON.stringify({
            //         "softwareName": $("#softwareName").val(),
            //         "status": $("#status").val(),
            //         "flatformId": $("#flatformId").val(),
            //         "categoryLevel1": $("#categoryLevel1").val(),
            //         "categoryLevel2": $("#categoryLevel2").val(),
            //         "categoryLevel3": $("#categoryLevel3").val()
            //     });
            // },
            "dataType": "json"
        },
        "columns": [
            {"data": "r_Name"},
            {"data": "r_DeptNo.d_Name"},
            {"data": "r_ModifyTime",defaultContent:""},
            {"data": "r_ModifyId.e_RealName"},
            {"data": "r_Description", defaultContent: ""}
        ]
    });

    $(".btn-success").on("click", function () {
        $('#appinfo').DataTable().ajax.reload();
    });
}
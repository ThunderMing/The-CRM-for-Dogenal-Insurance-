$(function () {
    var sale_datagrid = $("#sale_datagrid");
    var searchForm = $("#searchForm");
    sale_datagrid.datagrid({
        url: '/salesChart/query.do',
        fit: true,
        fitColumns: true,
        pagination: true,
        toolbar: '#tb',
        columns: [
            [
                {field: 'groupType', title: '', width: 80}
                ,
                {field: 'totalAmount', title: '', width: 80}
            ]
        ]
    })

    $("a[data-cmd]").click(function () {
        var methodName = $(this).data("cmd");
        methodObj[methodName]();
    });
   
    var methodObj = {
        query: function () {
           
            var safetymechanism = $("#safetymechanism").combobox('getValue');
            var product = $("#product").combobox('getValue');
            var beginDate = $("#beginDate").datebox('getValue');
            var endDate = $("#endDate").datebox('getValue');
            var groupType =$("#groupType option:selected").val();
            sale_datagrid.datagrid('load', {
                safetymechanismId: safetymechanism,
                productId: product,
                beginDate: beginDate,
                endDate: endDate,
                groupType: groupType
            })
        }
    };
});
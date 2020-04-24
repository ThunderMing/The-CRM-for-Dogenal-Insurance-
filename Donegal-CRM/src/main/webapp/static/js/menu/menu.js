$(function () {
    var menu_datagrid = $("#menu_datagrid");
    menu_datagrid.datagrid({
       
        url: "/menu/list.do",
        
        columns: [
            [
                {field: 'id', checkbox: true},
                {field: 'text', title: 'Menu', width: 100},
                {field: 'url', title: 'URL', width: 100},
                {
                    field: 'parent', title: 'Main Menu', width: 100, formatter: function (value, row, index) {
                        return value ? value.text : "";
                    }
                }
            ]
        ],
       
        fit: true,
       
        fitColumns: true,
        rownumbers: true,
        singleSelect: true,
        striped: true,
        toolbar: "#toolbar",
        pagination: true,
        pageNumber: 1,
        pageSize: 10,
        pageList: [10, 15, 20]

    });
});

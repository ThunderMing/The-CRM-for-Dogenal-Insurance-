$(function () {
    window.dictionaryDirItem_dtagrid = $("#dictionaryDirItem_dtagrid");
    window.dictionaryDirItem_dialog = $("#dictionaryDirItem_dialog");
    window.dictionaryDirItem_form = $("#dictionaryDirItem_form");
    dictionaryDirItem_dtagrid.datagrid({
        
        url: "/dictionary/queryByDirSn.do",
        
        columns: [
            [
                {field: 'name', title: '', width: 100},
                {field: 'intro', title: '', width: 100},
                {field: 'dir', title: '', width: 100,formatter:function (value, row, index) {
                          if (row != null && row.dir.sn != null) {
                              return row.dir.name;
                          } else {
                              return '';
                          }
                    }}
            ]
        ],
        
        fit: true,
    
        fitColumns: true,
        rownumbers: true,
        singleSelect: true,
        striped: true,
        toolbar: "#item_toolbar",
        pagination: true,
        pageNumber: 1,
        pageSize: 10,
        pageList: [10, 15, 20],
    });

    dictionaryDirItem_dialog.dialog({
        width: 300,
        height: 200,
        buttons: "#item_buttons",
        closed: true,
        onClose: function () {
            dictionaryDirItem_form.form("clear");
        }
    });
});
$(function () {
    var case_datagrid = $("#case_datagrid");
    var case_dialog = $("#case_dialog");
    var case_form = $("#case_form");
    var case_check_dialog = $("#case_check_dialog");
    var case_check_form = $("#case_check_form");

    case_datagrid.datagrid({
        
        url: "/case/query.do",
        
        columns: [
            [
                {field: 'id', checkbox: true},
                {field: 'insuranceId', title: 'Insurance number', width: 100},
                {field: 'reporter', title: 'Reporter', width: 100},
                {field: 'phone', title: 'Contact', width: 100},
                {field: 'caseTime', title: 'The time of case', width: 100, sortable: true},
                {field: 'location', title: 'The location of the accident', width: 100},
                {field: 'carNumber', title: 'The plate number of the car ', width: 100},
                {field: 'status', title: 'The status of the case', width: 100,formatter:function (value,row,index) {
                        if(value == 1){
                            return '<font color="#7fffd4">Reported case without investigation and damage</font>';
                        } else if(value == 5){
                            return '<font color="red">Invalid</font>';
                        } else if(value == 2){
                            return '<font color="yellow">Pending auditing </font>';
                        }
                    }}
            ]
        ],
       
        fit: true,
        
        fitColumns: true,
        rownumbers: true,
        singleSelect: true,
        striped: true,
        toolbar: "#toolbar",
        sortName: "caseTime",
        sortOrder: "asc",
        pagination: true,
        pageNumber: 1,
        pageSize: 10,
        pageList: [10, 15, 20],
        onSelect: function (index, row) {
            
            if (row.status == 2) {
                $("#state_btn").linkbutton({
                    disable:true
                });
            }
        }
    });

    
    case_dialog.dialog({
        width: 300,
        height: 300,
        buttons: "#buttons",
        closed: true,
        onClose: function () {
            case_form.form("clear");
        }
    });


    case_check_dialog.dialog({
        width: 300,
        height: 200,
        buttons: "#check_buttons",
        closed: true,
        onClose: function () {
            case_check_form.form("clear");
        }
    });



    $("a[data-cmd]").click(function () {
        var methodName = $(this).data("cmd");
        methodObject[methodName]();
    });

    var methodObject = {
        add: function () {
            case_dialog.dialog("open");
            case_dialog.dialog("setTitle", "Add new Report Form");
        },
        edit: function () {
            var row = case_datagrid.datagrid("getSelected");
          
            if (!row) {
                $.messager.alert("Warmly Reminder", "Please choose one data at least", "warning");
                return;
            }

           
            case_form.form("load", row);

            case_dialog.dialog("open");
            case_dialog.dialog("setTitle", "Edit the reporting form");
        },
        save: function () {
            case_form.form("submit", {
                url: "/case/saveOrUpdate.do",
                success: function (data) {
                    data = $.parseJSON(data);
                    console.log(data);
                    if (data.success) {
                        $.messager.alert("Warmly Reminder", "Save Successfully", "info", function () {
                            case_check_dialog.dialog('close');
                            methodObject.cancel();
                            case_datagrid.datagrid("reload");
                        });
                    } else {
                        $.messager.alert("Warmly Reminder", "Fail to save", "error");
                    }
                }
            });
        },
       
        cancel: function () {
            case_dialog.dialog("close");
        },
       
        check_add: function () {

            var row = case_datagrid.datagrid("getSelected");
          
            if (!row) {
                $.messager.alert("Warmly Reminder", "Please choose one data at least", "warning");
                return;
            }

           
            row["id"]=row.id;
            case_check_form.form("load", row);
            case_check_form.form("load", {status: 2});

            case_check_dialog.dialog("open");
            case_check_dialog.dialog("setTitle", "Add and check for the loss");
        },
    
        check_save: function () {
            var row = case_datagrid.datagrid("getSelected");
            case_check_form.form("submit", {
                url: "/case/checkUpdate.do",
                success: function (data) {
                    data = $.parseJSON(data);
                    if (data.success) {
                        $.messager.alert("Warmly Reminder", "Save Succesfully", "info", function () {
                            case_check_dialog.dialog('close');
                            methodObject.cancel();
                            case_datagrid.datagrid("reload");
                        });
                    } else {
                        $.messager.alert("Warmly Reminder", "Fail to Save", "error");
                    }
                }
            });
        },
       
        check_cancel: function () {
            case_check_dialog.dialog("close");
        },

        
        invalid: function () {
            var row = case_datagrid.datagrid("getSelected");

            if (!row) {
                $.messager.alert("Warmly Reminder", "Please choose one data at least", "warning");
                return;
            }
           
            $.messager.confirm("Confirm", "Are you sure you will implement?", function (right) {
                if (right) {
                   
                    $.get("/case/makeInvalidById.do", {id: row.id}, function (data) {
                        if (data.success) {
                            $.messager.alert("Warmly Reminder", "Operate Successfully!", "info", function () {
                                case_datagrid.datagrid("reload");
                            })
                        } else {
                            $.messager.alert("Warmly Reminder", "Fail to operate", "error");
                        }
                    });
                }
            });
        },

        query: function () {
            var keyword = $("#keyword").textbox("getValue");
            var minDate = $("#minDate").datebox("getValue");
            var maxDate = $("#maxDate").datebox("getValue");
            case_datagrid.datagrid("load", {
                keyword: keyword,
                minDate: minDate,
                maxDate: maxDate
            });
        },
       
        reload: function () {

          
            $("#keyword").textbox("clear");
            $("#minDate").datebox("clear");
            $("#maxDate").datebox("clear");

            case_datagrid.datagrid('reload');
        }
    }
});
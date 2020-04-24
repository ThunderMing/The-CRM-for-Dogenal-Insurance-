$(function () {
    var case_datagrid = $("#case_datagrid");
    var case_dialog = $("#case_dialog");
    var case_form = $("#case_form");
    var case_audit = $("#case_audit");


    case_datagrid.datagrid({
        
        url: "/case/queryForCaseList.do",
        
        columns: [
            [
                {field: 'id', checkbox: true},
                {field: 'insuranceId', title: 'Insurance Number', width: 100},
                {field: 'reporter', title: 'Reporter', width: 100},
                {field: 'blame', title: 'Clame or Not', width: 100},
                {field: 'lossamount', title: 'The amount of loss', width: 100},
                {field: 'remark', title: 'The description of the accident', width: 100},
                {field: 'caseTime', title: 'The time of the case', width: 100, sortable: true},
                {field: 'location', title: 'The location of the case', width: 100},
                {field: 'status', title: 'The status of the reporting', width: 100,formatter:function (value,row,index) {
                        if(value == 3){
                            return '<font color="#ffd700">Auditing and Claim Successfully</font>';
                        } else if(value == 6){
                            return '<font color="#7fffd4">Deductive</font>';
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
        pageList: [10, 15, 20]
    });

    case_dialog.dialog({
        width: 800,
        height: 450,
        collapsible: true,
        draggable: true,
        buttons: "#buttons",
        closed: true,
        setTitle:"Audit and deal with the report form",
        onClose: function () {
            case_form.form("clear");
        }
    });

    
    $("a[data-cmd]").click(function () {
        var methodName = $(this).data("cmd");
        methodObject[methodName]();
    });


    var methodObject = {
        
        look: function () {
            var row1 = case_datagrid.datagrid("getSelected");
            if (!row1) {
                $.messager.alert("warmly reminder", "Please choose one data at least", "warning");
                return;
            }
            
            var row = row1.insurance;

           
            //row["dept.id"] = row.dept.id;
            row["client.name"] = row.client.name;
            row["client.sex"] = row.client.sex;
            row["client.clientId"] = row.client.clientId;
            row["client.address"] = row.client.address;
            row["car.username"] = row.car.username;
            row["car.name"] = row.car.name;
            row["car.sn"] = row.car.sn;
            row["car.carNumber"] = row.car.carNumber;
            row["car.classify"] = row.car.classify;
            //汽车分类
            row["car.carExhaust"] = row.car.carExhaust;
            row["car.buyDate"] = row.car.buyDate;
            row["car.marketPrice"] = row.car.marketPrice;
            row["car.carTyoe"] = row.car.carTyoe;
            row["products.organizationName"] = row.products[0].organizationName;
            row["duration"] = 1;
            row["message"] = row.message;
            console.log(row);
            case_form.form("load", row);
            case_dialog.dialog("open");
        },


        
        cancel: function () {
            case_dialog.dialog("close");
        },

      
        pass: function () {
            var row = case_datagrid.datagrid("getSelected");
            
            $.messager.confirm("Confirm", "Are yoiu sure you will operate?", function (right) {
                if (right) {
                    
                    $.get("/case/makePassById.do", {id: row.id}, function (data) {
                        if (data.success) {
                            $.messager.alert("Warmly Reminder", "Operate Successfully", "info", function () {
                                methodObject.cancel();
                                case_datagrid.datagrid("reload");
                            })
                        } else {
                            $.messager.alert("Warmly Reminder", "Fail to Operate", "error");
                        }
                    });
                }
            });
        },

        //Deductive 
        nopay: function () {
            var row = case_datagrid.datagrid("getSelected");
            
            $.messager.confirm("Confirm", "Are you sure you will operate?", function (right) {
                if (right) {
                    
                    $.get("/case/makeNopayById.do", {id: row.id}, function (data) {
                        if (data.success) {
                            $.messager.alert("Warmly Reminder", "Operate Successfully", "info", function () {
                                methodObject.cancel();
                                case_datagrid.datagrid("reload");
                            })
                        } else {
                            $.messager.alert("Warmly reminder", "Fail to operate", "error");
                        }
                    });
                }
            });
        },


        
        query: function () {
            var minDate = $("#minDate").datebox("getValue");
            var maxDate = $("#maxDate").datebox("getValue");
            case_datagrid.datagrid("load", {
                minDate: minDate,
                maxDate: maxDate
            });
        },

        reload: function () {

            
            $("#minDate").datebox("clear");
            $("#maxDate").datebox("clear");

            case_datagrid.datagrid('reload');
        }
    };


});
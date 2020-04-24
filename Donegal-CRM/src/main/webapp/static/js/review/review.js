$(function () {
    var review_dtagrid = $("#review_dtagrid");
    var review_dialog = $("#review_dialog");
    var review_form = $("#review_form");
    var review_audit = $("#review_audit");

    review_dtagrid.datagrid({
       
        url: "/review/query.do",
       
        columns: [
            [
                {field: 'id', checkbox: true},
                {
                    field: 'billstatus', title: '', width: 100, formatter: function (value, row, index) {
                        return value == 2 ? "" : "";
                    }
                },
                {
                    field: 'client', title: '', width: 100, formatter: function (value, row, index) {
                        return value ? value.name : "";
                    }
                },
                {field: 'billsn', title: '', width: 100},
                {field: 'applytime', title: '', width: 100}

            ]
        ],
      
        fit: true,
        
        fitColumns: true,
        rownumbers: true,
        singleSelect: true,
        striped: true,
        toolbar: "#toolbar",
        sortName: "hireDate",
        sortOrder: "asc",
        pagination: true,
        pageNumber: 1,
        pageSize: 10,
        pageList: [10, 15, 20]
    });

    review_dialog.dialog({
        title: "",
        width: 800,
        height: 600,
        collapsible: true,
        draggable: true,
        buttons: "#buttons",
        closed: true,

        onClose: function () {
            review_form.form("clear");
        }
    });

    $("a[data-cmd]").click(function () {
        var methodName = $(this).data("cmd");
        methodObject[methodName]();
    });
   
    $("#organization").combobox({
        onSelect: function (row) {
            if (row != null) {
                $("#proId").combobox({
                   
                    url: "/productInformation/selectByOranication.do?id=" + row.id
                });
            }
        }
    });


    var methodObject = {
       
        look: function () {
            var row = review_dtagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("", "", "warning");
                return;
            }
            
            //row["dept.id"] = row.dept.id;
            row["client.name"] = row.client.name;
           
            if (row.client.sex) {
                row["client.sex"] = "Male";
            }else {
                row["client.sex"] = "Female";
            };
            row["client.clientId"] = row.client.clientId;
            row["client.address"] = row.client.address;
            row["car.username"] = row.car.username;
            row["car.name"] = row.car.name;
            row["car.sn"] = row.car.sn;
            row["car.carNumber"] = row.car.carNumber;
            row["car.classify"] = row.car.classify;
           
            row["car.carExhaust"] = row.car.carExhaust;
            row["car.buyDate"] = row.car.buyDate;
            row["car.marketPrice"] = row.car.marketPrice;
            row["car.carTyoe"] = row.car.carTyoe;
            row["products.organizationName"] = row.products[0].organizationName;
            row["duration"] = 1;
            row["message"] = row.message;
            console.log(row);
            review_form.form("load", row);
            review_dialog.dialog("open");
        },


      
        rollback: function () {
            var row = review_dtagrid.datagrid("getSelected");
           
            if (!row) {
                $.messager.alert("", "", "warning");
                return;
            }
           
            $.messager.alert("", "", "info", function () {
               
                review_form.form("submit", {
                    url: "/review/rollback.do?id=" + row.id,
                    success: function (data) {  
                        data = $.parseJSON(data);
                        if (data.success) {
                            $.messager.alert("", "", "info", function () {
                                methodObject.cancel();
                                review_dtagrid.datagrid("reload");
                            });
                        } else {
                            $.messager.alert("", "", "error");
                        }
                    }
                });
            });
        },

       
        audi: function () {
            var row = review_dtagrid.datagrid("getSelected");
           
            if (!row) {
                $.messager.alert("", "", "warning");
                return;
            }
          
            $.messager.alert("", "", "info", function () {
               
                review_form.form("submit", {
                    url: "/review/pass.do?id=" + row.id,
                    success: function (data) {  
                        data = $.parseJSON(data);
                        if (data.success) {
                            $.messager.alert("", "", "info", function () {
                                methodObject.cancel();
                                review_dtagrid.datagrid("reload");
                            });
                        } else {
                            $.messager.alert("", "", "error");
                        }
                    }
                });
            });

        },
       
        cancel: function () {
            review_dialog.dialog("close");
        },


        save: function () {
            
            review_form.form("submit", {
                url: "/review/updateByMessager.do",
                success: function (data) {
                    
                    data = $.parseJSON(data);
                    if (data.success) {
                        $.messager.alert("", "", "info", function () {
                            methodObject.cancel();
                            review_dtagrid.datagrid("reload");
                        })
                    } else {
                        $.messager.alert("", "", "error")
                    }
                }
            })
        },


        
        query: function () {
            var minDate = $("#minDate").datebox("getValue");
            var maxDate = $("#maxDate").datebox("getValue");
            var proId = $("#proId").textbox("getValue");
            var organization = $("#organization").textbox("getValue");
            review_dtagrid.datagrid("load", {
                minDate: minDate,
                maxDate: maxDate,
                proId: proId,
                organization: organization
            });
        }
    };


});
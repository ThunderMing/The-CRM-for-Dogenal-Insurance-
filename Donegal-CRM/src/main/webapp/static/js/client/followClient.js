$(function () {

   
    var develClient_datagrid = $("#develClient_datagrid");
  
    var develClient_dialog = $("#develClient_dialog");
   
    var develClient_form = $("#develClient_form");
   
    var chooseClient_dialog = $("#chooseClient_dialog");
    var chooseClient_datagrid = $("#chooseClient_datagrid");


    develClient_datagrid.datagrid({

        url: '/develClient/query.do?status=true',
        columns: [[
            {field: 'id', width: 80, checkbox: true},
            {field: 'result', title: 'The result of plan', width: 80},
            {field: 'follow_upTime', title: 'the time of follow-up', width: 80},
            {
                field: 'foundEmpl', title: 'Founder', width: 80, formatter: function (value) {
                    return value ? value.username : '';
                }
            },
            {
                field: 'client', title: 'client', width: 80, formatter: function (value) {
                    return value ? value.name : '';
                }
            },
            {field: 'follow_upTheme', title: 'the theme of follow-up', width: 80},
            {field: 'mode', title: 'the project of the implementation', width: 80},
            {field: 'details', title: 'detail', width: 80},
            {field: 'remark', title: 'remark', width: 80}
        ]],
        fitColumns: true,
        striped: true,
        pagination: true,
        rownumbers: true,
        singleSelect: true,
        pageList: [5, 10, 15],
        pageNumber: 1,
        toolbar: '#toolbar',
        fit: true
    });

   
    chooseClient_datagrid.datagrid({

        url: '/client/query.do?state=1',
        columns: [[
            {field: 'id', checkbox: true},
            {
                field: 'dutyEmpl', title: 'the person in charge', width: 80, formatter: function (value) {
                    return value.username;
                }
            },
            {field: 'name', title: 'client name', width: 80},
            {
                field: 'sex', title: 'Gender', width: 80, formatter: function (value) {
                    return value ? 'male' : 'female';
                }
            },
            {field: 'phone', title: 'client phone', width: 80},
            {field: 'email', title: 'email', width: 80},
            {field: 'address', title: 'client address', width: 80},
            {field: 'clientId', title: 'ID', width: 80}
        ]],
        fit: true,
     
        fitColumns: true,
        rownumbers: true,
        singleSelect: true,
        striped: true,
        sortOrder: "asc",
        pagination: true,
        pageNumber: 1,
        pageSize: 10,
        pageList: [10, 15, 20],
        buttons: '#buttons'
    });

    develClient_dialog.dialog({
        width: 550,
        height: 300,
        buttons: '#buttons',
        closed: true,
        onClose: function () {
         
            develClient_form.form('clear');
        }
    });

  
    var sign_dialog = $("#sign_dialog");
    var sign_form = $("#sign_form");
    sign_dialog.dialog({
        title: 'remark the effect of the follow-up',
        width: 300,
        height: 200,
        buttons: '#sign_buttons',
        closed: true,
        onClose: function () {
           
            sign_form.form('clear');
        }

    });

    chooseClient_dialog.dialog({
        width: 560,
        height: 310,
        buttons: '#chooseClient_buttons',
        closed: true,
    });

    
    var obj = {

        add: function () {
           
            develClient_dialog.dialog('open');
            develClient_dialog.dialog('setTitle', 'add new plans');

        },
        edit: function () {
            
            var row = develClient_datagrid.datagrid('getSelected');
            if (!row) {
                $.messager.alert('The warning by Thunder', 'Do you dare to make lots of female friends if you do not have money?', 'warning');
                return;
            }

            
            row["xx"] = row.client.name;
            
            row["client.id"] = row.client.id;
           
            develClient_form.form('load', row);

            develClient_dialog.dialog('open');
            develClient_dialog.dialog('setTitle', 'Modify Plans');

        },
        remove: function () {
            
            var row = develClient_datagrid.datagrid('getSelected');

            if (!row) {
                $.messager.alert('The warning by Thunder', 'Please choose one of the plans!', 'warning');
                return;
            }

            $.messager.alert('The warning by Thunder!', 'Are you sure you wanna remove the plan?', 'info', function () {

                
                $.get('/develClient/delete.do', {id: row.id}, function (data) {
                    if (data) {
                        $.messager.alert('The warning by Thunder!', 'Congra! You have delete it successfully!', 'info', function () {
                            develClient_datagrid.datagrid('reload');
                        });
                    } else {
                        $.messager.alert('The warning by it!', 'Fail to remove all the plans becuase you are not too pretty!', function () {
                            develClient_datagrid.datagrid('reload');
                        });
                    }
                })

            })
        },
        //remark
        sign: function () {
            
            var row = develClient_datagrid.datagrid('getSelected');

            if (!row) {
                $.messager.alert('The warning by Thunder!', 'Please choose one of the plans!', 'warning');
                return;
            }

           
            sign_dialog.dialog('open');
            $("#result_planTheme").textbox('setValue',row.planTheme);
            $("#develClient_id").val(row.id);

        },
       
        sign_confirm: function () {
            var row = develClient_datagrid.datagrid('getSelected');
            
            sign_form.form('submit', {
                url: '/develClient/updateResult.do',
                success:function (data) {

                    if (data) {
                        $.messager.alert('The warning by Thunder!', 'Save Successfully! What are you feeling? ', 'info', function () {
                            //refresh
                            develClient_datagrid.datagrid('reload');
                            //close Pop-ups
                            develClient_dialog.dialog('close');
                        });
                    } else {
                        $.messager.alert('The warning by it!', 'fail to save!', 'warning', function () {
                            develClient_datagrid.datagrid('reload');
                        })
                    }
                }
            });

            sign_dialog.dialog('close');
        },

        save: function () {
            
            develClient_form.form('submit', {
                url: '/develClient/saveOrUpdate.do',
               
                success: function (data) {
                    var data = $.parseJSON(data);

                    if (data) {
                        $.messager.alert('The warning by Thunder!', 'Save Succesffuly! Sooo Happy! ', 'info', function () {
                            //refresh
                            develClient_datagrid.datagrid('reload');
                            //close the pop-ups
                            develClient_dialog.dialog('close');
                        });
                    } else {
                        $.messager.alert('The warning by Thunder!', 'Fail to save!', 'warning', function () {
                            develClient_datagrid.datagrid('reload');
                        })
                    }
                }
            });

        },
       
        cancel: function () {
            //Close the pop-ups
            develClient_dialog.dialog('close');
        },
        //choose the client
        chooseClient: function () {
            chooseClient_dialog.dialog('open');
            chooseClient_dialog.dialog('setTitle', 'Choose the potential please!')
        },
        
        confirm: function () {
            
            var row = chooseClient_datagrid.datagrid('getSelected')
           
            if (!row) {
                $.messager.alert('The warning by Thunder!', 'OMG, will you still choose?', 'warning');
                return;
            }

            //set the name for client
            $("#clientName").textbox('setText', row.name);
            //
            $("#clientId").val(row.id);
            
            chooseClient_dialog.dialog('close');
        },
        //advanced query 
        query: function () {
           
            var biginTime = $("#biginTime").datebox('getValue');
            var endTime = $("#endTime").datebox('getValue');
            var queryClientName = $("#queryClientName").textbox('getValue');
            var foundEmpl = $("#foundEmpl").textbox('getValue');
            var planTheme = $("#planTheme").textbox('getValue');
            var mode = $("#mode").combobox('getValue');
          
            develClient_datagrid.datagrid('load', {
                biginTime: biginTime,
                endTime: endTime,
                queryClientName: queryClientName,
                foundEmpl: foundEmpl,
                planTheme: planTheme,
                mode: mode
            })

        },
      
        reload:function () {
         
            $("#planTheme").textbox("clear");
            $("#foundEmpl").textbox("clear");
            $("#queryClientName").textbox("clear");
            $("#biginTime").datebox("clear");
            $("#endTime").datebox("clear");
            $("#mode").combobox("clear");
            develClient_datagrid.datagrid('reload');
        }

    };

    //combine the fixed accident 
    $("a[data-cmd]").click(function () {

        var cmd = $(this).data("cmd");
        obj[cmd]();

    });

});
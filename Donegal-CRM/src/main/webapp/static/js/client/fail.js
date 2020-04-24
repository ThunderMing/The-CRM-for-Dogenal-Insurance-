

$(function () {

  
    var fail_datagrid = $("#fail_datagrid");

    fail_datagrid.datagrid({

        url:'/lossOrFail/query.do?state=true',
        columns:[[
            {field:'id',title:'id',width:80},
            {field:'lossOrFailTime',title:'the time of operate',width:80},
            {field:'clientName',title:'client',width:80},
            {field:'dutyEmpl',title:'the person in charge',width:80},
            {field:'reason',title:'the reason for transferring',width:80},
            {field:'phone',title:'client phone',width:80},
        ]],

        fit: true,
        
        fitColumns: true,
        rownumbers: true,
        singleSelect: true,
        striped: true,
        sortOrder: "asc",
        pagination: true,
        pageNumber: 1,
        toolbar: "#toolbar",
        pageSize: 10,
        pageList: [10, 15, 20],
    });

    
    $("a[data-cmd]").click(function () {

        var methodName = $(this).data("cmd");
        
        methodObject[methodName]();
    });

    var methodObject = {

     
        query:function () {
           
            var biginTime = $("#biginTime").datebox('getValue');
            var endTime = $("#endTime").datebox('getValue');
            var dutyEmpl = $("#dutyEmpl").textbox('getValue');
            var clientName = $("#clientName").numberbox('getValue');
            
            fail_datagrid.datagrid('load',{
                biginTime:biginTime,
                endTime:endTime,
                clientName:clientName,
                dutyEmpl:dutyEmpl,
            });

        },
       
        reload:function () {

          
            $("#dutyEmpl").textbox("clear");
            $("#clientName").textbox("clear");
            $("#biginTime").datebox("clear");
            $("#endTime").datebox("clear");

            fail_datagrid.datagrid('reload');
        }

    };

});
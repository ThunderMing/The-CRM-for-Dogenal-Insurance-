
$(function () {

  
    var clientTransfer_datagrid = $("#clientTransfer_datagrid");

    clientTransfer_datagrid.datagrid({

        url:'/clientTransfer/query.do',
        columns:[[
            {field:'id',checkbox:true},
            {field:'transferTime',title:'The time of transferring',width:80},
            {field:'operationEmpl',title:'The operator',width:80},
            {field:'clientName',title:'client',width:80},
            {field:'originallyEmpl',title:'Original Employee for marketing',width:80},
            {field:'newEmpl',title:'New employee for marketing',width:80,formatter: function (value) {
                    return value.username;
                }},
            {field:'reason',title:'The reason for transferring',width:80},
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
        //Invoke method
        methodObject[methodName]();
    });

    //define a object
    var methodObject = {

        //advanced query
        query:function () {
            //get all the parameters 
            var biginTime = $("#biginTime").datebox('getValue');
            var endTime = $("#endTime").datebox('getValue');
            var operationEmpl = $("#operationEmpl").textbox('getValue');
            var clientName = $("#clientName").numberbox('getValue');
            var originallyEmpl = $("#originallyEmpl").textbox('getValue');
            var newEmpl = $("#newEmpl").textbox('getValue');
            //send parameters
            clientTransfer_datagrid.datagrid('load',{
                biginTime:biginTime,
                endTime:endTime,
                operationEmpl:operationEmpl,
                clientName:clientName,
                originallyEmpl:originallyEmpl,
                newEmpl:newEmpl
            });

        },
        //refresh functions
        reload:function () {

            
            $("#newEmpl").textbox("clear");
            $("#originallyEmpl").textbox("clear");
            $("#clientName").textbox("clear");//client name 
            $("#biginTime").datebox("clear");//beginning time
            $("#endTime").datebox("clear");//ending time
            $("#operationEmpl").textbox("clear");//operator

            clientTransfer_datagrid.datagrid('reload');
        }

    };
});
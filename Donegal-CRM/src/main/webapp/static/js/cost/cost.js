$(function () {
    var cost_datagrid = $("#cost_datagrid");

    cost_datagrid.datagrid({
        url: '/costH/query.do',
        fit: true,
        fitColumns: true,
        pagination: true,
        toolbar: '#toolbar',
        singleSelect: true,
        striped: true,
        columns: [
            [
                {
                    field: 'name', title: '', width: 80, formatter: function (value, row, index) {
                        return row.client.name;
                    }
                }
                ,
                {
                    field: 'applysn', title: '', width: 80
                }
                ,
                {
                    field: 'applytime', title: '', width: 80
                }
                ,
                {
                    field: 'phone', title: '', width: 80, formatter: function (value, row, index) {
                        return row.client.phone;
                    }
                },
                {
                    field: 'address', title: '', width: 80, formatter: function (value, row, index) {
                        return row.client.address;
                    }
                },
                {
                    field: 'clientId', title: '', width: 80, formatter: function (value, row, index) {
                        return row.client.clientId;
                    }
                },
                {
                    field: 'paytype', title: '', width: 80
                },
                {
                    field: 'amount', title: '', width: 80
                },
                {field: 'starttime', title: '', width: 80},
                {
                    field: 'endtime', title: '', width: 80
                },
                {
                    field: 'inputer', title: '', width: 80,formatter: function (value, row, index) {
                        return value ? value.realname : '';
                    }
                },
                {
                    field: 'paystatus', title: '', width: 80, formatter: function (value, row, index) {
                        return value == 0 ? "<font color='green'></font>" : "<font color='#8b0000'></font>";
                    }
                }
            ]
        ]
    });
    
    var methodObj = {
        query: function () {

            var keyword = $("#keyword").textbox('getValue');
            var applysn = $("#applysn").textbox('getValue');
            var begin = $("#begin").datebox('getValue');
            var end = $("#end").datebox('getValue');
            cost_datagrid.datagrid('load', {
                keyword: keyword,
                begin: begin,
                end: end,
                applysn:applysn
            })
        }
    }

    $("a[data-cmd]").click(function () {
        var methodName = $(this).data("cmd");
        methodObj[methodName]();
    });
});

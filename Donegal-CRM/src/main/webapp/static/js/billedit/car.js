$(function () {

    carMessage_dtagrid = $("#carMessage_dtagrid");

    /**
 
     */
    car_dialog.dialog({
        width: 1050,
        height: 400,
        title: 'The Choice of Cars',
        closed: true
    });
    
    car_dialog.dialog("center");

   
     
    car_datagrid.datagrid({
        url:"/carMessage/selectAll.do",
        columns: [
            [
                {field: 'id'},
                {field: 'username', title: 'The name of Car host', width: 100},
                {field: 'name', title: 'The brand of Car', width: 100},
                {field: 'sn', title: 'The model of Car', width: 100},
                {field: 'carNumber', title: 'The plate number of car ', width: 100},
                {field: 'carExhaust', title: 'Exhaust/L', width: 100, sortable: true},
                {field: 'buyDate', title: 'The date of Purcharse', width: 100, sortable: true},
                {field: 'marketPrice', title: 'The appraised price in the marketing', width: 100, sortable: true},
                /*{
                    field: 'classify', title: 'classification', width: 100
                },*/
                {
                    field: 'carTyoe', title: 'The size of car', width: 100

                },
                {field: 'remark', title: 'The information of remark/note', width: 100, sortable: true}
            ]
        ],
        fit: true,
        singleSelect: true,
        toolbar: "#car_toolbar",
        onSelect: function (index, row) {
            
            row["car.id"] = row.id;
            row["car.username"] = row.username;
            row["car.carNumber"] = row.carNumber;
            row["car.buyDate"] = row.buyDate;
            row["car.carExhaust"] = row.carExhaust;
            row["car.marketPrice"] = row.marketPrice;
            $("#insure_form").form("load", row);

            
            $("#carSn").combobox("setValue", row.sn);
            $("#carName").combobox("setValue", row.name);
            $("#carClassify").combobox("setValue", row.classify);
            $("#carTyoe").combobox("setValue", row.carTyoe);

            car_dialog.dialog("close");
        }
    });
});
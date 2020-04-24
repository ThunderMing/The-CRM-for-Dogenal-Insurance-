$(function () {
  
    client_dialog.dialog({
        width: 500,
        height: 300,
        title: 'The choice for client',
        closed: true
    });
    
    client_dialog.dialog("center");

   
     
    client_datagrid.datagrid({
        columns: [[
            {field: 'id',hidden:true},
            {
                field: 'state', title: 'The status of client', width: 80, formatter: function (value) {
                    if (value) {
                        return 'Formal Client';
                    } else if (value) {
                        return 'Potential Client';
                    }
                    return '';
                }
            },
            {field: 'name', title: 'name of client', width: 80},
            {field: 'age', title: 'age of client', width: 80},
            {
                field: 'sex', title: 'Gender', width: 80, formatter: function (value) {
                    return value ? 'Male' : 'Female';
                }
            },
            {field: 'address', title: 'The address of client', width: 80},
            {field: 'clientId', title: 'The ID of Client', width: 80}
        ]],
        fit: true,
        singleSelect: true,
        toolbar: "#client_toolbar",
        onSelect: function (index, row) {
            row["client.id"] = row.id;
            row["client.name"] = row.name;
            row["client.sex"] = row.sex;
            row["client.clientId"] = row.clientId;
            row["client.address"] = row.address;
            $("#insure_form").form("load", row);
            client_dialog.dialog("close");
        }
    });
});
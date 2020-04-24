$(function () {
  
    product_dialog.dialog({
        width: 1000,
        height: 500,
        title: 'The choice for insurance',
        closed: true
    });
    
    product_dialog.dialog("center");
    
     
    product_datagrid_select.datagrid({
        columns: [
            [
                {field: 'id',hidden:true},
                {field: 'sn', title: 'Insurance number', width: 100},
                {field: 'name', title: 'Insurance name', width: 100},
                {
                    field: 'organization', title: 'Insurance Institution', width: 100, formatter: function (value, row, index) {
                        return value ? value.name : "";
                    }
                },
                {field: 'ageLimit', title: 'The limit age of Insurance', width: 100, sortable: true},
                {field: 'coverage', title: 'Insurance Coverage', width: 100, sortable: true},
                {field: 'annualFee', title: 'The basic Annual Fee', width: 100, sortable: true},
                {
                    field: 'saleStatus', title: 'The status of sale', formatter: function (value, row, index) {
                        return value ? 'For sale' : '<font color="red">Not available for sale</font>';
                    }
                },
                {
                    field: 'deductionStatus', title: 'Excluding deductible', formatter: function (value, row, index) {
                        return value ? 'YES' : '<font color="red">NO</font>';
                    }
                }
            ]
        ],
        fit: true,
        singleSelect: true,
        toolbar: "#product_toolbar",
        onSelect: function (index, row) {
           
            $("#product_view").show();
            var data = product_datagrid_select.datagrid("getData");
            var num = methodObject.counter(productCount);
            products[num] = data.rows[index];
           
            product_datagrid_view.datagrid("loadData", {total: num, rows: products});
            product_dialog.dialog("close");
            
            var amount = 0;
            for(var i = 0; i < products.length; i++){
                amount += products[i].annualFee
            }
          
            $("#product_amount").html(amount);
        }
    });

   
    
    product_datagrid_view.datagrid({
        width: '800',
        height: '300',
        columns: [
            [
                {field: 'id', hidden:true},
                {field: 'sn', title: 'Insurance Number', width: 100},
                {field: 'name', title: 'Insurance Name', width: 100},
                {
                    field: 'organization', title: 'Insurance Institution', width: 100, formatter: function (value, row, index) {
                        return value ? value.name : "";
                    }
                },
                {field: 'ageLimit', title: 'The limit age of Insurance', width: 100, sortable: true},
                {field: 'coverage', title: 'Insurance Coverage', width: 100, sortable: true},
                {field: 'annualFee', title: 'The basic Annual Fee ', width: 100, sortable: true},
                {
                    field: 'saleStatus', title: 'The status of sale ', formatter: function (value, row, index) {
                        return value ? 'For sale ' : '<font color="red">Not Available for sale</font>';
                    }
                },
                {
                    field: 'deductionStatus', title: 'Excluding deductible', formatter: function (value, row, index) {
                        return value ? 'YES' : '<font color="red">NO</font>';
                    }
                }
            ]
        ],
        singleSelect: true,
    });
});
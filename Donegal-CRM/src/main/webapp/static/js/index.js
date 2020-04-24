$(function () {
    $("#myTree").tree({
        url: "/menu/selectEmployeeMenu.do",
        onClick: function (node) {
           
            if (node.url) {
                var exists = $("#myTabs").tabs("exists", node.text);
             
                if (exists) {
                    
                    $("#myTabs").tabs("select", node.text);
                } else {
                    
                    $("#myTabs").tabs("add", {
                        title: node.text,
                        closable: true,
                        content: '<iframe src='+node.url+' width="100%" height="100%" frameborder="0"></iframe>',
                    });
                }
            } else {
              
                $("#myTree").tree("toggle", node.target);
            }
        },
    });
});
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="/static/common/common.jsp"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>

    <script type="text/javascript" src="/static/js/index.js"></script>

    <link rel="stylesheet" href="/static/css/reset.css">
    <link rel="stylesheet" href="/static/css/public.css">
    <script type="text/javascript">
        function startwork() {
            $.post('/signed/startwork.do',function (data) {
                if(data.success){
                    alert("Check in Successfully!")
                }else{
                    alert(data.msg);
                }
            })
        }
        function offwork() {
            $.post('/signed/offwork.do',function (data) {
                if(data.success){
                    alert("Check out Successfully!")
                }else{
                    alert(data.msg);
                }
            })
        }
    </script>
</head>
<body>


    <div data-options="region:'south',height:40" >
        <p align="center">Copy Right</p>
    </div>
    <div data-options="region:'west',width:150" >
        <div class="easyui-accordion" fit="true">
            <div title="Menu">
                <ul id="myTree"></ul>
            </div>
            <div title="">
                content3
            </div>
            <div title="">
                content3
            </div>
        </div>
    </div>
    <div data-options="region:'center'">
        <div  class="easyui-tabs" id="myTabs">
            <div title="Main Page" align="center">
                <h1 STYLE="font-size: 21PX">Welcome</h1>
                <div id="emp_buttons" align="center">
                    <a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-save'" href="javascript:startwork()" ></a>
                    <a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-save'" href="javascript:offwork()" ></a>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
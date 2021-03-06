<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <%@ include file="/static/common/common.jsp" %>
    <script type="text/javascript" src="/static/js/billedit/billedit.js"></script>
    <script type="text/javascript" src="/static/js/billedit/car.js"></script>
    <script type="text/javascript" src="/static/js/billedit/product.js"></script>
    <script type="text/javascript" src="/static/js/billedit/client.js"></script>
    <title></title>
</head>
<body>
<table id="review_dtagrid"></table>

<div id="insure_toolbar">
    <a class="easyui-linkbutton" iconCls="icon-edit" id="look" data-cmd="insure_edit"></a>
    <input class="easyui-datebox" id="minDate"/>~<input class="easyui-datebox" id="maxDate"/>
    <input class="easyui-combobox" id="organization" name="products.organization.id"
              data-options="panelHeight:'auto',url:'/organization/selectAll.do',textField:'name',valueField:'id'"/>
    <input class="easyui-combobox" id="proId" name="products.id"
                data-options="panelHeight:'auto',textField:'name',valueField:'id',method:'get'"/>
    <a class="easyui-linkbutton" iconCls="icon-search" data-cmd="query"></a>
</div>

<div class="easyui-dialog" id="insure_dialog">
    <form id="insure_form" method="post">
        <div class="easyui-panel" title="">
            <input type="hidden" name="id"/>
            <input type="hidden" name="client.id">
            <table>
                <tr>
                    <td><a class="easyui-linkbutton" iconCls="icon-search" data-cmd="client_select"></a></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td>
                        <input class="easyui-textbox" name="client.name" id="clientName" data-options="required:true">
                    </td>
                    <td>Gender:</td>
                    <td>
                        <div class="easyui-combobox" name="client.sex"name="clientSex"
                             data-options="textField:'text',valueFiled:'value', panelHeight:'auto',
                              data:[{text:'Male',value:'1'},{text:'female',value:'0'}], editable:false"></div>
                    </td>
                </tr>
                <tr>
                    <td>ID:</td>
                    <td><input class="easyui-textbox" name="client.clientId" id="clientClientId" data-options="required:true"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td>address:</td>
                    <td><input class="easyui-textbox" name="client.address" id="clientAddress"/></td>
                    <td></td>
                    <td></td>
                </tr>
            </table>
        </div>
        <div class="easyui-panel" title="car">
            <input type="hidden" name="car.id">
            <table>
                <tr>
                    <td><a class="easyui-linkbutton" iconCls="icon-search" data-cmd="car_select"></a></td>
                </tr>
                <tr>
                    <td>name :</td>
                    <td><input class="easyui-textbox" name="car.username" id="carUsername" data-options="required:true"></td>
                    <td>model:</td>
                    <td><input class="easyui-combobox" name="car.name" id="carName"
                               data-options="textField:'name',valueField:'id', panelHeight:'auto',
                                  url:'/dictionary/queryByDirSn.do?sn=carName', editable:false"></td>
                    <td>:</td>
                    <td><input class="easyui-combobox" name="car.sn" id="carSn"
                               data-options="textField:'name',valueField:'id', panelHeight:'auto',
                                  url:'/dictionary/queryByDirSn.do?sn=carSn', editable:false"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input class="easyui-textbox" name="car.carNumber" id="carCarNumber" data-options="required:true"></td>
                    <td></td>
                    <td><input class="easyui-numberbox" name="car.carExhaust" id="carCarExhaust" data-option="min:0,precision:2"></td>
                    <td></td>
                    <td><input class="easyui-combobox" name="car.classify" id="carClassify"
                               data-options="textField:'name',valueField:'id', panelHeight:'auto',
                                  url:'/dictionary/queryByDirSn.do?sn=classify', editable:false"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input class="easyui-datebox" name="car.buyDate" data-options="editable:false"></td>
                    <td></td>
                    <td><input class="easyui-textbox" name="car.marketPrice" id="carMarketPrice">
                    </td>
                    <td></td>
                    <td><input class="easyui-combobox" name="car.carTyoe" id="carTyoe"
                               data-options="textField:'name',valueField:'id', panelHeight:'auto',
                                  url:'/dictionary/queryByDirSn.do?sn=carTyoe',editable:false"/>
                    </td>
                </tr>
            </table>
        </div>
        <div class="easyui-panel" title="">
            <ul style="list-style: none">
                <li>
                    
                    <input class="easyui-combobox" name="product.organizationId" id="organization_combobox"
                           data-options="textField:'name',valueField:'id', panelHeight:'auto',
                          url:'/organization/selectAll.do', editable:false"/>

                    <a class="easyui-linkbutton" iconCls="icon-search" id="product_select" name="product.id"
                       data-cmd="product_select"></a></td>
                    <span id="product_amount">0</span></td>
                </li>
                <li>
                    <div id="product_view" style="display: none">
                        <div class="easyui-datagrid" id="product_datagrid_view"></div>
                    </div>
                </li>
                <li>
                    <div style="text-align: center">
                        <a class="easyui-linkbutton" data-cmd="btn_submit"></a>
                    </div>
                </li>
            </ul>
        </div>
    </form>
    <div class="easyui-dialog" id="client_dialog">
        <div class="easyui-datagrid" id="client_datagrid"></div>
    </div>
    <div class="easyui-dialog" id="car_dialog">
        <div class="easyui-datagrid" id="car_datagrid"></div>
    </div>
    <div class="easyui-dialog" id="product_dialog">
        <div class="easyui-datagrid" id="product_datagrid_select"></div>
    </div>
    <div id="client_toolbar">
        <a class="easyui-linkbutton" iconCls="icon-back" data-cmd="client_dialogClose"></a>
    </div>
    <div id="car_toolbar">
        <a class="easyui-linkbutton" iconCls="icon-back" data-cmd="car_dialogClose"></a>
    </div>
    <div id="product_toolbar">
        <a class="easyui-linkbutton" iconCls="icon-back" data-cmd="product_dialogClose"></a>
    </div>
</div>
</body>
</html>

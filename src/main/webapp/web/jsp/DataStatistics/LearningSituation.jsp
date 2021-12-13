<%--
Created by IntelliJ IDEA.
User: 24387
Date: 2021/11/25
Time: 22:59
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>自习室管理系统</title>
    <style>
        .quan{
            margin: 0px 115px;
        }
    </style>
    <script type="text/javascript" src="../../js/jQuery.js"></script>
</head>
<jsp:include page="../CommonFramework/head.jsp"></jsp:include>
<jsp:include page="../CommonFramework/left.jsp"></jsp:include>
<div class="layui-body" style="z-index: -1;">
<div style="padding: 15px;z-index: -1;width: 1200px;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>学习情况</legend>
    </fieldset>
    <div style="max-width: 1140px;">
        <ul class="layui-border-box site-doc-icon site-doc-anim" style=" display: flex;">
            <li class="quan">
                <div class="layui-anim" data-anim="layui-anim-scale" style=" width: 200px; height: 200px; line-height: 150px; margin: 0 auto 10px; text-align: center; background-color: #009688; cursor: pointer; color: #fff; border-radius: 50%;">
                    <c:if test="${using != null}">
                        <div style=" font-size: 55px;">${using}</div>
                    </c:if>
                    <c:if test="${using == null}">
                        <div style=" font-size: 55px;">无统计</div>
                    </c:if>
                </div>
                <div style=" text-align: center; margin: 17px 0px; font-size: 25px;">日人数</div>
            </li>
            <li class="quan">
                <div class="layui-anim" data-anim="layui-anim-scale" style=" width: 200px; height: 200px; line-height: 150px; margin: 0 auto 10px; text-align: center; background-color: #009688; cursor: pointer; color: #fff; border-radius: 50%;">
                    <div style=" font-size: 55px;">${usingZhou}</div>
                </div>
                <div style=" text-align: center; margin: 17px 0px; font-size: 25px;">周人数</div>
            </li>
            <li class="quan">
                <div class="layui-anim" data-anim="layui-anim-scale" style=" width: 200px; height: 200px; line-height: 150px; margin: 0 auto 10px; text-align: center; background-color: #009688; cursor: pointer; color: #fff; border-radius: 50%;">
                    <div style=" font-size: 55px;">${usingYue}</div>
                </div>
                <div style=" text-align: center; margin: 17px 0px; font-size: 25px;">月人数</div>
            </li>
        </ul>
    </div>

    <div id="container" style="min-width:400px;height:400px"></div>
    <div style=" margin: 16px 0px;"></div>
</div>
</div >
<jsp:include page="../CommonFramework/bottom.jsp"></jsp:include>
<script src="http://cdn.highcharts.com.cn/highcharts/highcharts.js"></script>
<script src="../../layui/layui.js"></script>
<script>
    //JS
    layui.use(['element', 'layer', 'util'], function () {
        var element = layui.element
            , layer = layui.layer
            , util = layui.util
            , $ = layui.$;

        //头部事件
        util.event('lay-header-event', {
            //左侧菜单事件
            menuLeft: function (othis) {
                layer.msg('展开左侧菜单的操作', {icon: 0});
            }
            , menuRight: function () {
                layer.open({
                    type: 1
                    , content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
                    , area: ['260px', '100%']
                    , offset: 'rt' //右上角
                    , anim: 5
                    , shadeClose: true
                });
            }
        });
    });

    var chart = Highcharts.chart('container', {
        chart: {
            type: 'column'
        },
        title: {
            text: '楼层人数分布'
        },
        xAxis: {
            categories: ['一楼', '二楼', '三楼', '四楼', '五楼']
        },
        yAxis: {
            min: 0,
            title: {
                text: '人数总量'
            }
        },
        tooltip: {
            pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b>' +
                '({point.percentage:.0f}%)<br/>',
            //:.0f 表示保留 0 位小数，详见教程：https://www.hcharts.cn/docs/basic-labels-string-formatting
            shared: true
        },
        plotOptions: {
            column: {
                stacking: 'percent'
            }
        },
        series: [{
            name: '男',
            data: [5, 3, 4, 7, 2]
        }, {
            name: '女',
            data: [3, 4, 4, 2, 5]
        }]
    });
</script>
</body>
</html>
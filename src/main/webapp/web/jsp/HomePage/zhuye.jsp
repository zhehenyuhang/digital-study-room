<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>自习室管理系统</title>
    <style>
        .quan{
            margin: 0px 115px;
        }
    </style>
</head>
<%--<body onload="alert('${teacherName}欢迎你！')">--%>
<body>
<jsp:include page="../CommonFramework/head.jsp"></jsp:include>
<jsp:include page="../CommonFramework/left.jsp"></jsp:include>
<div class="layui-body">
<div style="padding: 15px;height: 600px;">
    <div style="max-width: 1140px;">
        <ul class="layui-border-box site-doc-icon site-doc-anim" style=" display: flex;">
            <li class="quan">
                <div class="layui-anim" data-anim="layui-anim-scale" style=" width: 200px; height: 200px; line-height: 150px; margin: 0 auto 10px; text-align: center; background-color: #009688; cursor: pointer; color: #fff; border-radius: 50%;">
                    <div style=" font-size: 55px;">300</div>
                </div>
                <div style=" text-align: center; margin: 17px 0px; font-size: 25px;">总座位</div>
            </li>
            <li class="quan">
                <div class="layui-anim" data-anim="layui-anim-scale" style=" width: 200px; height: 200px; line-height: 150px; margin: 0 auto 10px; text-align: center; background-color: #009688; cursor: pointer; color: #fff; border-radius: 50%;">
                    <div style=" font-size: 55px;">231</div>
                </div>
                <div style=" text-align: center; margin: 17px 0px; font-size: 25px;">已用座位</div>
            </li>
            <li class="quan">
                <div class="layui-anim" data-anim="layui-anim-scale" style=" width: 200px; height: 200px; line-height: 150px; margin: 0 auto 10px; text-align: center; background-color: #009688; cursor: pointer; color: #fff; border-radius: 50%;">
                    <div style=" font-size: 55px;">61</div>
                </div>
                <div style=" text-align: center; margin: 17px 0px; font-size: 25px;">剩余座位</div>
            </li>
        </ul>
    </div>

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>更新情况</legend>
    </fieldset>
    <ul class="layui-timeline">
        <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <div class="layui-timeline-title">2021.09.20计划萌芽</div>
            </div>
        </li>
        <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <div class="layui-timeline-title">2021.09.31项目准备</div>
            </div>
        </li>
        <li class="layui-timeline-item">
            <i class="layui-icon layui-anim layui-anim-rotate layui-anim-loop layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <div class="layui-timeline-title">2021.10.03分布开始ing...</div>
            </div>
        </li>
    </ul>

</div>
</div>
<jsp:include page="../CommonFramework/bottom.jsp"></jsp:include>
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
</script>
</body>
</html>
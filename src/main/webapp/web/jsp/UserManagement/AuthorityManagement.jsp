<%--
Created by IntelliJ IDEA.
User: 24387
Date: 2021/11/25
Time: 21:02
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>自习室管理系统</title>
</head>
<jsp:include page="../CommonFramework/head.jsp"></jsp:include>
<jsp:include page="../CommonFramework/left.jsp"></jsp:include>
<div class="layui-body">
<div style="padding: 15px;height: 600px;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>权限管理</legend>
    </fieldset>
    <div class="layui-btn-container" style=" display: flex;">
        <button type="button" class="layui-btn">添加</button>
        <button type="button" class="layui-btn">修改</button>
        <button type="button" class="layui-btn">删除</button>
        <div id="layerDemo" style="margin-bottom: 0;">
            <div class="layui-btn-container">
                <button data-method="offset" data-type="auto" class="layui-btn layui-btn-normal" style="background-color: #009688;">授权</button>
            </div>
        </div>
    </div>


    <div style=" margin: 0 -32px;">
        <label class="layui-form-label"><strong>角色名称:</strong></label>
        <div class="layui-input-inline">
            <input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
        <button type="button" class="layui-btn">搜索</button>
    </div>


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
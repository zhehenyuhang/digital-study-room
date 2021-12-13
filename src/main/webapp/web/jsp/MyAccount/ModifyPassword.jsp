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
            <legend>修改密码</legend><p>&nbsp;</p>
            <div style=" margin: 0 -32px;">
                <label class="layui-form-label"><strong>原密码:</strong></label>
                <div class="layui-input-inline">
                    <input type="text" name="name" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
                </div>
            </div> <br>
            <div style=" margin: 0 -32px;">
                <label class="layui-form-label"><strong>新密码:</strong></label>
                <div class="layui-input-inline">
                    <input type="text" name="nicheng" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
                </div>
            </div> <br>
            <div style=" margin: 0 -32px;">
                <label class="layui-form-label"><strong>确认密码:</strong></label>
                <div class="layui-input-inline">
                    <input type="text" name="nicheng" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
                </div>
            </div> <br>
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" class="layui-btn" value="修改"/></p>
        </fieldset>
    </div>

    <script src="../../layui/layui.js" charset="utf-8"></script>
    <script>
        layui.use('laydate', function(){
            var laydate = layui.laydate;
            laydate.render({
                elem: '#test19'
                ,value: '2000-3-22'
                ,isInitValue: true
            });
        });
    </script>
    </fieldset>
</div>
<jsp:include page="../CommonFramework/bottom.jsp"></jsp:include>
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
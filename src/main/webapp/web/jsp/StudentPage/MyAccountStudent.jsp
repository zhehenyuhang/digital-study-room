<%--
  Created by IntelliJ IDEA.
  User: SPARK
  Date: 2021/12/7
  Time: 20:47
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
<body>
<jsp:include page="headStudent.jsp"></jsp:include>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>我的账户</legend>
</fieldset><p>&nbsp;</p>

<div style=" margin: 0 -32px;">
    <label class="layui-form-label"><strong>用户姓名:</strong></label>
    <div class="layui-input-inline">
        <input type="text" name="name" lay-verify="required" placeholder="石宇航" autocomplete="off" class="layui-input">
    </div>
</div> <br>
<div style=" margin: 0 -32px;">
    <label class="layui-form-label"><strong>用户昵称:</strong></label>
    <div class="layui-input-inline">
        <input type="text" name="nicheng" lay-verify="required" placeholder="是宇航" autocomplete="off" class="layui-input">
    </div>
</div> <br>
<div style=" margin: 0 -32px;">
    <label class="layui-form-label"><strong>用户年龄:</strong></label>
    <div class="layui-input-inline">
        <input type="number" style="width:183px;height:40px" name="age" lay-verify="required" placeholder="21" min="10" max="100"  autocomplete="off" class="layui-input">
    </div>
</div> <br>
<div style=" margin: 0 -32px;">
    <label class="layui-form-label"><strong>出生日期:</strong></label>
    <div class="layui-input-inline">
        <input type="text" class="layui-input" id="test19" placeholder="1999-3-22">
    </div>
</div> <br>
<div style=" margin: 0 -32px;">
    <label class="layui-form-label"><strong>电子邮箱:</strong></label>
    <div class="layui-input-inline">
        <input type="email" name="myemail" lay-verify="required" placeholder="1791832600@qq.com" autocomplete="off" class="layui-input">
    </div>
</div> <br>
<div style=" margin: 0 -32px;">
    <label class="layui-form-label"><strong>身份证号:</strong></label>
    <div class="layui-input-inline">
        <input type="etext" name="idcard" lay-verify="required" placeholder="610122200003222818"  pattern="^\d {8,18} | [0-9x] {8,18} | [0-9x] {8,18}?$" autocomplete="off" class="layui-input">
    </div>
</div> <br>
<div style=" margin: 0 -32px;">
    <label class="layui-form-label"><strong>手机号码:</strong></label>
    <div class="layui-input-inline">
        <input type="tel" name="telphone" lay-verify="required" placeholder="15596833841"  pattern="^\d {11}$" autocomplete="off" class="layui-input">
    </div>
</div> <br>
<div style=" margin: 0 -32px;">
    <label class="layui-form-label"><strong>个人主页:</strong></label>
    <div class="layui-input-inline">
        <input type="url" name="myurl" lay-verify="required" placeholder="https://user.qzone.qq.com/2287158727?source=namecardhoverqzone"   autocomplete="off" class="layui-input">
    </div>
</div>
<br>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" class="layui-btn" value="保存"/></p>


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

<%--
  Created by IntelliJ IDEA.
  User: SPARK
  Date: 2021/12/6
  Time: 20:32
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
        table tr td{
            text-align: center;
        }
    </style>
</head>
<body>
<jsp:include page="headStudent.jsp"></jsp:include>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>通知信息</legend>
</fieldset>

<table class="layui-table" border="1" cellspacing="0" style=" width: 75%;">
    <c:forEach items="${notices}" var="notice" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${notice.notice}</td>

        </tr>

    </c:forEach>
</table>
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
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
    <style>
        table tr td{
            text-align: center;
        }
    </style>
</head>
<jsp:include page="../CommonFramework/head.jsp"></jsp:include>
<jsp:include page="../CommonFramework/left.jsp"></jsp:include>
<div class="layui-body">
<div style="padding: 15px;height: 600px;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>通知管理</legend>
    </fieldset>
    <div class="layui-btn-container">
        <button type="button" class="layui-btn" ><a href="${pageContext.request.contextPath }/web/jsp/NotificationAnnouncement/addNotice.jsp">添加信息</a></button>
    </div>

    <table class="layui-table" border="1" cellspacing="0" style=" width: 75%;">
        <c:forEach items="${notices}" var="notice" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${notice.notice}</td>

                <td>
                    <a href="${pageContext.request.contextPath }/deleteNoticeServlet?id=${notice.id}">删除</a>
                </td>
            </tr>

        </c:forEach>
    </table>
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
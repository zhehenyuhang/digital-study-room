<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>自习室管理系统</title>
    <link rel="stylesheet" href="../../layui/css/layui.css">
</head>
<body style="overflow-x: hidden">
<jsp:include page="../CommonFramework/head.jsp"></jsp:include>
<jsp:include page="../CommonFramework/left.jsp"></jsp:include>
<div class="layui-body">
    <div style="padding: 15px;height: 600px;">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>修改教室信息</legend>
        </fieldset>
        <div>
            <form action="${pageContext.request.contextPath }/updataStudyroomServlet" method="post">
                <input value="${studyroom.id}" name="id" type="hidden">

                <div style=" margin: 0 -32px;">
                    <label class="layui-form-label"><strong>教室名称:</strong></label>
                    <div class="layui-input-inline">
                        <input value="${studyroom.srid}" name="srid" lay-verify="required"  autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div style=" margin: 0 -32px;">
                    <label class="layui-form-label"><strong>座位总数:</strong></label>
                    <div class="layui-input-inline">
                        <input value="${studyroom.seatNumber}" name="seatNumber" lay-verify="required"  autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-input-inline">
                    <select name="acid" style="width:200px;height:40px">
                        <option value="${studyroom.academy}">${studyroom.academy}</option>
                        <c:forEach items="${academies}" var="academy" varStatus="">
                            <option value="${academy.academyName}">${academy.academyName}</option>
                        </c:forEach>
                    </select>
                </div>

                <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="layui-btn" value="修改"/></p>

            </form>


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
                    , content: '<div style="padding: 15px;">系统通知</div>'
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
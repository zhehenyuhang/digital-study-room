
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
<div>
<div style="padding: 15px;height: 600px;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>座位管理</legend><p>&nbsp;</p>
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;座位信息【说明：绿色表示可选，红色表示可选】</p><p>&nbsp;</p>

        <form action="${pageContext.request.contextPath }/selectByIdStudyroomServlet" method="post">
            <div class="layui-form-item" style=" display: flex;">

                <label class="layui-form-label">座位选择：&nbsp;</label>
                <div class="layui-input-inline">
                    <select name="academyName" style="width:200px;height:40px">
                        <option value="">请选择学院</option>
                        <c:forEach items="${academies}" var="academie" varStatus="">
                            <option value="${academie.academyName}">${academie.academyName}</option>
                        </c:forEach>

                    </select>
                </div>

                <div class="layui-input-inline">
                    <select name="date" style="width:200px;height:40px">
                        <option value="">请选择日期</option>
                        <c:forEach items="${dates}" var="date" varStatus="">
                            <option value="${date.date}">${date.date}</option>
                        </c:forEach>

                    </select>
                </div>

                <div class="layui-input-inline">
                    <select name="timeId" style="width:200px;height:40px">
                        <option value="">请选择时间段</option>
                        <option value="1">08:00-12:00</option>
                        <option value="2">14:00-18:00</option>
                        <option value="3">19:00-21:00</option>
                    </select>
                </div>

                <div class="studyroomSrid" >
                    <select name="srid" style="width:200px;height:40px">
                        <option value="">请选择阅览室</option>
                        <c:forEach items="${srids}" var="srid" varStatus="status">
                            <option value="${srid.srid}">${srid.srid}</option>
                        </c:forEach>
                    </select>
                </div>

                <div>
                    <button name="submit" value="1" type="submit" class="layui-btn layui-btn-primary layui-btn-radius">🔍查询位置</button>
                    <%--<button name="submit" value="2" type="submit" class="layui-btn layui-btn-radius">√ 保存位置</button>--%>
                    <%--<button name="submit" value="3" type="submit" class="layui-btn layui-btn-danger layui-btn-radius">X 取消占座</button>--%>
                </div>


            </div>
        </form>

        <table class="layui-table" border="1" cellspacing="0" style=" width: 75%;">
            <tr>
                <td>学院名称</td>
                <td>教室号</td>
                <td>座位总数</td>
                <td>已使用座位</td>
                <td>未使用座位</td>
                <td>时间段</td>
                <td>时间日期</td>
            </tr>
            <c:forEach items="${studyroomLogs}" var="studyroomLog" varStatus="status">
                <tr>
                    <td>${studyroomLog.academyName}</td>
                    <td>${studyroomLog.srid}</td>
                    <td>${studyroomLog.seatNumber}</td>
                    <td>${studyroomLog.usIng}</td>
                    <td>${studyroomLog.nusIng}</td>
                    <c:if test="${studyroomLog.timeId == 1}">
                        <td>8:00-12:00</td>
                    </c:if>
                    <c:if test="${studyroomLog.timeId == 2}">
                        <td>14:00-18:00</td>
                    </c:if>
                    <c:if test="${studyroomLog.timeId == 3}">
                        <td>19:00-21:00</td>
                    </c:if>
                    <td>${studyroomLog.date}</td>
                </tr>

            </c:forEach>
        </table>

    </fieldset>
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
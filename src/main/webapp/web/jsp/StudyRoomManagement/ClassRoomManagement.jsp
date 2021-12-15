<%--
  Created by IntelliJ IDEA.
  User: SPARK
  Date: 2021/12/2
  Time: 21:46
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
<div class="layui-body" style="width: 1000px;">
    <div style="padding: 15px;height: 600px;width: 1521px">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>教室管理</legend>
        </fieldset>
        <div style="
    display: flex;
">
            <div class="layui-btn-container">
                <button type="button" class="layui-btn"><a href="${pageContext.request.contextPath }/selectSridServlet">添加教室</a></button>
                <%--<button type="button" class="layui-btn">批量添加</button>--%>


            </div>
            <form action="${pageContext.request.contextPath}/selectByNamestudyroom" method="post" style="
    display: flex;
">
                <input class="layui-input"  name="srid" placeholder="输入你要查询的教室号">
                <input  type="submit" value="查询" class="layui-btn">
            </form>
        </div>

        <table class="layui-table" border="1" cellspacing="0" style=" width: 40%;">

            <tr>
                <td>序号</td>
                <td>教室号</td>
                <td>座位总数</td>
                <td>所属学院</td>
                <td>操作</td>
            </tr>

            <c:forEach items="${studyrooms}" var="studyroom" varStatus="status">
                <tr align="center">
                        <%--<td>${brand.id}</td>--%>

                    <td>${status.count}</td>
                    <td>${studyroom.srid}</td>
                    <td>${studyroom.seatNumber}</td>
                    <td>${studyroom.academy}</td>

                    <td>
                        <a href="/digital-study-room/selectByIdsrServlet?id=${studyroom.id}">修改</a>
                        <a href="/digital-study-room/deleteStudyroomServlet?id=${studyroom.id}&srid=${studyroom.srid}">删除</a>
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

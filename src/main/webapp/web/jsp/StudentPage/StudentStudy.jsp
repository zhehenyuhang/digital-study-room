<%--
  Created by IntelliJ IDEA.
  User: SPARK
  Date: 2021/12/7
  Time: 21:07
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
<div>
  <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>座位管理</legend><p>&nbsp;</p>

    <table class="layui-table" border="1" cellspacing="0" style=" width: 75%;">
      <tr>
        <td>学号</td>
        <td>教室号</td>
        <td>时间段</td>
        <td>时间日期</td>
      </tr>
      <c:forEach items="${studentStudies}" var="studentStudy" varStatus="status">
        <tr>
          <td>${studentStudy.studentId}</td>
          <td>${studentStudy.srid}</td>
          <c:if test="${studentStudy.timeId == 1}">
            <td>8:00-12:00</td>
          </c:if>
          <c:if test="${studentStudy.timeId == 2}">
            <td>14:00-18:00</td>
          </c:if>
          <c:if test="${studentStudy.timeId == 3}">
            <td>19:00-21:00</td>
          </c:if>
          <td>${studentStudy.date}</td>
        </tr>

      </c:forEach>
    </table>

  </fieldset>
</div>
<c:if test="${xuanze == 1}">
  <script>
    alert("选择成功")
  </script>
</c:if>
<c:if test="${xuanze == -1}">
  <script>
    alert("选择失败")
  </script>
</c:if>



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
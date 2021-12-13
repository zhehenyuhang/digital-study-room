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
<div style="padding: 15px;">
  <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>日志信息</legend>
  </fieldset>
  <ul class="layui-timeline">
    <li class="layui-timeline-item">
      <i class="layui-icon layui-timeline-axis"></i>
      <div class="layui-timeline-content layui-text">
        <h3 class="layui-timeline-title">2021年9月15日</h3>
        <p>
          自习室占座系统开始
          <br>1111111111111111111111111111111
          <br>2222222222222222222 <i class="layui-icon"></i>
        </p>
      </div>
    </li>
    <li class="layui-timeline-item">
      <i class="layui-icon layui-timeline-axis"></i>
      <div class="layui-timeline-content layui-text">
        <h3 class="layui-timeline-title">2021年9月16日</h3>
        <p>44444444444444444444</p>
        <ul>
          <li>555555555</li>
          <li>66666666666666</li>
        </ul>
      </div>
    </li>
    <li class="layui-timeline-item">
      <i class="layui-icon layui-timeline-axis"></i>
      <div class="layui-timeline-content layui-text">
        <h3 class="layui-timeline-title">2021年10月5日</h3>
        <p>
          123456789465461321321321321321
          <br>45645642132
          <br>456456465456413213
          <br>456456412313
        </p>
      </div>
    </li>
    <li class="layui-timeline-item">
      <i class="layui-icon layui-timeline-axis"></i>
      <div class="layui-timeline-content layui-text">
        <div class="layui-timeline-title">至今</div>
      </div>
    </li>
  </ul>

  <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>日志记录</legend>
  </fieldset>
  <ul class="layui-timeline">
    <li class="layui-timeline-item">
      <i class="layui-icon layui-timeline-axis"></i>
      <div class="layui-timeline-content layui-text">
        <div class="layui-timeline-title">2021.9.1，XXXXXXXXX</div>
      </div>
    </li>
    <li class="layui-timeline-item">
      <i class="layui-icon layui-timeline-axis"></i>
      <div class="layui-timeline-content layui-text">
        <div class="layui-timeline-title">2021.9.5，XXXXXXXXXXXXXX</div>
      </div>
    </li>
    <li class="layui-timeline-item">
      <i class="layui-icon layui-timeline-axis"></i>
      <div class="layui-timeline-content layui-text">
        <div class="layui-timeline-title">2021.9.20，XXXXXXXXXXXX</div>
      </div>
    </li>
    <li class="layui-timeline-item">
      <i class="layui-icon layui-timeline-axis"></i>
      <div class="layui-timeline-content layui-text">
        <div class="layui-timeline-title">2021.10.1，XXXXXXXXXXXXX</div>
      </div>
    </li>
    <li class="layui-timeline-item">
      <i class="layui-icon layui-anim layui-anim-rotate layui-anim-loop layui-timeline-axis"></i>
      <div class="layui-timeline-content layui-text">
        <div class="layui-timeline-title">2021.10.6，XXXXXXXXXXXXXXXXXXX</div>
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
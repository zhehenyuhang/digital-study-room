<%--
  Created by IntelliJ IDEA.
  User: 24387
  Date: 2021/11/26
  Time: 0:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/web/layui/css/layui.css"  media="all">
    <script src="${pageContext.request.contextPath }/web/js/echarts.js"></script>
    <style >
        .ifr{
            width: 100%;
            height: 615px;
        }
        #div1 {
            position: sticky;
            top: 0px;
        }
    </style>
</head>
<body style="overflow-x: hidden">
<div class="layui-layout layui-layout-admin layui-header " id="div1" >
    <div class="layui-logo layui-hide-xs layui-bg-black" id="div2"><a href="${pageContext.request.contextPath }/web/jsp/HomePage/zhuye.jsp" style=" color: #fff;">自习室管理系统</a></div>
    <!-- 头部区域（可配合layui 已有的水平导航） -->
    <ul class="layui-nav layui-layout-left" style="width: 100%">
        <marquee scrollAmount=2 direction="left" scrolldelay="60" style="width: 1040px;height: 20px;padding: 20px;"> <font-size :50px;color="block" >欢迎使用自习室管理系统，祝你使用愉快！</font-size></marquee>
    </ul>
    <ul class="layui-nav layui-layout-right" >
        <li class="layui-nav-item layui-hide layui-show-md-inline-block">
            <a href="javascript:;">
                <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"
                     class="layui-nav-img">
                ${teacherName}
            </a>
            <dl class="layui-nav-child">
                <dd><a href="${pageContext.request.contextPath }/web/jsp/MyAccount/MyAccount.jsp" target="iframe1">我的账户</a></dd>
                <dd><a href="${pageContext.request.contextPath }/web/jsp/MyAccount/ModifyPassword.jsp">修改密码</a></dd>
                <dd><a href="${pageContext.request.contextPath }/web/jsp/HomePage/index.jsp">安全退出</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
            <a href="javascript:;">
                <i class="layui-icon layui-icon-more-vertical"></i>
            </a>
        </li>
    </ul>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 24387
  Date: 2021/11/26
  Time: 0:46
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
    <style>
        .ifr{
            width: 100%;
            height: 615px;
        }
    </style>
</head>
<body>
<div class="layui-side layui-bg-black layui-layout layui-layout-admin">
    <div class="layui-side-scroll" style="padding-top: 62px;height: 90%">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree" lay-filter="test">
            <li class="layui-nav-item layui-nav-itemed">
                <a class="" href="javascript:;">用户管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="${pageContext.request.contextPath }/selectAllTeacherServlet" >老师信息</a>
                    <dd><a href="${pageContext.request.contextPath }/selectAllStudentServlet"  >学生信息</a></dd>
                    <%--<dd><a href="${pageContext.request.contextPath }/web/jsp/NotificationAnnouncement/NotificationManagement.jsp"  >权限管理</a></dd>--%>
                </dl>
            </li>
            <li class="layui-nav-item layui-nav-itemed">
                <a href="javascript:;">自习室管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="${pageContext.request.contextPath }/selectAcademyServlet" >学院管理</a></dd>
                    <dd><a href="${pageContext.request.contextPath}/selectAllServlet" >教室管理</a></dd>
                    <dd><a href="${pageContext.request.contextPath }/selectStudyroomServlet"  >座位管理</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item layui-nav-itemed">
                <a href="javascript:;">通知公告</a>
                <dl class="layui-nav-child">
                    <dd><a href="${pageContext.request.contextPath }/selectNoticeServlet"  >通知管理</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item layui-nav-itemed">
                <a href="javascript:;">数据统计</a>
                <dl class="layui-nav-child">
                    <dd><a href="${pageContext.request.contextPath }/selectDataUsingServlet"  >学习情况</a></dd>
                    <dd><a href="${pageContext.request.contextPath }/web/jsp/DataStatistics/LogManagement.jsp"  >日志管理</a></dd>
                </dl>
            </li>
        </ul>
    </div>
</div>
</body>
</html>

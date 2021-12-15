<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        #container {
            min-width: 320px;
            max-width: 800px;
            margin: 0 auto;
        }
    </style>
    <style>
        .quan{
            margin: 0px 115px;
        }
    </style>
    <script src="../../js/Student/exporting.js"></script>
    <script src="../../js/Student/highcharts.js"></script>
    <script src="../../js/Student/networkgraph.js"></script>
    <script src="../../js/Student/oldie.js"></script>

</head>
<body>
<jsp:include page="headStudent.jsp"></jsp:include>
<div style="padding: 15px;height: 600px;">
    <div style="max-width: 1140px;">
        <ul class="layui-border-box site-doc-icon site-doc-anim" style=" display: flex;">
            <li class="quan">
                <div class="layui-anim" data-anim="layui-anim-scale" style=" width: 200px; height: 200px; line-height: 150px; margin: 0 auto 10px; text-align: center; background-color: #009688; cursor: pointer; color: #fff; border-radius: 50%;">
                    <div style=" font-size: 55px;">${seatNumber}</div>
                </div>
                <div style=" text-align: center; margin: 17px 0px; font-size: 25px;">总座位</div>
            </li>
            <li class="quan">
                <div class="layui-anim" data-anim="layui-anim-scale" style=" width: 200px; height: 200px; line-height: 150px; margin: 0 auto 10px; text-align: center; background-color: #009688; cursor: pointer; color: #fff; border-radius: 50%;">
                    <div style=" font-size: 55px;">${usIng}</div>
                </div>
                <div style=" text-align: center; margin: 17px 0px; font-size: 25px;">已用座位</div>
            </li>
            <li class="quan">
                <div class="layui-anim" data-anim="layui-anim-scale" style=" width: 200px; height: 200px; line-height: 150px; margin: 0 auto 10px; text-align: center; background-color: #009688; cursor: pointer; color: #fff; border-radius: 50%;">
                    <div style=" font-size: 55px;">${nusIng}</div>
                </div>
                <div style=" text-align: center; margin: 17px 0px; font-size: 25px;">剩余座位</div>
            </li>
        </ul>
    </div>

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>更新情况</legend>
    </fieldset>
    <ul class="layui-timeline">
        <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <div class="layui-timeline-title">2021.09.20计划萌芽</div>
            </div>
        </li>
        <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <div class="layui-timeline-title">2021.09.31项目准备</div>
            </div>
        </li>
        <li class="layui-timeline-item">
            <i class="layui-icon layui-anim layui-anim-rotate layui-anim-loop layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <div class="layui-timeline-title">2021.10.03分布开始ing...</div>
            </div>
        </li>
        <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <div class="layui-timeline-title">2021.12.10基本完工</div>
            </div>
        </li>
        <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <div class="layui-timeline-title">2021.12.xx升级系统</div>
            </div>
        </li>
    </ul>

</div>>
</body>
</html>

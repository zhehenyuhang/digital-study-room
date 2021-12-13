<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/web/layui/layui.js"></script>
</head>
<body>
<ul class="layui-nav layui-nav " style="padding-left: 60px">
    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/web/jsp/StudentPage/Studentindex.jsp">首页</a></li>
    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/web/jsp/StudentPage/NotificationInformation.jsp">通知</a></li>
    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/selectStudyroomCSServlet">选座</a></li>



    <ul class="layui-nav layui-layout-left" style="margin-left: 300px">
        <marquee scrollAmount=2 direction="left" scrolldelay="60" style="width: 640px;height: 20px;padding: 18px;"> <font-size :50px;color="block" >欢迎使用自习室管理系统，祝你使用愉快！</font-size></marquee>
    </ul>

    <li class="layui-nav-item layui-hide layui-show-md-inline-block layui-layout-right" style="margin-right: 60px">
        <a href="javascript:;" >
            <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"
                 class="layui-nav-img">
            ${studentId}
        </a>
        <dl class="layui-nav-child">
            <dd><a href="MyAccountStudent.jsp">我的账户</a></dd>
            <dd><a href="ModifyPasswordStudent.jsp">修改密码</a></dd>
            <dd><a href="../HomePage/login_student.jsp">安全退出</a></dd>
        </dl>
    </li>
</ul>
</body>
</html>

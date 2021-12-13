<%--
  Created by IntelliJ IDEA.
  User: shiyuhang
  Date: 2021/12/2
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../CommonFramework/head.jsp"></jsp:include>
<jsp:include page="../CommonFramework/left.jsp"></jsp:include>
<div class="layui-body">
    <div style="padding: 15px;height: 600px;">
<form action="${pageContext.request.contextPath }/addNoticeServlet" method="post">
    发布：<textarea rows="5" cols="20" name="notice"></textarea><br>
    <input type="submit" value="发布">
</form>
    </div>
</div>
<jsp:include page="../CommonFramework/bottom.jsp"></jsp:include>
</body>
</html>

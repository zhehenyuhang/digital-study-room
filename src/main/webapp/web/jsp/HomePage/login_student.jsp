<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="../../css/login.css">
  <title>自习室管理平台登录</title>

</head>
<body>
<div id="container">
  <div id="container-child">
    <div><img src="../../image/log.png" width="250" height="380"></div>
    <div id="login-div">
      <div>
        <p class="p-title">自习室管理平台学生端</p>

        <form id="login-form" action="${pageContext.request.contextPath}/loginStudentServlet" method="post">
          <div class="input-d">
            <input class="input-text" type="text" name="studentNumber"  placeholder="请输入您的账号">
          </div>
          <div class="input-d">
            <input class="input-text" type="password" name="studentPassword"  placeholder="请输入您的密码">
          </div>

          <div class="div-input">
            <div>
            </div>
			  <div>
            </div>
          </div>
          <input type="submit" class="login-button" value="登录" >
          <div class="footer"> <a href="${pageContext.request.contextPath}/web/jsp/HomePage/index.jsp">切换端口</a></div>

        </form>


      </div>
    </div>
  </div>

</div>
</body>
</html>
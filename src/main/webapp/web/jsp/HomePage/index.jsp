<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/web/css/login.css">
  <title>自习室管理平台登录</title>

</head>
<body>
<div id="container">
  <div id="container-child">
    <div><img src="${pageContext.request.contextPath }/web/image/log.png" width="250" height="380"></div>
    <div id="login-div">
      <div>

        <p class="p-title">自习室管理平台管理员端</p>
        <form id="login-form" action="/digital-study-room/loginTeacherServlet" method="post">
          <p  style="color: red;margin: -15px 0 -15px;">${login_msg}</p>
          <div class="input-d">
            <input class="input-text" type="text" name="teacherNumber"  placeholder="请输入您的账号">
          </div>
          <div class="input-d">
            <input class="input-text" type="password" name="teacherPassword"  placeholder="请输入您的密码">
          </div>

          <div class="div-input">
            <div>
            </div>
			  <div>
            </div>
          </div>
          <input type="submit" class="login-button" value="登录">
          <div class="footer"> <a href="${pageContext.request.contextPath }/web/jsp/HRegister.jsp">注册</a> | <a href="${pageContext.request.contextPath}/web/jsp/HomePage/login_student.jsp">切换端口</a></div>
        </form>

      </div>
    </div>
  </div>

</div>
</body>
</html>
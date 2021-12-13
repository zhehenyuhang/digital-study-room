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
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../css/Register.css">
    <script src="../../js/jQuery.js"></script>
    <script src="../../js/Register.js"></script>
    <title>自习室管理平台登录</title>
</head>
<body>
<div id="head">
    <span id="logo-text">自习室管理平台登录</span>
    <span style="font-size: 28px;color: #ece8e8dc;">&emsp;|&emsp;</span>
    <span style="font-size: 20px;font-weight: bold;">用户注册</span>
    <span style="float: right; margin-top: 5px;"><a href="login_student.jsp">已有账号登录</a></span>
</div>
<div class="line"></div>
<div id="body">
    <div class="boby-step">
        <div class="step-div">
            <div id="step-1" class="step-checkd">01</div>
            <div class="step-text-checkd">用户对象</div>
            <div id="step-01-line" class="step-line"></div>
        </div>
        <div class="step-div">
            <div id="step-2" class="step-uncheckd">02</div>
            <div id="step-2-text" class="step-text-uncheckd">账户信息</div>
            <div id="step-02-line" class="step-line"></div>
        </div>
        <div class="step-div">
            <div id="step-3" class="step-uncheckd">03</div>
            <div id="step-3-text" class="step-text-uncheckd">密码设置</div>
            <div id="step-03-line" class="step-line"></div>
        </div>
        <div class="step-div">
            <div id="step-4" class="step-uncheckd">04</div>
            <div id="step-4-text" class="step-text-uncheckd">注册成功</div>
        </div>
    </div>
    <div style="clear:both;"></div>
    <div id="step-01">
        <div style="margin-top: 50px;">
            <div style="font-size: 20px;font-weight: bold;">用户对象</div>
            <div class="line1"></div>
        </div>
        <div style="clear: both;"></div>
        <div>
            <form name="userobjectform" id="userobjectform">
                <div class="userobject">
                    <div>
                        <input type="radio"  name="userobject" checked="checked" value="渭南师范学院老师">
                        <label>渭南师范学院老师</label>
                    </div>
                    <div>
                        <input type="radio"  name="userobject" value="渭南师范学院学生">
                        <label>渭南师范学院学生</label>
                    </div>
                </div>
                <div style="clear: both;"></div>
                <div>
                    <button type="button" onclick="next(1)" class="next-step">下一步</button>
                </div>
            </form>
        </div>
        </form>
    </div>
    <div id="step-02" style="display: none;">
        <div style="margin-top: 50px;">
            <div style="font-size: 20px;font-weight: bold;">账户信息</div>
            <div class="line1"></div>
        </div>
        <div style="clear: both;"></div>
        <div style="margin-top: 50px;">
            <form name="userinfoform" id="userinfoform">
                <div class="accountinfo">
                    <label for="username">用户姓名</label>
                    <input type="text" name="username" id="username" placeholder="请输入您的姓名">
                </div>
                <div class="accountinfo">
                    <label for="userNationality">工号|学号</label>
                    <input type="text" name="userNationality" id="userNationality" placeholder="请输入工号|学号">
                </div>
                <div class="accountinfo">
                    <label for="IDNumber">证件号码</label>
                    <input type="text" name="IDNumber" id="IDNumber" placeholder="请输入您的证件号码">
                </div>
                <div class="accountinfo">
                    <label for="email">用户邮箱</label>
                    <input type="text" name="email" id="email" placeholder="请输入您的邮箱">
                </div>
                <div class="accountinfo">
                    <label for="phoneNumber">手机号码</label>
                    <input type="text" name="phoneNumber" id="phoneNumber" placeholder="请输入您的手机号码">
                </div>
                <div>
                    <button type="button" onclick="next(2)" class="next-step">下一步</button>
                    <button type="button" onclick="previous(2)" class="previous-step">上一步</button>
                </div>
            </form>
        </div>
    </div>

    <div id="step-03" style="display: none;">
        <div style="margin-top: 50px;">
            <div style="font-size: 20px;font-weight: bold;">密码设置</div>
            <div class="line1"></div>
        </div>
        <div style="clear: both;"></div>
        <div style="margin-top: 50px;">
            <form name="passwordform" id="passwordform">
                <div class="accountinfo">
                    <label for="password">登录密码</label>
                    <input type="password" name="password" id="password" placeholder="请输入您设置登录密码">
                </div>
                <div class="accountinfo">
                    <label for="confirmPassword">确认密码</label>
                    <input type="password" name="confirmPassword" id="confirmPassword" placeholder="请输入您再次确认密码">
                </div>
                <div>
                    <button type="button" onclick="next(3)" class="next-step">下一步</button>
                    <button type="button" onclick="previous(3)" class="previous-step">上一步</button>
                </div>
            </form>
        </div>
    </div>
    <div id="step-04" style="display: none;">
        <div>
            <div class="img">
                <img src="../../image/suss.png" alt="注册成功">
            </div>
            <div class="img-text">恭喜您注册成功</div>
            <div class="step-04-button">
                <input id="dl" type="button" class="next-step" value="登录" onclick="location.href = 'login_student.jsp'">
            </div>
        </div>
    </div>
</div>
<div style="clear: both;"></div>
<div id="footer">
    <div>
        <div id="footer-img">
            <img src="../../image/youxiang.jpg">
        </div>
        <div style="margin-left: 50px;">
            <table>
                <tr>
                    <th class="text">我们</th>
                    <th class="text">案例</th>
                    <th class="text">方案</th>
                    <th class="text">发现</th>
                    <th class="text1">联系我们</th>
                </tr>
                <tr>
                    <td>XXXX</td>
                    <td>XXXX</td>
                    <td>XXXX</td>
                    <td>XXXX</td>
                    <td>XXXX</td>
                </tr>
                <tr>
                    <td>XXXX</td>
                    <td>XXXX</td>
                    <td>XXXX</td>
                    <td>XXXX</td>
                    <td>XXXX</td>
                </tr>
                <tr>
                    <td>XXXX</td>
                    <td>XXXX</td>
                    <td>XXXX</td>
                    <td>XXXX</td>
                    <td>XXXX</td>
                </tr>
                <tr>
                    <td>XXXX</td>
                    <td>XXXX</td>
                    <td>XXXX</td>
                    <td>XXXX</td>
                    <td>XXXX</td>
                </tr>
            </table>
        </div>
    </div>

</div>
</body>
</html>
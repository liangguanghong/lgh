
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" media="screen" href="/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="/css/reset.css"/>
    <script src="js/particles.min.js"></script>
    <script src="js/app.js"></script>
    <script src="js/login.js"></script>

<title>登录页</title>
<%--    ${logininfo==null?'':'<script type="text/javascript"> alert("账号或者密码错误");</script>'}--%>
<script type="text/javascript">
function login() {
    document.getElementById('loginform').submit();




}

</script>
    <base href="<%=basepath%>"/>
</head>
<body>

    <div id="particles-js">
        <div class="login" >

            <div class="login-top">
                登录
            </div>
            <form action="/mc/l" method="post" id="loginform">

            <div class="login-center clearfix">
                <div class="login-center-img"><img src="/img/name.png"/></div>
                <div class="login-center-input">
                    <input type="text" name="loginname" value="zhangsan" placeholder="请输入您的用户名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的用户名'"/>
                    <div class="login-center-input-text">用户名</div>
                </div>
            </div>
            <div class="login-center clearfix">
                <div class="login-center-img"><img src="/img/password.png"/></div>
                <div class="login-center-input">
                    <input type="password" name="loginpwd"value="111" placeholder="请输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'"/>
                    <div class="login-center-input-text">密码</div>
                </div>
            </div>

            </form>
                <a href="javascript:void(0)" onclick="login();" >
                    <div class="login-button">登录</div>
                </a>

        </div>
        <div class="sk-rotating-plane"></div>
    </div>

    <!-- scripts -->
    <script src="js/particles.min.js"></script>
    <script src="js/app.js"></script>
    <script type="text/javascript" src="js/login.js"></script>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
</body>
</html>
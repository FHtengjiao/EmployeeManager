﻿<%@ page contentType="text/html;charset=utf-8" isELIgnored="false" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=8" >
<title>左边导航</title>
<link rel="stylesheet" type="text/css" href="../css/reset.css"/>
<link rel="stylesheet" type="text/css" href="../css/common.css"/>
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<!--框架高度设置-->
<script type="text/javascript">
$(function(){
	$('.sidenav li').click(function(){
		$(this).siblings('li').removeClass('now');
		$(this).addClass('now');
	});
	
	$('.erji li').click(function(){
		$(this).siblings('li').removeClass('now_li');
		$(this).addClass('now_li');
	});
	
	var main_h = $(window).height();
	$('.sidenav').css('height',main_h+'px');
})
</script>
<!--框架高度设置-->
</head>

<body>
<div id="left_ctn">
    <ul class="sidenav">
        <li class="now">
            <div class="nav_m">
                <span><a>人员管理</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">
                <li class="now now_li">
                    <span><a href="${pageContext.request.contextPath}/employee/list.do" target="main">员工管理</a></span>
                </li>
                <li>
                    <span><a href="${pageContext.request.contextPath}/department/list.do" target="main">部门管理</a></span>
                </li>
	    </ul>
        </li>
        <%--<li>--%>
            <%--<div class="nav_m">--%>
                <%--<span><a>用户权限</a></span>--%>
                <%--<i>&nbsp;</i>--%>
            <%--</div>--%>
            <%--<ul class="erji">--%>
                <%--<li>--%>
                    <%--<span><a href="#" target="main">角色设置</a></span>--%>
                <%--</li>--%>
                <%--<li>--%>
                    <%--<span><a href="#" target="main">功能权限</a></span>--%>
                <%--</li>--%>
            <%--</ul>--%>
        <%--</li>--%>
        <li>
            <div class="nav_m">
                <span><a>个人中心</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">
                <li>
                    <span><a href="${pageContext.request.contextPath}/pages/user_detail.jsp" target="main">个人信息</a></span>
                </li>
                <li>
                    <span><a href="${pageContext.request.contextPath}/toChangePassword.do" target="main">修改密码</a></span>
                </li>
            </ul>
        </li>
        <li>
            <div class="nav_m">
                <span><a href="${pageContext.request.contextPath}/logout.do" target="_top">退出系统</a></span>
            </div>
        </li>
    </ul>
</div>
</body>
</html>

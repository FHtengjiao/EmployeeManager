<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/3
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>员工编辑</title>
    <link rel="stylesheet" type="text/css" href="../css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/thems.css">
    <script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function(){
            //自适应屏幕宽度
            window.onresize=function(){ location=location };

            var main_h = $(window).height();
            $('.hy_list').css('height',main_h-45+'px');

            var main_w = $(window).width();
            $('.xjhy').css('width',main_w-40+'px');

            $("#submit_btn").click(function () {
                let newPassword = $("#new_password");
                let reNewPassword = $("#re_new_password");
                console.log(newPassword.val());
                if (newPassword.val() === reNewPassword.val() && newPassword.val() !== "") {
                    $("#addForm").submit();
                } else {
                    alert("两次输入的新密码不正确");
                    newPassword.val("");
                    reNewPassword.val("");
                }
            });
        });
    </script>
</head>

<body onLoad="Resize();">
<div id="right_ctn">
    <div class="right_m">
        <div class="hy_list">
            <div class="box_t">
                <span class="name">修改密码</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <form action="${pageContext.request.contextPath}/changePassword.do" method="post" id="addForm">
                <input type="hidden" name="id" value="${USER.id}">
                <div class="xjhy">
                    <!--高级配置-->
                    <ul class="hypz gjpz clearfix">
                        <li class="clearfix">
                            <span class="title">旧密码：</span>
                            <div class="li_r">
                                <input class="chang" name="old_password" type="password"/>
                                <i>*</i>
                                <i>${msg}</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">新密码：</span>
                            <div class="li_r">
                                <input class="chang" name="new_password" id="new_password" type="password"/>
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">再次输入新密码：</span>
                            <div class="li_r">
                                <input class="chang" name="re_new_password" id="re_new_password" type="password">
                                <i>*</i>
                            </div>
                        </li>
                        <li class="tj_btn">
                            <a href="javascript:history.go(-1);" class="back">返回</a>
                            <a id="submit_btn">保存</a>
                        </li>
                    </ul>
                    <!--高级配置-->
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
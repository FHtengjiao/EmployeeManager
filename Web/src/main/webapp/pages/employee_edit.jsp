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

            let gender = "${EMPLOYEE.gender}";
            $(":radio[value="+gender+"]").attr("checked", true);
        });
    </script>
</head>

<body onLoad="Resize();">
<div id="right_ctn">
    <div class="right_m">
        <div class="hy_list">
            <div class="box_t">
                <span class="name">员工编辑</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <form action="${pageContext.request.contextPath}/employee/edit.do" method="post" name="addForm">
                <input type="hidden" name="id" value="${EMPLOYEE.id}">
                <div class="xjhy">
                    <!--高级配置-->
                    <ul class="hypz gjpz clearfix">
                        <li class="clearfix">
                            <span class="title">账号：</span>
                            <div class="li_r">
                                <input class="chang" name="account" type="text" value="${EMPLOYEE.account}" readonly/>
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">状态：</span>
                            <div class="li_r">
                                <input class="chang" name="status" type="text" value="${EMPLOYEE.status}"/>
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">部门：</span>
                            <div class="li_r">
                                <select name="department_id">
                                    <c:forEach var="dep" items="${DEPARTMENTS}">
                                        <c:choose>
                                            <c:when test="${dep.id == EMPLOYEE.department.id}">
                                                <option value="${dep.id}" selected>${dep.name}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${dep.id}">${dep.name}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">名字：</span>
                            <div class="li_r">
                                <input class="chang" name="name" type="text" value="${EMPLOYEE.name}">
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">性别：</span>
                            <div class="li_r">
                                <span class="radio">
                                <input name="gender" type="radio" value="男"/>
                                <em>男</em>
                                </span>
                                <span class="radio">
                                <input name="gender" type="radio" value="女"/>
                                <em>女</em>
                                </span>
                                <span class="radio">
                                <input name="gender" type="radio" value="保密"/>
                                <em>保密</em>
                                </span>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">身份证号码：</span>
                            <div class="li_r">
                                <input class="chang" name="id_card" type="text" value="${EMPLOYEE.idCard}">
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">生日：</span>
                            <div class="li_r">
                                <input class="chang" name="birthday" type="date" value="<fmt:formatDate value="${EMPLOYEE.birthday}" pattern="yyyy-MM-dd"/>">
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">备注：</span>
                            <div class="li_r">
                                <textarea class="chang" name="mark">${EMPLOYEE.mark}</textarea>
                                <i>*</i>
                            </div>
                        </li>
                        <li class="tj_btn">
                            <a href="javascript:history.go(-1);" class="back">返回</a>
                            <a href="javascript:addForm.submit();">保存</a>
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
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/3
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>部门列表</title>
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

            var search_w = $(window).width()-40;
            $('.search').css('width',search_w+'px');
            //$('.list_hy').css('width',search_w+'px');
        });
    </script>
    <!--框架高度设置-->
</head>

<body onLoad="Resize();">
<div id="right_ctn">
    <div class="right_m">
        <div class="hy_list">
            <div class="box_t">
                <span class="name">员工列表</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <!--列表-->
            <table cellpadding="0" cellspacing="0" class="list_hy">
                <tr>
                    <th scope="col">名字</th>
                    <th scope="col">账号</th>
                    <th scope="col">部门</th>
                    <th scope="col">状态</th>
                    <th scope="col">操作</th>
                </tr>
                <c:forEach var="emp" items="${EMPLOYEES}">
                <tr>
                    <td>${emp.name}</td>
                    <td>${emp.account}</td>
                    <td>${emp.department.name}</td>
                    <c:choose>
                        <c:when test="${emp.status=='离职'}">
                            <td>${emp.status}</td>
                        </c:when>
                        <c:otherwise>
                            <td>${emp.status}<a href="${pageContext.request.contextPath}/employee/leave.do?id=${emp.id}" class="btn">离职</a></td>
                        </c:otherwise>
                    </c:choose>
                    <td>
                        <a href="${pageContext.request.contextPath}/employee/toEdit.do?id=${emp.id}" class="btn">编辑</a>
                        <a href="${pageContext.request.contextPath}/employee/delete.do?id=${emp.id}" class="btn">删除</a>
                        <a href="${pageContext.request.contextPath}/employee/detail.do?id=${emp.id}" class="btn">详情</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
            <!--列表-->
            <!--右边底部-->
            <div class="r_foot">
                <div class="r_foot_m">
                    <a href="${pageContext.request.contextPath}/employee/toAdd.do" class="btn">添加</a>
                </div>
            </div>
            <!--右边底部-->
        </div>
        <!--会议列表-->
    </div>
</div>

</body>
</html>

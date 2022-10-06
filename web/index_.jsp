<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.prprv.shop.util.DBUtil,java.util.List"%>

<html>
<head>
    <title>我的商城</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="renderer" content="webkit">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jc.css">

    <script src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/script/pintuer.js"></script>
    <script src="${pageContext.request.contextPath}/script/respond.js"></script>
</head>

<body>
<div class="layout bg bg-black hidden-l">
    <div class="hidden-s hidden-m x12 float-right ">
        <div class="x4  text-right height-big float-right">
            <a href="${pageContext.request.contextPath}/jsp/user/cart.jsp"
               style="color: red; display: inline-block; width: 121px; height: 45px;">购物车<font
                    size="3" color="white">(${cart.size})</font></a>
            <a class="text-white">400-123-4567</a><a href="#"
                                                     class="win-homepage">设为首页</a> | <a href="#" class="win-favorite">加入收藏</a>
        </div>
    </div>
</div>
<div class="layout">
    <div
            class="line padding-big-top padding-big-bottom navbar bg-blue bg-inverse ">
        <div class="x2">
            <button class="button icon-navicon float-right"
                    data-target="#header-demo3"></button>
            <img src="img/jclogo(2).png" width="150" class="padding" height="50" />
        </div>
        <div class=" x10 padding-top  nav-navicon" id="header-demo3">
            <div class="x5 text-right ">
                <ul class="nav nav-menu nav-inline">
                    <li class="active "><a href="#" class=" radius ">首页</a></li>
                    <li><a href="adlogin.jsp">商品管理</a></li>
                    <li><a
                            href="${pageContext.request.contextPath}/jsp/admin/ordermanage.jsp">订单管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/AdminManage">管理员管理</a></li>
                </ul>
            </div>
            <div class="x5">
                <%
                    if (session.getAttribute("email") == null) {
                %>
                <%@ include file="login.jsp"%>
<%--                <jsp:forward page="login.jsp"/>--%>
                <%
                    } else {
                        out.println(session.getAttribute("email") + "你好,<br/>欢迎你光顾本店!!!");
                        out.println("<br/><a href='userinfo.jsp'>查看/修改个人信息</a>");
                        out.println("<a href='./Logout'>[注销]</a>");
                    }
                %>
            </div>

        </div>
    </div>
</div>
<!--轮播-->
<div class="layout">
    <div class="banner">
        <div class="carousel">
            <div class="item">
                <img src="img/banner1.jpg" width="100%">
            </div>
            <div class="item">
                <img src="img/banner2.jpg" width="100%">
            </div>
            <div class="item">
                <img src="img/banner3.jpg" width="100%">
            </div>
        </div>
    </div>
</div>
<div class="layout">
    <div class="line">
        <div class="x2  margin-big-top">
            <button class="button icon-navicon" data-target="#nav-main1"></button>
            <ul class="nav nav-main nav-navicon text-center" id="nav-main1">
                <li class="nav-head">商品分类</li>
                <%
                    String sql = "select distinct Gclass from GoodsInfo";
                    List<String> vclass = DBUtil.getInfo(sql);
                    if (vclass != null) {
                        for (String st : vclass) {
                    %>
                    <li class="active"><a
                            href="${pageContext.request.contextPath}/Search?cname=<%= st %>"><%=st%></a></li>
                    <%
                        }
                    }
                %>
            </ul>
            <br>
            <div class="x12"><%@ include file="/jsp/admin/adminsearch.jsp"%></div>
        </div>
        <div class="x10"><%@ include file="/jsp/user/splist.jsp"%></div>
    </div>

    <!--分页-->
    <c:set var="curPage" value="${pages.curPage}"/>
    <c:set var="totalPage" value="${pages.totalPage}"/>
    <div class="x7 text-right">
        <ul class="pagination">
            <c:if test="${curPage>1}">
                <li><a href="${pageContext.request.contextPath}/PageChange?curPage=${curPage-1}">&lt;&lt;上一页</a></li>
            </c:if>
        </ul>

        <ul class="pagination pagination-group">
            <select class="input" onchange="this.form.submit()" name="selPage">
                <c:forEach var="i" begin="1" end="${totalPage}" step="1">
                    <c:set var="flag" value=""/> <!-- 如果此处不设置为空值，select永远在选中最后一项，页码不会跟着变化 -->

                    <c:if test="${i==curPage}">
                        <c:set var="flag" value="selected"/>
                    </c:if>

                    <option value="${i}" ${flag}>第${i}页</option>
                </c:forEach>
            </select>
        </ul>

        <ul class="pagination">
            <c:if test="${curPage<totalPage}">
                <li><a href="${pageContext.request.contextPath}/PageChange?curPage=${curPage+1}">下一页>></a></li>
            </c:if>
        </ul>

    </div >
    <br/><br/><br/><br/>
    <%@include file="down.jsp" %>
    <%-- 	<jsp:include page="down.jsp"> --%>
    <!-- 	<div class="container-layout margin-large-top bg-gray"> -->
    <!-- 	<div class="container bg-gray bg-inverse padding-big-top padding-big-bottom"> <div class="table-responsive padding hidden-l"> <ul class="nav nav-sitemap"> <li><a href="#">新闻资讯</a> <ul> <li><a href="#">新闻公告</a></li> <li><a href="#">业界资讯</a></li> <li><a href="#">媒体报道</a></li> </ul> </li> <li><a href="#">产品中心</a> <ul> <li><a href="#">产品分类</a></li> <li><a href="#">产品品牌</a></li> <li><a href="#">产品特色</a></li> </ul> </li> <li><a href="#">技术反馈</a> <ul> <li><a href="#">售后服务</a></li> <li><a href="#">营销网络</a></li> <li><a href="#">服务支持</a></li> </ul> </li> <li><a href="#">留言反馈</a></li> <li><a href="#">联系方式</a></li> </ul> </div> <div class="text-center">版权所有  Pintuer.com All Rights Reserved，图ICP备：380959609</div> </div> -->
    <!-- 	</div> -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="../components/jsp/include.jsp" />
<script type="text/javascript" src="../components/js/shopDetail.js"></script>
<link rel="stylesheet" type="text/css" href="../components/css/shopDetail.css">
<title>商家详情</title>
</head>
<body class="inside-body">
	<input id="base" type="hidden" value="<%=request.getContextPath()%>">
	<div class="body-div">
		<div class="shopdetail-total-div">
			<div class="label-div">
				<ul class="normal-ul shopdetail-horizontal">
					<li class="normal-li shopdetail-menu-li shopdetail-curr-li" target="#hishopinfo">
						嗨商信息
					</li>
					<li class="normal-li shopdetail-menu-li" target="#hibuydetail">
						嗨购详情
					</li>
					<li class="normal-li shopdetail-menu-li" target="#hievaluate">
						嗨评互动
					</li>
				</ul>
			</div>
			<div class="shopdetail-info-div" id="hishopinfo">
				<ul class="normal-ul shopdetail-ul">
					<li class="normal-li shopdetail-li">
						<label class="text-label">商家编号：</label>${shopid}
					</li>
					<li class="normal-li shopdetail-li">
						<label class="text-label">商家名称：</label>${shop.shopName}
					</li>
					<li class="normal-li">
						<label class="text-label">嗨小二：</label>
						<a class="normal-a floatnone-a cursor-a user-link" onclick="userinfo(this, '${shop.username}')">${shop.nickName}</a>
					</li>
					<li class="normal-li">
						<label class="text-label">商家描述：</label>${shop.shopDesc}
					</li>
					<li class="normal-li">
						<label class="text-label">商家地址：</label>${shop.shopAddr}
					</li>
				</ul>
			</div>
			<div class="shopdetail-info-div hid" id="hibuydetail">
				这是嗨购详情
			</div>
			<div class="shopdetail-info-div hid" id="hievaluate">
				这是嗨评互动
			</div>
		</div>
	</div>
</body>
</html>
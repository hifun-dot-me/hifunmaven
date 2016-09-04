<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="../components/jsp/include.jsp" />
<script type="text/javascript" src="../components/js/shopmodify.js"></script>
<link rel="stylesheet" type="text/css" href="../components/css/shopmodify.css">
<title>shopmodify</title>
</head>
<body class="inside-body">
	<input id="base" type="hidden" value="<%=request.getContextPath()%>">
	<input id="shopTypeHid" name="shopTypeHid" type="hidden" value="${shop.shopType}">
	<input id="shopLevelHid" name="shopLevelHid" type="hidden" value="${shop.shopLevel}">
	<div class="middle-div">
		<div class="left-div">
			<div class="form-div">
				<form action="" id="mainForm" method="post">
					<span class="form-title">商家注册</span>
					<input id="shopName" value="${shop.shopName}" class="form-control form-normal-input" disabled placeholder="商家名称，20字符以内"/>
					<select id="shopType" name="shopType" class="form-control form-normal-input">
						<option value="0">商家类型</option>
					</select>
					<select id="shopLevel" name="shopLevel" class="form-control form-normal-input">
						<option value="0">商家级别</option>
					</select>
					<input name="shopDesc" id="shopDesc" value="${shop.shopDesc}" class="form-control form-normal-input" placeholder="商家描述，50字符以内"/>
					<textarea name="shopAddr" id="shopAddr" class="form-control form-normal-input" rows="3" placeholder="商家地址，100字符以内">${shop.shopAddr}</textarea>
					<button class="btn btn-primary btn-right" id="submit">修改</button>
					<button class="btn btn-default btn-right" onclick="history.go(-1)">返回</button>
					<input id="shopId" name="shopId" type="hidden" value="${shop.id}">
				</form>
			</div>
		</div>
		<div class="right-div">
			
		</div>
	</div>
</body>
</html>
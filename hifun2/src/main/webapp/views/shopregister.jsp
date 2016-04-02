<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="../components/jsp/include.jsp" />
<script type="text/javascript" src="../components/js/shopregister.js"></script>
<link rel="stylesheet" type="text/css" href="../components/css/shopregister.css">
<title>shopregister</title>
</head>
<body class="inside-body">
	<input id="base" type="hidden" value="<%=request.getContextPath()%>">
	<div class="middle-div">
		<div class="left">
			<div class="form-div">
				<form action="" id="mainForm" method="post">
					<span class="form-title">商家注册</span>
					<input name="shopName" id="shopName" class="form-control form-normal-input" placeholder="商家名称，20字符以内"/>
					<select id="shopType" name="shopType" class="form-control form-normal-input">
						<option value="0">商家类型</option>
					</select>
					<select id="shopLevel" name="shopLevel" class="form-control form-normal-input">
						<option value="0">商家级别</option>
					</select>
					<input name="shopDesc" id="shopDesc" class="form-control form-normal-input" placeholder="商家描述，50字符以内"/>
					<textarea name="shopAddr" id="shopAddr" class="form-control form-normal-input" rows="3" placeholder="商家地址，100字符以内"></textarea>
					<button class="btn btn-primary btn-right" id="submit">提交</button>
					<button class="btn btn-default btn-right" onclick="history.go(-1)">返回</button>
				</form>
			</div>
		</div>
		<div class="right">
			
		</div>
	</div>
</body>
</html>
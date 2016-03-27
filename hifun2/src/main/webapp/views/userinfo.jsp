<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="../components/jsp/include.jsp" />
<script type="text/javascript" src="../components/js/userinfo.js"></script>
<link rel="stylesheet" type="text/css" href="../components/css/userinfo.css">
<title>用户信息</title>
</head>
<body class="inside-body">
	<input id="base" type="hidden" value="<%=request.getContextPath()%>">
	<div class="body-div">
		<div class="left-div">
			<div class="form-div">
				<span class="form-title">用户信息</span>
				<ul class="normal-ul userinfo-ul">
					<li class="normal-li">
						<label class="text-label">用户名：</label>${user.username}
					</li>
					<li class="normal-li">
						<label class="text-label">昵称：</label>${user.nickname}
					</li>
					<li class="normal-li">
						<label class="text-label">邮箱：</label>${user.email}
					</li>
					<li class="normal-li">
						<label class="text-label">等级：</label>${user.level}
					</li>
					<li class="normal-li">
						<label class="text-label">经验值：</label>${user.exp}
					</li>
				</ul>
				<div class="btn-div">
					<button class="btn btn-default home-link">返回首页</button>
				</div>
			</div>
		</div>
		<div class="right-div">
			
		</div>
	</div>
</body>
</html>
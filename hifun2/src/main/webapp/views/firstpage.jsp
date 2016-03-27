<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="../components/jsp/include.jsp" />
<link rel="stylesheet" type="text/css" href="../components/css/banner.css">
<script type="text/javascript" src="../components/js/firstpage.js"></script>

<title>嗨翻点我</title>
</head>
<body class="inside-body">
	<input id="base" type="hidden" value="<%=request.getContextPath()%>">
	<div class="middle-div">
		<div class="center-div">
			<div class="slide-div" id="slider">
				<ul class="pics">
					<c:forEach items="${bannerlist}" var="b" varStatus="i">
						<li><img src="${b.path}" alt="${b.title}" title="${b.title}" onclick="iframeTo('${b.linkType}', '${b.linkTo}')"/></li>
					</c:forEach>
				</ul>
				<ul id="nav">
					<c:forEach items="${bannerlist}" var="b" varStatus="i">
						<li onmouseover="setTimeout(function(){hifun.slider.pos(${i.index})},1000)"></li>
					</c:forEach>
				</ul>
			</div>
			
			<div class="centerright-div">
				<div class="signin-div">
					<c:if test="${isSign == 0}">
						<button type="button" class="btn btn-primary btn-lg btn-block" onclick="signin(this)">我 要 签 到</button>
					</c:if>
					<c:if test="${isSign == 1}">
						<button type="button" class="btn btn-primary btn-lg btn-block disabled">签 到 成 功</button>
					</c:if>
				</div>
				<div class="info-div">
					<div class="hifunbang-div">
						<div class="hifunbang-title">
							嗨翻榜
						</div>
						<div class="hifunbang-content">
							<div class="hifunbang-left">
								<ul class="normal-ul hifunbang-user">
									<c:forEach items="${toptenlist}" var="t" varStatus="i" begin="0" end="4">
										<li class="hifunbang-user-li">${i.index+1}.
											<a class="normal-a floatnone-a curson-a user-link" onclick="userinfo(this, '${t.username}')">${t.username}</a>
										</li>
									</c:forEach>
								</ul>
							</div>
							<div class="hifunbang-right">
								<ul class="normal-ul hifunbang-user">
									<c:forEach items="${toptenlist}" var="t" varStatus="i" begin="5" end="9">
										<li class="hifunbang-user-li">${i.index+1}.
											<a class="normal-a floatnone-a curson-a user-link" onclick="userinfo(this, '${t.username}')">${t.username}</a>
										</li>
									</c:forEach>
								</ul>
							</div>
						</div>
						<div class="hifunbang-bottom">
							<a href="javascript:void(0);" class="hifunbang-detail" onclick="hifundetail(this)">榜单详情>></a>
						</div>
					</div>
					<div class="transport-url">
						<div class="transport-title">
							本周热链
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="center-bottom-div">
			
		</div>
	</div>
<script type="text/javascript" src="../components/js/banner.js"></script>
<!--代码部分end-->
</body>

</html>
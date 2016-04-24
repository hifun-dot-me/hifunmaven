<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="../components/jsp/include.jsp" />
<script type="text/javascript" src="../components/js/hifunplayground.js"></script>
<link rel="stylesheet" type="text/css" href="../components/css/hifunplayground.css">
<title>嗨翻广场</title>
</head>
<body class="inside-body">
	<input id="base" type="hidden" value="<%=request.getContextPath()%>">
	<div class="middle-div minwid-div">
		<div class="left-div">
			<div class="left-temp-div">
				<div class="left-inside-div">
					<div class="left-inside-top-div">
						<c:if test="${shop != null}">
							<div class="welcome-div">
								<label class="normal-label">欢迎登录，</label>
								<a class="user-link" href="javascript:void(0)" onclick="locationTo(this, '/headpage/shopmodify.do?shopid=${shop.id}')">
									${shop.shopName}
								</a>
							</div>
						</c:if>
						<c:if test="${shop == null}">
							<button type="button" class="btn btn-primary btn-lg btn-block btn-warning" 
							onclick="locationTo(this, '/headpage/shopregister.do')">成 为 嗨 商</button>
						</c:if>
					</div>
					<div class="left-inside-middle-div">
						<ul class="normal-ul hiplayground-menu-ul">
							<li class="normal-li hiplayground-menu-li">
								嗨~吃 美食小吃应有尽有
							</li>
							<li class="normal-li hiplayground-menu-li">
								嗨~穿 好心情从穿着开始
							</li>
							<li class="normal-li hiplayground-menu-li">
								嗨~住 金窝银窝都在这里
							</li>
							<li class="normal-li hiplayground-menu-li">
								嗨~行 你出行，我帮砍价
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="right-div">
			<div class="right-top-div">
				<div class="right-top-tip-div">
					公告：嗨翻广场火热招商中...
				</div>
				<div class="right-top-search-div">
					<div class="search-div">
						<form action="" id="mainForm" method="get">
							<input class="search-input" name="shopName" id="shopName" value="${shopName}" placeholder="搜索嗨商">
							<span class="glyphicon glyphicon-search" id="search-btn"></span>
						</form>
					</div>
				</div>
			</div>
			<div class="right-inside-div">
				<ul class="normal-ul hiplayground-ul">
					<c:forEach items="${shoplist}" var="s">
						<li class="hiplayground-li">
							<div class="hiplayground-div" onmouseover="mouseonblackboard(this)" onclick="locationToNoSession('<%=request.getContextPath()%>/headpage/shop_detail.do?shopid=${s.id}')">
								<img alt="blackboard" title="${s.shopDesc}" src="../components/image/png/blackboard.png" width="100%" height="100%">
								<div class="hiplayground-tip-div" id="hiplayground-tip-div">
									<span class="shop-title">
										${s.shopName}
									</span>
									<p class="text-ellipsis">
										${s.shopDesc}
									</p>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
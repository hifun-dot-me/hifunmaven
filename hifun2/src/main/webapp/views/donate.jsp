<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="../components/jsp/include.jsp" />
<script type="text/javascript" src="../components/js/donate.js"></script>
<link rel="stylesheet" type="text/css" href="../components/css/donate.css">
<script type="text/javascript">
</script>
<title>donate</title>
</head>
<body class="inside-body">
	<input id="base" type="hidden" value="<%=request.getContextPath()%>">
	<div class="body-div">
		<div class="main-div">
			<span class="donate-font">如果你喜欢本站，不妨小额赞助一下</span>
			<div class="donate-total-div">
				<div class="label-div">
					<ul class="normal-ul donate-horizontal">
						<li class="normal-li donate-menu-li donate-curr-li" target="#weixindonate">
							微信打赏
						</li>
						<li class="normal-li donate-menu-li" target="#zhifubaodonate">
							支付宝打赏
						</li>
					</ul>
				</div>
				<div class="donate-info-div" id="weixindonate">
					<div class="donate-info-erweima-div">
						<img alt="赞助6.66" src="../components/image/jpg/weixindonate-6.66.jpg" class="weixin-donate"/>
						<img alt="赞助8.88" src="../components/image/jpg/weixindonate-8.88.jpg" class="weixin-donate hid"/>
						<img alt="赞助16.66" src="../components/image/jpg/weixindonate-16.66.jpg" class="weixin-donate hid"/>
						<img alt="赞助33.33" src="../components/image/jpg/weixindonate-33.33.jpg" class="weixin-donate hid"/>
					</div>
					<div class="donate-info-content-div">
						<div class="donate-normal-content-div">
							请选择不同金额打赏
						</div>
						<ul class="normal-ul">
							<li class="menu-horizontal donate-price-li">
								<div class="price-div price-div-curr">6.66元</div>
							</li>
							<li class="menu-horizontal donate-price-li">
								<div class="price-div">8.88元</div>
							</li>
							<li class="menu-horizontal donate-price-li">
								<div class="price-div">16.66元</div>
							</li>
							<li class="menu-horizontal donate-price-li">
								<div class="price-div">33.33元</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="donate-info-div hid" id="zhifubaodonate">
					这是支付宝打赏
				</div>
			</div>
		</div>
	</div>
</body>
</html>
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
					<img alt="赞助6.66" src="../components/image/jpg/weixindonate-ps.jpg" class="weixin-donate"/>
				</div>
				<div class="donate-info-div hid" id="zhifubaodonate">
					这是支付宝打赏
				</div>
			</div>
		</div>
	</div>
</body>
</html>
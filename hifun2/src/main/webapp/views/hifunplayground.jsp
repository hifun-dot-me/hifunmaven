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
						
					</div>
					<div class="left-inside-middle-div">
						
					</div>
				</div>
			</div>
		</div>
		<div class="right-div">
			<div class="right-inside-div">
				<ul class="normal-ul hiplayground-ul">
					<%-- <c:forEach items="${hiplaygroundlist}" var="h">
						<li class="hithings-li">
							<a class="user-link top-html" href="javascript:void(0)" onclick="btnTest(this)">${h.username}</a>&nbsp;&nbsp;&nbsp;${h.content}<br/><br/>
							<label class="normal-label">${h.updateTime}</label>&nbsp;&nbsp;&nbsp;<label class="normal-label">${h.statusName}</label>
						</li>
					</c:forEach> --%>
					<c:forEach items="${shoplist}" var="s">
						<li class="hiplayground-li">
							<div class="hiplayground-div">
								<img alt="blackboard" title="${s.shopDesc}" src="../components/image/png/blackboard.png" width="100%" height="100%">
								<div class="hiplayground-tip-div">
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
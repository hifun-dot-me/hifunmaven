<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="../components/jsp/include.jsp" />
<script type="text/javascript" src="../components/js/hithings.js"></script>
<link rel="stylesheet" type="text/css" href="../components/css/hithings.css">
<title>嗨百事</title>
</head>
<body class="inside-body">
	<input id="base" type="hidden" value="<%=request.getContextPath()%>">
	<div class="middle-div minwid-div">
		<div class="left-div">
			<div class="left-temp-div">
				<div class="left-inside-div">
					<div class="left-inside-top-div">
						今日给出的赞：<label class="normal-label" id="givezan">${totalzan}</label>
					</div>
					<div class="left-inside-middle-div">
						<button type="button" class="btn btn-primary btn-lg btn-block btn-warning" onclick="locationTo(this, '/headpage/uploadhithings.do')">我 要 上 传</button>
					</div>
				</div>
			</div>
		</div>
		<div class="right-div">
			<div class="right-inside-div">
				<ul class="normal-ul hithings-ul">
					<c:forEach items="${hithingslist}" var="h">
						<li class="hithings-li">
							<a class="normal-a floatnone-a cursor-a user-link text-ellipsis" onclick="userinfo(this, '${h.username}')">${h.nickname}</a>：${h.content}<br/><br/>
							<label class="normal-label">${h.updateTime}</label>&nbsp;&nbsp;&nbsp;
							<c:if test="${h.evaluateTypeId == 1}">
								<a href="javascript:void(0)" onclick="blurutil(this)">
									<img alt="赞" src="../components/image/png/zan.png" width="12px" height="12px">
								</a><label class="curr-choice">${h.zannum}</label>&nbsp;&nbsp;
								<a href="javascript:void(0)" onclick="blurutil(this)">
									<img alt="踩" src="../components/image/png/cai.png" width="12px" height="12px">
								</a><label>${h.cainum}</label>
							</c:if>
							<c:if test="${h.evaluateTypeId == -1}">
								<a href="javascript:void(0)" onclick="blurutil(this)">
									<img alt="赞" src="../components/image/png/zan.png" width="12px" height="12px">
								</a><label>${h.zannum}</label>&nbsp;&nbsp;
								<a href="javascript:void(0)" onclick="blurutil(this)">
									<img alt="踩" src="../components/image/png/cai.png" width="12px" height="12px">
								</a><label class="curr-choice">${h.cainum}</label>
							</c:if>
							<c:if test="${h.evaluateTypeId != -1 && h.evaluateTypeId != 1}">
								<a href="javascript:void(0)" onclick="zan(this, '${h.id}')" class="evaluate">
									<img alt="赞" src="../components/image/png/zan.png" width="12px" height="12px">
								</a><label>${h.zannum}</label>&nbsp;&nbsp;
								<a href="javascript:void(0)" onclick="cai(this, '${h.id}')" class="evaluate">
									<img alt="踩" src="../components/image/png/cai.png" width="12px" height="12px">
								</a><label>${h.cainum}</label>
							</c:if>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
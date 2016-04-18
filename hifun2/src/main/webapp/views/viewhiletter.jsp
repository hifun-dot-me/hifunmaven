<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="../components/jsp/include.jsp" />
<jsp:include page="../components/jsp/ueditor.jsp" />
<script type="text/javascript" src="../components/js/viewhiletter.js"></script>
<link rel="stylesheet" type="text/css" href="../components/css/viewhiletter.css">
<title>嗨信</title>
</head>
<body class="inside-body">
	<input id="base" type="hidden" value="<%=request.getContextPath()%>">
	<div class="body-div">
		<div class="letter-total-div">
			<div class="letter-left-div">
				<ul class="normal-ul letter-ul">
					<c:if test="${empty list}">
						<li class="normal-li letter-li nofriend">
							暂无好友哦
						</li>
					</c:if>
					<c:forEach items="${list}" var="l" varStatus="i">
						<c:if test="${i.index == 0}">
							<li class="normal-li letter-li curr-letter-li">
								${l.nickname}
							</li>
						</c:if>
						<c:if test="${i.index > 0}">
							<li class="normal-li letter-li">
								${l.nickname}
							</li>
						</c:if>
					</c:forEach>
				</ul>
			</div>
			<div class="letter-right-div">
				<div class="letter-content-div">
					
				</div>
				<div class="letter-write-div">
					<script id="letter" name="letterWrite" type="text/plain" style="width:100%;height:0px;"></script>
				</div>
				<div class="letter-btn-div">
					<c:if test="${!empty list}">
						<button class="btn btn-primary btn-send" onclick="sendletter(this)">发 送</button>
					</c:if>
					<button class="btn btn-default btn-send home-link">返回首页</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
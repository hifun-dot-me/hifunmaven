<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="../components/jsp/include.jsp" />
<script type="text/javascript" src="../components/js/hibar.js"></script>
<link rel="stylesheet" type="text/css" href="../components/css/hibar.css">
<script type="text/javascript">
$(document).ready(function(){
	
});
</script>
<title>嗨吧</title>
</head>
<body class="inside-body">
	<input id="base" type="hidden" value="<%=request.getContextPath()%>">
	<div class="middle-div minwid-div">
		<div class="left-div">
			<div class="left-temp-div">
				<div class="left-inside-div">
					<div class="left-inside-top-div">
						<ul class="normal-ul hibar-menu-ul">
							<li class="normal-li hibar-menu-li" onclick="locationToNoSession('<%=request.getContextPath()%>/hibar/firstpage.do')">
								嗨吧首页
							</li>
							<li class="normal-li hibar-menu-li hibar-menu-li-hover" onclick="locationToNoSession('<%=request.getContextPath()%>/hibar/hifunarea.do')">
								嗨翻专区
							</li>
							<li class="normal-li hibar-menu-li" onclick="locationToNoSession('<%=request.getContextPath()%>/hibar/talkarea.do')">
								任意聊
							</li>
							<li class="normal-li hibar-menu-li" onclick="locationToNoSession('<%=request.getContextPath()%>/hibar/fivetalkarea.do')">
								五毛专区
							</li>
						</ul>
					</div>
					<div class="left-inside-middle-div">
						<div class="welcome-div">
							<label class="normal-label">经验值</label>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="right-div">
			嗨翻专区
		</div>
	</div>
</body>
</html>
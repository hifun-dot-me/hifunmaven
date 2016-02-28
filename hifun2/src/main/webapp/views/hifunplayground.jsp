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
						<button type="button" class="btn btn-primary btn-lg btn-block btn-warning" onclick="locationTo(this, '/headpage/uploadhifunplayground.do')">我 要 上 传</button>
					</div>
				</div>
			</div>
		</div>
		<div class="right-div">
			<div class="right-inside-div">
				<ul class="normal-ul hithings-ul">
					<li class="hithings-li">
						<a class="user-link top-html" href="javascript:void(0)" onclick="btnTest(this)">月下</a>&nbsp;&nbsp;&nbsp;基家<br/>
						<img src="../components/image/png/hithings_online20160219.png" width="200px" height="120px"/><br/><br/>
						<label class="normal-label">2016-01-01 13:00:45</label>&nbsp;&nbsp;&nbsp;<label class="normal-label">已审核</label>
					</li>
					<li class="hithings-li">
						<a class="user-link top-html" href="javascript:void(0)" onclick="btnTest(this)">月下</a>&nbsp;&nbsp;&nbsp;美味尽在新白鹿<br/>
						<img src="../components/image/png/hithings_online20160219.png" width="200px" height="120px"/><br/><br/>
						<label class="normal-label">2016-01-04 09:05:15</label>&nbsp;&nbsp;&nbsp;<label class="normal-label">未审核</label>
					</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="../components/jsp/include.jsp" />
<jsp:include page="../components/jsp/ueditor.jsp" />
<script type="text/javascript" src="../components/js/uploadhithings.js"></script>
<link rel="stylesheet" type="text/css" href="../components/css/uploadhithings.css">
<title>uploadthings</title>
</head>
<body class="inside-body">
	<input id="base" type="hidden" value="<%=request.getContextPath()%>">
	<div class="middle-div">
		<div class="form-div">
			<form action="" method="post" id="mainForm">
<!-- 				<textarea class="form-control" rows="16" name="content" id="content"></textarea> -->
				<script id="editor" name="content" type="text/plain" style="width:700px;height:300px;"></script>
				<button class="btn btn-primary btn-right" id="submit">提交</button>
				<button class="btn btn-default btn-right" onclick="history.go(-1)">返回</button>
			</form>
		</div>
	</div>
</body>
</html>
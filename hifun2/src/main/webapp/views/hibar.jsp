<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="../components/jsp/include.jsp" />
<script type="text/javascript" src="../components/js/hibar.js"></script>
<script type="text/javascript" src="../components/scrolljs/scroller.min.js"></script>
<link rel="stylesheet" type="text/css" href="../components/css/hibar.css">
<link rel="stylesheet" type="text/css" href="../components/scrolljs/scroller.css">
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
							<li class="normal-li hibar-menu-li hibar-menu-li-hover" onclick="locationToNoSession('<%=request.getContextPath()%>/hibar/firstpage.do')">
								嗨吧首页
							</li>
							<li class="normal-li hibar-menu-li" onclick="locationToNoSession('<%=request.getContextPath()%>/hibar/hifunarea.do')">
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
			<div class="right-main-div">
				<div class="right-main-left-div">
					<div class="right-main-left-banner-div">
						原创专区 - banner scroll
					</div>
					<div class="right-main-left-note-div">
						精华嗨帖 - banner scroll
					</div>
				</div>
				<div class="right-main-right-div">
					<div id="scroller-pane" class="scroller-main-div"></div>
					<!-- <div id="clock-pane"></div> -->
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			ajaxAsyncPost(url, data, dataType, doSuccess);
			var num = 0;
			var scroller=Scroller.getNewInstance({
				direction:Scroller.DIRECTION.UP,
				interval:3000,
				width:200,
				amount:50,
				separatorType:Scroller.SEPARATOR.THOUSAND,
				separator:" "
			});
			scroller.appendTo(document.getElementById("scroller-pane")).setStyle({backgroundColor:"#97CBFF",color:"red"});
			scroller.start(completeNum(num, 9));
			scroller.scrollTo(completeNum(12388319, 9));
			/* setInterval(function(){
				num += 1;
				scroller.scrollTo(completeNum(num, 9));
			},10000); */
			/* var clockScroller=Scroller.getNewInstance({
				width:200,
				amount:40,
				interval:800,
				separatorType:Scroller.SEPARATOR.TIME,
				separator:":"
			});
			clockScroller.appendTo(document.getElementById("clock-pane"));
			clockScroller.start("000000");
			setInterval(function(){
				var now=new Date();
				var hours=now.getHours();
				var minutes=now.getMinutes();
				var seconds=now.getSeconds();
				hours=(hours<10)?"0"+hours:hours+"";
				minutes=(minutes<10)?"0"+minutes:minutes+"";
				seconds=(seconds<10)?"0"+seconds:seconds+"";
				var timeStr=hours+minutes+seconds;
				clockScroller.scrollTo(hours+minutes+seconds);
			},1000); */
		});
	</script>
</body>
</html>
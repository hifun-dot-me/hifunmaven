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
								<a class="user-link" href="javascript:void(0)" onclick="locationTo(this, '/headpage/shop_modify.do?shopid=${shop.id}')">
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
					<span class="glyphicon glyphicon-remove close-announcement" title="关闭"></span>
					<a class="announcement-font" data-toggle="modal" 
						data-target="#announcementModal">公告：嗨翻广场火热招商中...</a>
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
	<!-- 公告模态框（Modal） -->
	<div class="modal fade" id="announcementModal" tabindex="-1" role="dialog" 
	   aria-labelledby="announcementModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="announcementModalLabel">
		               	公 告
		            </h4>
				</div>
				<div class="modal-body">
					<c:if test="${shop == null}">
						&nbsp;&nbsp;&nbsp;&nbsp;嗨翻广场正在火热招商中，接入请查看
						<a class="user-link cursor-a" onclick="tobeHiShop(this)">成为嗨商</a>
						链接
					</c:if>
					<c:if test="${shop != null}">
						您已接入嗨商，可点此
						<a class="user-link" href="javascript:void(0)" onclick="locationTo(this, '/headpage/shop_modify.do?shopid=${shop.id}')">
							查看详情
						</a>
					</c:if>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
</body>
</html>
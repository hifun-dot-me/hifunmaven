<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="../components/jsp/include.jsp" />
<script type="text/javascript" src="../components/js/index.js"></script>
<script type="text/javascript">
</script>
<title>嗨翻点我</title>
</head>
<body>
	<input id="base" type="hidden" value="<%=request.getContextPath()%>">
	<div class="body-div">
		<div class="head-div">
			<div class="headlogin-div">
				<span class="normal-text">欢迎访问，</span>
				<c:if test="${username == null }">
					<a target="_self" class="normal-a curson-a" 
						data-toggle="modal" data-target="#loginModal"><span>请登录</span></a>
					<span class="li-spacing"></span>
					<a target="_self" class="normal-a curson-a" 
						data-toggle="modal" data-target="#registerModal"><span>免费注册</span></a>
				</c:if>
				<c:if test="${username != null}">
					<a href="javascript:void(0);" onclick="userinfo(this)">${username}</a>
					<a href="javascript:void(0);" onclick="logout(this)">退出</a>
				</c:if>
			</div>
			<div class="hitool-div">
				<ul class="normal-ul hitool-ul">
					<li class="normal-ho-li hitool-li" id="home-li" title="主页">
						<a class="normal-a floatnone-a" href="<%=request.getContextPath()%>">
							<span class="glyphicon glyphicon-home hitool-icon"></span>
						</a>
					</li>
					<li class="normal-ho-li hitool-li" onclick="clickhitoolli(this, '#hitool-letter-div')" 
						onmouseout="mouseouthitoolli(this, '#hitool-letter-div')" id="letter-li" title="嗨信">
						<span class="glyphicon glyphicon-envelope hitool-icon"></span>
					</li>
					<li class="normal-ho-li hitool-li" onclick="clickhitoolli(this, '#hitool-setup-div')" 
						onmouseout="mouseouthitoolli(this, '#hitool-setup-div')" id="setup-li" title="设置">
						<span class="glyphicon glyphicon-cog hitool-icon"></span>
					</li>
				</ul>
			</div>
		</div>
		<div class="hitool-temp-div" id="hitool-letter-div" onmouseout="mouseouthitoolletterdiv('#letter-li', this)">
			<ul class="normal-ul hitooldiv-ul">
				<li class="normal-ve-li hitooldiv-li">
					<a class="normal-a floatnone-a" href="<%=request.getContextPath()%>/headpage/viewhiletter.do">查看嗨信</a>
				</li>
				<li class="normal-ve-li hitooldiv-li">
					嗨友申请
				</li>
			</ul>
		</div>
		<div class="hitool-temp-div" id="hitool-setup-div" onmouseout="mouseouthitoolletterdiv('#setup-li', this)">
			<ul class="normal-ul hitooldiv-ul">
				<li class="normal-ve-li hitooldiv-li">
					<a class="normal-a floatnone-a" href="<%=request.getContextPath()%>/headpage/systemsetup.do">系统设置</a>
				</li>
				<li class="normal-ve-li hitooldiv-li">
					其他设置
				</li>
			</ul>
		</div>
		
		<!-- 登录模态框（Modal） -->
		<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" 
		   aria-labelledby="loginModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="loginModalLabel">
			               	登 录
			            </h4>
					</div>
					<div class="modal-body">
						<form action="" id="mainForm" method="post">
							<div class="form-group">
								<div class="form-group-line">
									<label class="glyphicons-label inline-html form-group-line-label" title="用户名">
										<span class="glyphicon glyphicon-user"></span>
									</label>
					            	<input class="inline-html form-input focus-remove-input" type="text" name="username" id="login-username" placeholder="请输入用户名"><br/>
								</div>
								<div class="form-group-line">
					            	<label class="glyphicons-label inline-html form-group-line-label" title="密码">
										<span class="glyphicon glyphicon-lock"></span>
									</label>
					            	<input class="inline-html form-input focus-remove-input" type="password" name="password" id="login-password" placeholder="请输入密码">
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			            <button type="button" id="loginBtn" class="btn btn-primary">
							确定
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		
		<!-- 注册模态框（Modal） -->
		<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" 
		   aria-labelledby="registerModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="registerModalLabel">
			               	注 册
			            </h4>
					</div>
					<div class="modal-body">
						<form action="" id="mainForm2" method="post">
							<div class="form-group">
								<div class="form-group-line">
									<label class="glyphicons-label inline-html form-group-line-label" title="用户名">
										<span class="glyphicon glyphicon-user"></span>
									</label>
					            	<input class="inline-html form-input focus-remove-input" type="text" name="username" id="register-username" placeholder="请输入用户名，20字符以内"><br/>
								</div>
								<div class="form-group-line">
					            	<label class="glyphicons-label inline-html form-group-line-label" title="密码">
										<span class="glyphicon glyphicon-lock"></span>
									</label>
					            	<input class="inline-html form-input focus-remove-input" type="password" name="password" id="register-password" placeholder="请输入密码，32字符以内">
								</div>
								<div class="form-group-line">
					            	<label class="glyphicons-label inline-html form-group-line-label" title="密码">
										<span class="glyphicon glyphicon-lock"></span>
									</label>
					            	<input class="inline-html form-input focus-remove-input" type="password" name="passwordr" id="register-passwordr" placeholder="请确认密码，32字符以内">
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			            <button type="button" id="registerBtn" class="btn btn-primary">
							注册
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		
		<div class="second-div">
			<a href="<%=request.getContextPath()%>">
				<div class="logo-div"></div>
			</a>
			<div class="menu-div">
				<ul class="menu-ul">
					<c:forEach items="${menulist}" var="m">
						<li class="menu-li menu-horizontal" id="${m.linkTo}" onclick="locationTo(this, '${m.menuPath}')">
							<span class="menu-text menu-link">${m.menuName}</span>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<iframe src="<%=request.getContextPath()%>/headpage/firstpage.do" id="content-frame" class="content-frame"></iframe>
		<div class="bottom-div">
			©2016 嗨翻工作室 联系邮箱:<a class="mail-a" href="javascript:void(0);" onclick="mailto(this)">790634031@qq.com</a><br/>
			<a class="curson-a mail-a" target="_blank" onclick="jumpTo(this, 'http://www.miitbeian.gov.cn/')">浙ICP备15004293号-2</a>
		</div>
	</div>
</body>
</html>

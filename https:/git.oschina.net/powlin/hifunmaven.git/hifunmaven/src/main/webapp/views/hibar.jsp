<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="../components/jsp/include.jsp" />
<script type="text/javascript" src="../components/js/hibar.js"></script>
<script type="text/javascript" src="../components/js/pic_tab.js"></script>
<script type="text/javascript" src="../components/scrolljs/scroller.min.js"></script>
<link rel="stylesheet" type="text/css" href="../components/css/hibar.css">
<link rel="stylesheet" type="text/css" href="../components/scrolljs/scroller.css">
<style type="text/css">
	*{ margin:0; padding:0; list-style:none;}
	img{ border:0;}
	.ban{ width:500px; height:600px; position:relative; overflow:hidden;margin:40px auto 0 auto;}
	.ban2{ width:500px; height:500px; position:relative; overflow:hidden;}
	.ban2 ul{ position:absolute; left:0; top:0;}
	.ban2 ul li{ width:500px; height:500px;}
	.prev{ float:left; cursor:pointer;}
	.num{ height:82px;overflow:hidden; width:430px; position:relative;float:left;}
	.min_pic{ padding-top:10px; width:500px;}
	.num ul{ position:absolute; left:0; top:0;}
	.num ul li{ width:80px; height:80px; margin-right:5px; padding:1px;}
	.num ul li.on{ border:1px solid red; padding:0;}
	.prev_btn1{ width:16px; text-align:center; height:18px; margin-top:40px; margin-right:20px; cursor:pointer; float:left;}
	.next_btn1{  width:16px; text-align:center; height:18px; margin-top:40px;cursor:pointer;float:right;}
	.prev1{ position:absolute; top:220px; left:20px; width:28px; height:51px;z-index:9;cursor:pointer;}
	.next1{ position:absolute; top:220px; right:20px; width:28px; height:51px;z-index:9;cursor:pointer;}
	.mhc{ background:#000; width:100%;opacity:0.5;-moz-opacity:0.5;filter:alpha(Opacity=50); position:absolute; left:0; top:0; display:none;}
	.pop_up{ width:500px; height:500px; padding:10px; background:#fff; position:fixed; -position:absolute; left:50%; top:50%; margin-left:-255px; margin-top:-255px; display:none; z-index:99;}
	.pop_up_xx{ width:40px; height:40px; position:absolute; top:-40px; right:0; cursor:pointer;}
	.pop_up2{ width:500px; height:500px; position:relative; overflow:hidden;}
	.pop_up2{ width:500px; height:500px; position:relative; overflow:hidden; float:left;}
	.pop_up2 ul{ position:absolute; left:0; top:0;}
	.pop_up2 ul li{ width:500px; height:500px; float:left;}
</style>
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
					<div class="right-main-left-banner-div padding-5">
						<div class="ban2" id="ban_pic1" style="display: none;">
							<div class="prev1" id="prev1">
								<img src="../components/image/tab_image/index_tab_l.png" width="28" height="51"  />
							</div>
							<div class="next1" id="next1">
								<img src="../components/image/tab_image/index_tab_r.png" width="28" height="51"  />
							</div>
							<ul>
								<li><a href="javascript:;"><img src="../components/image/tab_image/b1.jpg" width="500" height="500" /></a></li>
								<li><a href="javascript:;"><img src="../components/image/tab_image/b2.jpg" width="500" height="500" /></a></li>
								<li><a href="javascript:;"><img src="../components/image/tab_image/b3.jpg" width="500" height="500" /></a></li>
								<li><a href="javascript:;"><img src="../components/image/tab_image/b4.jpg" width="500" height="500" /></a></li>
								<li><a href="javascript:;"><img src="../components/image/tab_image/b5.jpg" width="500" height="500" /></a></li>
								<li><a href="javascript:;"><img src="../components/image/tab_image/b1.jpg" width="500" height="500" /></a></li>
								<li><a href="javascript:;"><img src="../components/image/tab_image/b2.jpg" width="500" height="500" /></a></li>
								<li><a href="javascript:;"><img src="../components/image/tab_image/b3.jpg" width="500" height="500" /></a></li>
								<li><a href="javascript:;"><img src="../components/image/tab_image/b4.jpg" width="500" height="500" /></a></li>
								<li><a href="javascript:;"><img src="../components/image/tab_image/b5.jpg" width="500" height="500" /></a></li>
							</ul>
						</div>
						<div class="min_pic">
							<div class="prev_btn1" id="prev_btn1"><img src="../components/image/tab_image/feel3.png" width="9" height="18"  /></div>
							<div class="num clearfix" id="ban_num1">
								<ul class="normal-ul">
									<li><a href="javascript:;"><img src="../components/image/tab_image/s1.jpg" width="80" height="80" /></a></li>
									<li><a href="javascript:;"><img src="../components/image/tab_image/s2.jpg" width="80" height="80" /></a></li>
									<li><a href="javascript:;"><img src="../components/image/tab_image/s3.jpg" width="80" height="80" /></a></li>
									<li><a href="javascript:;"><img src="../components/image/tab_image/s4.jpg" width="80" height="80" /></a></li>
									<li><a href="javascript:;"><img src="../components/image/tab_image/s5.jpg" width="80" height="80" /></a></li>
									<li><a href="javascript:;"><img src="../components/image/tab_image/s1.jpg" width="80" height="80" /></a></li>
									<li><a href="javascript:;"><img src="../components/image/tab_image/s2.jpg" width="80" height="80" /></a></li>
									<li><a href="javascript:;"><img src="../components/image/tab_image/s3.jpg" width="80" height="80" /></a></li>
									<li><a href="javascript:;"><img src="../components/image/tab_image/s4.jpg" width="80" height="80" /></a></li>
									<li><a href="javascript:;"><img src="../components/image/tab_image/s5.jpg" width="80" height="80" /></a></li>
								</ul>
							</div>
							<div class="next_btn1" id="next_btn1"><img src="../components/image/tab_image/feel4.png" width="9" height="18"  /></div>
						</div>
					</div>
					<div class="right-main-left-note-div padding-5">
						精华嗨帖 - banner scroll
					</div>
				</div>
				<div class="right-main-right-div padding-5">
					<div id="scroller-pane" class="scroller-main-div" title="嗨吧用户数">
					<!-- <div id="clock-pane"></div> -->
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
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
			//获取hibar总用户数
			ajaxAsyncPost(
					$("#base").val()+'/hibar/querytotalusers.do', 
					{}, 
					'json', function(res){
						num = res.data;
					}
			);
			scroller.scrollTo(completeNum(num, 9));
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
		
		jq(function(){
			jq('#demo1').banqh({
				box:"#demo1",//总框架
				pic:"#ban_pic1",//大图框架
				pnum:"#ban_num1",//小图框架
				prev_btn:"#prev_btn1",//小图左箭头
				next_btn:"#next_btn1",//小图右箭头
				pop_prev:"#prev2",//弹出框左箭头
				pop_next:"#next2",//弹出框右箭头
				prev:"#prev1",//大图左箭头
				next:"#next1",//大图右箭头
				pop_div:"#demo2",//弹出框框架
				pop_pic:"#ban_pic2",//弹出框图片框架
				pop_xx:".pop_up_xx",//关闭弹出框按钮
				mhc:".mhc",//朦灰层
				autoplay:true,//是否自动播放
				interTime:5000,//图片自动切换间隔
				delayTime:400,//切换一张图片时间
				pop_delayTime:400,//弹出框切换一张图片时间
				order:0,//当前显示的图片（从0开始）
				picdire:true,//大图滚动方向（true为水平方向滚动）
				mindire:true,//小图滚动方向（true为水平方向滚动）
				min_picnum:5,//小图显示数量
				pop_up:true//大图是否有弹出框
			})
		})
	</script>
</body>
</html>
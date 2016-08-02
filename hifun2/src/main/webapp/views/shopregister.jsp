<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="../components/jsp/include.jsp" />
<script type="text/javascript" src="../components/js/shopregister.js"></script>
<link rel="stylesheet" type="text/css" href="../components/css/shopregister.css">
<link rel="stylesheet" href="../components/cropper/dist/cropper.css">
<style>
	.container {
    	max-width: 500px;
    	margin: 20px auto;
    }
    .img-container {
    	width: 100%;
    	margin-top: 10px;
    }
    .img-container img {
    	width: 100%;
    }
</style>
<title>shopregister</title>
</head>
<body class="inside-body">
	<input id="base" type="hidden" value="<%=request.getContextPath()%>">
	<div class="middle-div">
		<div class="left-div">
			<div class="form-div">
				<form action="" id="mainForm" method="post">
					<span class="form-title">商家注册</span>
					<input name="shopName" id="shopName" class="form-control form-normal-input" placeholder="商家名称，20字符以内"/>
					<select id="shopType" name="shopType" class="form-control form-normal-input">
						<option value="0">商家类型</option>
					</select>
					<select id="shopLevel" name="shopLevel" class="form-control form-normal-input">
						<option value="0">商家级别</option>
					</select>
					<input name="shopDesc" id="shopDesc" class="form-control form-normal-input" placeholder="商家描述，50字符以内"/>
					<textarea name="shopAddr" id="shopAddr" class="form-control form-normal-input" rows="3" placeholder="商家地址，100字符以内"></textarea>
					<button class="btn btn-primary btn-right" id="submit">提交</button>
					<button class="btn btn-default btn-right" onclick="history.go(-1)">返回</button>
				</form>
			</div>
		</div>
		<div class="right-div">
			<div class="container">
			    <button type="button" class="btn btn-primary" id="replace">Replace Image</button>
			    <div class="img-container">
			    	<img src="../components/cropper/assets/img/picture.jpg" alt="Picture">
				</div>
			</div>
			<script src="../components/cropper/dist/cropper.js"></script>
			<script>
			    $(function () {
			    	var options = {
		    	        aspectRatio: 16 / 9,
		    	        preview: '.img-preview',
		    	        crop: function (e) {
		    	          console.log(Math.round(e.x));
		    	          console.log(Math.round(e.y));
		    	          console.log(Math.round(e.height));
		    	          console.log(Math.round(e.width));
		    	          console.log(e.rotate);
		    	          console.log(e.scaleX);
		    	          console.log(e.scaleY);
		    	        }
		    	      };
			    	var $image = $('.img-container > img');
			    	var croppable = false;
			        $image.cropper({
			          dragMode: 'move',
			          autoCropArea: 0.5,
			          restore: false,
			          guides: false,
			          highlight: false,
			          cropBoxMovable: false,
			          cropBoxResizable: false,
			          aspectRatio: 1,
			          viewMode: 1,
			          built: function () {
			            croppable = true;
			          }
			        });
			
			      $('#replace').on('click', function () {
			        $image.cropper('replace', '../components/cropper/assets/img/picture-2.jpg');
			      });
			      
			      // Cropper
			      $image.on({
			        'build.cropper': function (e) {
			          console.log(e.type);
			        },
			        'built.cropper': function (e) {
			          console.log(e.type);
			        },
			        'cropstart.cropper': function (e) {
			          console.log(e.type, e.action);
			        },
			        'cropmove.cropper': function (e) {
			          console.log(e.type, e.action);
			        },
			        'cropend.cropper': function (e) {
			          console.log(e.type, e.action);
			        },
			        'crop.cropper': function (e) {
			          console.log(e.type, e.x, e.y, e.width, e.height, e.rotate, e.scaleX, e.scaleY);
			        },
			        'zoom.cropper': function (e) {
			          console.log(e.type, e.ratio);
			        }
			      }).cropper(options);
			    });
		  </script>
		</div>
	</div>
</body>
</html>
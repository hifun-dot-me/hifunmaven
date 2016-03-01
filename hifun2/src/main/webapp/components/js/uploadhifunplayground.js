var second = 2, //跳转时间间隔
	content = '';
$(document).ready(function(){
	$("#submit").click(function(){
		$(this).blur();
		if(!checkForm()){
			return false;
		}
		$.ajax({
			url:$("#base").val()+'/headpage/submithifunplayground.do',
			data:$("#mainForm").serialize(),
			type:'post',
			dataType:'json',
			success:function(res){
				if(res.data == 1){
					window.wxc.xcConfirm('上传成功，请等待审核，'+second+'秒后自动跳转', window.wxc.xcConfirm.typeEnum.success);
					setTimeout(function(){
						location.href=$("#base").val()+"/headpage/hifunplayground.do";
					}, second*1000);
				}else if(res.data == 0){
					window.wxc.xcConfirm('请先登录后再上传', window.wxc.xcConfirm.typeEnum.info);
				}else if(res.data == -1){
					window.wxc.xcConfirm('上传频率太快了，休息一下吧', window.wxc.xcConfirm.typeEnum.info);
				}else{
					window.wxc.xcConfirm('上传的小伙伴太多了，请稍后再试', window.wxc.xcConfirm.typeEnum.info);
				}
			},
			error:function(res){
				window.wxc.xcConfirm('系统访问出错，请联系管理员！', window.wxc.xcConfirm.typeEnum.error);
			}
		});
		return false;
	});
});

UE.getEditor('editor').ready(function() {
    //this是当前创建的编辑器实例
	content = this.getContent();
});

function checkForm(){
	if(content == '' || content.length > 300){
		window.wxc.xcConfirm('内容长度不合法', window.wxc.xcConfirm.typeEnum.info);
		return false;
	}
	return true;
}
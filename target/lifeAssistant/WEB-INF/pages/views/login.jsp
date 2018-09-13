<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>登录</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="icon" href="${ctxStatic}/favicon.ico">
	<link rel="stylesheet" href="${ctxStatic}/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${ctxStatic}/css/public.css" media="all" />
	<link id="layuicss-layer" rel="stylesheet" href="http://layuicms.com/v2/layui/css/modules/layer/default/layer.css?v=3.1.1" media="all">

	<script type="text/javascript" src="${ctxStatic}/layui/layui.js"></script>
</head>

<script type="text/javascript">

	<!--登陆之后后台返回的提示信息-->
	var message = '${message}';
	if(message !== ''){
		alert('${message}');
	}

</script>

<body class="loginBody">
	<form class="layui-form" action="${ctx}/manage/login" method="post">
		<div class="login_face"><img src="${ctxStatic}/images/headImg.png" class="userAvatar"></div>
		<div class="layui-form-item input-item">
			<label for="userName">用户名</label>
			<input type="text" placeholder="请输入用户名" autocomplete="off" id="userName" name="userName" class="layui-input" lay-verify="required">
		</div>
		<div class="layui-form-item input-item">
			<label for="password">密码</label>
			<input type="password" placeholder="请输入密码" autocomplete="off" id="passWord" name="passWord" class="layui-input" lay-verify="required">
		</div>
		<div class="layui-form-item">
			<button class="layui-btn layui-block" lay-filter="login" lay-submit>登录</button>
		</div>
	</form>

	<script type="text/javascript">
		layui.use(['form','layer','jquery'],function(){
			var form = layui.form,
					layer = parent.layer === undefined ? layui.layer : top.layer,
			$ = layui.jquery;

			$(".loginBody .seraph").click(function(){
				layer.msg("这只是做个样式，至于功能，你见过哪个后台能这样登录的？还是老老实实的找管理员去注册吧",{
					time:5000
				});
			})

			//登录按钮
			/*form.on("submit(login)",function(data){
				var userName = $("#userName").val();
				var passWord = $("#passWord").val();
				$.ajax({
					url:baseurl+'/login',
					type:'post',
					dataType:'json',
					data:{userName:userName,passWord:passWord},
					success:function(data){
						if(data=="error"){
							layer.alert(data.error);
						}else{
							$(this).text("登录中...").attr("disabled","disabled").addClass("layui-disabled");
							setTimeout(function(){
								window.location.href='index';
							},1000);
							return false;
						}
					}
				})
			})*/

			//表单输入效果
			$(".loginBody .input-item").click(function(e){
				e.stopPropagation();
				$(this).addClass("layui-input-focus").find(".layui-input").focus();
			})
			$(".loginBody .layui-form-item .layui-input").focus(function(){
				$(this).parent().addClass("layui-input-focus");
			})
			$(".loginBody .layui-form-item .layui-input").blur(function(){
				$(this).parent().removeClass("layui-input-focus");
				if($(this).val() != ''){
					$(this).parent().addClass("layui-input-active");
				}else{
					$(this).parent().removeClass("layui-input-active");
				}
			})
		})
	</script>
</body>
</html>
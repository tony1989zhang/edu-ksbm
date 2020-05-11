<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>首页</title>
<script src="${pageContext.request.contextPath}/easyui/jquery.min.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript" charset="utf-8"></script>
<!--默认样式-->
<!-- <link rel="stylesheet" href="easyui/themes/gray/easyui.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/superBlue.css" id="themeCss">
<script src="js/super.js" type="text/javascript" charset="utf-8"></script> -->
<!--其他样式-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/super/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/super/superBlue.css"
	id="themeCss" />

<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/easyui/themes/super/super.js"></script>
<script src="${pageContext.request.contextPath}/js/superDemo.js"
	type="text/javascript" charset="utf-8"></script>

<!-- 暂时不用 -->
<!-- <link rel="stylesheet" type="text/css" href="css/taotao.css" /> -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/datagrid-export.js"></script>
</head>
<body id="main" class="easyui-layout">
<div data-options="region:'north',split:true,border:false," class="super-north" >
<!--顶部-->
		<div class="super-navigation" >
			<!--系统名称-->
			<div class="super-navigation-title" style = "width: 500px">2020年农林类、畜牧类技能测试报名系统</div>
			<!--自定义导航-->
			<div class="super-navigation-main" >
				<div class="super-setting-left" >
					<!-- 	<ul>
						<li><i class="fa fa-commenting-o"></i>消息</li>
						<li><i class="fa fa-envelope-o"></i>邮件</li>
						<li><i class="fa fa-bell-o"></i>通知</li>
					</ul> -->
				</div>
				<div class="super-setting-right">
					<ul>
						<li>
							<div class="super-setting-icon">
								<i class="fa fa-gears"></i>
							</div>
							<div id="mm" class="easyui-menu">
								<!-- 	<div>个人中心</div> -->
								<div id="themeSetting">主题</div>
								<div class="menu-sep"></div>
								<div id="logout">退出</div>
							</div>
						</li>
						<li class="user"><span class="user-icon">
						<img src="img/favicon.png"  hidden="hidden"/></span>安博科技</li>
					</ul>
				</div>
			</div>
		</div>
</div>
     
    
    <div data-options="region:'west',title:'West',split:true" style="width:100px;">
    <!--左侧导航-->
		<div class="easyui-accordion"
			data-options="border:false,fit:true,selected:true">
			<div title="学生管理" data-options="iconCls:'fa fa-table'">
				<ul>
					<li class="student-list"
						data-url='${pageContext.request.contextPath}/student-list'>考生列表</li>
					<li class="student-add"
						data-url='${pageContext.request.contextPath}/student-add'>新增考生</li>
				</ul>
			</div>
		</div>
    </div>
    
	
	<div data-options="region:'west',title:'菜單',border:false"
		class="super-west">
		
	</div>
	<div data-options="region:'center'" style="padding-top: 2px;">
		<!--主要内容-->
		<div id="tt" class="easyui-tabs" data-options="border:false,fit:true">
			<div title="首页" data-options="iconCls:'fa fa-home'">
				<div style="padding: 20px;">学生考试系统</div>
			</div>
		</div>
	</div>
	<div data-options="region:'south'" class="super-south">
		<!--页脚-->
		<div class="super-footer-info">
			<span><i class="fa fa-info-circle"></i> 作者：安博科技</span> <span><i
				class="fa fa-copyright"></i> CopyRight 2020 版权所有 <i
				class="fa fa-caret-right"></i></span>
		</div>
	</div>

	<!--主题设置弹窗-->
	<div id="win">
		<div class="themeItem">
			<ul>
				<li>
					<div class="superGreen" style="background: #1abc9c;">green</div>
				</li>
				<li class="themeActive">
					<div class="superBlue" style="background: #3498db;">blue</div>
				</li>
				<li>
					<div class="superGray" style="background: #95a5a6;">gray</div>
				</li>
				<li>
					<div class="superAmethyst" style="background: #9b59b6;">amethyst</div>
				</li>
				<li>
					<div class="superBlack" style="background: #34495e;">black</div>
				</li>
				<li>
					<div class="superYellow" style="background: #e67e22;">yellow</div>
				</li>
				<li>
					<div class="superEmerald" style="background: #2ecc71;">emerald</div>
				</li>
				<li>
					<div class="superRed" style="background: #e74c3c;">red</div>
				</li>
			</ul>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){ 
		//执行
			console.log("student..");
			$(".student-list").click();
		});
		
	</script>
</body>
</html>
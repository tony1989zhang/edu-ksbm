<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/easyui/jquery.min.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript" charset="utf-8"></script>
<!--其他样式-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/super/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/super/superRed.css"
	id="themeCss" />

<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/easyui/themes/super/super.js"></script>
<script src="${pageContext.request.contextPath}/js/superDemo.js"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common.js"></script>
<title>导出Excel</title>
</head>
<body style="background-color: #F3F3F3">
	<h1>点击导出Excel</h1>
	<a id="excelOut"  href="javascript:void(0)" class="easyui-linkbutton primary">导出Excel</a>
	<script type="text/javascript">
		$("#excelOut")
				.on(
						'click',
						function() {

							$
									.post(
											"${pageContext.request.contextPath}/student/excepOut",
											function(result) {
												if (result.status == 200) {
													$.messager
															.show({
																height : 42,
																timeout : 1500,
																showSpeed : 200,
																msg : '<a href="http://signup.51xgf.cn:81/0_uploadfiles/ksb.xls">&nbsp; 点击保存到本地</a>',
																style : {
																	left : '',
																	right : 20,
																	top : document.body.scrollTop
																			+ document.documentElement.scrollTop
																			+ 20,
																	'z-index' : 999,
																	'box-shadow' : '0 1px 6px rgba(0,0,0,.2)'
																}
															});
												} else {
													console.log("测试:" + result);
													$.messager
															.alert("提示",
																	"下载失败");
												}
											})
						});
	</script>
</body>
</html>
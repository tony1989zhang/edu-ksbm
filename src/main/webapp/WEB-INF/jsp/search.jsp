<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>搜索一下</title>
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
<script type="text/javascript">
	function qq(value, name) {
		alert(value + ":" + name)
	}
</script>

</head>
<body>
	<h2>Basic SearchBox</h2>
	<p>Click search button or press enter key in input box to do
		searching.</p>
	<div style="margin: 20px 0;"></div>
	<input class="easyui-searchbox"
		data-options="prompt:'Please Input Value',searcher:doSearch"
		style="width: 300px"></input>
	<script>
		function doSearch(value) {
			alert('You input: ' + value);
		}
	</script>
</body>
</html>
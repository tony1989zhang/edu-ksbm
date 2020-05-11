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
	<hr>
	<form id="ff" method="get">
		<h3>
			保存的路径为:<font color="red"><input id="path" type="text" name="path"
				value="D:\\ksb.xls"></font>
		</h3>
		<input type="submit" class="easyui-linkbutton success" value="下载">
	</form>
	<script type="text/javascript">
	$('#ff').form({
	    url: '${pageContext.request.contextPath}/student/excepOut',
	    onSubmit: function(){
	    },
	    success:function(data){
	    	console.log('ceshi:' + data);
	    	var json =eval("("+data+")");
	    	if(json.status==200){
	    		alert("导出成功,文件路径为:" + $("#path").val());
	    		$("#studentOutWindow").window('close');
	    	}
			
	    }
	});
	</script>
</body>
</html>
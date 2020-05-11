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
		<input id="path" type="text" name="path" value="D:\\ksb.xls" size="30">
		<input type=button value="选择" class="easyui-linkbutton success" 
					onclick="browseFolder('path')">
		<input type="submit" class="easyui-linkbutton success" value="下载">
	</form>
	<script type="text/javascript">
		$('#ff').form({
			url : '${pageContext.request.contextPath}/student/excepOut',
			onSubmit : function() {
				// do some check
				// return false to prevent submit;
			},
			success : function(data) {
				console.log('ceshi:' + data);
				var json = eval("(" + data + ")");
				if (json.status == 200) {
					alert("导出成功,文件路径为:" + $("#path").val());
					$("#studentOutWindow").window('close');
				}

			}
		});
		
		function browseFolder(path) {
		    try {
		        var Message = "选择保存文件路径"; //选择框提示信息
		        if(window.ActiveXObject){
		        var Shell = new ActiveXObject("Shell.Application");
		     /*    var Shell = new ActiveXObject("Shell.Application"); */
		        var Folder = Shell.BrowseForFolder(0, Message, 64, 17); //起始目录为：我的电脑
		        //var Folder = Shell.BrowseForFolder(0, Message, 0); //起始目录为：桌面
		        if (Folder != null) {
		            Folder = Folder.items(); // 返回 FolderItems 对象
		            Folder = Folder.item(); // 返回 Folderitem 对象
		            Folder = Folder.Path; // 返回路径
		            if (Folder.charAt(Folder.length - 1) != "\\") {
		                Folder = Folder + "\\";
		            }
		            document.getElementById(path).value = Folder;
		            return Folder;
		        }
		       }
		    }
		    catch (e) {
		        alert(e.message);
		    }
		}
	</script>
</body>
</html>
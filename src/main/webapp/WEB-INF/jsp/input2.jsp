<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="easyui/jquery.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="easyui/jquery.easyui.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"
	charset="utf-8"></script>
<!--默认样式-->
<!-- <link rel="stylesheet" href="easyui/themes/gray/easyui.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/superBlue.css" id="themeCss">
<script src="js/super.js" type="text/javascript" charset="utf-8"></script> -->
<!--其他样式-->
<link rel="stylesheet" type="text/css"
	href="easyui/themes/super/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="easyui/themes/super/superRed.css" id="themeCss" />
<script type="text/javascript" charset="utf-8"
	src="easyui/themes/super/super.js"></script>
<script src="js/superDemo.js" type="text/javascript" charset="utf-8"></script>

<!-- 暂时不用 -->
<!-- <link rel="stylesheet" type="text/css" href="css/taotao.css" /> -->
<script type="text/javascript" src="js/common.js"></script>
</head>
<body>
	<div align="left">
	<div>
	<h3>*Excel格式包含:<font color="red">'考生姓名','考试号'</font>,如图所示:</h3>
<!-- 	<h3><font color="red">*Excel格式'考生姓名','考试号','身份证号','系别(00-农林类  01-畜牧类)','考场编号','座位号','考试日期','考试时间','头像','健康码'</font></h3> -->
	<img src="http://signup.51xgf.cn:81/0_uploadfiles/excel.jpg">
	</div>
		<h3>选择文件： </h3>

	<form id="questionTypesManage" method="post" enctype="multipart/form-data">
	<input id="uploadExcel" name="uploadExcel" class="easyui-filebox" style="width: 200px"
			data-options="prompt:'请选择文件...'"> 
			<div align="right" style="margin-top: 10px;margin-right: 15px" >
			<a href="#" class="easyui-linkbutton success" onclick="uploadExcel()">导入考生数据</a>
			</div>
	</form>
	</div>
	<script type="text/javascript">
		function uploadExcel() {
			//得到上传文件的全路径
			var fileName = $('#uploadExcel').filebox('getValue');
			console.log(fileName);
			//进行基本校验
			if (fileName == "") {
				$.messager.alert('提示', '请选择上传文件！', 'info');
			} else {
				//对文件格式进行校验
				var d1 = /\.[^\.]+$/.exec(fileName);
				if (d1 == ".xls" || d1 == ".xlsx") {
					//提交表单
					$('#questionTypesManage').form({
					    url:'${pageContext.request.contextPath}/student/excepImport',
					    onSubmit: function(){
					    },
					    success:function(data){
							var data = eval('(' + data + ')'); 
							if(data.status == 200){
								$.messager.alert('操作成功', '恭喜导入成功', 'warning', function() {
									$("#studentImportWindow").window('close');
									$("#dgStudent").datagrid("reload");
								});
							}
					    }
					});
					$('#questionTypesManage').submit();
					
				} else {
					$.messager.alert('提示', '请选择xls或xlsx格式文件！', 'info');
					$('#uploadExcel').filebox('setValue', '');
				}
			}
		}
	</script>
</body>
</html>
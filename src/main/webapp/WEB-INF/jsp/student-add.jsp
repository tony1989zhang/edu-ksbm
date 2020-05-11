<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/js/kindeditor-4.1.10/themes/default/default.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<style type="text/css">
.form-item {
	margin-bottom: 15px;
	width: 100%;
	float: left;
}

.form-item>label {
	min-width: 72px;
	display: inline-block;
}

.form-item input, select {
	width: 170px;
}
</style>
<div class="super-theme-example">
	<form id="ffStudentAdd" method="post">
		
		<div class="form-item">
			<label for="" class="label-top">考生姓名：</label> <input
				class="easyui-textbox" type="text" name="stuname"
				data-options="required:true,prompt:'请输入考生姓名'" style="width: 280px;"></input>
		</div>
		<div class="form-item">
			<label for="" class="label-top">考试号：</label> <input
				class="easyui-textbox" type="text" name="examcode"
				data-options="required:true,prompt:'请输入考试号'" style="width: 280px;"></input>
		</div>
		<div class="form-item">
			<a href="javascript:void(0)" class="easyui-linkbutton warning"
				onclick="clearForm()">取消</a> <a href="javascript:void(0)"
				class="easyui-linkbutton success" onclick="submitForm()">提交</a>
		</div>
	</form>
</div>
<script type="text/javascript">
	
	//提交表单
	function submitForm(){
		//有效性验证
		if(!$('#ffStudentAdd').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//ajax的post方式提交表单
		//$("#itemAddForm").serialize()将表单序列号为key-value形式的字符串
		alert($("#ffStudentAdd").serialize());
		$.post("${pageContext.request.contextPath}/student/save",$("#ffStudentAdd").serialize(), function(data){
			if(data.status == 200){
				$("#dgStudent").datagrid("reload");
				$.messager.alert('操作成功', '添加考生成功', 'warning', function() {
					$('.student-list').click();
				});
			}
		});
	}
	
	function clearForm(){
		$('#ffStudentAdd').form('reset');
		itemAddEditor.html('');
	}
</script>

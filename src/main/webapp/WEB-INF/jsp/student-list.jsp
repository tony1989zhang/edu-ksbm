<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="super-theme-example">
	<div style="height: 425px;">
		<table id="dgStudent"></table>
		<div id="studentImportWindow" class="easyui-window" title="导入Excel" data-options="modal:true,closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath}/input'"
		 style="width: 30%; height: 80%; padding: 10px;"></div>
		<div id="studentOutWindow" class="easyui-window" title="导出Excel" data-options="modal:true,closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath}/down'"
		 style="width: 30%; height: 40%; padding: 10px;"></div>
		<div id="showImgWindow" class="easyui-window" title="查看图片" data-options="modal:true,closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath}/showImg'"
		 style="width: 35%; height: 50%; padding: 10px;"></div>
	</div>
	<div id="tb" style="padding: 3px">
	<!-- 	<div align="left" style="float: left;padding: 5px"> -->
			<a href="#" class="easyui-linkbutton" onclick="addStudent()" data-options="iconCls:'fa fa-plus',plain:true">添加</a>
			<a href="#" class="easyui-linkbutton" onclick="delStudent()" data-options="iconCls:'fa fa-remove',plain:true">删除</a>
			<a href="#" class="easyui-linkbutton" onclick="importExcel()" data-options="iconCls:'fa fa-file-word-o',plain:true">导入Excel</a>
			<a href="#" class="easyui-linkbutton" onclick="outExcel()" data-options="iconCls:'fa fa-file-word-o',plain:true">导出Excel</a>
			<span style="margin-left: 15px; color: black; font-weight: bold; size: 24px">筛选:</span>
			<select id="findStudent"  class="easyui-combobox" data-options="editable:false,panelHeight:null" style="line-height: 26px; border: 1px solid #ccc; width: 100px">
				<option value="all" selected="selected">全部考生</option>
				<option value="wbm">未报名考生</option>
				<option value="ybm">已报名考生</option>
			</select>
	<!-- 	</div> -->
	 	<div align="right" style="float: right;"> 
			<span style="margin-left: 15px; color: black; font-weight: bold; size: 24px">搜索项:</span>
			<select id="searchType" class="easyui-combobox" data-options="editable:false,panelHeight:null" name="searchType"
			 style="line-height: 26px; border: 1px solid #ccc">
				<option value="stuname">考生名</option>
				<option value="examcode">考试号</option>
			</select> <input id="searchWord" placeholder="请输入考生名或考试号" style="line-height: 26px; border: 1px solid #ccc;width: 100px"> <a href="#"
			 class="easyui-linkbutton primary" plain="true" onclick="doSearch()">搜索</a>
		</div>


		<!-- 		<a href="#" class="easyui-linkbutton" onclick="allStudent()"
			data-options="iconCls:'fa fa-comments',plain:true">全部</a> <a
			href="#" class="easyui-linkbutton" onclick="findStudentwbm()"
			data-options="iconCls:'fa fa-comments',plain:true">未报名</a> <a
			href="#" class="easyui-linkbutton" onclick="findStudentybm()"
			data-options="iconCls:'fa fa-comments',plain:true">已报名</a> -->
	</div>
</div>

<script type="text/javascript">
	$("#findStudent").combobox({onChange:function() {
		var opt = $(this).find('option:selected').val();
		console.log("=============" + opt);
		if (opt == 'wbm') {
			fStudent({
				deparment: 'wbm'
			});
		} else if (opt == 'ybm') {
			fStudent({
				deparment: 'ybm'
			});
		} else {
			fStudent({});
		}
	}});

	function fStudent(obj) {
		$('#dgStudent').datagrid('load', obj);
	}
	/*	
	function allStudent() {
	$('#dgStudent').datagrid('load', {});
	}
	function findStudentwbm() {
	$('#dgStudent').datagrid('load', {
		deparment : 'wbm',
	});
	}
	function findStudentybm() {
	$('#dgStudent').datagrid('load', {
		deparment : 'ybm',
	});
	} */

	function doSearch() {
		console.log("搜索项:" + $("#searchType").val() + "搜索框:" +
			$("#searchWord").val().toString());
		//搜索完,从新加载dataGrid
		if ($("#searchType").val() == 'stuname') {
			$('#dgStudent').datagrid('load', {
				stuname: $("#searchWord").val().toString(),
			});
		} else if ($("#searchType").val() == 'examcode') {
			$('#dgStudent').datagrid('load', {
				examcode: $("#searchWord").val().toString(),
			});
		} else {
			$('#dgStudent').datagrid('load', {
				deparment: $("#searchWord").val().toString(),
			});
		}
		$("#searchWord").val("");
	}

	function addStudent() {
		$(".student-add").click();
	}

	function importExcel() {
		$("#studentImportWindow").window({
			onLoad: function() {}
		}).window("open");
	}

	function outExcel() {
		$("#studentOutWindow").window({
			onLoad: function() {}
		}).window("open");
	}

	function delStudent() {
		var ids = getSelectionsIds();
		if (ids.length == 0) {
			$.messager.alert('提示', '必须选择一个考生才能删除!');
			return;
		}
		if (ids.indexOf(',') > 0) {
			$.messager.alert('提示', '只能选择一个考生!');
			return;
		}
		$.messager.confirm('确认', '确定清除ID为 ' + ids + ' 的考生吗？', function(r) {
			if (r) {
				var params = {
					"ids": ids
				};
				$.post("${pageContext.request.contextPath}/student/delete",
					params,
					function(data) {
						if (data.status == 200) {
							$.messager.alert('提示', '删除考生信息成功!', undefined,
								function() {
									$("#dgStudent").datagrid("reload");
								});
						}
					});
			}
		});
	}

	function getSelectionsIds() {
		var dgList = $("#dgStudent");
		var sels = dgList.datagrid("getSelections");
		var ids = [];
		for (var i in sels) {
			ids.push(sels[i].id);
		}
		ids = ids.join(",");
		return ids;
	}

	$('#dgStudent').datagrid({
		url: '${pageContext.request.contextPath}/student/list',
		fit: true,
		pagination: true,
		fitColumns: true,
		singleSelect: true,
		remoteSort: false,
		sortName: 'deparment',
		toolbar: '#tb',
		height: 400,
		columns: [
			[{
				field: 'id',
				title: 'id号',
				width: 100,
				sortable: true,
				align: 'center'
			}, {
				field: 'stuname',
				title: '考生姓名',
				width: 200,
				sortable: false,
				align: 'center'
			}, {
				field: 'examcode',
				title: '考试号',
				width: 200,
				sortable: true,
				align: 'center'
			}, {
				field: 'idcard',
				title: '身份证号',
				width: 200,
				sortable: true,
				align: 'center',
			}, {
				field: 'mobile',
				title: '手机号',
				width: 200,
				sortable: true,
				align: 'center'
			}, {
				field: 'deparment',
				title: '系别',
				width: 200,
				sortable: true,
				align: 'center',
				formatter: TT.formatDeparment
			}, {
				field: 'number',
				title: '考场编号',
				width: 200,
				sortable: true,
				align: 'center'
			}, {
				field: 'seatnumber',
				title: '座位号',
				width: 200,
				sortable: true,
				align: 'center'
			}, {
				field: 'headurl',
				title: '头像',
				width: 200,
				sortable: false,
				align: 'center',
				formatter: TT.formatImg
			}, {
				field: 'healthurl',
				title: '健康码',
				width: 200,
				sortable: false,
				align: 'center',
				formatter: TT.formatImg
			}, {
				field: 'examdate',
				title: '考试日期',
				width: 200,
				sortable: true,
				align: 'center'
			}, {
				field: 'examtime',
				title: '考试时间',
				width: 200,
				sortable: true,
				align: 'center'
			}]
		]
	});
</script>

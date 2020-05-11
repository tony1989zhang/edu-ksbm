<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="super-theme-example">
	<div style="height: 425px;">
		<table id="dgStudent"></table>
		<div id="studentImportWindow" class="easyui-window" title="导入Excel"
			data-options="modal:true,closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath}/input'"
			style="width: 30%; height: 80%; padding: 10px;"></div>
	</div>
	<div id="tb" style="padding: 3px">
		<span>Item ID:</span> <input id="itemid"
			style="line-height: 26px; border: 1px solid #ccc"> <span>Product
			ID:</span> <input id="productid"
			style="line-height: 26px; border: 1px solid #ccc"> <a
			href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">Search</a>
	</div>
</div>

<script type="text/javascript">
	function qq(value, name) {
		alert(value + ":" + name)
	}
	function getSelectionsIds() {
		var dgList = $("#dgStudent");
		var sels = dgList.datagrid("getSelections");
		var ids = [];
		for ( var i in sels) {
			ids.push(sels[i].id);
		}
		ids = ids.join(",");
		return ids;
	}

	$('#dgStudent')
			.datagrid(
					{
						url : '${pageContext.request.contextPath}/student/list',
						fit : true,
						pagination : true,
						fitColumns : true,
						singleSelect : true,
						remoteSort : false,
						sortName : 'deparment',
						toolbar : [
								{
									text : '添加',
									iconCls : 'fa fa-plus',
									handler : function() {
										$(".student-add").click();
									}
								},
								{
									text : '删除',
									iconCls : 'fa fa-remove',
									handler : function() {
										var ids = getSelectionsIds();
										if (ids.length == 0) {
											$.messager.alert('提示',
													'必须选择一个考生才能删除!');
											return;
										}
										if (ids.indexOf(',') > 0) {
											$.messager.alert('提示', '只能选择一个考生!');
											return;
										}
										$.messager
												.confirm(
														'确认',
														'确定清除ID为 ' + ids
																+ ' 的考生吗？',
														function(r) {
															if (r) {
																var params = {
																	"ids" : ids
																};
																$
																		.post(
																				"${pageContext.request.contextPath}/student/delete",
																				params,
																				function(
																						data) {
																					if (data.status == 200) {
																						$.messager
																								.alert(
																										'提示',
																										'删除考生信息成功!',
																										undefined,
																										function() {
																											$(
																													"#dgStudent")
																													.datagrid(
																															"reload");
																										});
																					}
																				});
															}
														});
									}
								},
								{
									text : '导入Excel',
									iconCls : 'fa fa-file-word-o',
									handler : function() {
										$("#studentImportWindow").window({
											onLoad : function() {
											}
										}).window("open");
										///
									}
								},
								{
									text : '导出Excel',
									iconCls : 'fa fa-file-word-o',
									handler : function() {
										$('#dgStudent').datagrid('toExcel',
												'考生表.xls'); // export to excel
									}
								}],

						height : 400,
						columns : [ [ {
							field : 'id',
							title : 'id号',
							width : 100,
							sortable : true,
							align : 'center'
						}, {
							field : 'stuname',
							title : '考生姓名',
							width : 200,
							sortable : false,
							align : 'center'
						}, {
							field : 'examcode',
							title : '考试号',
							width : 200,
							sortable : true,
							align : 'center'
						}, {
							field : 'idcard',
							title : '身份证号',
							width : 200,
							sortable : true,
							align : 'center',
						}, {
							field : 'mobile',
							title : '手机号',
							width : 200,
							sortable : true,
							align : 'center'
						}, {
							field : 'deparment',
							title : '系别',
							width : 200,
							sortable : true,
							align : 'center',
							formatter : TT.formatDeparment
						}, {
							field : 'number',
							title : '考场编号',
							width : 200,
							sortable : true,
							align : 'center'
						}, {
							field : 'seatnumber',
							title : '座位号',
							width : 200,
							sortable : true,
							align : 'center'
						}, {
							field : 'headurl',
							title : '头像',
							width : 200,
							sortable : false,
							align : 'center',
							formatter : TT.formatImg
						}, {
							field : 'healthurl',
							title : '健康码',
							width : 200,
							sortable : false,
							align : 'center',
							formatter : TT.formatImg
						}, {
							field : 'examdate',
							title : '考试日期',
							width : 200,
							sortable : true,
							align : 'center'
						}, {
							field : 'examtime',
							title : '考试时间',
							width : 200,
							sortable : true,
							align : 'center'
						}

						] ]
					});
</script>
/**
 * 通用js脚本
 */
/**
 * 重置查询条件
 */
function resetCondition(){
	$("div.conditionForm :text").val("");
	$("select").each(function(){
		this.selectedIndex = 0;
	})
}

/**
 * 批量删除
 * @param idField 标识属性，如果没有传递，默认是id
 */
function batchDelete(url,idField){
	if(!idField){
		idField = "id";
	}
	var rows = $table.bootstrapTable('getSelections');
	if(rows.length == 0){
		return;
	}
	swal({
		title : "确定要删除选中的数据吗?",
		text : "一旦删除数据将不能再恢复!",
		type : "warning",
		showCancelButton : true,
		cancelButtonText : "取消",
		confirmButtonText : "确定"
	}, function() {
		var postData = {};
		$.each(rows,function(i){
			postData["ids["+i+"]"] = this[idField];
		})
		$.post(url,postData,function(){
			$table.bootstrapTable("refresh");
		});
	});
}

/**
 * 删除单条数据
 * @param url 删除数据的服务端地址
 * @param id 要删除的数据编号
 */
function deleteRecord(url, id) {
	swal({
		title : "确定要删除吗?",
		text : "一旦删除数据将不能再恢复!",
		type : "warning",
		showCancelButton : true,
		cancelButtonText : "取消",
		confirmButtonText : "确定",
		closeOnConfirm : false
	}, function() {
		swal.close();
		$.post(url, {
			"id" : id
		}, function(data) {
			$table.bootstrapTable("refresh");
		});
	});

}

/**
 * 弹出对话框
 * @param id 要弹出来的元素id
 * @param href 要加载的页面地址
 */
var $dialog ; //弹出来的对话框
function showDialog(id,title,href) {
	$dialog = $(id);
	$dialog.find(".modal-header h4.modal-title").html(title);
	var url = href + (href.indexOf("?") == -1 ? "?" : "&") +"_=" + new Date().getTime();
	$(id + " div.modal-body").load(url, function() {
		$dialog.modal();
		var $form = $("#myModal form");
		$form.bind("submit", function() {
			submitForm();
			return false;
		});
	});
}

//提交表单，添加或者编辑
function submitForm() {
	var $form = $("form",$dialog);
	var postData = $form.serialize();
	var action = $form.attr("action");
	$.post(action, postData, function(data) {
		$dialog.modal("hide");
		$table.bootstrapTable("refresh");
	});

}
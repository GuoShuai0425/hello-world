<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>


<!-- Mirrored from www.zi-han.net/theme/hplus/table_bootstrap.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:20:03 GMT -->
<head>
	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>教材列表</title>
    
   <%@ include file="/common/common_css.jsp" %>
</head>

<body class="gray-bg">
    <div class="wrapper animated fadeInRight">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>教材列表</h5>
        </div>
        <div class="ibox-content">
            <div>
                <div class="form-inline conditionForm" role="form">
                    <div class="form-group">
                        <span>教材名称: </span>
                        <input id="name" class="form-control" type="text" >
                    </div>
                    <div class="form-group">
                        <span>年级: </span>
                        <select class="form-control" id="grade">
                        	<option value="-1">全部</option>
                        	<c:forEach items="${gradeList }" var="grade">
                        		<option value="${grade.gradeId }">${grade.gradeName }</option>
                        	</c:forEach>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-success" onclick="searchInfo();" ><i class="glyphicon glyphicon-search"></i> 查询</button>
                    <button type="submit" class="btn btn-success" onclick="resetCondition();" ><i class="glyphicon glyphicon-remove"></i> 重置</button>
                </div>
            </div>
            <div id="toolbar">
		        <button id="add" class="btn btn-success" onclick="showDialog('#myModal','添加教材','book/add');">
		            <i class="glyphicon glyphicon-plus"></i> 添加
		        </button>
		        <button id="add" class="btn btn-danger" onclick="batchDelete('book/batchDel','bookId');">
		            <i class="glyphicon glyphicon-remove"></i> 批量删除
		        </button>
		    </div>
            <table id="bookList"
            	data-url="book/list" data-id-field="id" data-side-pagination="server" 
            	data-method="post" data-content-type="application/x-www-form-urlencoded; charset=UTF-8"
            	data-pagination="true" data-page-list="[10, 25, 50, 100, ALL]" data-page-size="10"
            	data-show-columns="true" data-show-refresh="true"  data-show-export="true" data-toolbar="#toolbar">
                 <thead>
                     <tr>
                     	<th data-field="state" data-checkbox="true"></th>
                        <th data-field="bookId">编号</th>
                        <th data-field="name">教材名称</th>
                        <th data-field="grade.gradeName">所属年级</th>
                        <th data-formatter="operateFormatter">操作</th>
                     </tr>
                 </thead>
             </table>
             
             <div class="modal inmodal" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
                 <div class="modal-dialog">
                 	
                     <div class="modal-content animated bounceInRight">
                         <div class="modal-header">
	                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	                        <h4 class="modal-title text-left">title</h4>
	                    </div>
                         <div class="modal-body">
                         </div>
                         <div class="modal-footer">
                             <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                             <button type="button" class="btn btn-primary" onclick="submitForm();">保存</button>
                         </div>
                     </div>
                 </div>
             </div>
             
             </div>
         </div>
    </div>
    <%@ include file="/common/common_js.jsp" %>
	<script type="text/javascript">
		var $table = $("#bookList");
		$table.bootstrapTable({
			queryParams: function(params){
				params["name"] = $("#name").val();
				params["grade.gradeId"] = $("#grade").val();
				return params;
			}
		});
		//自定义操作列
		function operateFormatter(value, row, index) {
	        return [
	            '<a href="javascript:void(0)" title="Edit" onclick="showDialog(\'#myModal\',\'编辑\',\'book/toedit?id='+row.bookId+'\');">',
	            '<i class="glyphicon glyphicon-pencil"></i>',
	            '</a>&nbsp;&nbsp;',
	            '<a href="javascript:void(0)" title="Remove" onclick="deleteRecord(\'book/delete\','+row.bookId+');">',
	            '<i class="glyphicon glyphicon-remove"></i>',
	            '</a>'
	        ].join('');
        }
		
		function searchInfo(){
			$table.bootstrapTable("refresh");
		}
		
	</script>
	<script type="text/javascript" src="js/axems-common.js"></script>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/table_bootstrap.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:20:06 GMT -->
</html>


<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script src="hplus/js/jquery.min.js?v=2.1.4"></script>
<script src="hplus/js/bootstrap.min.js?v=3.3.6"></script>
<script src="hplus/js/content.min.js?v=1.0.0"></script>
<script src="hplus/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="hplus/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="hplus/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="hplus/js/demo/bootstrap-table-demo.min.js"></script>
<script src="hplus/js/plugins/sweetalert/sweetalert.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("select").each(function(){
			var v = $(this).attr("data");
			if(v == undefined){
				v = -1;
			}
			$(this).val(v);
		})
	})
</script>

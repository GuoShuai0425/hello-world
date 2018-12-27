<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <title>添加试卷类型</title>
    
   <%@ include file="/common/common_css.jsp" %>
</head>

<body class="gray-bg">
    <div class="">
	    <div class="ibox float-e-margins">
	        <div class="ibox-content">
	        	<form method="post" action="exampaperType/add" class="form-horizontal">
                   <div class="form-group">
                       <label class="col-sm-2 control-label">试卷类型名称:</label>

                       <div class="col-sm-10">
                           <input type="text" name="name" class="form-control" >
                       </div>
                   </div>
                 </form>
	        </div>
	     </div>
    </div>
    <%@ include file="/common/common_js.jsp" %>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/table_bootstrap.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:20:06 GMT -->
</html>



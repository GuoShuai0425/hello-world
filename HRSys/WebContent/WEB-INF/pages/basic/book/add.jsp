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
    <title>年级列表</title>
    
   <%@ include file="/common/common_css.jsp" %>
</head>

<body class="gray-bg">
    <div class="">
	    <div class="ibox float-e-margins">
	        <div class="ibox-content">
	        	<form method="post" action="book/add" class="form-horizontal">
                   <div class="form-group">
                       <label class="col-sm-2 control-label">教材名称:</label>

                       <div class="col-sm-10">
                           <input type="text" name="name" class="form-control" >
                       </div>
                   </div>
                   <div class="form-group">
                        <label class="col-sm-2 control-label">年级:</label>
                        <div class="col-sm-10">
                        <select class="form-control" id="grade" name="grade.gradeId">
                        	<option value="-1">全部</option>
                        	<c:forEach items="${gradeList }" var="grade">
                        		<option value="${grade.gradeId }">${grade.gradeName }</option>
                        	</c:forEach>
                        </select>
                        </div>
                    </div>
                 </form>
	        </div>
	     </div>
    </div>
    <%@ include file="/common/common_js.jsp" %>
</body>


</html>



<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <title></title>
    
   <%@ include file="/common/common_css.jsp" %>
</head>

<body class="gray-bg">
    <div class="wrapper animated fadeInRight">
	    <div class="ibox float-e-margins">
	        <div class="ibox-content">
	        put your content here
	        </div>
	     </div>
    </div>
    <%@ include file="/common/common_js.jsp" %>
</body>
</html>



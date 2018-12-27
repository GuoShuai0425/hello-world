<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="getbyname.action" method="post">
姓名<input type="text" name="yg.staffName">
<input type="submit" value="查询"> 
</form>

<center>

<table style="border: 1px solid;">
<c:forEach items="${yglist}" var="yg">
<tr>
<td>${yg.attendld }</td>
<td>${yg.sex }</td>
<td>${yg.staffName }</td>
<td>${yg.staffName }</td>
<td>${yg.attendIn }</td>
<td>${yg.attendOut }</td>
<td>${yg.remark }</td>
<td>${yg.bm.deptName }</td>
<td><a href="deleteById.action?yg.attendld=${yg.attendld }">删除</a> </td>
</tr>
</c:forEach>
</table>
</center>

</body>
</html>
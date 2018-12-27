<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="addyh.action" method="post">
<select name="yg.bm.deptld">
<option value="1">技术部</option>
<option value="2">制造</option>
</select>
男<input type="radio" name="yg.sex" value="男">
女<input type="radio" name="yg.sex" value="女">
姓名<input name="yg.staffName">
考勤日期<input name="yg.attendDate">
签到<input name="yg.attendIn">
签退<input name="yg.attendOut">
备注<input name="yg.remark">
<input type="submit" value="增加">
</form>
</body>
</html>
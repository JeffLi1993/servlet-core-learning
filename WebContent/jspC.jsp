<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>当前日期</title>
</head>
<body>
	当前的日期是：<%=new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())%> 
</body>
</html>
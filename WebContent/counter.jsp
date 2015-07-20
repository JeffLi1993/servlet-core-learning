<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.jsp.Counter" %> <!-- 利用page指令导入jar包或者类对象 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H2>
		计数点 -> 
		<%= Counter.getCount() %> <!-- 表达式，会成为out.print()的参数，顾没分号 -->
		<!--等价于  <% out.println(Counter.getCount()); %> -->
	</H2>
</body>
</html>
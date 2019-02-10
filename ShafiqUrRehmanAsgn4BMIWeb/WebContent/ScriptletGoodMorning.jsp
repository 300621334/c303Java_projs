<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Scriplets generate new values while expressions return already existing values...
<p/><p>(1) First a Scriplet - equal sign &lt;%</p>
	<%
	Calendar c = Calendar.getInstance();
	if(c.get(Calendar.AM_PM) == Calendar.AM) out.print("Good Morning!");
	else out.print("Good AFternoon");//prints on browser
	%>
	
	<p/><p>(1) Expression has an equal sign &amp; returns evaluated value -  &lt;%=</p>
	<%= request.getHeader("user-agent") %>
	
	<p> (3) JSP-tag to include another JSP </p> 
	<jsp:include page="test.jsp"></jsp:include>
	
	<p>(4) Expression Language is NOT standard Java code but has its own syntax</p>
	
</body>
</html>
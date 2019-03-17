<%@page import="java.util.List"%>
<%@page import="shafiq.ur.rehman.menu.model.MenuItem"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- the JSTL core library --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	List<MenuItem> menuItems = (List) request.getAttribute("menuItems");
	for(MenuItem item : menuItems)
	{
		out.print("<option value='" + item + "'>" + item + "</option>");
	}
	%>
<form method="post">
	Name: <input id="username" name="username" type="text"  />
	Click to place order: <input value="Place Order" type="submit"/>
</form>
</body>
</html>
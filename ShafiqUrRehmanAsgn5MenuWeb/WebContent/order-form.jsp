<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
 tr, td { 
 border: 1px solid black;
 }
</style>
</head>
<body>
order-form...

<table border="1">
	<tr>
		<td>Number</td><td>Description</td><td>Price</td><td>Quantity</td>
	</tr>
	
	<c:forEach items="${menuItems}" var="item">
	<tr>
		<td>${item.itemNo}</td>
		<td>${item.itemDesc}</td>
		<td>${item.itemPrice}</td>
		<%-- <td>${item.quantity}</td> --%>
	</tr>
	</c:forEach>
</table>
</body>
</html>
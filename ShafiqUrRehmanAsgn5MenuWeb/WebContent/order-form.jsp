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
 th{font-weight:bold;}
 input[name="orderId"]{border:none; font-weight:bold; color:blue;}
</style>
</head>
<body>


<form action="/ShafiqUrRehmanAsgn5MenuWeb/order_form" method="post">
Your order ID is: <input value="${orderId}" name="orderId" id="orderId" />
	<table border="1">
	<tr>
		<th>Number</th><th>Description</th><th>Price</th><th>Quantity</th>
	</tr>
	
	<c:forEach items="${menuItems}" var="item">
	<tr>
		<td>${item.itemNo}</td>
		<td>${item.itemDesc}</td>
		<td>${item.itemPrice}</td>
		<td>
		
			<select name="itemId_${item.itemNo}">
				<option value="0"> </option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
			</select>
		
		</td>
	</tr>
	</c:forEach>
	
	<tr>
		<th></th><th></th><th></th>
		<th><input type="submit" value="Order" /></th>
	</tr>
</table>
	
</form>
</body>
</html>
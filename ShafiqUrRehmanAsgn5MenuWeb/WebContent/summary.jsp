<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
summary...

<form action="${pageContext.request.contextPath}/thanks" method="post">
Your order ID is: <input value="${orderId}" name="orderId" id="orderId" />
	<table border="1">
	<tr>
		<th>Number</th><th>Description</th><th>Price</th><th>Quantity</th><th>Cost</th>
	</tr>
	
	<c:set var="totalCost" value="${0}" />
	<c:forEach items="${menuItems}" var="item">
	
	<%-- <c:if test="${not empty item.quantity}"> --%>
	<c:if test="${item.quantity gt 0}">
		<tr>
		<td>${item.itemNo}</td>
		<td>${item.itemDesc}</td>
		<td>${item.itemPrice}</td>
		<td>${item.quantity}</td>
		<td>$${item.quantity * item.itemPrice}</td>
		<c:set var="totalCost" value="${totalCost + (item.quantity * item.itemPrice)}" />
	</tr>	
	</c:if>
	
	</c:forEach>
	<tr>
		<th></th><th>TOTAL cost of order</th><th></th><th></th><th>$${totalCost}</th>
	</tr>
</table>
	<input name="Confirm" type="submit" value="Confirm" />
	<!-- <input type="submit" value="Cancel" formaction="/ShafiqUrRehmanAsgn5MenuWeb" /> -->
	<input name="Cancel" type="submit" value="Cancel" />
		
		To EDIT, use the BACK button
</form>
</body>
</html>
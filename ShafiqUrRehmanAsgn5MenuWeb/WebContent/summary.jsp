<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
summary...

<form action="/ShafiqUrRehmanAsgn5MenuWeb/thanks" method="post">
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
		<td>${item.quantity}</td>
	</td>
	</tr>
	</c:forEach>
	
	
		
		<input type="submit" value="Confirm" />
		<input type="submit" value="Cancel" formaction="/ShafiqUrRehmanAsgn5MenuWeb/order_form" />
		To EDIT, use the BACK button
	
</table>
	
</form>
</body>
</html>
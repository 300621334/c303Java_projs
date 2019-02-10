<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<!-- copy the next line to any JSP page that uses the core JSTL tags  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- copy the next line to any JSP page formats  numbers              -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<body>
aaaa
<%-- <c:if test="${param.heightMeters eq '' or param.weightKilos eq ''}">
	<c:set var="heightMeters" value="${param.heightMeters}" />
	<c:set var="weightKilos" value="${param.weightKilos}" />
	
	
	<c:redirect url="calcBMI.jsp">
		
	</c:redirect>
</c:if>
 --%>

<p>${param.heightInches}</p>
<p>${param.weightPounds}</p>



</body>
</html>
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

<%-- <c:if test="${param.heightMeters eq '' or param.weightKilos eq ''}">
	<c:set var="heightMeters" value="${param.heightMeters}" />
	<c:set var="weightKilos" value="${param.weightKilos}" />
	
	
	<c:redirect url="calcBMI.jsp">
		
	</c:redirect>
</c:if>
 --%>

<h2>
	Shafiq calculated the BMI to be: <fmt:formatNumber type="number" maxFractionDigits="1" value="${bmi}" />
</h2>

<p>For a person os <strong>height: ${param.heightInches} inches</strong> and <strong>weight of ${param.weightPounds} lbs</strong></p>
<h4>What's the meaning of my BMI result?</h4>
<p>${desc}</p>
<p><a href="${pageContext.request.contextPath}/Assign_4_BMI/unitsUSA.jsp">Try Again</a> (with same units) or 
<a href="${pageContext.request.contextPath}/Assign_4_BMI/index.html">Start Over</a> to change units.</p>

</body>
</html>
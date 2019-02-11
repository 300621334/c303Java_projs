<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="public/Forms.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="CalcBmiServlet" method="post">
		<label>Height (maters)</label><input name="heightMeters" type="text" value="" /><p/>
		<label>Weight (kilograms)</label><input name="weightKilos" type="text" value="" /><p/>
		<input type="submit" value="Calculate BMI" />
		
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit cargo</title>
</head>
<body>

<form:form action="update" modelAttribute="cargo">

<form:hidden path="cargoId"/>
Cargo Name : <form:input path="cargoName"/><br><br>

</form:form>

</body> 
</html>
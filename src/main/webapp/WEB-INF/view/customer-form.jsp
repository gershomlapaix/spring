<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register customer</title>

<style>
.error{
color:red;
}
</style>
</head>
<body>

<i>	Fill out the form. Asterisk(*) means required</i>
	<form:form action="processForm" modelAttribute="customer">
		  
		  First name(*): <form:input path="firstName" />
		  <!-- display error message if set -->
		  <form:errors path="firstName" cssClass="error" /> 
		   <br><br>
		   
		   Last name: <form:input path="lastName" />
		   
		   <br><br>
		   
		    <input type="submit" value="submit"/>	
	</form:form>
  
</body>
</html>
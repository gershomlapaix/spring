<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
   <title>Student registration form</title>
</head>
<body>
   <form:form action="processForm" modelAttribute="student">
	   First name: <form:input path="firstName" />
	   
	   <br><br>
	   
	   Last name: <form:input path="lastName" />
	   
	   <br><br>
	   
	   Country: <form:select path="country">
	     <form:option value="Brazil" label="Brazil"/>
	     <form:option value="Rwanda" label="Rw"/>
	     <form:option value="Chile" label="Chile"/>
	     <form:option value="USA" label="USA"/>
	     </form:select>	
	   
	   <br><br>
	   
	   Favorite language: 
	       Java<form:radiobutton path="language" value="Java"/>
	   	   PHP<form:radiobutton path="language" value="PHP"/>
	   	   JS<form:radiobutton path="language" value="JS"/>	   	  
	   <br><br>
	   
	   <input type="submit" value="submit"/>	
   </form:form>
</body>
</html>
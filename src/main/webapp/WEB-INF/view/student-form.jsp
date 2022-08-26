<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
   <title>Student registration form</title>
</head>
<body>
   <form:form action="processForm" modelAttribute="student">
   First name: <form:input path="firstName" />
   <br>
   
   Last name: <form:input path="lastName" />
   
   <br>
   
   <form type="submit" value="submit"/>
   </form:form>
</body>
</html>
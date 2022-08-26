<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <title>Student confirmation</title>
</head>
<body>
<hr>

<p>The student is: ${student.firstName } ${student.lastName }</p>
<p>Country: ${student.country }</p>
<p>Favorite language: ${student.language }</p>

<p>Operating system(s): </p>
<ul>
  <c:forEach var="temp" items="${student.os }">
   <li>${temp} </li>
   </c:forEach>
</ul>
</body>
</html>
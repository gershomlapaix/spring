<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <title>Customer confirmation</title>
</head>
<body>
<hr>

<p>The customer is confirmed: ${customer.firstName }  ${customer.lastName }</p>
<p>Free passes: ${customer.freePasses }</p>

</body>
</html>
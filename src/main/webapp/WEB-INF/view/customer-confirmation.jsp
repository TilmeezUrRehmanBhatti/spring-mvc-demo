<%--
  Created by IntelliJ IDEA.
  User: tilme
  Date: 01/09/2022
  Time: 02:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer Confirmation</title>
</head>
<body>

The customer is confirmed: ${customer.firstName} ${customer.lastName}

<br><br>

Free passes: ${customer.freePass}

<br><br>

Postal code: ${customer.postalCode}

<br><br>

Course code: ${customer.courseCode}

</body>
</html>

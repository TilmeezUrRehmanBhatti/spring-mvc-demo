<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>

The student is confirmed: ${student.firstName} ${student.lastName}

<br><br>

Country: ${student.country}

<br><br>

Favourite Language: ${student.favoriteLanguage}

<br><br>

Operating Systems:

<ul>
    <c:forEach var="temp" items="${student.operatingSystems}">

        <li>${temp}</li>

    </c:forEach>
</ul>

</body>
</html>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>

<form:form action="processForm" modelAttribute="student">
    First name: <form:input path="firstName"/>

    <br><br>

    Last name: <form:input path="lastName"/>

    <br><br>

    Country:
    <form:select path="country">

        <form:options items="${student.countryOption}"/>

        <!-- <form:option value="Brazil" label="Brazil" />
        <form:option value="France" label="France" />
        <form:option value="Germany" label="Germany" />
        <form:option value="Pakistan" label="Pakistan" /> -->

    </form:select>

    <br><br>

    Favorite Language:

    <form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOption}"/>

    <!--
    Java <form:radiobutton path="favoriteLanguage" value="Java"/>
    C# <form:radiobutton path="favoriteLanguage" value="C#"/>
    PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
    Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
    -->

    <br><br>

    Operating Systems:

    <form:checkboxes path="operatingSystems" items="${student.operatingSystemsOption}"/>

    <!--
    Linux <form:checkbox path="operatingSystems" value="linux"/>
    Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
    MS Windows <form:checkbox path="operatingSystems" value="MS Windows"/>
    -->

    <br><br>

    <input type="submit" value="Submit"/>

</form:form>
</body>
</html>





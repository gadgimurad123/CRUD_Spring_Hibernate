<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>
<h2>User Info</h2>
<br>

<form:form action="saveUser" modelAttribute="user">

    <form:hidden path="id"/>

    Name <form:input path="name"/>
    <br><br>
    Last name <form:input path="lastName"/>
    <br><br>
    Address <form:input path="address"/>
    <br><br>
    Year <form:input path="year"/>
    <br><br>
    <input type="submit" value="OK">

</form:form>

</body>
</html>
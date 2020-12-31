<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>

<body>
<h2>All Users</h2>

<table>

    <tr>
        <th>Name</th>
        <th>Last name</th>
        <th>Address</th>
        <th>Year</th>
        <th>Actions</th>
    </tr>

    <c:forEach var="user" items="${allUsers}">

        <c:url var="updateButton" value="/updateInfo">
            <c:param name="userId" value="${user.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteUser">
            <c:param name="userId" value="${user.id}"/>
        </c:url>

        <tr>
            <td>${user.name}</td>
            <td>${user.lastName}</td>
            <td>${user.address}</td>
            <td>${user.year}</td>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href = '${updateButton}'"/>
                <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>

</table>

<br>

<input type="button" value="Add new User"
       onclick="window.location.href = 'addNewUser'"/>

</body>

</html>
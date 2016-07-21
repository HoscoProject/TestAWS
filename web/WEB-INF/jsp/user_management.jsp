<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>User Management</title>
    </head>
    <body>
        <h3>Persons List</h3>
        <c:if test="${!empty listUser}">
                <table class="tg">
                <tr>
                        <th width="80">Person ID</th>
                        <th width="120">Person Name</th>
                        <th width="120">Person Country</th>
                        <th width="60">Edit</th>
                        <th width="60">Delete</th>
                </tr>
                <c:forEach items="${listUser}" var="user">
                        <tr>
                                <td>${user.id}</td>
                                <td>${user.name}</td>
                                <td>${user.country}</td>
                                <td><a href="<c:url value='/edit/${user.username}' />" >Edit</a></td>
                                <td><a href="<c:url value='/remove/${user.username}' />" >Delete</a></td>
                        </tr>
                </c:forEach>
                </table>
        </c:if>
    </body>
</html>

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
        
        <form:form method ="post" commandName ="customer" action="registerUser.html">
        <table>
            <tr>
                <td>ID</td>
                <td><form:input path="id"/></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><form:password  path="name"/></td>
            </tr>
            <tr>
                <td>Age</td>
                <td><form:input path="age"/></td>
            </tr>
             <tr>
                 <td><input type="submit" value="Add"></td>                
            </tr>
        </table>                        
        
    </form:form>
        
        <h3>Customers List</h3>
        <c:if test="${!empty listUser}">
                <table  border="1">
                <tr>
                        <th width="80">ID</th>
                        <th width="120">Name</th>
                        <th width="120">Age</th>
                        <th width="60">Edit</th>
                        <th width="60">Delete</th>
                </tr>
                <c:forEach items="${listUser}" var="user">
                        <tr>
                                <td>${user.id}</td>
                                <td>${user.name}</td>
                                <td>${user.age}</td>
                                <td><a href="user_management.jsp" >Edit</a></td>
                                <td><a href="<c:url value='/remove/${user.id}' />" >Delete</a></td>
                        </tr>
                </c:forEach>
                </table>
        </c:if>
    </body>
</html>

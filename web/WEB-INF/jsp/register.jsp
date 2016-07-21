<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
    <form:form method ="post" commandName ="user" action="registerUser.html">
        <table>
            <tr>
                <td>Username</td>
                <td><form:input path="username"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><form:password  path="password"/></td>
            </tr>
            <tr>
                <td>Group</td>
                <td><form:input path="group"/></td>
            </tr>
             <tr>
                 <td><input type="submit" value="Register"></td>                
            </tr>
        </table>
                        
        
    </form:form>
    </body>
</html>

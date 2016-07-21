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
        <h1>${result}</h1>
    <form:form method ="post" commandName ="userLogin" action="checkLogin.html">
        <table>
            <tr>
                <td>Username</td>
                <td><form:input path="username"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><form:input path="password"/> </td>  
            </tr>
            <tr>
                <td><input type="submit" value="Login"></td>                
            </tr>
        </table>                        
        
    </form:form>
    </body>
</html>

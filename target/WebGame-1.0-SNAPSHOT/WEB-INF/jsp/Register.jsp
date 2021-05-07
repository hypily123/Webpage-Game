<%-- 
    Document   : Register
    Created on : Apr 24, 2021, 4:11:31 AM
    Author     : Jian Xiao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1 align="center">Register Page</h1>
        <c:if test="${msg != null}">
            <div align="center"><c:out value="${msg}"/></div>
        </c:if>
        <div style="display: flex;align-items: center;justify-content: center;border:1px solid #000">
            <table>
                <tr><td><form name="Login.htm" action="Login.htm" method="GET">
                            <input type="submit" value="Login Page">
                        </form></td>
                    <td><form name="Register.htm" action="Register.htm" method="GET">
                            <input type="submit" value="Register Page">
                        </form></td></tr>
            </table>
        </div>
        <div style="display: flex;align-items: center;justify-content: center;border:1px solid #000">
            <form name="Register.htm" action="Register.htm" method="POST">
                <table><tr><td>Username:</td><td><input type="text" name ="username"  pattern="[a-zA-Z0-9]+" required/></td></tr>
                    <tr><td>Password:</td><td><input type="password" name="password" pattern="[a-zA-Z0-9]+" required/></td></tr>
                    <tr><td>Confirm Password:</td><td><input type="password" name="password2" pattern="[a-zA-Z0-9]+" required/></td></tr>
                </table>
                <input type="submit" value="Register"/>
            </form>
        </div>
    </body>
</html>

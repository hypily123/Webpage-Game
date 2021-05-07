<%-- 
    Document   : Player_Main
    Created on : Apr 24, 2021, 4:00:52 AM
    Author     : Jian Xiao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Player End Battle</title>
    </head>
    <body>
        <div style="display: flex;align-items: center;justify-content: center">
            <h1>Player End Battle</h1>
        </div>
        <c:if test="${msg != null}">
            <div style="display: flex;align-items: center;justify-content: center">
                <c:out value="${msg}"/>
            </div>
        </c:if>
        <div style="display: flex;align-items: center;justify-content: center;border:1px solid #000">
            <form name="Login.htm" action="Login.htm" method="GET">
                <input type="submit" value="Log out">
            </form>
        </div>
        <div style="display: flex;align-items: center;justify-content: center;border:1px solid #000">
            <table>
                <tr>
                    <td>
                        <form name="Player_Main.htm" action="Player_Main.htm" method="GET">
                            <input type="submit" value="To Main Page">
                        </form>
                    <td>
                        <form name="Player_Store.htm" action="Player_Store.htm" method="GET">
                            <input type="submit" value="To Store">
                        </form>
                    <td>
                    <td>
                        <form name="Player_Dungeon.htm" action="Player_Dungeon.htm" method="POST">
                            <input type="submit" value="To Dungeon">
                        </form>
                    </td>
                </tr>
            </table>
        </div>
        <div align=center"><h2>This trip has ended</h2></div>
    </body>
</html>

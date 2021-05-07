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
        <title>To Dungeon</title>
    </head>
    <body>
        <div style="display: flex;align-items: center;justify-content: center">
            <h1>To Dungeon</h1>
        </div>
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
        <div style="display: flex;align-items: center;justify-content: center;border:1px solid #000">
            <c:out value="Level: ${sessionScope.user.getLvl()}"/>
            <c:out value="experience: ${sessionScope.user.getExp()}"/>
        </div>
        <div style="display: flex;align-items: center;justify-content: center;border:1px solid #000">
            <h3 align="center">Dungeons</h3>
        </div>
        <div style="display: flex;align-items: center;justify-content: center;border:1px solid #000">
            <table>
                <tr><td>Dungeon name</td>
                    <td>lvl</td>
                    <td>waves</td></tr>
                    <c:if test="${dungeons != null}">
                        <c:forEach var="dungeon" items="${dungeons}">
                        <tr><td><c:out value="${dungeon.getName()}"/></td>
                            <td><c:out value="${dungeon.getLvl()}" /></td>
                            <td><c:out value="${dungeon.getWaves()}"  /></td></tr>
                        </c:forEach>
                    </c:if>
            </table>
        </div>
        <div style="display: flex;align-items: center;justify-content: center;border:1px solid #000">
            <form name="Player_Enter_Dungeon.htm" action="Player_Enter_Dungeon.htm" method="POST">
                <c:if test="${dungeons != null}">
                    <select name="dungeon">
                        <c:forEach var="dungeon" items="${dungeons}">
                            <option value="${dungeon.getId()}"><c:out value="${dungeon.getName()}"/></option>
                        </c:forEach>
                    </select>
                </c:if>
                <br/>
                <input type="submit" value="Enter The Dungeon">
            </form>
        </div>
    </body>
</html>
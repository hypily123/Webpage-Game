<%-- 
    Document   : GM_Dungeon
    Created on : Apr 23, 2021, 11:27:02 AM
    Author     : Jian Xiao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GM_Dungeon</title>
    </head>
    <body>
        <div style="display: flex;align-items: center;justify-content: center">
            <h1>Dungeon</h1>
        </div>
        <div style="display: flex;align-items: center;justify-content: center">
            <form name="GM_Dungeon.htm" action="GM_Dungeon.htm"" method="POST">
                <table>
                    <tr><td>name</td>
                        <td>lvl</td>
                        <td>waves</td>
                        <td>update</td>
                        <td>remove</td></tr>
                        <c:if test="${dungeons != null}">
                            <c:set var="count" value="0" scope="page" />
                            <c:forEach var="dungeon" items="${dungeons}">
                            <tr><td><input type="text" name="name" value="${dungeon.getName()}" pattern="[a-zA-Z0-9]+" required/></td>
                                <td><input type="number" name="lvl" min="1" step="1" value="${dungeon.getLvl()}" required /></td>
                                <td><input type="number" name="waves" min="1" step="1" value="${dungeon.getWaves()}" required /></td>
                                <td><input type="checkbox" name="toUpdate" value="${dungeon.getId()},${count}" /></td>
                                <td><input type="checkbox" name="toRemove" value="${dungeon.getId()},${count}" /></td></tr>
                                    <c:set var="count" value="${count + 1}" scope="page"/>
                                </c:forEach>
                            </c:if>
                    <tr><td><input type="text" name="name2" pattern="[a-zA-Z0-9]+"  /></td>
                        <td><input type="number" name="lvl2" min="1" step="1"  /></td>
                        <td><input type="number" name="waves2" min="1" step="1"  /></td></tr>
                </table>
                <input type="submit" value="submit"/>
            </form>
        </div>
        <br/>
        <div style="display: flex;align-items: center;justify-content: center">
            <a href= "GM_Main.htm">Go Back To Homepage</a>
        </div>
    </body>
</html>
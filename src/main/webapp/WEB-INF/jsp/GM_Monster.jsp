<%-- 
    Document   : GM_Monster
    Created on : Apr 7, 2021, 12:53:57 PM
    Author     : Jian Xiao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GM_Monster</title>
    </head>
    <body>
        <div style="display: flex;align-items: center;justify-content: center">
            <h1>Monster</h1>
        </div>
        <div style="display: flex;align-items: center;justify-content: center">
            <form name="GM_Monster.htm" action="GM_Monster.htm"" method="POST">
                <table>
                    <tr><td>name</td>
                        <td>lvl</td>
                        <td>hp</td>
                        <td>atk</td>
                        <td>def</td>
                        <td>spd</td>
                        <td>exp</td>
                        <td>loot</td>
                        <td>update</td>
                        <td>remove</td></tr>
                        <c:if test="${monsters != null}">
                            <c:set var="count" value="0" scope="page" />
                            <c:forEach var="monster" items="${monsters}">
                            <tr><td><input type="text" name="name" value="${monster.getName()}" pattern="[a-zA-Z0-9]+" required/></td>
                                <td><input type="number" name="lvl" min="1" step="1" value="${monster.getLvl()}" required /></td>
                                <td><input type="number" name="hp" min="1" step="1" value="${monster.getHp()}" required /></td>
                                <td><input type="number" name="atk" min="1" step="1" value="${monster.getAtk()}" required /></td>
                                <td><input type="number" name="def" min="0" step="1" value="${monster.getDef()}" required /></td>
                                <td><input type="number" name="spd" min="1" step="1" value="${monster.getSpd()}" required /></td>
                                <td><input type="number" name="exp" min="1" step="1" value="${monster.getExp()}" required /></td>
                                <td><input type="number" name="loot" min="0" step="1" value="${monster.getLoot()}" required /></td>
                                <td><input type="checkbox" name="toUpdate" value="${monster.getId()},${count}" /></td>
                                <td><input type="checkbox" name="toRemove" value="${monster.getId()},${count}" /></td></tr>
                                    <c:set var="count" value="${count + 1}" scope="page"/>
                                </c:forEach>
                            </c:if>
                    <tr><td><input type="text" name="name2"  pattern="[a-zA-Z0-9]+" /></td>
                        <td><input type="number" name="lvl2" min="1" step="1"  /></td>
                        <td><input type="number" name="hp2" min="1" step="1"  /></td>
                        <td><input type="number" name="atk2" min="1" step="1"  /></td>
                        <td><input type="number" name="def2" min="0" step="1"  /></td>
                        <td><input type="number" name="spd2" min="1" step="1"  /></td>
                        <td><input type="number" name="exp2" min="1" step="1"  /></td>
                        <td><input type="number" name="loot2" min="0" step="1"  /></td></tr>
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

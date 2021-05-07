<%-- 
    Document   : GM_DungeonMonsterPair
    Created on : Apr 24, 2021, 6:07:22 AM
    Author     : Jian Xiao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dungeon-Monster-Pair</title>
    </head>
    <body>
        <div style="display: flex;align-items: center;justify-content: center">
            <h1>Dungeon-Monster-Pair</h1>
        </div>
        <c:if test="${addF}">
            <p align="center">Addition Failed</p>
        </c:if>
        <c:if test="$deleteF}">
            <p align="center">Deletion Failed</p>
        </c:if>
        <div style="display:flex; align-items: flex-start; justify-content: center">
            <div style="border:1px solid #000">
                <h3 align="center">Dungeon</h3>
                <table>
                    <tr><td>dungeonID</td>
                        <td>name</td>
                        <td>lvl</td>
                        <td>waves</td></tr>
                        <c:if test="${dungeons != null}">
                            <c:forEach var="dungeon" items="${dungeons}">
                            <tr><td><c:out value="${dungeon.getId()}"/></td>
                                <td><c:out value="${dungeon.getName()}"/></td>
                                <td><c:out value="${dungeon.getLvl()}"/></td>
                                <td><c:out value="${dungeon.getWaves()}"/></td></tr>
                            </c:forEach>
                        </c:if>
                </table>
            </div>
            <div style="border:1px solid #000">
                <h3 align="center" style="top:10em">Dungeon Monster Pair</h3>
                <form name="GM_DungeonMonsterPair.htm" action="GM_DungeonMonsterPair.htm"" method="POST">
                    <table>
                        <tr><td>dungeonID</td>
                            <td>monsterID</td>
                            <td>wave</td>
                            <td>update</td>
                            <td>remove</td></tr>
                            <c:if test="${DungeonMonsterPairs != null}">
                                <c:set var="count" value="0" scope="page" />
                                <c:forEach var="DungeonMonsterPair" items="${DungeonMonsterPairs}">
                                <tr><td><input type="number" name="dungeonID" min="1" step="1" value="${DungeonMonsterPair.getDungeonID()}" required /></td>
                                    <td><input type="number" name="monsterID" min="1" step="1" value="${DungeonMonsterPair.getMonsterID()}" required /></td>
                                    <td><input type="number" name="wave" min="1" step="1" value="${DungeonMonsterPair.getWave()}" required /></td>
                                    <td><input type="checkbox" name="toUpdate" value="${DungeonMonsterPair.getId()},${count}" /></td>
                                    <td><input type="checkbox" name="toRemove" value="${DungeonMonsterPair.getId()},${count}" /></td></tr>
                                        <c:set var="count" value="${count + 1}" scope="page"/>
                                    </c:forEach>
                                </c:if>
                        <tr>
                            <td><input type="number" name="dungeonID2" min="1" step="1"  /></td>
                            <td><input type="number" name="monsterID2" min="1" step="1"  /></td>
                            <td><input type="number" name="wave2" min="1" step="1"  /></td>
                        </tr>
                    </table>
                    <input type="submit" value="submit"/>
                </form>
            </div>
            <div style="border:1px solid #000">
                <h3 align="center">Monster</h3>
                <table>
                    <tr><td>monsterID</td>
                        <td>name</td>
                        <td>lvl</td>
                        <td>hp</td>
                        <td>atk</td>
                        <td>def</td>
                        <td>spd</td>
                        <td>exp</td>
                        <td>loot</td></tr>
                        <c:if test="${monsters != null}">
                            <c:forEach var="monster" items="${monsters}">
                            <tr><td><c:out value="${monster.getId()}"/></td>
                                <td><c:out value="${monster.getName()}"/></td>
                                <td><c:out value="${monster.getLvl()}"/></td>
                                <td><c:out value="${monster.getHp()}"/></td>
                                <td><c:out value="${monster.getAtk()}"/></td>
                                <td><c:out value="${monster.getDef()}"/></td>
                                <td><c:out value="${monster.getSpd()}"/></td>
                                <td><c:out value="${monster.getExp()}"/></td>
                                <td><c:out value="${monster.getLoot()}"/></td></tr>
                            </c:forEach>
                        </c:if>
                </table>
            </div>
        </div>
        <div style="display: flex;align-items: center;justify-content: center">
            <a href= "GM_Main.htm">Go Back To Homepage</a>
        </div>
    </body>
</html>

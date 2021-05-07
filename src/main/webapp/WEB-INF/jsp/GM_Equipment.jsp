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
        <title>GM_Equipment</title>
    </head>
    <body>
        <div style="display: flex;align-items: center;justify-content: center">
            <h1>Equipment</h1>
        </div>
        <c:if test="${addF}">
            <p align="center">Addition Failed</p>
        </c:if>
        <c:if test="$deleteF}">
            <p align="center">Deletion Failed</p>
        </c:if>
        <div style="display: flex;align-items: center;justify-content: center">
            <form name="GM_Equipment.htm" action="GM_Equipment.htm"" method="POST">
                <table>
                    <tr><td>name</td>
                        <td>part</td>
                        <td>atk</td>
                        <td>def</td>
                        <td>spd</td>
                        <td>value</td>
                        <td>update</td>
                        <td>remove</td></tr>
                        <c:if test="${equipments != null}">
                            <c:set var="count" value="0" scope="page" />
                            <c:forEach var="equipment" items="${equipments}">
                            <tr><td><input type="text" name="name" value="${equipment.getName()}" pattern="[a-zA-Z0-9]+" required/></td>
                                <td><select name="part">
                                        <option value="weapon"<c:if test="${equipment.getPart() == 'weapon'}">selected</c:if>>weapon</option>
                                        <option value="armor"<c:if test="${equipment.getPart() == 'armor'}">selected</c:if>>armor</option>
                                        <option value="boot" <c:if test="${equipment.getPart() == 'boot'}">selected</c:if>>boot</option></select></td>
                                <td><input type="number" name="atk" min="0" step="1" value="${equipment.getAtk()}" required /></td>
                                <td><input type="number" name="def" min="0" step="1" value="${equipment.getDef()}" required /></td>
                                <td><input type="number" name="spd" min="0" step="1" value="${equipment.getSpd()}" required /></td>
                                <td><input type="number" name="value" min="1" step="1" value="${equipment.getVal()}" required /></td>
                                <td><input type="checkbox" name="toUpdate" value="${equipment.getId()},${count}" /></td>
                                <td><input type="checkbox" name="toRemove" value="${equipment.getId()},${count}" /></td></tr>
                                    <c:set var="count" value="${count + 1}" scope="page"/>
                                </c:forEach>
                            </c:if>
                    <tr><td><input type="text" name="name2"  pattern="[a-zA-Z0-9]+" /></td>
                        <td><select name="part2">
                                <option value="weapon">weapon</option>
                                <option value="armor">armor</option>
                                <option value="boot">boot</option> </select></td>
                        <td><input type="number" name="atk2" min="0" step="1"  /></td>
                        <td><input type="number" name="def2" min="0" step="1"  /></td>
                        <td><input type="number" name="spd2" min="0" step="1"  /></td>
                        <td><input type="number" name="value2" min="1" step="1"  /></td></tr>
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

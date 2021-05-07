<%-- 
    Document   : Player_Store
    Created on : May 1, 2021, 1:35:41 AM
    Author     : Jian Xiao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Player Store</title>
    </head>
    <body>
        <h1 align="center">Player store</h1>
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
        <c:set var="golds" value="${sessionScope.user.getGold()}" scope="page" />
        <form name="Player_Store.htm" action="Player_Store.htm" method="POST">
            <div style="display:flex; align-items: flex-start; justify-content: center">
                <div style="border:1px solid #000">
                    <h3 align="center">Store</h3>
                    <table>
                        <tr>
                            <td>Equipment Name</td>
                            <td>Part</td>
                            <td>ATK</td>
                            <td>DEF</td>
                            <td>SPD</td>
                            <td>Price</td>
                            <td>Buy</td>
                        </tr>
                        <c:if test="${equipments != null}">
                            <c:forEach var="equipment" items="${equipments}">
                                <tr>
                                    <td><c:out value="${equipment.getName()}"/></td>
                                    <td><c:out value="${equipment.getPart()}"/></td>
                                    <td><c:out value="${equipment.getAtk()}"/></td>
                                    <td><c:out value="${equipment.getDef()}"/></td>
                                    <td><c:out value="${equipment.getSpd()}"/></td>
                                    <td><c:out value="${equipment.getVal()}"/></td>
                                    <td><input type="checkbox" name="buy" value="${equipment.getId()},${equipment.getVal()}"/></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </table>
                </div>
                <div style="border:1px solid #000">
                    <h3 align="center">Inventory</h3>
                    <table>
                        <tr>
                            <td>Equipment Name</td>
                            <td>Part</td>
                            <td>ATK</td>
                            <td>DEF</td>
                            <td>SPD</td>
                            <td>Price</td>
                            <td>Sell</td>
                        </tr>
                        <c:if test="${inventory != null}">
                            <c:forEach var="equipment" items="${inventory}">
                                <tr>
                                    <td><c:out value="${equipment.getName()}"/></td>
                                    <td><c:out value="${equipment.getPart()}"/></td>
                                    <td><c:out value="${equipment.getAtk()}"/></td>
                                    <td><c:out value="${equipment.getDef()}"/></td>
                                    <td><c:out value="${equipment.getSpd()}"/></td>
                                    <td><c:out value="${equipment.getVal()}"/></td>
                                    <td><input type="checkbox" name="sell" value="${equipment.getId()},${equipment.getVal()}"/></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </table>
                </div>
            </div>
            <div align="center">Golds: <c:out value="${golds}"/></div>
            <div align="center"> <input type="submit" value="Buy and Sell" /></div>
        </form>
    </body>
</html>

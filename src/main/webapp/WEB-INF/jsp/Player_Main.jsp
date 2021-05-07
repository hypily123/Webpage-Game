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
        <title>Player Homepage</title>
    </head>
    <body>
        <div style="display: flex;align-items: center;justify-content: center">
            <h1>Player Homepage</h1>
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
        <div style="display: flex;align-items: center;justify-content: center;border:1px solid #000">
            <c:out value="Level: ${sessionScope.user.getLvl()}"/>
            <c:out value="experience: ${sessionScope.user.getExp()}"/>
        </div>
        <form name="Player_Main.htm" action="Player_Main.htm" method="POST">
            <div style="display: inline; text-align: center; align-items: center;justify-content: center;border:1px solid #000">
                <c:set var="vit" value="${sessionScope.user.getVit()}" scope="page" />
                <c:set var="pow" value="${sessionScope.user.getPow()}" scope="page" />
                <c:set var="str" value="${sessionScope.user.getStr()}" scope="page" />
                <c:set var="intelligence" value="${sessionScope.user.getIntelligence()}" scope="page" />
                <c:set var="dex" value="${sessionScope.user.getDex()}" scope="page" />
                <c:set var="points" value="${sessionScope.user.getPoints()}" scope="page" />
                <c:set var="golds" value="${sessionScope.user.getGold()}" scope="page" />
                <h3 align="center">Attributes</h3>
                <h5 align="center">total spend points should be <= 20 + 5 * Level where each attribute >= 5</h5>
                <table align="center">
                    <tr><td>Vitality</td>
                        <td><input type="number" name="vit" min="5" step="1"  value="${vit}" required/>
                    <tr><td>Power</td>
                        <td><input type="number" name="pow"min="5" step="1"  value="${pow}" required/>
                    <tr><td>Strength</td>
                        <td><input type="number" name="str" min="5" step="1"  value="${str}" required/>
                    <tr><td>Intelligence</td>
                        <td><input type="number" name="intelligence" min="5" step="1"  value="${intelligence}" required/>
                    <tr><td>Dexterity</td>
                        <td><input type="number" name="dex" min="5" step="1"  value="${dex}" required/>
                </table>
                <div>
                    <input type="submit" value="Apply" /><br/>
                    Points: <c:out value="${points}"/><br/>
                    Golds: <c:out value="${golds}"/><br/>
                </div>
            </div>
            <h3 align="center">Equipped Equipments</h3>
            <div style="display:flex; align-items: flex-start; justify-content: center">
                <div style="border:1px solid #000">
                    <h5 align="center">Weapon</h5>
                    <table>
                        <tr>
                            <td>name</td>
                            <td>atk</td>
                            <td>def</td>
                            <td>spd</td>
                            <td>value</td>
                        </tr>
                        <c:if test="${weapon != null}">
                            <tr>
                                <td><c:out value="${weapon.getName()}"/></td>
                                <td><c:out value="${weapon.getAtk()}"/></td>
                                <td><c:out value="${weapon.getDef()}"/></td>
                                <td><c:out value="${weapon.getSpd()}"/></td>
                                <td><c:out value="${weapon.getVal()}"/></td>
                            </tr>
                        </c:if>
                    </table>
                    <c:if test="${weapons != null}">
                        <div align="center">
                            <select name="weapon" >
                                <c:forEach var="weapon2" items="${weapons}">
                                    <option value="${weapon2.getId()}"<c:if test="${weapon2.getName() == weapon.getName()}">selected</c:if>><c:out value="${weapon2.getName()}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                    </c:if>
                </div>
                <div style="border:1px solid #000">
                    <h5 align="center">Armor</h5>
                    <table>
                        <tr>
                            <td>name</td>
                            <td>atk</td>
                            <td>def</td>
                            <td>spd</td>
                            <td>value</td>
                        </tr>
                        <c:if test="${armor != null}">
                            <tr>
                                <td><c:out value="${armor.getName()}"/></td>
                                <td><c:out value="${armor.getAtk()}"/></td>
                                <td><c:out value="${armor.getDef()}"/></td>
                                <td><c:out value="${armor.getSpd()}"/></td>
                                <td><c:out value="${armor.getVal()}"/></td>
                            </tr>
                        </c:if>
                    </table>
                    <c:if test="${armors != null}">
                        <div align="center">
                            <select name="armor" >
                                <c:forEach var="armor2" items="${armors}">
                                    <option value="${armor2.getId()}"<c:if test="${armor2.getName() == armor.getName()}">selected</c:if>><c:out value="${armor2.getName()}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                    </c:if>
                </div>
                <div style="border:1px solid #000">
                    <h5 align="center">Boot</h5>
                    <table>
                        <tr>
                            <td>name</td>
                            <td>atk</td>
                            <td>def</td>
                            <td>spd</td>
                            <td>value</td>
                        </tr>
                        <c:if test="${boot != null}">
                            <tr>
                                <td><c:out value="${boot.getName()}"/></td>
                                <td><c:out value="${boot.getAtk()}"/></td>
                                <td><c:out value="${boot.getDef()}"/></td>
                                <td><c:out value="${boot.getSpd()}"/></td>
                                <td><c:out value="${boot.getVal()}"/></td>
                            </tr>
                        </c:if>
                    </table>
                    <c:if test="${boots != null}">
                        <div align="center">
                            <select name="boot" >
                                <c:forEach var="boot2" items="${boots}">
                                    <option value="${boot2.getId()}"<c:if test="${boot2.getName() == boot.getName()}">selected</c:if>><c:out value="${boot2.getName()}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                    </c:if>
                </div>
            </div>
            <div style="display:flex; align-items: flex-start; justify-content: center">
                <input type="submit" value="Apply" />
            </div>
            <div style="display:flex; align-items: flex-start; justify-content: center">
                <h3 align="center">Inventory</h3>
            </div>
            <div style="display:flex; align-items: flex-start; justify-content: center">
                <div style="border:1px solid #000">
                    <h5 align="center">Weapons</h5>
                    <c:if test="${weapons != null}">
                        <table>
                            <tr>
                                <td>name</td>
                                <td>atk</td>
                                <td>def</td>
                                <td>spd</td>
                                <td>value</td>
                            </tr>
                            <c:forEach var="weapon" items="${weapons}">
                                <tr>
                                    <td><c:out value="${weapon.getName()}"/></td>
                                    <td><c:out value="${weapon.getAtk()}"/></td>
                                    <td><c:out value="${weapon.getDef()}"/></td>
                                    <td><c:out value="${weapon.getSpd()}"/></td>
                                    <td><c:out value="${weapon.getVal()}"/></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                </div>
                <div style="border:1px solid #000">
                    <h5 align="center">Armors</h5>
                    <c:if test="${armors != null}">
                        <table>
                            <tr>
                                <td>name</td>
                                <td>atk</td>
                                <td>def</td>
                                <td>spd</td>
                                <td>value</td>
                            </tr>
                            <c:forEach var="armor" items="${armors}">
                                <tr>
                                    <td><c:out value="${armor.getName()}"/></td>
                                    <td><c:out value="${armor.getAtk()}"/></td>
                                    <td><c:out value="${armor.getDef()}"/></td>
                                    <td><c:out value="${armor.getSpd()}"/></td>
                                    <td><c:out value="${armor.getVal()}"/></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                </div>
                <div style="border:1px solid #000">
                    <h5 align="center">Boots</h5>
                    <c:if test="${boots != null}">
                        <table>
                            <tr>
                                <td>name</td>
                                <td>atk</td>
                                <td>def</td>
                                <td>spd</td>
                                <td>value</td>
                            </tr>
                            <c:forEach var="boot" items="${boots}">
                                <tr>
                                    <td><c:out value="${boot.getName()}"/></td>
                                    <td><c:out value="${boot.getAtk()}"/></td>
                                    <td><c:out value="${boot.getDef()}"/></td>
                                    <td><c:out value="${boot.getSpd()}"/></td>
                                    <td><c:out value="${boot.getVal()}"/></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                </div>
            </div>
        </form>
    </body>
</html>

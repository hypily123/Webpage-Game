<%-- 
    Document   : Player_Battle
    Created on : Apr 5, 2021, 5:18:41 PM
    Author     : Jian Xiao
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Player Battle</title>
    </head>
    <body>
        <h1 align="center">player Battle</h1>
        <c:set var="hp" value="${curHP}" scope="page" />
        <c:set var="atk" value="${sessionScope.user.getPow()+sessionScope.user.getStr()}" scope="page" />
        <c:set var="def" value="${sessionScope.user.getStr()+sessionScope.user.getDex()}" scope="page" />
        <div style="display: flex;align-items: center;justify-content: center;border:1px solid #000">
            HP: <c:out value="${hp}"/>
            ATK: <c:out value="${atk}"/>
            DEF: <c:out value="${def}"/>
        </div>
        <div style="display: flex;align-items: center;justify-content: center;border:1px solid #000">
            Wave:<c:out value="${curWave}"/>
        </div>
        <div style="display: flex;align-items: center;justify-content: center;border:1px solid #000">
            <c:set var="gold" value="0" scope="page" />
            <c:set var="exp" value="0" scope="page" />
            <table>
                <tr>
                    <c:forEach var="monster" items="${monsters}">
                        <c:set var="gold" value="${gold + monster.getLoot()}" scope="page"/>
                        <c:set var="exp" value="${exp + monster.getExp()}" scope="page"/>
                        <td>
                            Monster Name: <c:out value="${monster.getName()}"/> 
                        </td>
                    </c:forEach>
                </tr>
                <tr>
                    <c:forEach var="monster" items="${monsters}">
                        <c:set var="g" value="${g + monster.getLoot()}" scope="page"/>
                        <td>
                            HP: <c:out value="${monster.getHp()}"/> 
                        </td>
                    </c:forEach>
                </tr>
                <tr>
                    <c:forEach var="monster" items="${monsters}">
                        <td>
                            ATK: <c:out value="${monster.getAtk()}"/> 
                        </td>
                    </c:forEach>
                </tr>
                <tr>
                    <c:forEach var="monster" items="${monsters}">
                        <td>
                            DEF: <c:out value="${monster.getDef()}"/> 
                        </td>
                    </c:forEach>
                </tr>
            </table>
        </div>
        <div style="display: flex;align-items: center;justify-content: center;border:1px solid #000">
            <form name="Player_InBattle.htm" action="Player_InBattle.htm" method="POST">
                <input type="hidden" name="gold" value="${gold}"/>
                <input type="hidden" name="exp" value="${exp}"/>
                <input type="submit" value= "Next Wave"/>
            </form>
        </div>
    </body>
</html>

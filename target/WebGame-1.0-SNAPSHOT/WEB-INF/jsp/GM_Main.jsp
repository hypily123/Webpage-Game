<%-- 
    Document   : GM_Main
    Created on : Apr 7, 2021, 12:41:21 PM
    Author     : Jian Xiao
--%>
<%--
div center;
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GM Main Page</title>
    </head>
    <body>
        <div style="display: flex;align-items: center;justify-content: center;border:1px solid #000">
            <form name="Login.htm" action="Login.htm" method="GET">
                <input type="submit" value="Log out ">
            </form>
        </div>
        <c:if test="${msg != null}">
            <c:out value="${msg}"/>
        </c:if>
        <h3 align="center">Game Content</h3>
        <div style="display: flex;align-items: center;justify-content: center; border:1px solid #000">
            <div>
                <form name="GM_Main.htm" action="GM_Main.htm"" method="POST">
                    <input type="hidden" name ="choice" value="monster"/>
                    <input type="submit" value="Monsters"/>
                </form>
            </div>
            <div >
                <form name="GM_Main.htm" action="GM_Main.htm"" method="POST">
                    <input type="hidden" name ="choice" value="dungeon"/>
                    <input type="submit" value="Dungeons"/>
                </form>
            </div>
            <div >
                <form name="GM_Main.htm" action="GM_Main.htm"" method="POST">
                    <input type="hidden" name ="choice" value="dungeon_monster"/>
                    <input type="submit" value="Dungeon-Monster Pairs"/>
                </form>
            </div>
            <div>
                <form name="GM_Main.htm" action="GM_Main.htm"" method="POST">
                    <input type="hidden" name ="choice" value="equipment"/>
                    <input type="submit" value="Equipment"/>
                </form>
            </div>
        </div>
    </body>
</html>

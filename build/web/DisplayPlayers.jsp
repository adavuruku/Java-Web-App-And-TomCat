<%-- 
    Document   : DisplayPlayers.jsp
    Created on : Sep 26, 2020, 7:01:03 PM
    Author     : SHERIFF
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List Of All Players</h1>
        <table border="1">
            
            <tr>
                <th>Rank</th>
                <th>Players</th>                
                <th>Team</th>
            </tr>
            <c:forEach var="cricketer" begin="0" items="${requestScope.playerList}">
                <tr>
                    <td>${cricketer.playerRank}</td>
                    <td>${cricketer.playerName}</td>
                    <td>${cricketer.playerTeam}</td>
                </tr>
            </c:forEach>
            

        </table>
        <a href="./addPlayers">Add New Player</a>
    </body>
</html>

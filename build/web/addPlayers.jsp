<%-- 
    Document   : addPlayers.jsp
    Created on : Sep 26, 2020, 7:08:59 PM
    Author     : SHERIFF
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add More Players</h1>
        <form action="addPlayers" method="post" id="addNewPlayersForm">
            <table>
                <tr>
                    <td>Enter Rank </td>
                    <td><input type="text" name="playerRank" id="rank"/></td>
                </tr>
                <tr>
                    <td>Enter Player Name </td>
                    <td><input type="text" name="playerName" id="playerName"/></td>
                </tr>
                <tr>
                    <td>Enter Player Team </td>
                    <td><input type="text" name="playerTeam" id="team"/></td>
                </tr>
            </table>
            <input type="submit" value="CreateRecord" id="Create Record" />
        </form>
        <br/>
        <a href="./displayPlayers">View List</a>
    </body>
</html>

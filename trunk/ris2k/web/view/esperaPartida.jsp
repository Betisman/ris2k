<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Partidas Creadas</title>
    </head>
    <body>
        <%@page import ="java.util.*"%>
        <%@ page import="model.Jugador" %>
        <%@ page import="model.Partida" %>
        
        <%Partida partida = (Partida)request.getAttribute("partida");%>

    <h1>Partida <%=partida.getNombre()%></h1>
        <p>Nombre: <%=partida.getNombre()%></p>
        <p>Creador: <%=partida.getOwner().getUser()%></p>
        <p>Mapa: <%=partida.getTablero().getMapa()%></p>
        <p>Número de jugadores máximo: <%=partida.getNumJugadores()%></p>
        <p>Jugadores actualmente conectados: <%=partida.getJugadores().size()%></p>
        <table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%">
          <%int i = 0; for(Jugador j : partida.getJugadores()){%>
            <tr>
            <td width="5%"><%=i+1%>.</td>
            <td width="40%"><%=j.getUser()%></td>
            <td width="50%"><%=j.getEmail()%></td>
            <td width="5%"><%=j.getColor()%></td>
          </tr>
          <%i++;}%>
        </table>
    </body>
</html>
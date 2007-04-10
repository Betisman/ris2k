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
        <%@ page import="java.util.List" %>
        <%@ page import="model.Jugador" %>
        <%@ page import="model.Partida" %>
        
        <jsp:useBean id="partidasBean" scope="application" class="java.util.List" />
        <%List<Partida> partidas = (List)partidasBean;%>
        

    <h1>Lista de partidas creadas</h1>
        <table border="2">
            <thead>
                <tr>
                    <th>Nombre Partida</th>
                    <th>Creador</th>
                    <th>Num Jugadores</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <% for(Partida partida : partidas){ %>
                    <tr>
                        <td><%=partida.getNombre()%></td>
                        <td><%=partida.getOwner().getUser()%></td>
                        <td align="center"><%=partida.getNumJugadores()%></td>
                        <td align="center"><a href="anadirJugadorPartida?partida=<%=partida.getIdPartida()%>">Unirse a la partida</a></td>
                        <td><a href="view/tableroMenu.jsp">Ir a la partida</a></td>
                    </tr>
                <%}%>
            </tbody>
        </table>      
    
    
    </body>
</html>

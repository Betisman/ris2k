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

    <h1>Partidas Creadas</h1>
    <jsp:useBean id="partida" scope="session" class="model.Partida" />
    <jsp:useBean id="creador" scope="application" class="model.Jugador" />
    <%creador = partida.getOwner();%>
<!-- está programado para una sola partida, NO para una colección de partidas -->        
        <table border="2">
            <thead>
                <tr>
                    <th>Nombre Partida</th>
                    <th>Creador</th>
                    <th>Num Jugadores</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><%=partida.getNombre()%></td>
                    <td><%=creador.getUser()%> o <%=partida.getOwner().getUser()%></td>
                    <td align="center"><%=partida.getNumJugadores()%></td>
                </tr>
            </tbody>
        </table>      
    
    
    </body>
</html>

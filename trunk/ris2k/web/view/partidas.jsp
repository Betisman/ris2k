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
    <body background="/ris2k/images/Fondo.jpg">
        <%@page import ="java.util.*"%>
        <%@ page import="model.Jugador" %>
        <%@ page import="model.Partida" %>
        
        <%List<Partida> partidas = (List)request.getAttribute("partidas");%>
        
   <table width="100%" height="430" border="0">
  <tr>
    <td width="15%" height="112">&nbsp;</td>
    <td width="73%"><div align="center">
        <p><img src="/ris2k/images/partidascreadas.jpg" width="510" height="159"></p>
        <p><strong><font size="+1" face="Georgia, Times New Roman, Times, serif">Actualmente 
          hay <%=partidas.size()%> partidas creadas</font></strong></p>
      </div></td>
    <td width="12%">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>
	<table border="2" bgcolor="#CCCCCC" align="center">
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
                        <td align="center"><%=partida.getJugadores().size()%>/<%=partida.getNumJugadores()%></td>
                        <td align="center"><a href="AnadirJugadorAPartida?partida=<%=partida.getIdPartida()%>">Unirse a la partida</a></td>
                        <td align="center"><a href="VerPartida?partida=<%=partida.getIdPartida()%>">Ver la partida</a></td>
                    </tr>
                <%}%>
            </tbody>
        </table> 
    </td>
    <td>&nbsp;</td>
  </tr>
</table>
</body>
</html>

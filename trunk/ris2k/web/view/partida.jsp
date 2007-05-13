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
        
        <%Partida partida = (Partida)request.getAttribute("partida");%>

    <table width="100%" height="430" border="0">
  <tr>
    <td width="15%" height="112">&nbsp;</td>
    <td width="73%"><div align="center">
        <p><font size="+1"><strong>Has creado una nueva partida</strong></font></p>
        <p><font size="+4" face="Georgia, Times New Roman, Times, serif" color="#660099"><strong><%=partida.getNombre()%></strong></font></p>
        </div></td>
    <td width="12%">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><table width="80%" height="100%" border="0" align="center">
        <tr> 
            <td><p><font size="+1" color="#000000"><strong>Nombre: <font color= "#993333"><%=partida.getNombre()%> </font></strong></font></p>
            <p><strong><font color="#000000" size="+1">Creador: <font color= "#993333"><%=partida.getOwner().getUser()%></font></font></strong></p>
            <p><strong><font color="#000000" size="+1">Mapa: <font color= "#993333"><%=partida.getTablero().getMapa()%></font></font></strong></p>
            <p><strong><font color="#000000" size="+1">N&uacute;mero m&aacute;ximo 
              de jugadores: <font color= "#993333"><%=partida.getNumJugadores()%></font></font></strong></p>
            <p><strong><font color="#000000" size="+1">Jugadores actualmente conectados 
              a la partida: <font color= "#993333"><%=partida.getJugadores().size()%></font></font></strong></p></td>
        </tr>
        <tr> 
          <td height="89"> 
            <table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%" bgcolor="#CCCCCC">
              <%int i = 0; for(Jugador j : partida.getJugadores()){%>
              <tr> 
                <td><%=i+1%>.</td>
                <td><%=j.getUser()%></td>
                <td><%=j.getEmail()%></td>
                <td><%=j.getColor()%></td>
              </tr>
              <%i++;}%>
            </table></td>
        </tr>
      </table></td>
    <td>
		<% Jugador j = (Jugador)request.getSession().getAttribute("usuario");
        request.setAttribute("partida", partida);%>
        
        <%if ((partida.estaJugador((Jugador)request.getSession().getAttribute("usuario"))) && (partida.getNumJugadores()==partida.getJugadores().size())){ %>
        <!--<form name="frmJugar" action="view/tableroMenu.jsp">-->
        <form name="frmJugar" action="/InicioPartida">
            <input type="submit" value="Jugar!!" name="btnJugar"/>
        </form>
        <%}%>
	</td>
  </tr>
</table>

</body> 
</body>
</html>
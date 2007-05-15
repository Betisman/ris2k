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
		
<table width="100%" height="462" border="0">
  <tr>
    <td width="14%" height="92">&nbsp;</td>
    <td width="69%"><div align="center"><font size="+3" face="Georgia, Times New Roman, Times, serif"><strong> 
        Partida: <%=partida.getNombre()%></strong></font> </div></td>
    <td width="17%">
     </td>
  </tr>
  <tr>
    <td height="198">&nbsp;</td>
    <td bordercolor="#666666"> 
      <table width="70%" height="141" border="2" align="center" bordercolor="#333333" bgcolor="#9999FF">
        <tr>
          
          <td width="78%">
		    <p><font size="+1">Nombre: <%=partida.getNombre()%></font></p>
            <p><font size="+1">Creador: <%=partida.getOwner().getUser()%></font></p>
            <p><font size="+1">Mapa: New York City (by Weil)</font></p>
            <p><font size="+1">N&uacute;mero m&aacute;ximo de jugadores: 
              <%=partida.getNumJugadores()%></font></p>
            <p><font size="+1">Jugadores actualmente unidos a la partida: 
              <%=partida.getJugadores().size()%></font></p></td>
          
        </tr>
      </table>
    </td>
    <td>
    </td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><table width="100%" height="183" border="0">
        <tr>
          <td height="107">
		 <table border="2" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#666666" width="100%">
          <%int i = 0; for(Jugador j : partida.getJugadores()){%>
            <tr>
            <td bgcolor="#CCCCCC"><%=i+1%>.</td>
            <td bgcolor="#CCCCCC"><%=j.getUser()%></td>
            <td bgcolor="#CCCCCC"><%=j.getEmail()%></td>
            <td bgcolor="<%=j.getColor()%>" style=""><font color="<%=j.getColor()%>">.</font></td>
          </tr>
          <%i++;}%>
        </table>
		  </td>
        </tr>
        
      </table> </td>
    <td>
	<% Jugador j = (Jugador)request.getSession().getAttribute("usuario");
        request.getSession().setAttribute("partida", partida); %>
        
        <%if ((partida.estaJugador((Jugador)request.getSession().getAttribute("usuario"))) && (partida.getNumJugadores()==partida.getJugadores().size())){ %>
        <form name="frmJugar" action="InicioPartida">
            <input type="submit" value="Jugar!!"/>
        </form>
        <%}%>

	</td>
  </tr>
</table>
</body>
</html>
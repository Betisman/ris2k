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
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Usuario ingresado correctamente</title>
<style type="text/css">
<!--
.Estilo7 {font-family: Georgia, "Times New Roman", Times, serif; font-size: xx-large; font-weight: bold; }
-->
</style>
</head>

<body background="/ris2k/images/Fondo.jpg">
<div align="center"><strong></strong>
  <table width="777" border="0">
    <tr>
      <td colspan="5"><div align="right"><strong>${sessionScope["jugador"]} </strong><a href="Logout.java">logout</a></div></td>
    </tr>
    <tr>
      <td colspan="5"><div align="center">
        <p><img src="/ris2k/images/ris2kmenu.jpg" width="220" height="116"></p>
        <p>&nbsp;</p>
      </div></td>
    </tr>
    <tr>
      <td width="111">&nbsp;</td>
      <td width="101"><div align="center"><a href="/ris2k/view/nuevaPartida.jsp"><img src="/ris2k/images/canonpeq.gif" width="88" height="70" border="0"></a></div></td>
      <td colspan="3"><span class="Estilo7">CREAR UNA NUEVA PARTIDA</span></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><div align="center"><a href="/ris2k/ListarPartidas"><img src="/ris2k/images/infanteriapeq.gif" width="70" height="70" border="0"></a></div></td>
      <td colspan="3"><span class="Estilo7">ENTRAR EN UNA PARTIDA</span></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><div align="center"><a href="/ris2k/view/hallOfFameForm.jsp"><img src="/ris2k/images/caballeriapeq.gif" width="70" height="70" border="0"></a></div></td>
      <td colspan="3"><span class="Estilo7">HALL OF FAME </span></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><div align="center"><a href="/ris2k/view/instrucciones.jsp"><img src="/ris2k/images/reglas.gif" width="70" height="70" border="0"></a></div></td>
      <td colspan="3"><span class="Estilo7">REGLAS DE R<em>IS2</em>K</span></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td colspan="2">&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td><div align="left"><a href="/ris2k/view/jugadoresEnLinea.jsp">Jugadores en l&iacute;nea </a></div></td>
      <td>&nbsp;</td>
      <td colspan="2"><div align="rigth"><a href="/ris2k/view/ayudaForm.jsp">Ayuda</a></div></td>
      <td width="241"><div align="rigth"><a href="/ris2k/view/acercaDeForm.jsp">Acerca de R<em>IS2</em>K </a></div></td>
    </tr>
  </table>
  </div>

    
    <%--
    This example uses JSTL, uncomment the taglib directive above.
    To test, display the page like this: index.jsp?sayHello=true&name=Murphy
    --%>
    <%--
    <c:if test="${param.sayHello}">
        <!-- Let's welcome the user ${param.name} -->
        Hello ${param.name}!
    </c:if>
    --%>
    
</body>
</html>

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
        <title>RIS2K</title>
<style type="text/css">
<!--
.Estilo14 {
	font-size: 36pt;
	font-family: Georgia, "Times New Roman", Times, serif;
}
.Estilo15 {
	color: #FF0000;
	font-weight: bold;
}
.Estilo16 {
	color: #0000FF;
	font-style: italic;
}
.Estilo18 {color: #009933}
.Estilo19 {font-family: Georgia, "Times New Roman", Times, serif; font-size: large; }
.Estilo21 {
	font-size: x-large;
	font-weight: bold;
}
-->
</style>
</head>

<body background="images/Fondo.jpg">
  
<table width="90%" height="90%" border="0" align="center" cellspacing="5">
  <tr>
    <td width="34%" height="120">&nbsp;</td>
    <td width="29%"><div align="center"><span class="Estilo14"><span class="Estilo15">R</span><span class="Estilo16">IS2</span><span class="Estilo18">K</span></span></div></td>
    <td width="37%" valign="top"><div align="right" id="jugador"><strong>Bienvenido${sessionScope["jugador"]}</strong></div></td>
  </tr>
  
  <tr>
    <td height="184" align="center" valign="top">
<p class="Estilo19">&iquest;C&oacute;mo se juega al Ris2k? </p>
      <form id="form1" name="form1" method="post" action="view/instrucciones.jsp">
        <label>
          <input name="Submit" type="submit" value="Reglas del juego" />
        </label>
      </form>
      
    </td>
    <td>&nbsp;</td>
    <td><table width="100%" height="191" border="2">
        <tr> 
          <td height="28" bgcolor="#CCCCCC"><div align="center" class="Estilo19">Acceso Jugador</div></td>
        </tr>
        <tr> 
          <td height="155"> 
            <form name="form3" id="form3" method="post" action="/ris2k/accesoServlet">
              <p align="center" class="Estilo19">Usuario 
                <input type="text" name="user" id="user" />
              </p>
              <p align="center" class="Estilo19">Contrase&ntilde;a 
                <input type="password" name="password" id="password" />
              </p>
              <p align="center"> 
                <input type="submit" name="Submit3" value="Enviar" />
              </p>
            </form>
            
          </td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td align="center" valign="baseline"><p><span class="Estilo21">Sitio en construcci&oacute;n</span></p>
    <p><img src="images/construccion.gif" alt="En construcci&oacute;n" width="294" height="208" /></p></td>
    <td>&nbsp;</td>
    <td valign="top"><p align="center" class="Estilo19">Usuarios no registrados</p>
    <form id="form2" name="form2" method="post" action="view/altaForm.jsp">
      <label>
        <div align="center">
          <input type="submit" name="Submit2" value="Registrarse" />
        </div>
      </label>
    </form>    <p>&nbsp; </p></td>
  </tr>
</table>
    </body>
</html>

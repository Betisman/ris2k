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
    <title>Documento sin t&iacute;tulo</title>
    <style type="text/css">
    <!--
    .Estilo1 {color: #FF0000}
    .Estilo2 {
            color: #0000FF;
            font-style: italic;
    }
    .Estilo4 {color: #006600}
    .Estilo6 {
            font-family: Verdana, Arial, Helvetica, sans-serif;
            font-weight: bold;
            color: #FF0000;
            font-size: 22px;
    }
    .Estilo7 {font-weight: bold; font-family: Georgia, "Times New Roman", Times, serif; font-size: 48px; }
    -->
    </style>
    </head>

    <body bgcolor="#FFFF99">
    <table border="0" align="center">
      <tr>
        <td height="58" valign="top"><p align="center" class="Estilo7"><img src="/ris2k/images/construccionpeq.gif" width="137" height="96" /></p>      </td>
        <td height="58" colspan="2" valign="middle"><div align="center"></div></td>
        <td height="58" align="left" valign="middle"><div align="left">
          <form id="form1" name="form1" method="post" action="/ris2k/index.jsp">
            <label></label>


              <div align="center">
                <input type="submit" name="Submit" value="Volver al men&uacute; principal"/>
              </div>
          </form>
          </div></td>
      </tr>
      <tr>
        <td height="21" colspan="4"><div align="center"><img src="/ris2k/images/reglasdeljuego.jpg" width="510" height="159"></div></td>
      </tr>
      <tr>
        <td width="26%" height="21">&nbsp;</td>
        <td width="26%">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="21" colspan="2"><p><strong><u>NORMAS QUE HAY QUE CUMPLIR ANTES DE JUGAR:</u></strong></p></td>
        <td width="7%">&nbsp;</td>
        <td width="41%">&nbsp;</td>
      </tr>
      <tr>
        <td height="57" colspan="2"><p align="justify"><strong>1. Cuando alguien accede al juego por primera vez, lo primero que debe hacer es registrarse como jugador.</strong></p></td>
        <td height="60" rowspan="3">&nbsp;</td>
        <td height="60" rowspan="3"><img src="/ris2k/images/reglas1.jpg" width="300" height="233" /></td>
      </tr>
      <tr>
        <td height="57" colspan="2"><p align="justify"><strong>2. Si el jugador est&aacute; ya registrado, deber&aacute; loguearse en el sistema para poder acceder a las partidas.</strong></p></td>
      </tr>
      <tr>
        <td height="108" colspan="2"><p><strong>3. Una vez logueado, un jugador tendr&aacute; dos opciones:</strong></p>
            <blockquote>
              <p><strong> - Crear una partida nueva.</strong></p>
              <p><strong>- Ingresar en una partida ya creada. </strong></p>
            </blockquote></td>
      </tr>
    </table>
    </body>
</html>

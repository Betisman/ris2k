<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true" %>
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
<title>Alta Jugador</title>
<style type="text/css">    
<!--
.Estilo14 {
	font-size: 36pt;
	font-family: Georgia, "Times New Roman", Times, serif;
        color: #FF0000
}
.Estilo15 {
        font-size: 36pt;
	color: #00CC00;
	
}
.Estilo16 {
        font-size: 36pt;
	color: #0000FF;
}
.Estilo18 {
        font-size: 36pt;
        color: #FF9900
}
.Estilo19 {font-family: Georgia, "Times New Roman", Times, serif; font-size: large; }
-->
</style>
</head>
<body background="/ris2k/images/Fondo.jpg">

<table width="90%" height="399" align="center">
    <tr>
    <td height="79"><div align="center"><span class="Estilo14">Alta</span><span class="Estilo15"> de</span><span class="Estilo16"> un</span><span class="Estilo18"> Jugador </span></div></td>
    </tr>
    <tr>
        <td height="172"><p>&nbsp;</p>
            <table width="45%" height="118" border="1" align="center" bordercolor="#666666" bgcolor="#CCCCCC">
                <tr>
                    <td width="44%"><p class="Estilo19">Nombre de Usuario</p>
                        <p class="Estilo19">Contrase&ntilde;a</p>
                        <p class="Estilo19">E-mail</p>
                        <p>&nbsp;</p>
                        <p>&nbsp;</p>
                    </td> 
                    <td width="56%"><div align="right"> 
                            <form name="form1" id="form1" method="post" action="/ris2k/altaServlet">
                                <p align="left">
                                    <input name="user" type="text" id="user"/>
                                </p>
                                <p align="left">
                                    <input name="password" type="password" id="password"/>
                                </p>
                                <p align="left">
                                    <input name="email" type="text" id="email"/>
                                </p>
                                <p align="left">
                                    <input type="submit" name="Submit" value="Enviar datos" />
                                </p>
                            </form>
                    </div></td>
                </tr>
            </table>
          <div align="right"></div>
         <div align="center"></div></td>
    </tr>  
    <tr>
        <td align="center">
            <p class="Estilo19" align="center">Normas para darse de alta</p>
            <p align="center">1. Introduzca un nombre de usuario (sin espacios)</p>
            <p align="center">2. Introduzca una contraseña de al menos 6 caracteres</p>
            <p align="center">3. Introduzca una dirección de correo electrónico válida</p>
        </td>
  </tr>
</table>
</body>
</html>
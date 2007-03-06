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
.Estilo2 {font-family: Georgia, "Times New Roman", Times, serif}
.Estilo4 {
	font-size: xx-large;
	color: #000000;
	font-weight: bold;
}
.Estilo6 {font-family: Georgia, "Times New Roman", Times, serif; font-weight: bold; }
-->
</style>
</head>
<body background="images/Fondo.jpg">


<table width="93%" height="399" align="center">
    <tr>
        <td height="79"><div align="center"><span class="Estilo4 Estilo2"><strong>Alta 
        de un Jugador</strong> </span></div></td>
    </tr>
    <tr>
        <td height="172"><p>&nbsp;</p>
            <table width="45%" height="118" border="1" align="center" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
                <tr>
                    <td width="44%"><p>Nombre de Usuario</p>
                        <p>Contrase&ntilde;a</p>
                        <p>E-mail</p>
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
        <!--<td bordercolor="1">
        </td>-->


 <!-- <p class="Estilo2">To do:</p>
      <p class="Estilo2">Disclaimer</p>
      <p> ...</p>
    <p>&nbsp;</p></td> -->
  </tr>
</table>
</body>
</html>
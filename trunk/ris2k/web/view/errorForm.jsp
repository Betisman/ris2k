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
<title>Error al Acceder</title>
<style type="text/css">
<!--
.Estilo1 {font-family: Georgia, "Times New Roman", Times, serif}
.Estilo2 {
	font-family: Georgia, "Times New Roman", Times, serif;
	font-size: 36px;
	font-weight: bold;
}
.Estilo3 {
	font-family: Georgia, "Times New Roman", Times, serif;
	font-size: 18px;
	font-weight: bold;
	color: #000000;
}
.Estilo4 {color: #0000FF}
.Estilo5 {color: #000000}
-->
</style>
</head>

<body background="images/Fondo.jpg">
    <div align="center" class="Estilo2">
      <p>ERROR</p>
    </div>
    <h1 align="center" class="Estilo1"><img src="images/error.jpg" alt="Error" width="97" height="102" /></h1>
    <p align="center" class="Estilo1">&nbsp;</p>
    <p align="center" class="Estilo3 Estilo5">Ha surgido el siguiente error: </p>
    <p align="center" class="Estilo3">${sessionScope["errorRis2k"]} </p>
    <form id="form1" name="form1" method="post" action="view/altaForm.jsp"> 
      <div align="center" class="Estilo4"></div>
      <span class="Estilo4">
      <label>  </label>
      </span>
      <label><div align="center"><br />
        <FORM><INPUT TYPE="button" VALUE="VOLVER" onClick="history.go(-1);return true;"> </FORM>
      </div>
      </label>
    </form>    
</body>
</html>

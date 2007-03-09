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
<title>Alta usuario correcta</title>
<style type="text/css">
<!--
.Estilo1 {
	font-family: Georgia, "Times New Roman", Times, serif;
	font-size: large;
	font-weight: bold;
}
-->
</style>
</head>

<body background="images/Fondo.jpg">
<div align="center">
  <p class="Estilo1">&iexcl;Bienvenido!</p>
  <p class="Estilo1">Has accedido correctamente </p>
  <p><img src="images/Smiley_head_happy.png" alt="Acceso correcto!!" width="152" height="151" />      </p>
  <p>&nbsp;</p>
  <p>TO DO:</p>
  <p>Aqu&iacute; ir&iacute;a el men&uacute; principal...  </p>
  <p>Volver al menú principal</p>
  <form id="form1" name="form1" method="post" action="">
    <label>
      <!-- <input type="submit" name="Submit" value="Ver tablero" action="/tablero.html"/> -->
      <FORM><INPUT TYPE="BUTTON" VALUE="Volver al menú principal" ONCLICK="window.location.href='index.jsp'">
      </FORM>
    </label>
  </form>
  <p>&nbsp; </p>
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

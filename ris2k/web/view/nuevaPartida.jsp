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
        <title>JSP Page</title>
        <style type="text/css">
<!--
.Estilo4 {font-size: 36px; font-weight: bold; color: #990000; }
-->
        </style>
</head>
    <body background="/ris2k/images/Fondo.jpg">
    <p align="center"><img src="/ris2k/images/nuevapartida.jpg" width="510" height="159"></p>
    <p align="center">
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
    </p>
    <form name="nuevaPartida" action="/ris2k/CrearPartida" method="POST">
        <p align="center" class="Estilo4">Nombre de la partida</p>
        <p align="center">
          <input type="text" name="nombrePartida" value="" />
        </p>
        <p align="center"><span class="Estilo4">Número de jugadores</span>  
          <select name="numJugadores">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
          </select>
        </p>
        <p align="center" class="Estilo4">Tablero</p>
        <p align="center">
          <input type="text" name="tablero" value="newYork by Weil" readonly="readonly" />
      </p>
        <p align="center">          <br>
          <input type="submit" value="Aceptar" name="btnCrearPartida" />
          </p>
    </form>
    </body>
</html>

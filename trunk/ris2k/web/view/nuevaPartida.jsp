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
    </head>
    <body>

    <h1>Nueva Partida</h1>
    
    <%--
    This example uses JSTL, uncomment the taglib directive above.
    To test, display the page like this: index.jsp?sayHello=true&name=Murphy
    --%>
    <%--
    <c:if test="${param.sayHello}">
        <!-- Let's welcome the user ${param.name} -->
        Hello ${param.name}!
    </c:if>
        --%><form name="nuevaPartida" action="/ris2k/CrearPartida" method="POST">
        Nombre de la partida: <input type="text" name="nombrePartida" value="" /><br>
        Numero de jugadores: <select name="numJugadores">
            <option>1</option>
            <!--<option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>-->
        </select><br>
        Tablero: <input type="text" name="tablero" value="newYork by Weil" readonly="readonly" />
        <br><input type="submit" value="Aceptar" name="btnCrearPartida" />
    </form>
    </body>
</html>

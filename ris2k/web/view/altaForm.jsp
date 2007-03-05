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
 <title>ALTA RIS2K</title>
</head>
<body bgcolor="#33CCFF">
 <font face="Times New Roman,Times" size="+3">
  ALTA RIS2K
 </font>
 <hr><p>
 <center>
 <form name="formulario" 
   action="/ris2k/altaServlet" 
   method="POST" > 
 	User: <input type="text" name="user" value="" /><BR>
        Password: <input type="password" name="password" value="" /><BR>
        Email: <input type="text" name="email" value="" /><BR>    
 <input type="submit" name="Submit" value="Insertar datos">
 </form>
 </center> 
</body>
</html>
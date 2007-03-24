<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html>
    <head>
        <link rel="stylesheet" href="jmaki-right-sidebar.css" type="text/css"></link>
        <title>RIS2K</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    </head>
    <body background="/ris2k/images/Fondo.jpg">
        <div class="outerBorder">
            
            <div class="header">
                <div class="banner">RIS2K</div>
                <div class="subheader">
                    
                    <div>
                        <a href="/ris2k/index.jsp">Página Inicial</a> |
                        <a href="menuForm.jsp">Menú principal</a> |
                        <a href="#">Logout</a>
                    </div>
                    
                </div> <!-- subheader -->
            </div> <!-- header -->

            <div class="main">
                
                <div class="rightSidebar" style="height:700px">
                    <table border="1" width="100%" heigth="700px" bgcolor="#CCCCCC">
                        <thead>
                            <tr>
                                <th>MENÚ</th>
                            </tr>
                        </thead>
                        <tbody>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th bgcolor="#FF9933">COLOCAR EJÉRCITOS</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td bgcolor="#FFCC33">
                                            Número total de ejércitos:
                                            <strong>${sessionScope["Ejercitos"]} </strong>
                                           
                                            <form name="ColocacionForm" action="/ris2k/actualizacionJugada">
                                                Colocar en territorio
                                                <input type="text" name="Territorio" id="territorio" />
                                                
                                                Número de ejércitos
                                                <input type="text" name="NumEjercitos" id="numEjercitos" />
                                                
                                                <input type="submit" value="ENVIAR" name="enviarColocacion" />
                                                
                                            </form> 
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th bgcolor="#339900">REALIZAR ATAQUE</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td bgcolor="#33CC33">
                                            <form name="RealizarAtaqueForm" action="actualizacionJugada">
                                                <p>Atacar de territorio</p>
                                                <input type="text" name="territorioAtacante"/>   
                                                <p>a territorio</p>
                                                <input type="text" name="territorioDefensor"/>
                                                <p>con número de ejércitos</p>
                                                <input type="text" name="NumEjercitos"/>
                                                
                                                <input type="submit" value="ENVIAR" name="enviarAtaque" />
                                            </form> 
                                        </td>
                                    </tr>
                                </tbody>
                            </table>         
                        </tbody>
                    </table>
                    <table border="1">
                                <thead>
                                    <tr>
                                        <th bgcolor="#FF00FF">RECOLOCAR EJÉRCITOS</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td bgcolor="#FF66FF">
                                            <form name="RecolocacionForm" action="/ris2k/actualizacionJugada">
                                                Mover de territorio
                                                <input type="text" name="TerritorioA" id="territorioA" />
                                                
                                                 a territorio
                                                <input type="text" name="TerritorioB" id="territorioB" />
                                                
                                                Número de ejércitos
                                                <input type="text" name="NumEjercitos" id="numEjercitos" />
                                                
                                                <input type="submit" value="ENVIAR" name="enviarColocacion" />
                                                
                                            </form> 
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                    
                   
                    
                </div> <!-- rightSidebar -->
        
                <div class="content" style="height:700px">
                    <!--<img src="Tablero1024.JPG" width="100%" height="100%" alt="Tablero1024"/>-->
                    <EMBED SRC="../images/tablero.svg" WIDTH="100%" HEIGHT="100%" pluginspage="http://www.adobe.com/svg/viewer/install/"/>
                    
                   
                </div> <!-- content -->

            </div> <!-- main -->
      
        </div> <!-- outerborder -->
    </body>
</html>

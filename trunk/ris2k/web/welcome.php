<html>
<body>


<?php

    // Primero comprobamos que ningún campo esté vacío y que todos los campos existan.
    if(isset($_POST['name']) && !empty($_POST['name']) &&
    isset($_POST['lastname']) && !empty($_POST['lastname']) &&
	isset($_POST['email']) && !empty($_POST['email'])) {

        // Si entramos es que todo se ha realizado correctamente


        BIENVENIDO: <?php echo $_POST["name"];   ?> <?php echo $_POST["lastname"]; ?><br />
        SU EMAIL:  <?php echo $_POST["email"];   ?> 

        $link = mysql_connect("localhost:3306","prueba","prueba");
        mysql_select_db("ris2k",$link);

        // Con esta sentencia SQL insertaremos los datos en la base de datos
        mysql_query("INSERT INTO user (name,lastname,email)
        VALUES ('{$_POST['name']}','{$_POST['lastname']}','{$_POST['email']}')",$link);

        // Ahora comprobaremos que todo ha ido correctamente
        $my_error = mysql_error($link);

        if(!empty($my_error)) {
			
            echo "<br>Ha habido un error al insertar los valores. $my_error"; 

        } else {
			
            echo "<br>Los datos han sido introducidos satisfactoriamente";

        }

    } else {
		
        echo "<br>Error, no ha introducido todos los datos";
    }

?>
</body>
</html>
<?php
$connection = mysqli_connect("wagstore.mysql.uhserver.com","wagstore","8g6A@8B2s");
$db = mysqli_select_db($connection, 'wagstore');


    if(isset($_POST['updatedata']))
    {   
        $id = $_POST['update_id'];
        
        $nome = $_POST['nome'];
        $email = $_POST['email'];
        $senha = $_POST['senha'];
        $niveis_acesso_id = $_POST['niveis_acesso_id'];

        $query = "UPDATE usuarios SET nome='$nome', email='$email', senha='$senha', niveis_acesso_id=' $niveis_acesso_id' WHERE id='$id'  ";
        $query_run = mysqli_query($connection, $query);

        if($query_run)
        {
            header("Location:usuarios.php");
        }
        else
        {
            echo '<script> alert("Data Not Updated"); </script>';
        }
    }
?>
<?php
$connection = mysqli_connect("wagstore.mysql.uhserver.com","wagstore","8g6A@8B2s");
$db = mysqli_select_db($connection, 'wagstore');

    if(isset($_POST['updatedata']))
    {   
        $id = $_POST['update_id'];
        
        $nome = $_POST['nome'];
        $sobrenome = $_POST['sobrenome'];
        $cpf = $_POST['cpf'];
        $email = $_POST['email'];
        $endereco = $_POST['endereco'];
        $cidade = $_POST['cidade'];
        $estado = $_POST['estado'];
        $cep = $_POST['cep'];
    

        $query = "UPDATE clientes SET nome='$nome', sobrenome='$sobrenome', cpf='$cpf', email='$email', endereco='$endereco', cidade='$cidade', estado='$estado', cep='$cep' WHERE id='$id' ";
        $query_run = mysqli_query($connection, $query);

        if($query_run)
        {
            header("Location:clientes.php");
        }
        else
        {
            echo '<script> alert("Data Not Updated"); </script>';
        }
    }
?>
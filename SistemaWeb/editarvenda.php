<?php
$connection = mysqli_connect("wagstore.mysql.uhserver.com","wagstore","8g6A@8B2s");
$db = mysqli_select_db($connection, 'wagstore');


    if(isset($_POST['updatedata']))
    {   
        $id = $_POST['update_id'];
        
            $nome = $_POST['nome'];
            $cpf = $_POST['cpf'];
            $email = $_POST['email'];
            $telefone = $_POST['telefone'];
            $endereco = $_POST['endereco'];
            $produtoAquirido = $_POST['produtoAquirido'];

        $query = "UPDATE vendas SET nome='$nome', cpf='$cpf', email='$email', telefone='$telefone', endereco='$endereco', produtoAquirido='$produtoAquirido' WHERE id='$id'  ";
        $query_run = mysqli_query($connection, $query);

        if($query_run)
        {
            header("Location:vendas.php");
        }
        else
        {
            echo '<script> alert("Data Not Updated"); </script>';
        }
    }
?>
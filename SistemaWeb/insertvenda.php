<?php

$connection = mysqli_connect("wagstore.mysql.uhserver.com","wagstore","8g6A@8B2s");
$db = mysqli_select_db($connection, 'wagstore');


if(isset($_POST['insertdata']))
{
    $nome = $_POST['nome'];
    $cpf = $_POST['cpf'];
    $email = $_POST['email'];
    $telefone = $_POST['telefone'];
    $endereco = $_POST['endereco'];
    $produtoAquirido = $_POST['produtoAquirido'];

    $query = "INSERT INTO vendas (`nome`,`cpf`,`email`,`telefone`,`endereco`,`produtoAquirido`) VALUES ('$nome','$cpf','$email','$telefone','$endereco','$produtoAquirido')";
    $query_run = mysqli_query($connection, $query);

    if($query_run)
    {
        header('Location: vendas.php');
    }
    else
    {
        echo '<script> alert("Usuário não cadatrados"); </script>';
    }
}

?>
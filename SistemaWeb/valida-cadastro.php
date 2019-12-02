<?php

$connection = mysqli_connect("wagstore.mysql.uhserver.com","wagstore","8g6A@8B2s");
$db = mysqli_select_db($connection, 'wagstore');


if(isset($_POST['insertdata']))
{
    $nome = $_POST['nome'];
    $sobrenome = $_POST['sobrenome'];
    $email = $_POST['email'];
    $endereco = $_POST['endereco'];
    $pais = $_POST['pais'];
    $estado = $_POST['estado'];
    $cep = $_POST['cep'];

    $query = "INSERT INTO clientes (`nome`,`sobrenome`,`email`,`endereco`,`pais`,`estado`,`cep`) VALUES ('$nome','$sobrenome','$email','$endereco','$pais','$estado','$cep')";
    $query_run = mysqli_query($connection, $query);

    if($query_run)
    {
        header('Location: clientes.php');
    }
    else
    {
        echo '<script> alert("Usuário não cadatrados"); </script>';
    }
}

?>
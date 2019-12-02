<?php

$connection = mysqli_connect("wagstore.mysql.uhserver.com","wagstore","8g6A@8B2s");
$db = mysqli_select_db($connection, 'wagstore');


if(isset($_POST['insertdata']))
{
    $nome = $_POST['nome'];
    $email = $_POST['email'];
    $senha = $_POST['senha'];
    $niveis_acesso_id = $_POST['niveis_acesso_id'];

    $query = "INSERT INTO usuarios (`nome`,`email`,`senha`,`niveis_acesso_id`) VALUES ('$nome','$email','$senha','$niveis_acesso_id')";
    $query_run = mysqli_query($connection, $query);

    if($query_run)
    {
        header('Location: usuarios.php');
    }
    else
    {
        echo '<script> alert("Usuário não cadatrados"); </script>';
    }
}

?>
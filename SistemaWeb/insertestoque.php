<?php

$connection = mysqli_connect("wagstore.mysql.uhserver.com","wagstore","8g6A@8B2s");
$db = mysqli_select_db($connection, 'wagstore');


if(isset($_POST['insertdata']))
{
    $marca = $_POST['marca'];
    $modelo = $_POST['modelo'];
    $cor = $_POST['cor'];
    $tamanho = $_POST['tamanho'];
    $quantidade = $_POST['quantidade'];

    $query = "INSERT INTO estoque (`marca`,`modelo`,`cor`,`tamanho`,`quantidade`) VALUES ('$marca','$modelo','$cor','$tamanho','$quantidade')";
    $query_run = mysqli_query($connection, $query);

    if($query_run)
    {
        header('Location: estoque.php');
    }
    else
    {
        echo '<script> alert("Usuário não cadatrados"); </script>';
    }
}

?>
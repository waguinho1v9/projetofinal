<?php
$connection = mysqli_connect("wagstore.mysql.uhserver.com","wagstore","8g6A@8B2s");
$db = mysqli_select_db($connection, 'wagstore');


    if(isset($_POST['updatedata']))
    {   
        $id = $_POST['update_id'];
        
        $marca = $_POST['marca'];
        $modelo = $_POST['modelo'];
        $cor = $_POST['cor'];
        $tamanho = $_POST['tamanho'];
        $quantidade = $_POST['quantidade'];

        $query = "UPDATE estoque SET marca='$marca', modelo='$modelo', cor='$cor', tamanho='$tamanho', quantidade='$quantidade' WHERE id='$id'  ";
        $query_run = mysqli_query($connection, $query);

        if($query_run)
        {
            header("Location:estoque.php");
        }
        else
        {
            echo '<script> alert("Data Not Updated"); </script>';
        }
    }
?>
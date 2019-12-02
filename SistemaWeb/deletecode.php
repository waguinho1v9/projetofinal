<?php
$connection = mysqli_connect("wagstore.mysql.uhserver.com","wagstore","8g6A@8B2s");
$db = mysqli_select_db($connection, 'wagstore');


if(isset($_POST['deletedata']))
{
    $id = $_POST['delete_id'];

    $query = "DELETE FROM usuarios WHERE id='$id'";
    $query_run = mysqli_query($connection, $query);

    if($query_run)
    {
        header("Location:usuarios.php");
    }
    else
    {
        echo '<script> alert("Data Not Deleted"); </script>';
    }
}

?>

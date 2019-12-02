<?php

include_once('conexao.php');

//PEGA OS DADOS ENVIADOS PELO FORMULÁRIO
$nome	=	$_POST["nome"];
$sobrenome	=	$_POST["sobrenome"];
$cpf	=	$_POST["cpf"];
$email	=	$_POST["email"];
$endereco	=	$_POST["rua"];
$cidade =	$_POST["cidade"];
$estado	=	$_POST["uf"];
$cep	=	$_POST["cep"];

$result_msg_contato = "INSERT INTO clientes(nome, sobrenome, cpf, email, endereco, cidade, estado, cep) VALUES ('$nome', '$sobrenome', '$cpf', '$email', '$endereco', '$cidade', '$estado', '$cep')";
$resultado_msg_contato= mysqli_query($conn, $result_msg_contato);

header('Location: compra-finalizada.php');

?>


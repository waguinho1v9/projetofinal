<?php
	$servidor = "wagstore.mysql.uhserver.com";
	$usuario = "wagstore";
	$senha = "8g6A@8B2s";
	$dbname = "wagstore";
	
	//Criar a conexao
	$conn = mysqli_connect($servidor, $usuario, $senha, $dbname);
	
	if(!$conn){
		die("Falha na conexao: " . mysqli_connect_error());
	}else{
		//echo "Conexao realizada com sucesso";
	}	
	
?>
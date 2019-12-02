  function validarSenhaForca(){
	var senha = document.getElementById('senhaForca').value;
	var forca = 0;
	/*Imprimir a senha*/
	/*document.getElementById("impSenha").innerHTML = "Senha " + senha;*/

	if((senha.length >= 4) && (senha.length <= 7)){
		forca += 10;
	}else if(senha.length > 8){
		forca += 100;
	}

	if((senha.length >= 5) && (senha.match(/[a-z]+/))){
		forca += 50;
	}

	if((senha.length >= 6) && (senha.match(/[A-Z]+/))){
		forca += 70;
	}

	if((senha.length >= 7) && (senha.match(/[@#$%&;*]/))){
		forca += 30;
	}

	if(senha.match(/([1-9]+)\1{1,}/)){
		forca += -25;
	}

	mostrarForca(forca);
}

function mostrarForca(forca){
	/*Imprimir a força da senha*/
	/*document.getElementById("impForcaSenha").innerHTML = "Força: " + forca;*/

	if(forca < 30 ){
		document.getElementById("erroSenhaForca").innerHTML = '<div class="progress"><div class="progress-bar bg-danger" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div></div>';
	}else if((forca >= 30) && (forca < 50)){
		document.getElementById("erroSenhaForca").innerHTML = '<div class="progress"><div class="progress-bar bg-warning" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div></div>';
	}else if((forca >= 50) && (forca < 70)){
		document.getElementById("erroSenhaForca").innerHTML = '<div class="progress"><div class="progress-bar bg-info" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div></div>';
	}else if((forca >= 70) && (forca < 100)){
		document.getElementById("erroSenhaForca").innerHTML = '<div class="progress"><div class="progress-bar bg-success" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div></div>';
	}
}
const inputLogin = document.getElementById('login');
const inputSenha = document.getElementById('senha');
const smallErro = document.getElementById('mensagem-erro');

function validarForm() {
	if(!validarLogin(inputLogin.value)){
		return false;
	}
	if(!validarSenha(inputSenha.value)){
		return false;
	}	
	return true;
}

function validarLogin(login) {
	smallErro.innerText = '';
	if(login === '' || login === null || login === undefined) {
		smallErro.innerText = 'Infome um login js';
		return false;
	}
	return true;
}

function validarSenha(senha){
	smallErro.innerText = '';
	if(senha === '' || senha === null || senha === undefined) {
		smallErro.innerText = 'Informe uma senha js';
		return false;
	}
	return true;
}
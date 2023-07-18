/**
 * 
 */		

const inputLogin = document.getElementById('login');
const inputSenha = document.getElementById('senha');
const inputNome = document.getElementById('nome');
const inputEmail = document.getElementById('email');
const inputTelefone = document.getElementById('telefone');
const inputLogradouro = document.getElementById('logradouro');
const inputNumero = document.getElementById('numero');
const inputBairro = document.getElementById('bairro');
const inputCidade = document.getElementById('cidade');
const inputEstado = document.getElementById('estado');
const inputCep = document.getElementById('cep');
const inputFoto = document.getElementById('foto');
const inputCurriculo = document.getElementById('curriculo');
const smallErro = document.getElementById('mensagem-erro');
let cepResult;

inputCep.addEventListener('focusout', () => {
	if(validarCEP(inputCep.value)){
		fetch(`https://viacep.com.br/ws/${inputCep.value}/json/`)
			.then(response => response.json())
			.then(result => {
				if(result.erro === true) {
					smallErro.innerText = 'CEP não encontrado'
				}else{
					inputLogradouro.value = result.logradouro;
					inputBairro.value = result.bairro;
					inputCidade.value = result.localidade;
					inputEstado.value = result.uf;
				}
			});
	}
})

	
function validarForm() {
	if(!validarLogin(inputLogin.value)){
		return false;
	}
	if(!validarSenha(inputSenha.value)){
		return false;
	}
	if(!validarNome(inputNome.value)){
		return false;
	}
	if(!validarEmail(inputEmail.value)){
		return false;
	}
	if(!validarTelefone(inputTelefone.value)){
		return false;
	}
	if(!validarCEP(inputCep.value)){
		return false;
	}
	if(!validarLogradouro(inputLogradouro.value)){
		return false;
	}
	if(!validarNumero(inputNumero.value)){
		return false;
	}
	if(!validarBairro(inputBairro.value)){
		return false;
	}
	if(!validarCidade(inputCidade.value)){
		return false;
	}
	if(!validarEstado(inputEstado.value)){
		return false;
	}
		
	return true;
}

function validarLogin(login) {
	if(login.replace(' ', '') === '' || login.length < 4) {
		smallErro.innerText = 'Usuário precisa ter pelo menos 4 dígitos';
		return false;
	}
	smallErro.innerText = '';
	return true;
}

function validarSenha(senha){
	if(senha.replace(' ', '') === '' || senha.length < 4) {
		smallErro.innerText = 'Senha precisa ter pelo menos 4 dígitos';
		return false;
	}
	smallErro.innerText = '';
	return true;
}

function validarNome(nome){
	if(nome.replace(' ', '') === '' || nome === null || nome === undefined) {
		smallErro.innerText = 'Informe um nome';
		return false;
	}
	smallErro.innerText = '';
	return true;
}

function validarTelefone(telefone) {
    let regex = /^[0-9]{10,11}$/;
    if(!regex.test(telefone)){
		smallErro.innerText = 'Telefone inválido';
		return false;		
	}
	smallErro.innerText = '';
	return true;
}

function validarEmail(email) {
	let regex = /^(.+)@(.+)$/;
    if(!regex.test(email)){
		smallErro.innerText = 'Email inválido';
		return false;		
	}
	smallErro.innerText = '';
	return true;
}

function validarCEP(cep) {
	if(cep.length !== 8) {
		smallErro.innerText = 'CEP inválido';
		return false;
	}
	smallErro.innerText = '';
	return true;
}

function validarLogradouro(logradouro) {
	if(logradouro.replace(' ', '') === '' || logradouro === null || logradouro === undefined) {
		smallErro.innerText = 'Logradouro inválido';
		return false;
	}
	smallErro.innerText = '';
	return true;
}

function validarNumero(numero) {
	if(numero < 0) {
		smallErro.innerText = 'Numero inválido';
		return false;
	}
	smallErro.innerText = '';
	return true;
}

function validarBairro(bairro) {
	if(bairro.replace(' ', '') === '' || bairro === null || bairro === undefined) {
		smallErro.innerText = 'Bairro inválido';
		return false;
	}
	smallErro.innerText = '';
	return true;
}

function validarCidade(cidade) {
	if(cidade.replace(' ', '') === '' || cidade === null || cidade === undefined) {
		smallErro.innerText = 'Cidade inválido';
		return false;
	}
	smallErro.innerText = '';
	return true;
}

function validarEstado(estado) {
	if(estado.replace(' ', '') === '' || estado === null || estado === undefined) {
		smallErro.innerText = 'Estado inválido';
		return false;
	}
	smallErro.innerText = '';
	return true;
}

function validarFoto() {
	console.log(inputFoto.files[0].type.toLowerCase());
	smallErro.innerText = '';
	if((inputFoto.files[0].type.toLowerCase() !== 'application/jpeg') && (inputFoto.files[0].type.toLowerCase() !== 'application/jpg') && (inputFoto.files[0].type.toLowerCase() !== 'application/png')) {
		smallErro.innerText = 'Tipo de arquivo inválido, selecione uma foto em JPEG, JPG ou PNG';
		inputFoto.value = '';
	}
}

function validarCurriculo() {
	smallErro.innerText = '';
	if(inputCurriculo.files[0].type.toLowerCase() !== 'application/pdf') {
		smallErro.innerText = 'Tipo de arquivo inválido, selecione um curriculo em PDF';
		inputCurriculo.value = '';
	}
}


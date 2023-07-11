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
const smallErro = document.getElementById('mensagem-erro');
let cepResult;

inputCep.addEventListener('focusout', () => {
	if(validaCEP(inputCep.value)){
		fetch(`https://viacep.com.br/ws/${inputCep.value}/json/`)
			.then(response => response.json())
			.then(result => {
				if(result.erro === true) {
					smallErro.innerText = 'CEO não encontrado'
				}else{
					console.log(result.logradouro);
					inputLogradouro.value = result.logradouro;
					inputBairro.value = result.bairro;
					inputCidade.value = result.localidade;
					inputEstado.value = result.uf;
				}
			});
	}
})

	
function validarForm() {
	
	if(inputLogin.value.replace(' ', '') === '' || inputLogin.value.length < 4) {
		smallErro.innerText = 'Usuário precisa ter pelo menos 4 dígitos';
		return false;
	}
	
	if(inputSenha.value.replace(' ', '') === '' || inputSenha.value.length < 4) {
		smallErro.innerText = 'Senha precisa ter pelo menos 4 dígitos';
		return false;
	}
	
	if(inputNome.value.replace(' ', '') === '' || inputNome.value === null) {
		smallErro.innerText = 'Nome inválido';
		return false;
	}
	
	if(validaTelefone(inputTelefone.value)) {
		smallErro.innerText = 'Telefone inválido';
		return false;
	}
	
	if(inputLogradouro.value.replace(' ', '') === '' || inputLogradouro.value === null) {
		smallErro.innerText = 'Logradouro inválido';
		return false;
	}
	
	if(inputNumero.value < 0) {
		smallErro.innerText = 'Numero inválido';
		return false;
	}
	
	if(inputBairro.value.replace(' ', '') === '' || inputBairro.value === null) {
		smallErro.innerText = 'Bairro inválido';
		return false;
	}
	
	if(inputCidade.value.replace(' ', '') === '' || inputCidade.value === null) {
		smallErro.innerText = 'Cidade inválido';
		return false;
	}
	
	if(inputEstado.value.replace(' ', '') === '' || inputEstado.value === null) {
		smallErro.innerText = 'Estado inválido';
		return false;
	}
	
	if(inputCep.value.replace(' ', '') === '' || inputCep.value === null) {
		smallErro.innerText = 'CEP inválido';
		return false;
	}
	
	return true;
}

function validaCEP(cep) {
	if(cep.length !== 8) {
		smallErro.innerText = 'CEP inválido';
		return false;
	}
	smallErro.innerText = '';
	return true;
}

function validaTelefone(telefone) {
    let regex = '^(\\d{10,11})$';
    return regex.test(telefone);
}
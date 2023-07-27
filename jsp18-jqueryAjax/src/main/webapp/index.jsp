<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<title>Jquery Ajax</title>
</head>
<body>
	<h1>Cusro JSP - JQuery e Ajax</h1>
	<div>
		<input type="number" id="input-numero1" placeholder="Primeiro número">
		<select id="operacao">
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="*">*</option>
			<option value="/">/</option>
		</select>
		<input type="number" id="input-numero2" placeholder="Segundo número">
		<button id="btn-teste" onclick="testeJQueryAjax()">Calcular</button>
	</div>
	<p id="resultado"></p>
</body>
<script type="text/javascript">
	function testeJQueryAjax() {
		$('#resultado').text("");
		let numero1 = $('#input-numero1').val();
		let numero2 = $('#input-numero2').val();
		let operacao = $('#operacao').val();
		
		$.ajax({
			method: "POST",
			url: "teste-ajax",
			data: {
				"numero1": numero1,
				"numero2": numero2,
				"operacao": operacao		
			}
		}).done(function(response) {
			$('#resultado').text(response);
		}).fail(function(response) {
			$('#resultado').text(response.responseText);
		});
	}
</script>
</html>
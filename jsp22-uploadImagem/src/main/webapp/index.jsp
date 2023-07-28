<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<title>Upload de imagem</title>
</head>
<body>
	<h1>Curso JSP - Upload de Imagem</h1>
	<input type="file" id="file" name="file" onchange="uploadFile()"/><br>
	<img alt="Imagem" src="" id="imagem" width="200" height="200">
	<p id="resultado"></p>
</body>
<script type="text/javascript">
	function uploadFile() {
		let inputFile = document.getElementById("file");
		let inputImagem = document.getElementById("imagem");
		let reader = new FileReader();
		
		if(inputFile){
			reader.readAsDataURL(inputFile.files[0]);
		}else {
			inputImagem.src="";
		}
		
		reader.onloadend = function() {
			inputImagem.src = reader.result;
			
			$.ajax({
				method: "POST",
				url: "upload",
				data: { "imagem": reader.result }
			}).done(function(response) {
				$('#resultado').text(response);
			}).fail(function(response) {
				$('#resultado').text(response.responseText);
			});
		}	
	}
</script>
</html>
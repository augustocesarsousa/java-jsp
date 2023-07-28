<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<style type="text/css">
	#minhaBarraContent {
		width: 100%;
		background-color: #ddd;
	}
	
	#minhaBarra {
		width: 1%;
		height: 30px;
		background-color: #4caf50
	}
	
	.ui-progressbar {
		position: relative;
	}
	
	.progress-label {
		position: relative;
		left: 50%;
		top: 4px;
		font-weight: bold;
		text-shadow: 1px 1px 0 #fff;
	}
</style>
<title>ProgressBar</title>
</head>
<body>
	<h1>Curso JSP - ProgressBar</h1>
	<h2>Javascript</h2>
	<button onclick="iniciarBarra()">Iniciar barra</button>
	<div id="minhaBarraContent">
		<div id="minhaBarra"></div>
	</div>
	
	<h2>JQuery</h2>
	<button onclick="iniciarBarra2()">Iniciar barra</button>
	<div id="progressbar">
		<div class="progress-label">
			Carregando...
		</div>
	</div>
	
</body>
<script type="text/javascript">
	function iniciarBarra() {
		let barra = document.getElementById('minhaBarra');
		let width = 1;
		let id = setInterval(frame, 10);
		
		function frame() {
			if(width >= 100) {
				clearInterval(id);
			}else {
				width++;
				barra.style.width = width + "%";
			}
		}
	}
	
	function iniciarBarra2() {
		let progressbar = $("#progressbar");
		let progresslabel = $(".progress-label");
		
		progressbar.progressbar ({
			value : false,
			change : function() {
				progresslabel.text(progressbar.progressbar('value') + "%");
			},
			complete: function () {
				progresslabel.text('Completo');
			}
		});
		
		function progress() {
			let val = progressbar.progressbar("value") || 0;
			progressbar.progressbar("value", val + 2);
			if( val < 99) {
				setTimeout(progress, 80);
			}
		}
		
		progress();
	}
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<title>Data</title>
</head>
<body>
	<h1>Curso JSP - Data</h1>
	<form action="data" method="post">
		<div>
			<label for="data-inicial">Data inicial:</label>
			<input id="data-inicial" name="data-inicial">
		</div>
		<div>
			<label for="tempo-horas">Tempo em hotas:</label>
			<input id="tempo-horas" name="tempo-horas">
		</div>
		<input type="submit" value="Calcular">
	</form><br>
	<div>
		<label for="resultado">Resultado:</label>
		<input type="text" id="resultado" name="resultado" readonly="readonly" value="${dataFinal}">
	</div>	
</body>
<script type="text/javascript">
	$(function name() {
		$('#data-inicial').datepicker({
			dateFormat: 'dd/mm/yy'
		});
	});
</script>
</html>
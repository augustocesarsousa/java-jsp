<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="http://cdn.datatables.net/1.13.5/css/jquery.dataTables.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.13.5/js/jquery.dataTables.min.js"></script>
<title>Datatable</title>
</head>
<body>
	<h1>Curso JSP - Datatable</h1>
	<table id="teste-datatable" class="display">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Sobrenome</th>
				<th>Telefone</th>
				<th>Email</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</body>
<script type="text/javascript">
	$(document).ready( function () {
	    $('#teste-datatable').DataTable({
	    	processing: true,
	    	serverSide: true,
	    	ajax: 'datatable'
	    });
	} );
</script>
</html>
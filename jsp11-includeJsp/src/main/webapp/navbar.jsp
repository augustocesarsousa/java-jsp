<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Navbar</title>
<style>
	* {
		box-sizing: border-box;
	}
	
	nav {
		width: 100%;
		height: 50px;
		background-color: #8bf1c3;
		display: flex;
		align-items: center;
		justify-content: space-between;
		padding: 10px;
	}
	
	a {
		text-decoration: none;
		font-size: 24px;
		color: #000;
	}
</style>
</head>
<body>
	<nav>
		<a href="#">
			<%= request.getParameter("logo") %>
		</a>
		<div>
			<a href="#">Link</a>
			<a href="#">Link</a>
			<a href="#">Link</a>
		</div>
	</nav>
</body>
</html>
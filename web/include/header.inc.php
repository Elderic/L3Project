<?php
	function myHeader($title) {
		echo "
<!DOCTYPE html>
<html lang=\"fr\">
	<head>
		<meta charset=\"utf-8\" />
		<link rel=\"stylesheet\" href=\"default_style.css\" />
		<title>".$title."</title>
	</head>
	
	
	<body>
		<header>
			<nav>
				<ul>
					<li>MENU 1</li>
					<li>MENU 2</li>
					<li>MENU 3</li>
				</ul>
			</nav>
			
			<h1>".$title."</h1>
		</header>";
	}
?>
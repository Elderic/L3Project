<?php
	session_start();
	
	$_SESSION = array();
	
	session_destroy();
	
	require("include/functions.inc.php");
	require("include/header.inc.php");
	myHeader("D&eacute;connection");
	redirect("admin_login");
?>


		<div class="info">
			<h2>Vous avez &eacute;t&eacute; d&eacute;connect&eacute; !</h2>
			<p class="redirect">Vous allez &ecirc;tre redirig&eacute;.</p>
		</div>

		
<?php
	require("include/footer.inc.php");
?>

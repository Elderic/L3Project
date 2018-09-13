<?php
	require("include/header.inc.php");
	myHeader("Administration des Bases de Donn&eacute;es");
?>


		<div class="info">
			<h2>Bienvenue sur le Panel Admin !</h2>
			<p>Vous devez vous connecter pour acc&eacute;der aux fonctionnalit&eacute;s d'Administration.</p>
		</div>
		
		
		<div class="form">
			<form method="post" action="admin_panel.php">
				<p><label>Identifiant :</label></p>
				<p><input class="field" type="text" name="adminLogin" required /></p>
				<p><label>Mot de passe :</label></p>
				<p><input class="field" type="password" name="adminPassword" required /></p>
				
				<p><input class="button" type="submit" value="Connexion" /></p>
			</form>
		</div>

		
<?php
	require("include/footer.inc.php");
?>
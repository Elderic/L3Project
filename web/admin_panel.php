<?php
	require("include/functions.inc.php");
	require("include/header.inc.php");
	myHeader("Administration des Bases de Donn&eacute;es");

	$error=true;
	if(!isset($_SESSION['admin-login']))
	{
		if(isset($_POST['adminLogin']) && isset($_POST['adminPassword']))
		{
			if(isCheckAdminLogin($_POST['adminLogin'], $_POST['adminPassword']))
			{
				$_SESSION['admin-login']=$_POST['adminLogin'];
				$error=false;
			}
			else
			{
				$error=true;
			}
		}
		else
		{
			$error=true;
		}
	}
	else
	{
		$error=false;
	}

	if(!$error)
	{
		redirect("admin_login");
		echo "
		<div class=\"info\">
			<h2>Erreur : L'Identifiant ou le Mot de passe n'est pas valide !</h2>
			<p class=\"redirect\">Vous allez &ecirc;tre redirig&eacute;.</p>
		</div>";
	}
	else
	{
		echo "
		<div class=\"info\">
			<h2>Bienvenue sur le Panel Admin !</h2>
			<p>Ici vous pouvez administrer les bases de donn&eacute;es.</p>
		</div>
		
		<div class=\"form\">
			<form method=\"get\" action=\"admin_disconnect.php\">
				<p>
					<input class=\"button\" type=\"submit\" value=\"D&eacute;connexion\" />
				</p>
			</form>
		</div>
		
		<div>";
		
		if(isset($_POST['add-login']) && isset($_POST['add-password']))
		{
//			print(addLogin($_POST['add-login'], $_POST['add-password']));
		}
		
		echo "
			<form method=\"post\" action=\"panel_admin.php\">
				<fieldset>
					<legend>Ajouter un acc&egrave;s au Trombinoscope</legend>
					
					<label>Choisir l'identifiant :</label>
					<input class=\"field\" type=\"text\" name=\"add-login\" required />
					<label>Choisir le mot de passe :</label>
					<input class=\"field\" type=\"text\" name=\"add-password\" required />
					
					<input class=\"button\" type=\"submit\" value=\"Ajouter\" />
				</fieldset>
			</form>";
			
		if(isset($_POST['choose-login']))
		{
//			print(removeLogin($_POST['choose-login']));
		}
		
		echo "
			<form method=\"post\" action=\"panel_admin.php\">
				<fieldset>
					<legend>Supprimer un acc&egrave;s au Trombinoscope</legend>
					
					<label>Choisir l'identifiant :</label>
					<select class=\"list\" name=\"choose-login\">
						<option value=\"none\" selected>Aucune</option>";
						
//		print(getAllLogins());
		
		echo "
					</select>
					
					<input class=\"button\" type=\"submit\" value=\"Supprimer\" name=\"submit\" />
				</fieldset>
			</form>
		</div>
		
		<div>";
		
		if(isset($_POST['create-license']) && isset($_POST['license-workforce']))
		{
//			print(createLicense($_POST['create-license'], $_POST['license-workforce']));
		}
		
		echo "
			<form method=\"post\" action=\"panel_admin.php\">
				<fieldset>
					<legend>Cr&eacute;er une fili&egrave;re</legend>
					
					<label>Choisir le nom de la fili&egrave;re :</label>
					<input class=\"field\" type=\"text\" name=\"create-license\" required />
					<label>Choisir l'effectif :</label>
					<input class=\"field\" type=\"number\" name=\"license-workforce\" required />
					
					<input class=\"button\" type=\"submit\" value=\"Cr&eacute;er\" />
				</fieldset>
			</form>";

		if(isset($_POST['choose-license']) && isset($_POST['create-group']) && isset($_POST['group-workforce']))
		{
//			print(createGroup($_POST['choose-license'], $_POST['create-group'], $_POST['group-workforce']));
		}
		
		echo "
			<form method=\"post\" action=\"panel_admin.php\">
				<fieldset>
					<legend>Cr&eacute;er un groupe</legend>
					
					<label>Choisir une fili&egrave;re :</label>
					<select class=\"list\" name=\"choose-license\">
						<option value=\"none\" selected>Aucune</option>";

//		print(getAllLicenses());
		
		echo "
					</select>
					<label>Choisir le nom du groupe :</label>
					<input class=\"field\" type=\"text\" name=\"create-group\" required />
					<label>Choisir l'effectif :</label>
					<input class=\"field\" type=\"number\" name=\"group-workforce\" required />
					
					<input class=\"button\" type=\"submit\" value=\"Cr&eacute;er\" />
				</fieldset>
			</form>
		</div>
		
		<div>";
		
		if(isset($_POST['delete-license']))
		{
//			print(removeLicense($_POST['delete-license']));
		}
		
		echo "
			<form method=\"post\" action=\"panel_admin.php\">
				<fieldset>
					<legend>Supprimer une fili&egrave;re</legend>
					
					<label>Choisir une fili&egrave;re :</label>
					<select class=\"list\" name=\"delete-license\">
						<option value=\"none\" selected>Aucune</option>";

//		print(getAllLicenses());

		echo "
					</select>
					
					<input class=\"button\" type=\"submit\" value=\"Supprimer\" />
				</fieldset>
			</form>";
			
		if(isset($_POST['delete-group']))
		{
//			print(removeGroup($_POST['delete-group']));
		}

		echo "
			<form method=\"post\" action=\"panel_admin.php\">
				<fieldset>
					<legend>Supprimer un groupe</legend>
					
					<label>Choisir un groupe en fonction de la fili&egrave;re :</label>
					<select class=\"list\" name=\"delete-group\">";

//		print(getLicensesAndGroups("../images/trombinoscope/"));

		echo "
					</select>
					
					<input class=\"button\" type=\"submit\" value=\"Supprimer\" />
				</fieldset>
			</form>
		</div>
		
		<div>";
		
		if(isset($_POST['submit']))
		{
//			print(removeAllLicenses());
		}
		
		echo "
			<form method=\"post\" action=\"panel_admin.php\">
				<fieldset>
					<legend>Supprimer toutes les fili&egrave;res</legend>
					
					<input class=\"button\" type=\"submit\" value=\"Supprimer toutes les fili&egrave;res\" name=\"submit\" />
				</fieldset>
			</form>
		</div>";
	}
	
	require("include/footer.inc.php");
?>

<?php
	/**
	* Redirect to the given page
	* @param page
	*/
	function redirect($page)
	{
		header('Refresh:5; url='.$page.'.php');
	}

?>
<?php 
	require "../loader.php";

	if($_SERVER['REQUEST_METHOD'] == "POST"){
		echo 0;
		if(
			isset($_POST["firstname"]) && 
			isset($_POST["surname"]) &&
			isset($_POST["birthday"]) &&
			isset($_POST["city"]) &&
			isset($_POST["zipCode"]) &&
			isset($_POST["address"]) &&
			isset($_POST["houseNumber"]) &&
			isset($_POST["phoneNumber"]) &&
			isset($_POST["email"]) &&
			isset($_POST["gender"]) &&
			isset($_POST["password"]) &&
			isset($_POST["repassword"])
		){
			try{
				echo 1;
				$u = new User(
					$_POST["firstname"],
					$_POST["surname"],
					$_POST["birthday"],
					$_POST["city"],
					$_POST["zipCode"],
					$_POST["address"],
					$_POST["houseNumber"],
					$_POST["phoneNumber"],
					$_POST["email"],
					$_POST["gender"],
					$_POST["password"],
					$_POST["repassword"]
				);		
				$db->insertUser($u); 
				$cryptedMail = $_POST["email"] ^ $privateKey;
				$message = '<hr>How are you? <br> <hr>This i your link:<a href="http://cashyland.tk/GestioneCasino/code/php/validate.php?id='.urlencode($cryptedMail).'">Click me!</a>';
				$subjet = "Hi there! Verify your email :)";
				$mailSender->mailSend($_POST["email"],$subjet,$message);
				header("Location: ../../../GestioneCasinoSito/verificaMail.html");	
			}catch(Exception $e){
//				echo "<script>alert($e->getMessage())</script>";
				echo "<script>window.location.replace('http://cashyland.tk/GestioneCasinoSito/registrazione.html')</script>";
			}
		}
	}
?>
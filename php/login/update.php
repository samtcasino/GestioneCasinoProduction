<?php
require "../loader.php";
if($_SERVER['REQUEST_METHOD'] == "POST"){
    if(
        isset($_POST["firstname"]) &&
        isset($_POST["surname"]) &&
        isset($_POST["city"]) &&
        isset($_POST["zipCode"]) &&
        isset($_POST["address"]) &&
        isset($_POST["houseNumber"]) &&
        isset($_POST["phoneNumber"])
    ){
        $name = $_POST["firstname"];
        $surname = $_POST["surname"];
        $city = $_POST["city"];
        $zipCode = $_POST["zipCode"];
        $address = $_POST["address"];
        $houseNumber = $_POST["houseNumber"];
        $phoneNumber = $_POST["phoneNumber"];
        $email = $_POST["email"];

        $query = "update user set
            phone_number='$phoneNumber',
            house_number='$houseNumber',
            street='$address',
            zip_code='$zipCode',
            city='$city',
            name='$name',
            surname='$surname',
            Where email = '$email'
        ";
        $db->executeQuery($query);
        $message = '<h1>Hey ' .$_POST["firstname"] .'!, your data was modified</h1>';
        $subjet = "Hi there! Cashyland";
        $mailSender->mailSend($_POST["email"],$subjet,$message);
        header("Location: ../../../profile.php");
    }
}
?>
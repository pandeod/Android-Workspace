<?php
	require "connect.php";
	$user=$_POST["user_name"];
	$order=$_POST["order"];
	
	$query="insert into `orders`(`user`,`items`) values('$user','$order')";
	$result=mysqli_query($db,$query);
	if($result)
	{
		echo "order placed successfully";
	}
	else
	{
		echo "Error...";
	}
?>
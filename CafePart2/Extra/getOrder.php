<?php 
	
 //database constants
 define('DB_HOST', 'localhost');
 define('DB_USER', 'id4810333_onkarpande2012');
 define('DB_PASS', 'admin');
 define('DB_NAME', 'id4810333_resto');
 
 //connecting to database and getting the connection object
 $conn = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
 
 //Checking if any error occured while connecting
 if (mysqli_connect_errno()) {
 echo "Failed to connect to Database: " . mysqli_connect_error();
 die();
 }
 
 //creating a query
 $stmt = $conn->prepare("select * from`orders`");
 
 //executing the query 
 $stmt->execute();
 
 //binding results to the query 
 $stmt->bind_result($id, $user, $order, $status);
 
 $products = array(); 
 
 //traversing through all the result 
 while($stmt->fetch()){
 $temp = array();
 $temp['id'] = $id; 
 $temp['user'] = $user; 
 $temp['order'] = $order; 
 $temp['status'] = $status; 
 
 array_push($products, $temp);
 }
 
 //displaying the result in json format 
 echo json_encode($products);
 
 ?>
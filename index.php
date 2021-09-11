<?php      

require_once "connection.php";
require_once "session.php";

$email = $_POST['inputEmailAddress'];  
$password = $_POST['inputPassword'];  
  
    //to prevent from mysqli injection  
    $email = stripcslashes($email);  
    $password = stripcslashes($password);  
    $email = mysqli_real_escape_string($con, $email);  
    $password = mysqli_real_escape_string($con, $password);  
  
    $sql = "select * from users where email = '$email' and password = '$password'";  
    $result = mysqli_query($con, $sql);  
    $row = mysqli_fetch_array($result, MYSQLI_ASSOC);  
    $count = mysqli_num_rows($result);  
      
    if($count == 1){  
        echo "<h1><center> Login successful </center></h1>";  
    }  
    else{  
        echo "<h1> Login failed. Invalid username or password.</h1>";  
    }     
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mirkwood Attendance Management System - Login</title>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="js/index.js"></script>
</head>

<body>
    <div class="card-bg">
        <div class="card shadow p-3 mb-5 bg-white rounded">
            <div class="card-body" style="background-color: White;">
                <h5 class="card-title mb-3 fs-2 text-center">Login</h5>
                <h6 class="card-subtitle mb-5 fs-5 text-muted text-center">Mirkwood Attendance Management System</h6>
                    <!--Login Form-->
                    <form class="row g-3 needs-validation" novalidate method="POST" action="#">
                        <div class="mb-1">
                            <div class="form-outline">
                                <label for="inputEmailAddress" class="form-label">Email address</label>
                                <input type="text" class="form-control" id="inputEmailAddress" required />
                                <div class="invalid-feedback">Please enter your email address.</div>
                            </div>
                        </div>
                        <div class="mb-3">
                            <div class="form-outline">
                                <label for="inputPassword" class="form-label">Password</label>
                                <input type="password" class="form-control" id="inputPassword" required />
                                <div class="invalid-feedback">Please enter your password.</div>
                            </div>
                        </div>
                        <div class="col-12">
                            <button class="btn btn-primary" type="submit">Login</button>
                        </div>
                    </form>
                    <!--Login Form end-->
            </div>
        </div>
    </div>
</body>
</html>
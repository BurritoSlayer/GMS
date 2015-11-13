<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link href="css/bootstrap.css" rel="stylesheet">
  <link href="css/mainstyles.css" rel="stylesheet">
  <link rel="shortcut icon" type="image/x-icon" href="resources/favi.ico">
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  
  <link href="fonts/" rel="stylesheet" type="text/css"> <!-- TODO add font style sheet -->
<title>MATA Login</title>
</head>
<body>

 <div class="container">
 
    <!-- Login Box -->
	<div class="panel panel-default">
  	 <div class="panel-body">
  	 
  	 <img src="resources/MATAMS.jpg" style="display:block;
    margin:auto;">
	 <br>
	    <!--  Login Form -->
		<form role="form" method='post' action="login">
		<div class="row">
  	      <div class="form-group textaligncenter col-lg-4 col-md-offset-4">
			<label for="username">Username: </label>
		    <input type="text" class="form-control" name="username">
	      </div>
		</div>
		
		<div class="row">
   	      <div class="form-group textaligncenter col-lg-4 col-md-offset-4">
		     <label for="pwd">Password: </label>
			 <input type="password" class="form-control" name="password">
	      </div>
	     </div>
	     
  	      <button type="submit" name='continue' class="btn btn-primary" style="display: block; margin: 0 auto;">Login</button>
  		</form>
  	  <br>
  	  <p class="redtext">Username or password incorrect. Please try again.</p>
  	 </div>
	</div>
	<!-- End of Login Box -->
	
 </div>
 
 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Member</title>

 <link href="css/bootstrap.css" rel="stylesheet">
   <link href="css/dashstyles.css" rel=stylesheet>
</head>
<body>
<!--  Navigation bar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
            <form id="returnDash" method='post' action='ReturnEmpDash'>
      <a class="navbar-brand" href="#" onclick="document.getElementById('returnDash').submit();">MATA MS&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
      </form>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="#" type="submit">Test</a></li>
        <li><a href="#menu-toggle" id="menu-toggle">Toggle Sidebar</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Menu <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Members</a></li>
            <li><a href="#">Schedules</a></li>
            <li><a href="#">Classes</a></li>
            <li><a href="#">Disciplines</a></li>
            <li><a href="#">Plans</a></li>
            <li><a href="#">Weekly Logs</a></li>
			<li role="separator" class="divider"></li>
            <li><a href="#">Leaderboard</a> </li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-right" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="http://www.martialartstrainingacademy.com/" target="_blank">Website</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${PN}<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="PassChange.jsp">Change Password</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#" data-toggle="modal" data-target="#logoutModal">Sign Out</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<!-- End of navbar -->
<br>
<br>
<br>
<div class="wrapper">
<div class="container">
	<form method="post" action="UpdateMember3">
	${Mbrdata}
	<br>
	<button class="btn btn-warning" type="submit">Update Member</button>
	</form>
	<br>
	<button class="btn btn-danger" type="submit" data-toggle="modal" data-target="#deMember">Deactivate Member</button>
	
	
	</div>
	</div>
	<!-- Modal -->
  			 <div class="modal fade" id="deMember" role="dialog">
    		 <div class="modal-dialog">
    
      			<!-- Modal content-->
      			<div class="modal-content">
        			<div class="modal-header">
          			  <button type="button" class="close" data-dismiss="modal">&times;</button>
          			  <h2 class="modal-title" style="text-align: center;">Are you sure you would like to deactivate this member?
          			  </h2>
        			</div>
        		
        		<div class="modal-footer">
        		<form method="post" action="DeactivateMember">
                	<button type="submit" name='continue' class="btn btn-primary">Continue</button>
                	</form>
                	<br>
          			<button class="btn btn-default" data-dismiss="modal">Cancel</button>
          	
       			</div>
       			</div>
       			</div>
       			</div>
       			<!-- End of Modal -->
        
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
</body>
</html>
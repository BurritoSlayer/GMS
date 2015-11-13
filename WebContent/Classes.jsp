<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

   <link href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" rel="stylesheet">
   <link href="css/bootstrap.css" rel="stylesheet">
   <link href="css/dashstyles.css" rel=stylesheet>
   <link rel="shortcut icon" type="image/x-icon" href="resources/favi.ico">
   
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Classes</title>
</head>
<body>
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
<br>
<br>
<br>
<br>
<div class="wrapper">



 <div class="container">
  <div class="panel">
	<table id="example" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Class Name</th>
                <th>Description</th>
                <th>Discipline</th>
            </tr>
        </thead>
 
        <tfoot>
            <tr>
            	<th>Class Name</th>
                <th>Description</th>
                <th>Discipline</th>
            </tr>
        </tfoot>
 
        <tbody>
            ${Classes}
          </tbody>
          </table>
          </div>
         
  
  <div class="col-med-4 text-center">
            <!-- Trigger the modal wih a button -->
  			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">New Class</button>
  			
			<br>
  			<br>
  			<form method="get" action="UpdatePlan">
  				<button type="submit" class="btn btn-warning">Modify Class</button>
  			</form>
		   </div>
		   		   <br>
		   </div>

 			 <!-- Modal -->
  			 <div class="modal fade" id="myModal" role="dialog">
    		 <div class="modal-dialog">
    
      			<!-- Modal content-->
      			<div class="modal-content">
        			<div class="modal-header">
          			  <button type="button" class="close" data-dismiss="modal">&times;</button>
          			  <h4 class="modal-title" style="text-align: center;">Add New Discipline</h4>
        			</div>
        		
        		<div class="modal-body">
          			<p><div class="container">
          			<div class="tab-content">
    				<div id="prsninfo" class="tab-pane fade in active">
    				<form role="form" method='post' action="AddClass">
    				<br>
    				
    				<div class="row">
    					<div class='col-lg-6'>
						<label for="planName">Class Name: </label>
				        <input type="text" class="form-control col-med-2" name="planName" id="planName" required>
				        </div>
				    </div>    
	
					<div class="row">
						<div class='col-lg-6'>
						<label for="planLName">Class Description </label>
				        <input type="text" class="form-control" name="planLName" id="planLName">
				        </div>
				    </div>
				    
				    <div class="row">
						<div class='col-lg-6'>
						<label for="desc">Discipline: </label>
				        <input type="text" class="form-control" name="desc" id="desc" required>
				        </div>
				    </div>
			    
				    </div>
				    </div>
				    
				    </div>
				    </div>
				    <div class="modal-footer">
                	 <button type="submit" name='continue' class="btn btn-primary">Add</button>
                	
                	</form>
          			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
       			</div>
       			</div>
       			</div>
       			</div>
       			</div>
          			

<!--  Datatables -->
<script type="text/javascript" src="https://cdn.datatables.net/r/bs/dt-1.10.9,af-2.0.0,b-1.0.3,b-colvis-1.0.3,cr-1.2.0,fc-3.1.0,fh-3.0.0,kt-2.0.0,r-1.0.7,rr-1.0.0,sc-1.3.0,se-1.0.1/datatables.min.js"></script>

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</body>
</html>
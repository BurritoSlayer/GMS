<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <link href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" rel="stylesheet">
   <link href="css/bootstrap.css" rel="stylesheet">
   <link href="css/dashstyles.css" rel="stylesheet">
   <link rel="shortcut icon" type="image/x-icon" href="resources/favi.ico">
   <!--  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/r/bs/dt-1.10.9,af-2.0.0,b-1.0.3,b-colvis-1.0.3,cr-1.2.0,fc-3.1.0,fh-3.0.0,kt-2.0.0,r-1.0.7,rr-1.0.0,sc-1.3.0,se-1.0.1/datatables.min.css"/>  -->
   <link rel="stylesheet" type="text/css rel="stylesheet" href="css/simplesidebar.css">
   
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Employee Dashboard</title>
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
            <li><form id="memberForm" action="MemberEmails" method="post">
    			<a href="MemberEmails.jsp" class="fixedDrops" style="display: block !important; padding: 3px 20px !important; clear: both !important; font-weight: 400 !important; line-height: 1.42857143 !important; color: #333 !important; white-space: nowrap !important;">
    			Members</a>
			</form>
            <li><form id="schedForm" action="Schedules" method="post">
    			<a href="#" class="fixedDrops" style="display: block !important; padding: 3px 20px !important; clear: both !important; font-weight: 400 !important; line-height: 1.42857143 !important; color: #333 !important; white-space: nowrap !important;" onclick="document.getElementById('schedForm').submit();">
    			Schedules</a>
			</form>
            <li><form id="classForm" action="Classes" method="post">
    			<a href="#" class="fixedDrops" style="display: block !important; padding: 3px 20px !important; clear: both !important; font-weight: 400 !important; line-height: 1.42857143 !important; color: #333 !important; white-space: nowrap !important;" onclick="document.getElementById('classForm').submit();">
    			Classes</a>
			</form>
            <li><form id="discForm" action="Disciplines" method="post">
    			<a href="#" class="fixedDrops" style="display: block !important; padding: 3px 20px !important; clear: both !important; font-weight: 400 !important; line-height: 1.42857143 !important; color: #333 !important; white-space: nowrap !important;" onclick="document.getElementById('discForm').submit();">
    			Disciplines</a>
			</form>
            <li><form id="planForm" action="Plans" method="post">
    			<a href="#" class="fixedDrops" style="display: block !important; padding: 3px 20px !important; clear: both !important; font-weight: 400 !important; line-height: 1.42857143 !important; color: #333 !important; white-space: nowrap !important;" onclick="document.getElementById('planForm').submit();">
    			Plans</a>
			</form>
			</li>
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

	<!-- Log out modal -->
		<div id="logoutModal" class="modal fade" role="dialog"> 
  			<div class="modal-dialog">
    			<!-- Modal content-->
    				<div class="modal-content">
      				  	<div class="modal-body" style="text-align: center; font-family: Impact, Charcoal, sans-serif; font-size: 28px;">
        					Are you sure you want to sign out?
     			      	</div>
      					<div class="modal-footer">
      				  		<a type="submit" class='btn btn-default' href="Login.jsp">Sign out</a>
       				    	<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
      				  	</div>
    			   	</div>
    		</div>
    	</div>

<!-- Sidebar -->
   <div id="wrapper" class="toggled">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav toggled">
                <li>
                    <a href="#">Members</a>
                </li>
                <li>
                    <a href="#">Schedules</a>
                </li>
                <li>
                    <a href="#">Classes</a>
                </li>
                <li>
                    <a href="#">Disciplines</a>
                </li>
                <li>
                    <a href="#">Plans</a>
                </li>
                <li>
                    <a href="#">Weekly Logs</a>
                </li>
                <li>
                    <a href="#">Leaderboard</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

    </div>
    <!-- /#wrapper -->
<!-- End of sidebar -->

  <br>	
  <br>
  <br>
  <br>
  		
  <div class="panel">
	<table id="example" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
            	<th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Plan</th>
                <th>Start Date</th>
                <th>Last Login</th>
            </tr>
        </thead>
 
        <tfoot>
            <tr>
            	<th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Plan</th>
                <th>Start Date</th>
                <th>Last Login</th>
            </tr>
        </tfoot>
 
        <tbody>
            ${mbrtable}
          </tbody>
          </table>
            
           <div class="col-med-4 text-center">
            <!-- Trigger the modal wih a button -->
  			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">New Member</button>
  			
			<br>
  			<br>
  			<form method="get" action="UpdateMember">
  				<button type="submit" class="btn btn-warning">Update Member</button>
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
          			  <h4 class="modal-title" style="text-align: center;">Add New Member</h4>
        			</div>
        		
        		<div class="modal-body">
          			<p><div class="container">
  						<ul class="nav nav-pills">
    						<li class="active"><a data-toggle="pill" href="#prsninfo">Personal Info</a></li>
    						<li><a data-toggle="pill" href="#emrgncycntct">Emergency Contact</a></li>
    						<li><a data-toggle="pill" href="#pln">Chosen Plan</a></li>
  						</ul>
  
  				<div class="tab-content">
    				<div id="prsninfo" class="tab-pane fade in active">
    				<form role="form" method='post' action="EmpDashController">
    				<br>
    				
    				<div class="row">
    					<div class='col-lg-6'>
						<label for="firstname">First Name: </label>
				        <input type="text" class="form-control col-med-2" name="firstname" id="firstname" required>
				        </div>
				    </div>    
	
					<div class="row">
						<div class='col-lg-6'>
						<label for="firstname">Last Name: </label>
				        <input type="text" class="form-control" name="lastname" id="lastname" required>
				        </div>
				    </div>
				    
				    <div class="row">
						<div class='col-lg-6'>
						<label for="firstname">Middle Initial: </label>
				        <input type="text" class="form-control" name="middleinit" id="middleinit">
				        </div>
				    </div>
				        
				    <div class="row">
						<div class='col-lg-6'>
						<label for="firstname">Phone Number: </label>
				        <input type="text" class="form-control" name="phonenum" id="phonenum">
				        </div>
				    </div>
				    
				    <div class="row">
						<div class='col-lg-6'>
						<label for="firstname">Email: </label>
				        <input type="text" class="form-control" name="email" id="email">
				        </div>
				    </div>
				    
				    <div class="row">
						<div class='col-lg-6'>
						<label for="firstname">Address: </label>
				        <input type="text" class="form-control" name="address" id="address">
				     	</div>
				    </div>
				        
    				</div>
    				
    				<div id="emrgncycntct" class="tab-pane fade">
      					<br>
      					
      					<div class="row">
    						<div class='col-lg-6'>
							<label for="firstname">Contact's Full Name: </label>
				        	<input type="text" class="form-control col-med-2" name="cname" id="cname">
				            </div>
				    	</div>  
      					
      					<div class="row">
    						<div class='col-lg-6'>
							<label for="firstname">Contact's Relationship to Member: </label>
				        	<input type="text" class="form-control col-med-2" name="rel" id="rel">
				            </div>
				    	</div>  
				    	
      					<div class="row">
    						<div class='col-lg-6'>
							<label for="firstname">Contact's Phone Number: </label>
				        	<input type="text" class="form-control col-med-2" name="cphone" id="cphone">
				            </div>
				    	</div>  
				    	
				    </div>
    				<div id="pln" class="tab-pane fade">
      					<br>
      					
      					<div class="row">
    						<div class='col-lg-6'>
							<label for="chos">Chosen Plan: </label>
				        	${plans}
				            </div>
				    	</div>  
				    	
      					<div class="row">
    						<div class='col-lg-6'>
							<label for="firstname">Eligible For Discount: </label>
				        	<div class="checkbox">
  								<label><input type="radio" name="elig" id="eligyes" value="yes">Yes</label>
							</div>
							<div class="checkbox">
  								<label><input type="radio" name="elig" id="eligno" value="no">No</label>
							</div>
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
  			<!--  End of add employee modal -->
	</div>
	</div>
	</div>
	
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<!--  Datatables -->
<script type="text/javascript" src="https://cdn.datatables.net/r/bs/dt-1.10.9,af-2.0.0,b-1.0.3,b-colvis-1.0.3,cr-1.2.0,fc-3.1.0,fh-3.0.0,kt-2.0.0,r-1.0.7,rr-1.0.0,sc-1.3.0,se-1.0.1/datatables.min.js"></script>

    <!-- Menu Toggle Script (for sidebar)-->
    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>
    
    <script>
    $(document).ready(function() {
        $('#example').DataTable();
    } );
    </script>
    
    <script>
    $(document).ready(function(){
    $("tr.rows").click(function(){
        alert("Click!");
    });
	});
	</script>
	
	<!-- 
	<script>
	var table = $("#example")[0];

	var cell = table.rows[1].cells[1];
	
	$(document).ready(function() {
		$("cell").dblclick(function(){
		    alert("The paragraph was double-clicked");
		});
	
	</script>
	-->
	

</body>
</html>
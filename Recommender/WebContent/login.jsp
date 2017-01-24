
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Behind the Mirror-Login</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="login.js"></script>
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js"
	type="text/javascript"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
	type="text/javascript"></script>
<script type="text/javascript" src="app.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="login.js"></script>
        <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
    
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js" type="text/javascript"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="app.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<!-- 
<body>

	<div class="login">
		<h1>Login to Web App</h1>
		<form id="loginform" method="post" action="UsersServlet">
			<p>
				<input type="text" name="username" id="username" value=""
					placeholder="Username or Email">
			</p>
			<p>
				<input type="password" name="password" id="password" value=""
					placeholder="Password">
			</p>

			<input type="submit" name="login" id="login" value="Login">
		</form>
	</div>
</body>
-->
<body>
<div class="container" align="center">
  <h3>Behind the Mirror</h3>
  <ul class="list-inline">
    <li><a href="home.html">Home</a></li>
    <li><a href="#">Login</a></li>
    <li><a href="register.html">New User</a></li>
    <li><a href="contactus.html">Contact Us</a></li>
  </ul>
</div>

<br/>
<div align="center" style="color: #FF0000;">${errorMessage}</div>
<div align="center" style="color: black;"><h4>${thankyou}</h4></div>
<form class="form-horizontal" method="post" action="UsersServlet">

   <div class="form-group">
      <label class="control-label col-sm-2" for="username">Username/Email:</label>
      <div class="col-sm-3">
     <!-- <input type="text" class="form-control" id="username" placeholder="Enter username/email">-->
        <input type="text" class="form-control" name="username" id="username" value=""
					placeholder="Username or Email">
        
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="password">Password:</label>
      <div class="col-sm-3">          
      <!--  <input type="password" class="form-control" id="password" placeholder="Enter password">-->
        <input type="password" class="form-control" name="password" id="password" value=""
					placeholder="Password">
      </div>
    </div>
    
<div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <input type="submit" class="btn btn-default" id="login" value="Login">
        <input type="button" class="btn btn-default" id="new_user" value="New User">
        <button type="reset" class="btn btn-default" >Reset </button>
      </div>
    </div>
</form>
</body>
</html>
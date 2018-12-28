<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- <!DOCTYPE HTML>
<html>
 <head>
	<title>Book My Cinema</title>
 </head>
<body>
<div class="log-form">
  <h2>Login to your account</h2>
  <form method="POST", action="login">
    <input type="text" name="username" placeholder="username" />
    <input type="password" name="password" placeholder="password" />
    <input type = "submit" value="Login"/>
    <a class="forgot" href="#">Forgot Username?</a>
  </form>
</div>end log form

 </body>
 </html> -->
 
 <!DOCTYPE HTML>
<html>
 <head>
	<title>Book My Cinema</title>
	<link rel="stylesheet" href="login.css"/>
	<link href="https://fonts.googleapis.com/css?family=Slabo+27px" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Calligraffitti" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Courgette" rel="stylesheet">
 </head>
 <body>
	<header>
	
    <div class="main-head">
		
			<a href="index.jsp"><img class="logo" src="mylogo.png">
	
		<nav class="nav1">
			<ul>
				<li><a href="registration.jsp">Register</a></li>
				<li><a href="login.jsp">Login</a></li>
			</ul>
		</nav>
		
		<nav class="nav2">
	
				<ul>
				<li><a href="#">Theatres</a></li>
				<li><a href="movies.jsp">Movies</a></li>
				<li><a href="#">Cities</a></li>
				<input id="search" type="text" placeholder="Search..">
					
				</ul>
		</nav>

	</div>
 </header>
 
 
	<div class="page-container">
		
		<div class="row">
			<div class="col2">
				<h1 class="popular register-here">Login here</h1>
				<br>
				<c:if test="${not empty param.err}">
					<p class = "invalid">Invalid Login. Please check your username and password!</p>
					
				</c:if>
				
			</div>
			
		</div>
			
		<!-- Form -->
			
		<div id="formdiv">
			<form method="POST", action="login">
			   <!-- <label>Enter your First name</label> -->
			   <input class="in" type="text" name="username" placeholder="Username"/>
			  
			 
			   <input class="in" type="password" name="password" placeholder="Password"/>
			  
			   
			   
			   <input class="in reg" type="submit" value="Login"/>
			</form>
		</div>
	</div>	
			
			     <!-- Form ends -->
			
			

	
	
	
	<footer class="footer">
		<div class="footernav">
			<ul class="contact-about">
			<li><a href="#">Contact Us</a></li>
			<li><a href="#">About Us</a></li>
			</ul>
		</div>
	
	</footer>
 
 </body>
 </html>
 
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
 <head>
	<title>Book My Cinema</title>
	<link rel="stylesheet" href="registration.css"/>
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
				<h1 class="popular">Register here</h1>
			</div>
			
			
		</div>
			
		<!-- Form -->
			
		<div id="formdiv">
			<form method="POST" action="register">
			   <!-- <label>Enter your First name</label> -->
			   <input class="in" type="text" name="fname" placeholder="First Name"/>
			   <!-- <label>Enter your Last name</label> -->
			   <input class="in" type="text" name="lname" placeholder="Last Name"/>
			   <!-- <label>Choose a unique user name</label> -->
			   
			   <input class="in" type="text" name="uname" placeholder="User Name"/>
		
			   <!-- <label>Enter your Email</label> -->
			   <input class="in" type="email" name="email" placeholder="Email address"/>
			   
			   <input class="in" type="text" name="mobile" placeholder="Mobile number"/>
			   <!-- <label>Enter your date of birth</label> -->
			  <!--  <input class="in" type="number" name="age" placeholder="Age"/> -->
			  <input class="in" type="date" name="bday">
			   <!-- <label>Password</label> -->
			   <input class="in" type="password" name="password" placeholder="Password"/>
			   <!-- <label>Confirm Password</label> -->
			   <input class="in" type="password" name="cpassword" placeholder="Confirm Password"/>
			   
			   <input class="in reg" type="submit" value="Register"/>
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
 
 
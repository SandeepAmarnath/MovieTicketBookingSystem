<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>



<!DOCTYPE HTML>
<html>
 <head>
	<title>Book My Cinema</title>
	<link rel="stylesheet" href="bookingConfirmation.css"/>
	<link href="https://fonts.googleapis.com/css?family=Slabo+27px" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Calligraffitti" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Courgette" rel="stylesheet">
	

<link rel="stylesheet" href="jquery.datetimepicker.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="jquery.js"></script>
	<script src="jquery.datetimepicker.full.js"></script>
 </head>
 
 
 
<body>

	<header>
		
		<div class="main-head">
		
			<a href="index.jsp"><img class="logo" src="mylogo.png"></a>
	
			<nav class="nav1">
				<ul>
					<li><a href="#">Register</a></li>
					<li><a href="#">Login</a></li>
				</ul>
			</nav>
		
			<nav class="nav2">
				<ul>
					<li><a href="#">Theatres</a></li>
					<li><a href="#">Movies</a></li>
					<li><a href="#">Cities</a></li>
					<input id="search" type="text" placeholder="Search..">
				</ul>
			</nav>

		</div>
		
	</header>
 
	<div class="page-container">
	
		<div class="row">
			<div class="col2">
				<h1 class="popular register-here">Booking</h1>
			</div>	
		</div>
		
		
	<div class="movieborder">
		
		<form method="POST" action = "userbooking">
			<table>
				<tr>
					<td>Username</td>
					<td><input name="username" type="hidden" value="${username}"/>${username}</td>
				</tr>
				<tr>
					<td>Movie</td>
					<td><input name="movie" type="hidden" value="${movie}"/>${movie}</td>
				</tr>
				<tr>
					<td>Theater</td>
					<td><input name="theatre" type="hidden" value="${theatre}"/>${theatre}</td>
				</tr>
				<tr>
					<td>Seats</td>
					<td><input name="seats" type="hidden" value="${seats}"/>${seats}</td>
				</tr>
				
				<tr>
					<td>Show Time</td>
					<td><input name="showtimes" type="hidden" value="${showtimes}"/>${showtimes}</td>
				</tr>
				
				<tr>
					<td>Type</td>
					<td><input name="priceType" type="hidden" value="${priceType}"/>${priceType}</td>
				</tr>
				
				<tr>
					<td>Price</td>	
					<td><input name="price" type="hidden" value="${cp}"/>${cp}</td>	
				</tr>
			</table>
			
			<br>
			<br>
				<input class="button button2" id="testprice" type="submit" name="button" value="Book" />
		</form>
	</div>
		
				

</div>
	
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
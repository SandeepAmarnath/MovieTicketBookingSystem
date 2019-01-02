<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>



<!DOCTYPE HTML>
<html>
 <head>
	<title>Book My Cinema</title>
	<link rel="stylesheet" href="userBookingInfo.css"/>
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
				<h1 class="popular register-here">Welcome ${username}</h1>
			</div>	
		</div>
		
		
	<div class="movieborder">
		
		<form method="POST" action = "userbooking">
			<table>
				
				<th>Movie</th>
				<th>Theatre</th>
				<th>Showtime</th>
				<th>Seats</th>
				<th>Type</th>
				<th>Price</th>
				
				<tr>
					<td><input type="hidden" value="${movie}"/>${movie}</td>
				
					<td><input type="hidden" value="${theatre}"/>${theatre}</td>
				
					<td><input name="showtimes" type="hidden" value="${showtimes}"/>${showtimes}</td>
				
					<td><input name="seats" type="hidden" value="${seats}"/>${seats}</td>
				
					<td><input type="hidden" value="${priceType}"/>${priceType}</td>
				
					<td><input type="hidden" value="${price}"/>${price}</td>	
				</tr>
			</table>
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
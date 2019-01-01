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
				<h1 class="popular register-here">Booking Details</h1>
			</div>	
		</div>
		
		
	<div class="movieborder">
		
		<form method="POST" action = "booking">
			<table>
				<tr>
					<td>Username</td>
					<td>${username}</td>
				</tr>
				<tr>
					<td>Movie</td>
					<td><input type="hidden" name="movie" value="${movie}"/>${movie}</td>
				</tr>
				<tr>
					<td>Theater</td>
					<td><input type="hidden" name="theatre" value="${theater}"/>${theater}</td>
				</tr>
				<tr>
					<td>Seats</td>
					<td><input type="hidden" name="seats" value="${seats}"/>${seats}</td>
				</tr>
				
				<tr>
					<td>Show Time</td>
					<td>
					<div class="styled-select green rounded">
					<select id="showtimes" name="shows" >
						<option>Select Show</option>
					<c:forEach var="show" items="${showtime}">	
						
						<option><c:out value = "${show}" /></option>
					</c:forEach>
					</select>
					</div>
				</td>
				</tr>
				
				<tr>
					<td>Type</td>
					<td>
					<div class="styled-select green rounded">
					
					<select id = "priceid" name="priceType">
						<option>Economy</option>
						<option>Enhanced</option>
						
					</select>
					
					</div>
					</td>
				</tr>
				
				
				<tr>
				
				</tr>
			</table>
			
				<br>
				<br>
				<input class="button button2" id="testprice" type="submit" name="button" value="Proceed" />
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
 					<!-- AJAX TRY -->
 					 <!-- <script>
						$(document).ready(function(){
							$('#testprice').click(function(){
								
								var price = $('#priceid').val();
								var showtimes = $("#showtimes").val();
								var movie = $("#movie").html();
								var theatre = $("#theatre").html();
								var seats = $("#seats").html();
								
								$.ajax({
									
									data:{price:price,
										  showtimes:showtimes,
										  movie:movie,
										  theatre:theatre,
										  seats:seats,
										  
										  },
									type:'GET',
									url:'booking',
									success: function(data){
										 $('#testprice').html(data);
									
									} 
								});
							});
						});
					
					</script> -->
 
 
 
 </body>
 </html>
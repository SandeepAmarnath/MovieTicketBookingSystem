<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>



<!DOCTYPE HTML>
<html>
 <head>
	<title>Book My Cinema</title>
	<link rel="stylesheet" href="movieTheaterList.css"/>
	<link href="https://fonts.googleapis.com/css?family=Slabo+27px" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Calligraffitti" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Courgette" rel="stylesheet">
	
	<!-- Date time JavaScript -->
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
				<h1 class="popular register-here">Movies</h1>
				
			</div>	
		</div>
		
		
	<div class="movieborder">
		
		<!-- TABLE STARTS -->
		<table id="table">
		
			<tr>		 
				<th>MOVIE</th>
				<th>RUN TIME</th>
				<th>IMDB</th>
				<th>MOVIE TYPE</th>
				<th>THEATERS</th>
				<th>SEATS</th>
				<th>SHOW TIME</th>
				<th>BOOK</th> 
  			</tr>
  			
  			<!--Movie Column  -->
  			
  			<%-- <c:out value = "${movie.getName()}" /> --%>
  			<%-- <c:out value = "${movie.getRuntime()}" /> --%>
  			<%-- <c:out value = "${movie.getRating()}" /> --%>
  			<%-- <c:out value = "${movie.getCinRating()}" /> --%>
  			
			
				<c:forEach var="movie" items="${movies}">
				<form method="POST" action="movies">
					<tr>
					<td><input class="hidebg" name="movie" value="${movie.getName()}" readonly/></td>	
					<td><input class="hidebg" name="runtime" value="${movie.getRuntime()}" readonly/></td>	
					<td><input class="hidebg" name="rating" value="${movie.getRating()}" readonly/></td>
					<td><input class="hidebg" name="cinerating" value="${movie.getCinRating()}" readonly/></td>
					<td>
					
					<div class="styled-select green rounded">
					<select name="theatre" id="opt" onchange="theaterSelect();">
					<c:forEach var="theatre" items="${theatres.get(movie.getName())}">		
						<option><c:out value = "${theatre}" /></option>
					</c:forEach>
					</select>
					</div>
					
					</td>	
					<td><input class="seat" type="number" name="seat" min="1" max="100" required/></td>
					<!-- <td><button class="button button2">Confirm</button></td> -->
					<td><input class="datetime" required/></td>
					<td><input type="submit" class="button button2" value="Confirm"/></td>
					</tr>
					 </form>
				</c:forEach>
			 
			
			<!-- <script>
				/* This gives movie name in the row */
				$("button").click(function(){
					 var name = $(this).closest('tr').find('#movie').eq(0).text(); 
					 /* Can also do */
					/* var name = $(this).closest('tr').find('td').eq(0).text(); */
					
					console.log(name);
				});
						
			</script>
			 -->
			
			
		</table>
		
		<!-- TABLE ENDS -->	
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
 
 <!-- DATE TIME JS -->
 <!--Date field-->



<!--Initializing-->
<script>
	$(".datetime").datetimepicker({
		step: 15
	});
	
</script>
 
 
 </body>
 </html>
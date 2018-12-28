<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
 <head>
	<title>Book My Cinema</title>
	<link rel="stylesheet" href="movies.css"/>
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
				<h1 class="popular register-here">Movies</h1>
				
			</div>
			
		</div>
		
		
		<div class="movieborder">
			
			<table>
  <tr>
    <th>Movie</th>
	<th>Run time</th>
    <th>IMDB Rating</th>
	<th>Type</th>
	<th>Theatres</th>
	<th>Seats</th>
	<th>Book</th>
   
	
  </tr>
  <tr>
    <td class="moviename">Avengers: Infinity Wars</td>
    <td>2</td>
    <td>9.2</td>
	<td>U</td>
	<!-- First dropdown -->
	<td><div class="styled-select green rounded">
  <select>
    <option>Cineplex Cinemas Abbotsford</option>
    <option>Cineplex Cinemas Metropolis</option>
    <option>Galaxy Cinemas Chilliwack</option>
  </select>
</div></td>
<!-- First dropdown ends-->

<!--First Select seats-->
	<td>
	
	<select>
  <option value="volvo">1</option>
  <option value="saab">2</option>
  <option value="mercedes">3</option>
  <option value="audi">4</option>
</select>
	
	
	</td>
	
	<!--First Select seats end-->
	<td><button class="button button2">Confirm</button></td>
	
  </tr>
  <tr>
    <td class="moviename">Mission Impossible - Fallout</td>
    <td>2.5</td>
    <td>7.7</td>
	<td>PG</td>
	<!-- Second dropdown -->
	<td><div class="styled-select green rounded">
  <select>
    <option>Cineplex Cinemas Abbotsford</option>
    <option>Cineplex Cinemas Metropolis</option>
    <option>Galaxy Cinemas Chilliwack</option>
  </select>
</div></td>
<!-- Second dropdown ends-->

<!--First Select seats-->
	<td>
	
	<select>
  <option value="volvo">1</option>
  <option value="saab">2</option>
  <option value="mercedes">3</option>
  <option value="audi">4</option>
</select>
	
	
	</td>
	
	<!--First Select seats end-->
	
	
	
<td><button class="button button2">Confirm</button></td>
  </tr>
  <tr>
    <td class="moviename">Incredibes 2</td>
    <td>2</td>
    <td>8.5</td>
	<td>FIFTEEN</td>
	<!-- Third dropdown -->
	<td><div class="styled-select green rounded">
  <select>
    <option>Cineplex Cinemas Abbotsford</option>
    <option>Cineplex Cinemas Metropolis</option>
    <option>Galaxy Cinemas Chilliwack</option>
  </select>
</div></td>
<!-- Third dropdown ends-->

<!--First Select seats-->
	<td>
	
	<select>
  <option value="volvo">1</option>
  <option value="saab">2</option>
  <option value="mercedes">3</option>
  <option value="audi">4</option>
</select>
	
	
	</td>
	
	<!--First Select seats end-->
	
	
	
<td><button class="button button2">Confirm</button></td>

  </tr>
  <tr>
    <td class="moviename">Black Panther</td>
    <td>1.5</td>
    <td>6.6</td>
	<td>EIGHTEEN</td>
	<!-- Fourth dropdown -->
	<td><div class="styled-select green rounded">
  <select>
    <option>Cineplex Cinemas Abbotsford</option>
    <option>Cineplex Cinemas Metropolis</option>
    <option>Galaxy Cinemas Chilliwack</option>
  </select>
</div></td>
<!-- Fourth dropdown ends-->


<!--First Select seats-->
	<td>
	
	<select>
  <option value="volvo">1</option>
  <option value="saab">2</option>
  <option value="mercedes">3</option>
  <option value="audi">4</option>
</select>
	
	
	</td>
	
	<!--First Select seats end-->
	
	
	
<td><button class="button button2">Confirm</button></td>
  </tr>
  <tr>
    <td class="moviename">A Star Is Born</td>
    <td>2.5</td>
    <td>7.9</td>
	<td>TWELVE</td>
	<!-- Fifth dropdown -->
	<td><div class="styled-select green rounded">
  <select>
    <option>Cineplex Cinemas Toronto</option>
    <option>Cineplex Cinemas Metropolis</option>
    <option>Galaxy Cinemas Chilliwack</option>
  </select>
</div></td>
<!-- Fifth dropdown ends-->

<!--First Select seats-->
	<td>
	
	<select>
  <option value="volvo">1</option>
  <option value="saab">2</option>
  <option value="mercedes">3</option>
  <option value="audi">4</option>
</select>
	
	
	</td>
	
	<!--First Select seats end-->
	
	
<td><button class="button button2">Confirm</button></td>
  </tr>
  <tr>
    <td class="moviename">Dead Pool 2</td>
    <td>2</td>
    <td>8.4</td>
	<td>FIFTEEN</td>
	<!-- Sixth dropdown -->
	<td><div class="styled-select green rounded">
  <select>
    <option>Cineplex Cinemas Abbotsford</option>
    <option>Cineplex Cinemas Metropolis</option>
    <option>Galaxy Cinemas Chilliwack</option>
  </select>
</div></td>
<!-- Sixth dropdown ends-->

<!--First Select seats-->
	<td>
	
	<select>
  <option value="volvo">1</option>
  <option value="saab">2</option>
  <option value="mercedes">3</option>
  <option value="audi">4</option>
</select>
	
	
	</td>
	
	<!--First Select seats end-->
<td><button class="button button2">Confirm</button></td>
  </tr>
</table>
			
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
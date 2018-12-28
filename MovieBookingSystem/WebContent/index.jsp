<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
 <head>
	<title>Book My Cinema</title>
	<link rel="stylesheet" href="mainpage.css"/>
	<link href="https://fonts.googleapis.com/css?family=Slabo+27px" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Calligraffitti" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Courgette" rel="stylesheet">
 </head>
 <body>
	<header>
	
    <div class="main-head">
    		
    	
		
			<a href="index.jsp"><img class="logo" src="mylogo.png"></a>
		
		
		<nav class="nav1">
		
		        
			
		
		
			
			<ul>
				<c:choose>
					<c:when test="${not empty param.login}">
										
					</c:when>
					<c:otherwise>
						<li><a href="registration.jsp">Register</a></li>
					</c:otherwise>
				</c:choose>
				
						
				<c:choose>
					<c:when test = "${not empty param.login}">
						<li><a href = "index.jsp">Logout</a></li>
						
				   </c:when>
				   
				   <c:otherwise>
				   		<li><a href = "login.jsp">Login</a></li>
				   </c:otherwise>
				</c:choose>
				
				
			</ul>
		</nav>
		
		<nav class="nav2">
		
			<%-- <ul>
				<c:if test="${not empty param.login}">
				<h1 class="welcome">Welcome ${name}</h1>
				</c:if>
			</ul> --%>
	
				<ul>
				<li><a href="theatre.jsp">Theatres</a></li>
				<!-- <li><a href="movieTheaterList.jsp">Movies</a></li> -->
				<li><a href="<%=request.getContextPath()%>/movies">Movies</a></li>
				<li><a href="bookingConfirmation.jsp">Cities</a></li>
				<input type="text" placeholder="Search..">
					
				</ul>
		
		
		
		</nav>
		
		
	
	</div>
	
  
 </header>
 
		<div class="page-container">
		
			<div class="row">
				<div class="col2">
				
					<c:if test="${ not empty param.login }">
						<h1 class="popular">Welcome ${name}</h1>
					</c:if>
					
					
					<c:if test="${ empty param.login }">
						<h1 class="popular">Popular Movies of the Week</h1>
					</c:if>
					
					
					

				</div>
			
			</div>
		
			<div class="row img-row">
				<div class="col gallery">
					<a href="http://www.google.com"><img src="movie1.jpg" alt="Peaceful nature image" height="250" width="150"/></a>
				</div>
				
				<div class="col gallery">
					<a href="http://www.google.com"><img src="movie2.jpg" alt="Modern technology" height="250" width="150"/></a>
			
				</div>
				
				<div class="col gallery">
					<a href="http://www.google.com"><img class="float-right"src="movie3.jpg" alt="Nature image" height="250" width="150"/></a>
				</div>
				
				<div class="col gallery">
					<a href="http://www.google.com"><img class="float-right"src="movie4.jpg" alt="Nature image" height="250" width="150"/></a>
				</div>					
			</div>
			
			
		</div>
 
 
		
 
	<footer class="footer">
		<div>
			<ul class="contact-about">
			<li><a href="#">Contact Us</a></li>
			<li><a href="#">About Us</a></li>
			</ul>
		</div>
	
	</footer>
 
 </body>

</html>
</!DOCTYPE>
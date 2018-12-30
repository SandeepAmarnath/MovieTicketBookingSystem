package servlets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessLogic.MovieTheatreListBusinessLogic;
import dao.jpa.MovieJpaDao;
import model.Movie;
import model.Theatre;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet("/movies")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//To get the value from hashmap ;    hm['key'];
		
	/*	String theatre = request.getParameter("theatre");
		String movie = request.getParameter("movie");
		
		System.err.println("After click the theatre is "+ theatre);
		System.err.println("After click the movie is "+ movie);*/
		
		MovieTheatreListBusinessLogic mtbl = new MovieTheatreListBusinessLogic();
		HashMap<String,ArrayList<String>>  movieTheatres = mtbl.getMoviesAndTheatreList();
		
		
		List<Timestamp> showtimes = mtbl.getShowTime("Jumanji", "Carlton Cinemas");
		
		
		
		
		request.setAttribute("showtimes", showtimes);
		MovieJpaDao movieDao = new MovieJpaDao();
		List<Movie> movies = movieDao.readAll();
		System.out.println(showtimes);
//		movies.get(1).getName();
		
		request.setAttribute("movies", movies);
		request.setAttribute("theatres",movieTheatres);
	
		
		
		
		
		request.getRequestDispatcher("movieTheaterList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		MovieTheatreListBusinessLogic mtbl = new MovieTheatreListBusinessLogic();
		HashMap<String,ArrayList<String>>  movieTheatres = mtbl.getMoviesAndTheatreList();
		
		
		
			HttpSession session = request.getSession();
		// TODO Auto-generated method stub
			String movie = request.getParameter("movie");
			String seats = request.getParameter("seat");
			String theater = request.getParameter("theatre");
			String username = (String)session.getAttribute("username");
			
				
			List<Timestamp> showtimes = mtbl.getShowTime(movie, theater);
			
			
			HashMap<String,ArrayList<String>>  theatrePrices = mtbl.getPriceListNonPeak(theater);
			
			
						
			
			request.setAttribute("username", username);
			request.setAttribute("movie", movie);
			request.setAttribute("seats", seats);
			request.setAttribute("theater", theater);
			request.setAttribute("showtime", showtimes);
			
			request.getRequestDispatcher("bookingConfirmation.jsp").forward(request, response);
			
	}

}

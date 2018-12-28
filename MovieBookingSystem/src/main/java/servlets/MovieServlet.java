package servlets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessLogic.MovieTheatreListBusinessLogic;
import dao.jpa.MovieJpaDao;
import model.Movie;

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
		
		
		MovieTheatreListBusinessLogic mtbl = new MovieTheatreListBusinessLogic();
		HashMap<String,ArrayList<String>>  movieTheatres = mtbl.getMoviesAndTheatreList();
		
		MovieJpaDao movieDao = new MovieJpaDao();
		List<Movie> movies = movieDao.readAll();
//		movies.get(1).getName();
		
		request.setAttribute("movies", movies);
		request.setAttribute("theatres",movieTheatres);
	
		
		request.getRequestDispatcher("movieTheaterList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
		// TODO Auto-generated method stub
			String movie = request.getParameter("movie");
			String seats = request.getParameter("seat");
			String theater = request.getParameter("theatre");
			String username = (String)session.getAttribute("username");
			
			request.setAttribute("username", username);
			request.setAttribute("movie", movie);
			request.setAttribute("seats", seats);
			request.setAttribute("theater", theater);
			request.getRequestDispatcher("bookingConfirmation.jsp").forward(request, response);
			
	}

}

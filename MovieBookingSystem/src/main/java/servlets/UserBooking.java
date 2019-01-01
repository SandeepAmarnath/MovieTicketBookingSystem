package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.BookingBusinessLogic;
import dao.DaoFactory;
import dao.interfaces.IBookingDao;
import dao.interfaces.IUserDao;
import model.Booking;
import model.CinemaRating;
import model.Customer;
import model.Movie;
import model.Price;
import model.Show;
import model.Theatre;
import model.User;
import model.UserStatus;

/**
 * Servlet implementation class UserBooking
 */
@WebServlet("/userbooking")
public class UserBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String movie = request.getParameter("movie");
		String theatre = request.getParameter("theatre");
		String seats = request.getParameter("seats");
		String showtimes = request.getParameter("showtimes");
		String price = request.getParameter("price");
		String priceType = request.getParameter("priceType");
		
		int intPrice = Integer.valueOf(price);
		int intSeats = Integer.valueOf(seats);
		
		String priceInDb = String.valueOf(intPrice/intSeats);
		
		BookingBusinessLogic bbl = new BookingBusinessLogic(movie, theatre, showtimes, priceInDb, username);
		
		Movie movieObject = bbl.getMovie();
		Theatre theatreObject = bbl.getTheatre();
		Price priceObject = bbl.getPrice();
		Show showObject = bbl.getShow();
		Customer userObject = bbl.getUser();
		
		System.out.println(movieObject);
		System.out.println(theatreObject);
		System.out.println(priceObject);
		System.out.println(showObject);
		System.out.println(userObject);
		
		
		Booking booking = new Booking().setNumTickets(2).setPrice(priceObject).setShow(showObject).setUser(userObject);
		
		IBookingDao bookingDao = DaoFactory.getBookingDao();
		bookingDao.create(booking);
		
		System.out.println("Success");
	}

}

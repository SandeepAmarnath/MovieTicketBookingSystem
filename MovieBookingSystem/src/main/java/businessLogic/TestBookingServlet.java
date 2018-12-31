package businessLogic;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestBookingServlet
 */
@WebServlet("/booking")
public class TestBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("bookingConfirmation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String movie = request.getParameter("movie");
		String theatre = request.getParameter("theatre");
		String seats = request.getParameter("seats");
		String showtimes = request.getParameter("shows");
		String priceType = request.getParameter("priceType");
		System.out.println(priceType+" is the priceType");
		Character typeOfPrice = 'T';
		
		System.err.println("Price "+ typeOfPrice+"   "+" it is "+priceType);
		System.err.println("Showtimes "+ showtimes);
		System.err.println("Movie "+ movie);
		System.err.println("theatre "+ theatre);
		System.err.println("seats "+ seats);
		
		if (priceType.equals("Enhanced")) {
			typeOfPrice = 'F';
		}
		
		PriceCalculationLogic p = new PriceCalculationLogic();
		
		BigDecimal price = p.getPrice(seats, movie, showtimes, theatre, typeOfPrice);
		
		
		System.out.println(price);
		
		request.setAttribute("cp", price);
		request.setAttribute("movie", movie);
		request.setAttribute("showtimes", showtimes);
		request.setAttribute("theatre", theatre);
		request.setAttribute("seats", seats);
		request.setAttribute("priceType", priceType);
		
		request.getRequestDispatcher("booking.jsp").forward(request, response);		
	}

}

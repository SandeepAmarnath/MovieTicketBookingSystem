package servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.PriceCalculationLogic;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/bookings")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServlet() {
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
		
//		PriceCalculationLogic p = new PriceCalculationLogic();
//		BigDecimal price = p.getPrice("1", "Jumanji", "2018-12-31 20:09:32.0", "INOX", 'T');
//		System.out.println(price);
//		
		
		request.getRequestDispatcher("booking.jsp").forward(request, response);
		

//		String movie = request.getParameter("movie");
//		String theatre = request.getParameter("theatre");
//		String seats = request.getParameter("seats");
//		String showtimes = request.getParameter("shows");
//		String priceType = request.getParameter("priceType");
//		System.out.println(priceType+" is the priceType");
//		Character typeOfPrice = 'T';
//		
//		System.err.println("Price "+ typeOfPrice+"   "+" it is "+priceType);
//		System.err.println("Showtimes "+ showtimes);
//		System.err.println("Movie "+ movie);
//		System.err.println("theatre "+ theatre);
//		System.err.println("seats "+ seats);
//		
//		
//		
//		if (priceType.equals("Enhanced")) {
//			typeOfPrice = 'F';
//		}
//		
////		BigDecimal calculatedPrice = priceCalculate.getPrice("1", "Jumanji", "2018-12-31 20:09:32.0", "INOX", 'T');
//		
////		request.setAttribute("cp", calculatedPrice);
////		request.setAttribute("movie", movie);
////		request.setAttribute("theatre", theatre);
////		request.setAttribute("seats", seats);
////		request.setAttribute("shows", showtimes);
//
////		BigDecimal price = p.getPrice("1", "Jumanji", "2018-12-31 20:09:32.0", "INOX", 'T');
//		System.out.println(calculatedPrice+" is the calculated price");
//		
//		request.getRequestDispatcher("bookingConfirmation.jsp").forward(request, response);
	}

}

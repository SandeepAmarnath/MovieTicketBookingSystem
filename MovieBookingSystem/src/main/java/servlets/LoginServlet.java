package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessLogic.ABL;
import businessLogic.AuthenticationBusinessLogic;
import dao.DaoFactory;
import dao.interfaces.IUserDao;
import dao.interfaces.generic.Authenticator;
import dao.jpa.CustomerJpaDao;
import dao.jpa.JpaDaoFactory;
import model.Customer;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
//		IUserDao<Customer> customer = JpaDaoFactory.getCustomerDao();
//			
//		Customer cust = customer.login(username, password);
		
		
//		AuthenticationBusinessLogic<Customer> cust = new AuthenticationBusinessLogic<>(Customer.class);
//		Authenticator<Customer> authDao = DaoFactory.getCustomerDao();
//		cust.setAuthDao(authDao);
		String type="Customer";
		
		AuthenticationBusinessLogic<? extends User> abl;
		Class<? extends User> userType;
		Authenticator<? extends User> authDao;
		User user=null;
		
		if(type.equals("Customer")){
			userType=Customer.class;
			abl=new AuthenticationBusinessLogic<>(userType);
			authDao = DaoFactory.getUserDao(userType);
			abl.setAuthDao((Authenticator) authDao);
			user = abl.login(username, password);
			
		}
		
		
//		 user.login(username, password);
		
		if (user==null) {
			
			response.sendRedirect("login.jsp?err=1");
			return;
		}
		else{
			
			session.setAttribute("username", user.getUsername());
			System.out.println("The value of username getusername() is "+user.getUsername());
			System.out.println("The value of user.getFirstNAme() is "+user.getFirstName());
			request.setAttribute("username", user.getUsername());
			request.setAttribute("name", user.getFirstName());
			request.getRequestDispatcher("index.jsp?login=1").forward(request, response);
			
		}
		
	}

}

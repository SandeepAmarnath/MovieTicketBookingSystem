package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.AuthenticationBusinessLogic;
import dao.DaoFactory;
import dao.interfaces.IUserDao;
import dao.interfaces.generic.Authenticator;
import exceptions.UserDataException;
import model.Customer;
import model.User;
import model.UserStatus;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = "Customer";
		AuthenticationBusinessLogic<? extends User> abl=null;
		Class<? extends User> userType;
		Authenticator<? extends User> authDao;
		if(type.equals("Customer")){
			userType=Customer.class;
			abl=new AuthenticationBusinessLogic<>(userType);
			authDao = DaoFactory.getUserDao(userType);
			abl.setAuthDao((Authenticator) authDao);
		}
		
		
//		IUserDao<Customer> customerDao = DaoFactory.getCustomerDao();
		
		PrintWriter out = response.getWriter();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String bday = request.getParameter("bday");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");
	
		
		
//		User user = new Customer().setUsername(uname).setFirstName(fname).setLastName(lname)
//				.setEmail(email).setPassword(password).setPhoneNumber(mobile).setUserStatus(UserStatus.ACTIVE).setAge(intAge);
				
		LocalDate todayDate = LocalDate.now();
		LocalDate userBday = LocalDate.parse(bday);
		
		int age = (int) ChronoUnit.YEARS.between(userBday, todayDate);
		
		try {
			abl.register(uname,mobile, password, fname, lname, email, age);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (UserDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		int intAge = Integer.valueOf(age);
//		
//		User user = new Customer().setUsername(uname).setFirstName(fname).setLastName(lname)
//				.setEmail(email).setPassword(password).setPhoneNumber(mobile).setUserStatus(UserStatus.ACTIVE).setAge(intAge);
//		
//		customerDao.create((Customer)user);
//		System.out.println("Created customer succesfully");
//		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}

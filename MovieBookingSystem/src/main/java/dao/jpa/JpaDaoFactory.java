package dao.jpa;

import dao.interfaces.IBookingDao;
import dao.interfaces.ICityDao;
import dao.interfaces.IMovieDao;
import dao.interfaces.IPriceDao;
import dao.interfaces.IScreenDao;
import dao.interfaces.IShowDao;
import dao.interfaces.ITheatreDao;
import dao.interfaces.IUserDao;
import dao.interfaces.PriceJpaDao;
import model.Admin;
import model.Customer;


public class JpaDaoFactory {
	
	private JpaDaoFactory() {
		
	}

	public static final IUserDao<Customer> getCustomerDao(){
		return new CustomerJpaDao();
	}
	
	public static final IUserDao<Admin> getAdminDao() {
		return new AdminJpaDao();
	}
	
	public static final ITheatreDao getTheatreDao(){
		return new TheatreJpaDao();
	}
	
	public static final IMovieDao getMovieDao(){
		return new MovieJpaDao();
	}
	
	public static final IScreenDao getScreenDao(){
		return new ScreenJpaDoa();
	}
	
	public static final IBookingDao getBookingDao(){
		return new BookingJpaDao();
	}
	
	public static final ICityDao getCityDao(){
		return new CityJpaDao();
	}
	
	public static final IShowDao getShowDao(){
		return new ShowJpaDao();
	}
	
	public static final IPriceDao getPriceDao(){
		return new PriceJpaDao();
	}
	
}

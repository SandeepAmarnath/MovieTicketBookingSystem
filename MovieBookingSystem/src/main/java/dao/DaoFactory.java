package dao;

import dao.interfaces.IBookingDao;
import dao.interfaces.ICityDao;
import dao.interfaces.IMovieDao;
import dao.interfaces.IPriceDao;
import dao.interfaces.IScreenDao;
import dao.interfaces.IShowDao;
import dao.interfaces.ITheatreDao;
import dao.interfaces.IUserDao;
import dao.jpa.JpaDaoFactory;
import model.Admin;
import model.Customer;
import model.User;

public class DaoFactory {
	
	@SuppressWarnings("unchecked")
	public static final <T extends User> IUserDao<T> getUserDao(Class<T> clz) {
		if (clz == Customer.class)
			return (IUserDao<T>) getCustomerDao();
		else if (clz == Admin.class)
			return (IUserDao<T>) getAdminDao();
		else
			throw new IllegalArgumentException("Unknown type when getting a generic UserDao");
	}

	
	public static final IUserDao<Customer> getCustomerDao() {
		return JpaDaoFactory.getCustomerDao();
	}
	
	public static final IUserDao<Admin> getAdminDao() {
		return JpaDaoFactory.getAdminDao();
	}
	
	
	public static final ITheatreDao getTheatreDao(){
		return JpaDaoFactory.getTheatreDao();
	}
	
	public static final IMovieDao getMovieDao(){
		return JpaDaoFactory.getMovieDao();
	}
	
	public static final IScreenDao getScreenDao(){
		return JpaDaoFactory.getScreenDao();
	}
	
	public static final IBookingDao getBookingDao(){
		return JpaDaoFactory.getBookingDao();
	}
	
	public static final ICityDao getCityDao(){
		return JpaDaoFactory.getCityDao();
	}
	
	public static final IShowDao getShowDao(){
		return JpaDaoFactory.getShowDao();
	}
	
	public static final IPriceDao getPriceDao(){
		return JpaDaoFactory.getPriceDao();
	}
	
}

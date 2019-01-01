package businessLogic;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.DaoFactory;
import dao.interfaces.IUserDao;
import dao.interfaces.PriceJpaDao;
import dao.jpa.EMFactory;
import dao.jpa.MovieJpaDao;
import dao.jpa.ShowJpaDao;
import dao.jpa.TheatreJpaDao;
import dao.jpa.UserJpaDao;
import model.Customer;
import model.Movie;
import model.Price;
import model.Show;
import model.Theatre;
import model.User;

public class BookingBusinessLogic {
	
	private String movie;
	private String theatre;
	private String showtime;
	private String price;
	private String username;
	private int theatreId=0;
	private int movieId = 0;
	private int priceId = 0;
	private int showId =0;
	
	public BookingBusinessLogic(String movie, String theatre, String showtime, String price, String username) {
		this.movie = movie;
		this.theatre = theatre;
		this.showtime = showtime;
		this.price = price;
		this.username = username;
		getData();
	}
	
	private void getData() {
			
		EntityManager em = EMFactory.getEntityManager();
			
		Query q = em.createNativeQuery(""
				+ "SELECT t.theatre_id, m.movie_id, sh.show_id, p.price_id, sh.show_time, t.theatre_name, "
				+ "m.movie_name, p.price FROM theatre t "
				+ "JOIN screen s ON t.theatre_id = s.theatre_id "
				+ "JOIN show sh ON sh.screen_id = s.screen_id "
				+ "JOIN movie m ON m.movie_id = sh.movie_id "
				+ "JOIN price p ON p.theatre_id = t.theatre_id "
				+ "WHERE t.theatre_name=?1 AND m.movie_name=?2 AND sh.show_time=?3 "
				+ "AND p.price=?4");
		
		q.setParameter(1, theatre);
		q.setParameter(2, movie);
		q.setParameter(3, Timestamp.valueOf(showtime));
		q.setParameter(4, price);

		List<Object[]> all = q.getResultList();
		
		
		for (Object[] objects : all) {
			ArrayList<String> strArray = new ArrayList<String>();
			System.err.println((BigDecimal)objects[0]+ "        "+"         "+(BigDecimal)objects[1]+"   "
					+ "   "+(BigDecimal)objects[2]+"           "+ (BigDecimal)objects[3]+ "         "
					+ "    "+(Timestamp)objects[4]+"         "+(String)objects[5]+"         "
					+ "  "+(String)objects[6]+"           "+(BigDecimal)objects[7]);
			
			theatreId = ((BigDecimal)objects[0]).intValue();
			movieId = ((BigDecimal)objects[1]).intValue();
			showId = ((BigDecimal)objects[2]).intValue();
			priceId = ((BigDecimal)objects[3]).intValue();	
							
		}
		
	}
	 
	public Movie getMovie() {
		
		MovieJpaDao mDao = new MovieJpaDao();
		return mDao.readby(movieId);
//		System.out.println(mDao.readby(movieId));

	}

	public Theatre getTheatre() {
		
		TheatreJpaDao tDao = new TheatreJpaDao();
		return tDao.readby(theatreId);
//		System.out.println(tDao.readby(theatreId));
	}
	
	public Price getPrice() {
		
		PriceJpaDao pDao = new PriceJpaDao();
		return pDao.readby(priceId);
//		System.out.println(pDao.readby(priceId));
	}
	
	public Show getShow() {
		
		ShowJpaDao sDao = new ShowJpaDao();
		return sDao.readby(showId);
//		System.out.println(sDao.readby(showId));
	}
	
	public Customer getUser() {
		IUserDao<Customer> customerDao = DaoFactory.getCustomerDao();
		return customerDao.readByUsername(username);
	}
	
}


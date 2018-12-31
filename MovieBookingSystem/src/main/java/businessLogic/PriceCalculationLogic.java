package businessLogic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import dao.jpa.EMFactory;
import dao.jpa.MovieJpaDao;
import model.Movie;

public class PriceCalculationLogic {
	
//	public static void main(String[] args) {
//		getPrice("2", "Dracula", "2018-12-31 20:09:32.0", "INOX", 'T');
//	}
	
	public BigDecimal getPrice(String seats, String movie, String showtimes, String theatre, Character priceType) {
		
		System.err.println("I was called ");
		EntityManager em = EMFactory.getEntityManager();
			
		
		Query q = em.createNativeQuery(""
				+ "SELECT p.price,sh.show_time, s.screen_id "
				+ "FROM theatre t JOIN SCREEN s ON s.theatre_id = t.theatre_id "
				+ "JOIN show sh ON sh.screen_id = s.screen_id "
				+ "JOIN movie m ON m.movie_id = sh.movie_id "
				+ "JOIN price p ON p.theatre_id=t.theatre_id "
				+ "WHERE p.ISDISCOUNTED=?1 AND m.movie_name=?2 AND t.theatre_name=?3 "
				+ "AND sh.show_time=?4 AND p.ISPEAKRATE=?5");

		q.setParameter(1, priceType);
		q.setParameter(2, movie);
		q.setParameter(3, theatre);
		q.setParameter(4, Timestamp.valueOf(showtimes));
		q.setParameter(5, 'F');

		
		
		List<Object[]> all = q.getResultList();
		
		BigDecimal price = null;
		
		for (Object[] objects : all) {
			ArrayList<String> strArray = new ArrayList<String>();
//			System.err.println((BigDecimal)objects[0]+ "        "+"         "+(Timestamp)objects[1]+"      "+(BigDecimal)objects[2]);
			
			price = (BigDecimal)objects[0];
			
		}
		
		int seat = Integer.valueOf(seats);
		
//		System.out.println("The price is "+price);
		
		System.out.println("I returned "+price);
		price = price.multiply(new BigDecimal(seat));
		
		
		
		return price;
	}
	

}

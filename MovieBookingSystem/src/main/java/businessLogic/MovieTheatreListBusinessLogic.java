package businessLogic;

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

public class MovieTheatreListBusinessLogic {
	
	
//	public static void main(String[] args) {
//		
//		System.out.println(getPriceListNonPeak("INOX"));
//		
//	}
	
	public HashMap<String,ArrayList<String>> getMoviesAndTheatreList() {
		
		HashMap<String,ArrayList<String>> movieTheatre=new HashMap<String,ArrayList<String>>(); 
		
		
		
		
		
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		
		
		Query q = em.createNativeQuery("select m.movie_name,t.theatre_name,s.capacity from theatre t "
				+ "join screen s on s.theatre_id=t.theatre_id "
				+ "join show sh on sh.screen_id = s.screen_id "
				+ "join movie m on m.movie_id=sh.movie_id order by m.movie_name");
		
		List<Object[]> all = q.getResultList();
		
		for (Object[] objects : all) {
			ArrayList<String> strArray = new ArrayList<String>();
			System.err.println((String)objects[0]+ "      "+(String)objects[1]);
			
			
			
			if (! movieTheatre.containsKey((String)objects[0])) {
				
				movieTheatre.put((String)objects[0], strArray);
				strArray.add((String)objects[1]);
				
			}
			
			else {
				if (! movieTheatre.get((String)objects[0]).contains((String)objects[1])) {
					movieTheatre.get((String)objects[0]).add((String)objects[1]);
				}
				
			}
			
		}
		

		em.getTransaction().commit();
		em.close();
		
		return movieTheatre;
	}
	
	
	public List<Timestamp> getShowTime(String movie, String theatre) {
		
		
		List<Timestamp> showTimes = new ArrayList<>();
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
	
	/*	
		String movie = "Jumanji";
		String theatre = "Carlton Cinemas";*/
		Query q = em.createNativeQuery("select sh.show_id,m.MOVIE_NAME,t.THEATRE_NAME,s.SCREEN_ID,s.CAPACITY,sh.show_time FROM screen s "
									  + "JOIN show sh ON sh.screen_id=s.screen_id "
									  + "JOIN movie m ON sh.movie_id=m.movie_id "
									  + "JOIN theatre t ON t.theatre_id=s.theatre_id where m.movie_name=?1 and t.theatre_name=?2");
		q.setParameter(1, movie);
		q.setParameter(2, theatre);
		
		List<Object[]> all = q.getResultList();
		
		for (Object[] objects : all) {
			
			ArrayList<Timestamp> strArray = new ArrayList<Timestamp>();
			SimpleDateFormat simpleDateFormat = null;
//			System.err.println((BigDecimal)objects[0]+ "      "+(String)objects[1]+ "      "+(String)objects[2]+ "   "
//					+ "   "+(BigDecimal)objects[3]+ "      "+(BigDecimal)objects[4]+"         "+(Timestamp)objects[5]);
			Timestamp time = (Timestamp)objects[5];
//			System.out.println("The time is "+time);
			showTimes.add(time);
		}
		return showTimes;
		
	}
	
	public HashMap<String,ArrayList<String>> getPriceListNonPeak(String theatre) {
		
		HashMap<String,ArrayList<String>> theatrePrices=new HashMap<String,ArrayList<String>>(); 
		
		List<String> prices = new ArrayList<String>();
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		Query q = em.createNativeQuery("select t.THEATRE_NAME,p.ISDISCOUNTED,p.ISENHANCED,p.PRICE from price p "
										+ "join theatre t on t.theatre_id= p.theatre_id "
										+ "where ISPEAKRATE='F'");
		List<Object[]> all = q.getResultList();
		for (Object[] object : all) {
			ArrayList<String> strArray = new ArrayList<String>();
			
//			System.out.println((String)object[0]+"   "+((Character)object[1]).toString()+" "
//								+ "        "+((Character)object[2]).toString()+"      "+((Character)object[3]).toString()+"      "+((BigDecimal)object[4]).toString());

		
		
			
			if (! theatrePrices.containsKey((String)object[0])) {
				theatrePrices.put((String)object[0], strArray);
				strArray.add(((Character)object[1]).toString());
				strArray.add(((Character)object[2]).toString());
				strArray.add(((BigDecimal)object[3]).toString());
			}
			
			else {
				theatrePrices.get((String)object[0]).add(((Character)object[1]).toString());
				theatrePrices.get((String)object[0]).add(((Character)object[2]).toString());
				theatrePrices.get((String)object[0]).add(((BigDecimal)object[3]).toString());
			}
			
		}
		return theatrePrices;
	}
	
	
	
	
}

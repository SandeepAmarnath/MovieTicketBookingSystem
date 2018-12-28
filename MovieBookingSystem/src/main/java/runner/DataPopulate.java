package runner;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Admin;
import model.Booking;
import model.CinemaRating;
import model.City;
import model.Customer;
import model.Movie;
import model.Price;
import model.Screen;
import model.Show;
import model.Theatre;
import model.User;
import model.UserStatus;

public class DataPopulate {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MovieBookingSystem");

		EntityManager em = emf.createEntityManager();
		

		City toronto = new City().setName("Toronto");
		
		
		
		User user = new Customer().setUsername("SandeepAmarnath").setFirstName("Sandeep").setLastName("Amarnath")
				.setEmail("sandeep@gmail.com").setPassword("123").setPhoneNumber("54321").setUserStatus(UserStatus.ACTIVE);
		
		User admin = new Admin().setUsername("BharathR").setFirstName("Bharath").setLastName("Raj")
				.setEmail("Bharath@fdmgroup.com").setPassword("123").setPhoneNumber("54321").setUserStatus(UserStatus.ACTIVE);
		
		Movie movie = new Movie().setName("Hucha").setRuntime(2).setRating(4.5).setCinRating(CinemaRating.KIDS);
		
		Show show = new Show().setMovie(movie).setShowTime(LocalDateTime.now());
		
		Price price = new Price().setPrice(30).setDiscounted(true).setPeakRate(false).setEnhanced(true);
		Price price2 = new Price().setPrice(300).setDiscounted(true).setPeakRate(false).setEnhanced(true);
		
		Set<Screen> screens = new HashSet<>();
//		
		Screen firstScreen = new Screen().setCapacity(80).setShowing(show);
		Screen secondScreen = new Screen().setCapacity(100).setShowing(show);
		Screen thirdScreen = new Screen().setCapacity(150).setShowing(show);
//		
		screens.add(firstScreen);
		screens.add(secondScreen);
		screens.add(thirdScreen);
		
		Theatre th = new Theatre().setAddress("120 Adelaide street, Toronto").setCity(toronto).setTheatreName("INOX").setPrice(price).setScreens(screens);
		
		Booking booking = new Booking().setNumTickets(2).setPrice(price).setShow(show).setUser(user);
//		th.addScreen(firstScreen);
//		th.addScreen(secondScreen);
//		th.addScreen(thirdScreen);
//		
		
		em.getTransaction().begin();
		em.persist(toronto);
		em.persist(user);
		em.persist(admin);
		em.persist(movie);
		em.persist(price);
		em.persist(firstScreen);
		em.persist(secondScreen);
		em.persist(thirdScreen);
		em.persist(show);
		em.persist(th);
		em.persist(booking);
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}

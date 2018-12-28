package client;

import java.time.LocalDateTime;
import java.util.List;

import dao.DaoFactory;
import dao.interfaces.ICityDao;
import dao.interfaces.IMovieDao;
import dao.interfaces.IPriceDao;
import dao.interfaces.IScreenDao;
import dao.interfaces.IShowDao;
import dao.interfaces.ITheatreDao;
import dao.interfaces.IUserDao;
import dao.jpa.JpaDaoFactory;
import model.Admin;
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

public class DataAccessDemo {

	public static void main(String[] args) {
		
		//      City
//			ICityDao cityDao = DaoFactory.getCityDao();
		
		
		
		
		//Creating 5 cities
//			City halifax = new City().setName("Halifax");
//			City toronto = new City().setName("Toronto");
//			cityDao.create(toronto);
		/*City toronto = new City().setName("Bangalore");
		City halifax = new City().setName("Halifax");
		City windsor = new City().setName("Windsor");
		City vancouver = new City().setName("Vancouver");
		City manitoba = new City().setName("Manitoba");
		cityDao.create(toronto);
		cityDao.create(halifax);
		cityDao.create(windsor);
		cityDao.create(vancouver);
		cityDao.create(manitoba);
		System.out.println("Finished");*/
//			City vancouver = new City().setName("Vancouver");
		
		
		//Testing cityDao.readAll..Working fine
		/*List<City> mycities = cityDao.readAll();
		
		for(City city : mycities){
			System.out.println("The city name is " + city.getName());
		}
		
		//Testing cityDao.readby(id)..Working fine
		/*City city = cityDao.readby(1);
		System.out.println(city.getCityId());*/
		
		
		//Testing cityDao.readbyName..Working fine
		/*City city = cityDao.readbyName("Manitoba");
		System.out.println(city.getCityId());*/
		
		
		
		
		//      User (Customer and Admin
//	
//		IUserDao<Customer> customerDao = DaoFactory.getCustomerDao();
//		IUserDao<Admin> adminDao = DaoFactory.getAdminDao();
		
		//IUserDao create is working for Customer and Admin
		
		//Creating 3 Customers and 2 Admins 
		
		/*User sandeep = new Customer().setUsername("SandeepAmarnath").setFirstName("Sandeep").setLastName("Amarnath")
				.setEmail("sandeep@gmail.com").setPassword("123").setPhoneNumber("9028028894").setUserStatus(UserStatus.ACTIVE);
		
		customerDao.create((Customer)sandeep);
		
		
		User vamsi = new Customer().setUsername("VamsiPaidipalli").setFirstName("Vamsi").setLastName("Paidipalli")
				.setEmail("vp@gmail.com").setPassword("123").setPhoneNumber("9564562214").setUserStatus(UserStatus.ACTIVE);
		customerDao.create((Customer)vamsi);
		
		
		User surya = new Customer().setUsername("SuryaNarayana").setFirstName("Surya").setLastName("Narayana")
				.setEmail("Narayana@gmail.com").setPassword("123").setPhoneNumber("9568543546").setUserStatus(UserStatus.ACTIVE);
		customerDao.create((Customer)surya);
		
		
		User anand = new Admin().setUsername("AnandRajendran").setFirstName("Anand").setLastName("Rajendran")
				.setEmail("ar@gmail.com").setPassword("123").setPhoneNumber("6577844569").setUserStatus(UserStatus.ACTIVE);
		adminDao.create((Admin)anand);
		
		
		User navin = new Admin().setUsername("NavinReddy").setFirstName("Navin").setLastName("Reddy")
				.setEmail("navinreddy@gmail.com").setPassword("123").setPhoneNumber("2563438713").setUserStatus(UserStatus.ACTIVE);
		adminDao.create((Admin)navin);*/
		
		
		// readbyEmail and readbyUsername works for both admin and customer
		
		/*System.out.println(adminDao.readByEmail("ar@gmail.com"));
		System.out.println(customerDao.readByUsername("SandeepAmarnath"));
		System.out.println(adminDao.readByUsername("AnandRajendran"));*/
		
		
		
		
		
		// Movie
		
//		IMovieDao movieDao = DaoFactory.getMovieDao();
		
		//Create tables. It works
		
		/*Movie jumanji = new Movie().setName("Jumanji").setRuntime(2).setRating(4.5).setCinRating(CinemaRating.KIDS);
		Movie dracula = new Movie().setName("Dracula").setRuntime(2).setRating(4.7).setCinRating(CinemaRating.TWELVE);
		Movie wolverine = new Movie().setName("Wolverine").setRuntime(1).setRating(3.5).setCinRating(CinemaRating.FIFTEEN);
		Movie assasins = new Movie().setName("13 Assasins").setRuntime(2).setRating(4.2).setCinRating(CinemaRating.U);
		Movie irobot = new Movie().setName("I Robot").setRuntime(2).setRating(3.9).setCinRating(CinemaRating.KIDS);
		movieDao.create(dracula);
		movieDao.create(wolverine);
		movieDao.create(assasins);
		movieDao.create(irobot);
		System.out.println("Done");*/
		
		
//		readall works		
//		System.out.println(movieDao.readAll());
		
		
		//readby(id) works
		//System.out.println(movieDao.readby(2));
		
		//readby(id) works
		//System.out.println(movieDao.readby(2));
		
		//readbyKidsMovie works 
		//System.out.println(movieDao.readByKidsMovies());
		
		
		
	   //Show works	
//		IShowDao showDao =  DaoFactory.getShowDao();
//		Movie avatar = new Movie().setName("Avatar").setRuntime(2).setRating(4.5).setCinRating(CinemaRating.KIDS);
//		movieDao.create(avatar);
//		Show show = new Show().setMovie(avatar).setShowTime(LocalDateTime.now());
//		showDao.create(show);
		
		//show readall works
//		System.out.println(showDao.readAll());
		//show readby(id) works
//		System.out.println(showDao.readby(3));
		
		
//		IPriceDao priceDao = DaoFactory.getPriceDao();
		
//	
//		Price discounted1 = new Price().setPrice(30).setDiscounted(true).setPeakRate(false).setEnhanced(false);
//		Price enhanced1 = new Price().setPrice(50).setDiscounted(false).setPeakRate(false).setEnhanced(true);
		
//		Price peakrateWithEnhanced1 = new Price().setPrice(90).setDiscounted(false).setPeakRate(true).setEnhanced(true);
//		Price peakrate1 = new Price().setPrice(70).setDiscounted(false).setPeakRate(true).setEnhanced(false);
//		Price discountedWithEnhanced1 = new Price().setPrice(35).setDiscounted(true).setPeakRate(false).setEnhanced(true);
//		
//		priceDao.create(discounted1);
//		priceDao.create(enhanced1);
//		priceDao.create(peakrateWithEnhanced1);
//		priceDao.create(peakrate1);
//		priceDao.create(discountedWithEnhanced1);
//		
//		System.out.println("Done creating Prices");
		
//		ITheatreDao theatreDao = DaoFactory.getTheatreDao();
//		Theatre th = new Theatre().setAddress("120 Adelaide street, Toronto").setCity(toronto).setTheatreName("INOX").setPrice(enhanced1);
//		theatreDao.create(th);
//		System.err.println("Done");
		
		//Theatre Read all works
//		System.out.println(theatreDao.readAll());
		//Theatre Read by id works
//		System.out.println(theatreDao.readby(2));
		//Theatre Read by address works
//		System.out.println(theatreDao.readbyAddress("501 Brunswick street, Halifax"));
		
		//Theatre Read by city works
		
//		System.out.println(theatreDao.readByCity(vancouver));
		
//		IMovieDao movieDao = DaoFactory.getMovieDao();
//		Movie newmovie = new Movie().setName("newMovie").setRuntime(2).setRating(4.5).setCinRating(CinemaRating.KIDS);
//		movieDao.create(newmovie);
//		
//		Show show = new Show().setMovie(newmovie).setShowTime(LocalDateTime.now());
//		IShowDao showDao =  DaoFactory.getShowDao();
//		showDao.create(show);
//		
//		
//		IScreenDao screenDao = DaoFactory.getScreenDao();
//		Screen firstScreen = new Screen().setCapacity(80).setShowing(show);
//		screenDao.create(firstScreen);
//		
//		
//		System.err.println("Done");
	}
}

package client;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import dao.DaoFactory;
import dao.interfaces.IBookingDao;
import dao.interfaces.ICityDao;
import dao.interfaces.IMovieDao;
import dao.interfaces.IPriceDao;
import dao.interfaces.IScreenDao;
import dao.interfaces.IShowDao;
import dao.interfaces.ITheatreDao;
import dao.interfaces.IUserDao;
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
//import oracle.net.aso.i;
//import oracle.net.aso.j;

public class FillDb {
	
	public static void main(String[] args) {
		
		
			//City
			ICityDao cityDao = DaoFactory.getCityDao();
			City toronto = new City().setName("Toronto");
			City halifax = new City().setName("Halifax");
			City windsor = new City().setName("Windsor");
			City vancouver = new City().setName("Vancouver");
			City manitoba = new City().setName("Manitoba");
			City bangalore = new City().setName("Bangalore");
			cityDao.create(bangalore);
			cityDao.create(toronto);
			cityDao.create(halifax);
			cityDao.create(windsor);
			cityDao.create(vancouver);
			cityDao.create(manitoba);
			
			
			//User (Customer and Admin)
			
			IUserDao<Customer> customerDao = DaoFactory.getCustomerDao();
			IUserDao<Admin> adminDao = DaoFactory.getAdminDao();
			
			User sandeep = new Customer().setUsername("SandeepAmarnath").setFirstName("Sandeep").setLastName("Amarnath")
					.setEmail("sandeep@gmail.com").setPassword("123").setPhoneNumber("9028028894").setUserStatus(UserStatus.ACTIVE).setAge(15);
			
			User vamsi = new Customer().setUsername("VamsiPaidipalli").setFirstName("Vamsi").setLastName("Paidipalli")
					.setEmail("vp@gmail.com").setPassword("123").setPhoneNumber("9564562214").setUserStatus(UserStatus.ACTIVE).setAge(17);
			
			
			User surya = new Customer().setUsername("SuryaNarayana").setFirstName("Surya").setLastName("Narayana")
					.setEmail("Narayana@gmail.com").setPassword("123").setPhoneNumber("9568543546").setUserStatus(UserStatus.ACTIVE).setAge(19);
			
		
			User anand = new Admin().setUsername("AnandRajendran").setFirstName("Anand").setLastName("Rajendran")
					.setEmail("ar@gmail.com").setPassword("123").setPhoneNumber("6577844569").setUserStatus(UserStatus.ACTIVE).setAge(25);
			
				
			User navin = new Admin().setUsername("NavinReddy").setFirstName("Navin").setLastName("Reddy")
					.setEmail("navinreddy@gmail.com").setPassword("123").setPhoneNumber("2563438713").setUserStatus(UserStatus.ACTIVE).setAge(14);
			
			
			customerDao.create((Customer)sandeep);
			customerDao.create((Customer)vamsi);
			customerDao.create((Customer)surya);
			adminDao.create((Admin)anand);
			adminDao.create((Admin)navin);
			
			
			//Price
			
			IPriceDao priceDao = DaoFactory.getPriceDao();
			
			Price discounted1 = new Price().setPrice(30).setDiscounted(true).setPeakRate(false).setEnhanced(false);
			Price enhanced1 = new Price().setPrice(50).setDiscounted(false).setPeakRate(false).setEnhanced(true);
			Price peakrateWithEnhanced1 = new Price().setPrice(90).setDiscounted(false).setPeakRate(true).setEnhanced(true);
			Price peakrate1 = new Price().setPrice(70).setDiscounted(false).setPeakRate(true).setEnhanced(false);
			Price discountedWithEnhanced1 = new Price().setPrice(35).setDiscounted(true).setPeakRate(false).setEnhanced(true);
			
			priceDao.create(discounted1);
			priceDao.create(enhanced1);
			priceDao.create(peakrateWithEnhanced1);
			priceDao.create(peakrate1);
			priceDao.create(discountedWithEnhanced1);	
			
			
			
			// Movie
			IMovieDao movieDao = DaoFactory.getMovieDao();
			
			Movie jumanji = new Movie().setName("Jumanji").setRuntime(2).setRating(4.5).setCinRating(CinemaRating.KIDS);
			Movie dracula = new Movie().setName("Dracula").setRuntime(2).setRating(4.7).setCinRating(CinemaRating.TWELVE);
			Movie wolverine = new Movie().setName("Wolverine").setRuntime(1).setRating(3.5).setCinRating(CinemaRating.FIFTEEN);
			Movie assasins = new Movie().setName("13 Assasins").setRuntime(2).setRating(4.2).setCinRating(CinemaRating.U);
			Movie irobot = new Movie().setName("I Robot").setRuntime(2).setRating(3.9).setCinRating(CinemaRating.U);
			Movie avengers = new Movie().setName("Avengers").setRuntime(2).setRating(3.9).setCinRating(CinemaRating.KIDS);
			
			movieDao.create(jumanji);
			movieDao.create(dracula);
			movieDao.create(wolverine);
			movieDao.create(assasins);
			movieDao.create(irobot);
			movieDao.create(avengers);
			
			//Show
			IShowDao showDao = DaoFactory.getShowDao();
			
			Show showJumanjiCarlton = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now());
			Show showJumanjiInox = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now());
			Show showJumanjiFamous = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now());
			Show showJumanjiChilli = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now());
			Show showJumanjiArcade = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now());
			Show showJumanjiJackman = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now());
			Show showJumanjiTed = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now());
			
			
			Show showDracullaCarlton = new Show().setMovie(dracula).setShowTime(LocalDateTime.now());
			Show showDracullaInox = new Show().setMovie(dracula).setShowTime(LocalDateTime.now());
			Show showDracullaArcade = new Show().setMovie(dracula).setShowTime(LocalDateTime.now());
			Show showDracullaTed = new Show().setMovie(dracula).setShowTime(LocalDateTime.now());
			
			Show showWolverineCarlton = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now());
			Show showWolverineInox = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now());
			Show showWolverineChilli = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now());
			Show showWolverineJackman = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now());
			Show showWolverineTed = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now());
			Show showWolverineArcade = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now());
			
			Show showAssasinsFamous = new Show().setMovie(assasins).setShowTime(LocalDateTime.now());
			Show showAssasinsChilli = new Show().setMovie(assasins).setShowTime(LocalDateTime.now());
			Show showAssasinsTed = new Show().setMovie(assasins).setShowTime(LocalDateTime.now());
			
			Show showIrobotCarlton = new Show().setMovie(irobot).setShowTime(LocalDateTime.now());
			Show showIrobotInox = new Show().setMovie(irobot).setShowTime(LocalDateTime.now());
			Show showIrobotFamous = new Show().setMovie(irobot).setShowTime(LocalDateTime.now());
			Show showIrobotJackman = new Show().setMovie(irobot).setShowTime(LocalDateTime.now());
			Show showIrobotTed = new Show().setMovie(irobot).setShowTime(LocalDateTime.now());
			Show showIrobotArcade = new Show().setMovie(irobot).setShowTime(LocalDateTime.now());
			
			Show showAvengersInox = new Show().setMovie(avengers).setShowTime(LocalDateTime.now());	
			Show showAvengersFamous = new Show().setMovie(avengers).setShowTime(LocalDateTime.now());
			Show showAvengersChilli = new Show().setMovie(avengers).setShowTime(LocalDateTime.now());
			Show showAvengersTed = new Show().setMovie(avengers).setShowTime(LocalDateTime.now());
			Show showAvengersArcade = new Show().setMovie(avengers).setShowTime(LocalDateTime.now());
			
			
			showDao.create(showJumanjiCarlton);
			showDao.create(showDracullaCarlton);
			showDao.create(showWolverineCarlton);
			showDao.create(showIrobotCarlton);
			
			showDao.create(showJumanjiInox);
			showDao.create(showDracullaInox);
			showDao.create(showWolverineInox);
			showDao.create(showIrobotInox);
			showDao.create(showAvengersInox);
			
			showDao.create(showJumanjiFamous);
			showDao.create(showAssasinsFamous);
			showDao.create(showIrobotFamous);
			showDao.create(showAvengersFamous);
			
			showDao.create(showJumanjiChilli);
			showDao.create(showWolverineChilli);
			showDao.create(showAssasinsChilli);
			showDao.create(showAvengersChilli);
			
			showDao.create(showJumanjiArcade);
			showDao.create(showDracullaArcade);
			showDao.create(showWolverineArcade);
			showDao.create(showIrobotArcade);
			showDao.create(showAvengersArcade);
			
			showDao.create(showWolverineTed);
			showDao.create(showAssasinsTed);
			showDao.create(showIrobotTed);
			showDao.create(showAvengersTed);
			showDao.create(showJumanjiTed);
			showDao.create(showDracullaTed);			
			
			showDao.create(showJumanjiJackman);
			showDao.create(showWolverineJackman);
			showDao.create(showIrobotJackman);
			
			
			
			
			//Screen
			
			IScreenDao screenDao = DaoFactory.getScreenDao();
			
			Screen carltonCinemaOne = new Screen().setCapacity(80).setShowing(showJumanjiCarlton);
			Screen carltonCinemaTwo = new Screen().setCapacity(65).setShowing(showDracullaCarlton);
			Screen carltonCinemaFour = new Screen().setCapacity(95).setShowing(showWolverineCarlton);
			Screen carltonCinemaThree = new Screen().setCapacity(130).setShowing(showIrobotCarlton);
			
			Screen inoxOne = new Screen().setCapacity(80).setShowing(showJumanjiInox);
			Screen inoxTwo = new Screen().setCapacity(90).setShowing(showDracullaInox);
			Screen inoxThree = new Screen().setCapacity(120).setShowing(showWolverineInox);
			Screen inoxFour = new Screen().setCapacity(130).setShowing(showIrobotInox);
			Screen inoxFive = new Screen().setCapacity(100).setShowing(showAvengersInox);
			
			Screen famousPlayersOne = new Screen().setCapacity(110).setShowing(showJumanjiFamous);
			Screen famousPlayersTwo = new Screen().setCapacity(85).setShowing(showAssasinsFamous);
			Screen famousPlayersThree = new Screen().setCapacity(75).setShowing(showIrobotFamous);
			Screen famousPlayersFour = new Screen().setCapacity(130).setShowing(showAvengersFamous);

			Screen chilliwackOne = new Screen().setCapacity(150).setShowing(showJumanjiChilli);
			Screen chilliwackTwo = new Screen().setCapacity(140).setShowing(showWolverineChilli);
			Screen chilliwackThree = new Screen().setCapacity(100).setShowing(showAssasinsChilli);
			Screen chilliwackFour = new Screen().setCapacity(100).setShowing(showAvengersChilli);
			
			Screen arcadeOne = new Screen().setCapacity(95).setShowing(showJumanjiArcade);
			Screen arcadeTwo = new Screen().setCapacity(75).setShowing(showDracullaArcade);
			Screen arcadeThree = new Screen().setCapacity(80).setShowing(showWolverineArcade);
			Screen arcadeFour = new Screen().setCapacity(120).setShowing(showIrobotArcade);
			Screen arcadeFive = new Screen().setCapacity(135).setShowing(showAvengersArcade);
			
			Screen jackManOne = new Screen().setCapacity(105).setShowing(showJumanjiJackman);
			Screen jackManTwo = new Screen().setCapacity(75).setShowing(showWolverineJackman);
			Screen jackManThree = new Screen().setCapacity(60).setShowing(showIrobotJackman);
			
			Screen tedRogersOne = new Screen().setCapacity(125).setShowing(showJumanjiTed);
			Screen tedRogersTwo = new Screen().setCapacity(115).setShowing(showDracullaTed);
			Screen tedRogersThree = new Screen().setCapacity(90).setShowing(showWolverineTed);
			Screen tedRogersFour = new Screen().setCapacity(80).setShowing(showAssasinsTed);
			Screen tedRogersFive = new Screen().setCapacity(100).setShowing(showIrobotTed);
			Screen tedRogersSix = new Screen().setCapacity(110).setShowing(showAvengersTed);
			
			screenDao.create(carltonCinemaOne);
			screenDao.create(carltonCinemaTwo);
			screenDao.create(carltonCinemaThree);
			screenDao.create(carltonCinemaFour);
			
			screenDao.create(inoxOne);
			screenDao.create(inoxTwo);
			screenDao.create(inoxThree);
			screenDao.create(inoxFour);
			screenDao.create(inoxFive);
			
			screenDao.create(famousPlayersOne);
			screenDao.create(famousPlayersTwo);
			screenDao.create(famousPlayersThree);
			screenDao.create(famousPlayersFour);
			
		
			screenDao.create(chilliwackOne);
			screenDao.create(chilliwackTwo);
			screenDao.create(chilliwackThree);
			screenDao.create(chilliwackFour);
			
			screenDao.create(arcadeOne);
			screenDao.create(arcadeTwo);
			screenDao.create(arcadeThree);
			screenDao.create(arcadeFour);
			screenDao.create(arcadeFive);
			
			screenDao.create(jackManOne);
			screenDao.create(jackManTwo);
			screenDao.create(jackManThree);
			
			screenDao.create(tedRogersOne);
			screenDao.create(tedRogersTwo);
			screenDao.create(tedRogersThree);
			screenDao.create(tedRogersFour);
			screenDao.create(tedRogersFive);
			screenDao.create(tedRogersSix);
			
			
			Set<Screen> carltonCinemaScreens = new HashSet<>(Arrays.asList(carltonCinemaOne,carltonCinemaTwo,carltonCinemaThree,carltonCinemaFour));
			Set<Screen> inoxScreens = new HashSet<>(Arrays.asList(inoxOne,inoxTwo,inoxThree,inoxFour,inoxFive));
			Set<Screen> famousPlayersScreens = new HashSet<>(Arrays.asList(famousPlayersOne,famousPlayersTwo,famousPlayersThree,famousPlayersFour)); 
 			Set<Screen> chilliwackScreens = new HashSet<>(Arrays.asList(chilliwackOne,chilliwackTwo,chilliwackThree,chilliwackFour)); 
			Set<Screen> arcadeScreens = new HashSet<>(Arrays.asList(arcadeOne,arcadeTwo,arcadeThree,arcadeFour,arcadeFive)); 
			Set<Screen> jackManScreens = new HashSet<>(Arrays.asList(jackManOne,jackManTwo,jackManThree));
			Set<Screen> tedRogersScreens = new HashSet<>(Arrays.asList(tedRogersOne,tedRogersTwo,tedRogersThree,tedRogersFour,tedRogersFive,tedRogersSix));
			

			
			
			//Theatre
			
			ITheatreDao theatreDao = DaoFactory.getTheatreDao();
			
			Theatre carltonCinema = new Theatre().setAddress("20 Carlton St, Toronto, ON M5B 2H5").setCity(toronto).setTheatreName("Carlton Cinemas").setPrice(discounted1).setScreens(carltonCinemaScreens);
			Theatre inox = new Theatre().setAddress("501 Brunswick street, Halifax").setCity(halifax).setTheatreName("INOX").setPrice(enhanced1).setScreens(inoxScreens);
			Theatre famousPlayers = new Theatre().setAddress("2190 Yonge St, Toronto, ON M4S 2C6").setCity(windsor).setTheatreName("Famous Players").setPrice(peakrateWithEnhanced1).setScreens(famousPlayersScreens);
			Theatre chilliwack = new Theatre().setAddress("8249 Eagle Landing Parkway, Chilliwack, BC, V2P 7K6").setCity(vancouver).setTheatreName("Galaxy Cinemas Chilliwack").setPrice(peakrate1).setScreens(chilliwackScreens);
			Theatre arcade = new Theatre().setAddress("12 Bedford Road, Manitoba").setCity(manitoba).setTheatreName("Cineplex Arcade").setPrice(discountedWithEnhanced1).setScreens(arcadeScreens);
			Theatre jackMan = new Theatre().setAddress("317 Dundas St W, Toronto, ON M5T 1G4").setCity(toronto).setTheatreName("Jackman Hall").setPrice(discountedWithEnhanced1).setScreens(jackManScreens);
			Theatre tedRogers = new Theatre().setAddress("12 Bedford Road, Manitoba").setCity(manitoba).setTheatreName("Ted Rogers Cinemas").setPrice(discountedWithEnhanced1).setScreens(tedRogersScreens);
			
			
			theatreDao.create(carltonCinema);
			theatreDao.create(inox);
			theatreDao.create(famousPlayers);
			theatreDao.create(chilliwack);
			theatreDao.create(arcade);
			theatreDao.create(jackMan);
			theatreDao.create(tedRogers);
			
			
			
			
			//Booking
			
			IBookingDao bookingDao = DaoFactory.getBookingDao();
			
			Booking bookJumanjiInox = new Booking().setNumTickets(2).setPrice(discounted1).setShow(showJumanjiInox).setUser(sandeep);
			Booking bookDraculaArcade = new Booking().setNumTickets(2).setPrice(enhanced1).setShow(showDracullaArcade).setUser(sandeep);
			
			bookingDao.create(bookJumanjiInox);
			bookingDao.create(bookDraculaArcade);
			
			
	}

}

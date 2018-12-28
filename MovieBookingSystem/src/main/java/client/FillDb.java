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
			
			//Jumanji shows
			
			Show showJumanjiCarltonToday = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now());
			Show showJumanjiCarltonTomorrow = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now().plusDays(1));
			Show showJumanjiCarltonDayAfter = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showJumanjiCarltonToday);
			showDao.create(showJumanjiCarltonTomorrow);
			showDao.create(showJumanjiCarltonDayAfter);
			
			Set<Show> showsJumanjiCarlton = new HashSet<>();	
			showsJumanjiCarlton.add(showJumanjiCarltonToday);
			showsJumanjiCarlton.add(showJumanjiCarltonTomorrow);
			showsJumanjiCarlton.add(showJumanjiCarltonDayAfter);
			
			
			Show showJumanjiInoxToday = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now());
			Show showJumanjiInoxTomorrow = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now().plusDays(1));
			Show showJumanjiInoxDayAfter = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now().plusDays(2));
						
			showDao.create(showJumanjiInoxToday);
			showDao.create(showJumanjiInoxTomorrow);
			showDao.create(showJumanjiInoxDayAfter);
			
			Set<Show> showsJumanjiInox = new HashSet<>();
			showsJumanjiInox.add(showJumanjiInoxToday);
			showsJumanjiInox.add(showJumanjiInoxTomorrow);
			showsJumanjiInox.add(showJumanjiInoxDayAfter);
			
			Show showJumanjiFamousToday = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now());
			Show showJumanjiFamousTomorrow = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now().plusDays(1));
			Show showJumanjiFamousDayAfter = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now().plusDays(2));
			
			
			showDao.create(showJumanjiFamousToday);
			showDao.create(showJumanjiFamousTomorrow);
			showDao.create(showJumanjiFamousDayAfter);
			
			Set<Show> showsJumanjiFamous= new HashSet<>();
			showsJumanjiFamous.add(showJumanjiFamousToday);
			showsJumanjiFamous.add(showJumanjiFamousTomorrow);
			showsJumanjiFamous.add(showJumanjiFamousDayAfter);
			
			Show showJumanjiChilliToday = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now());
			Show showJumanjiChilliTomorrow = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now().plusDays(1));
			Show showJumanjiChilliDayAfter = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now().plusDays(2));
			
			Set<Show> showsJumanjiChilli= new HashSet<>();
			showsJumanjiChilli.add(showJumanjiChilliToday);
			showsJumanjiChilli.add(showJumanjiChilliTomorrow);
			showsJumanjiChilli.add(showJumanjiChilliDayAfter);
			
			
			showDao.create(showJumanjiChilliToday);
			showDao.create(showJumanjiChilliTomorrow);
			showDao.create(showJumanjiChilliDayAfter);
					
			Show showJumanjiArcadeToday = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now());
			Show showJumanjiArcadeTomorrow = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now().plusDays(1));
			Show showJumanjiArcadeDayAfter = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showJumanjiArcadeToday);
			showDao.create(showJumanjiArcadeTomorrow);
			showDao.create(showJumanjiArcadeDayAfter);
			
			Set<Show> showsJumanjiArcade= new HashSet<>();
			showsJumanjiArcade.add(showJumanjiArcadeToday);
			showsJumanjiArcade.add(showJumanjiArcadeTomorrow);
			showsJumanjiArcade.add(showJumanjiArcadeDayAfter);
			
			
			Show showJumanjiJackmanToday = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now());
			Show showJumanjiJackmanTomorrow = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now().plusDays(1));
			Show showJumanjiJackmanDayAfter = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showJumanjiJackmanToday);
			showDao.create(showJumanjiJackmanTomorrow);
			showDao.create(showJumanjiJackmanDayAfter);
			
			Set<Show> showsJumanjiJackman= new HashSet<>();
			showsJumanjiJackman.add(showJumanjiJackmanToday);
			showsJumanjiJackman.add(showJumanjiJackmanTomorrow);
			showsJumanjiJackman.add(showJumanjiJackmanDayAfter);
			
			
			Show showJumanjiTedToday = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now());
			Show showJumanjiTedTomorrow = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now().plusDays(1));
			Show showJumanjiTedDayAfter = new Show().setMovie(jumanji).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showJumanjiTedToday);
			showDao.create(showJumanjiTedTomorrow);
			showDao.create(showJumanjiTedDayAfter);
			
			Set<Show> showsJumanjiTed= new HashSet<>();
			showsJumanjiTed.add(showJumanjiTedToday);
			showsJumanjiTed.add(showJumanjiTedTomorrow);
			showsJumanjiTed.add(showJumanjiTedDayAfter);
			
//			Jumanji shows done
			
//			Dracula shows
			
			Show showDracullaCarltonToday = new Show().setMovie(dracula).setShowTime(LocalDateTime.now());
			Show showDracullaCarltonTomorrow = new Show().setMovie(dracula).setShowTime(LocalDateTime.now().plusDays(1));
			Show showDracullaCarltonDayAfter = new Show().setMovie(dracula).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showDracullaCarltonToday);
			showDao.create(showDracullaCarltonTomorrow);
			showDao.create(showDracullaCarltonDayAfter);
			
			Set<Show> showsDraculaCarlton= new HashSet<>();
			showsDraculaCarlton.add(showDracullaCarltonToday);
			showsDraculaCarlton.add(showDracullaCarltonTomorrow);
			showsDraculaCarlton.add(showDracullaCarltonDayAfter);
			
			Show showDracullaInoxToday = new Show().setMovie(dracula).setShowTime(LocalDateTime.now());
			Show showDracullaInoxTomorrow = new Show().setMovie(dracula).setShowTime(LocalDateTime.now().plusDays(1));
			Show showDracullaInoxDayAfter = new Show().setMovie(dracula).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showDracullaInoxToday);
			showDao.create(showDracullaInoxTomorrow);
			showDao.create(showDracullaInoxDayAfter);
			
			Set<Show> showsDraculaInox= new HashSet<>();
			showsDraculaInox.add(showDracullaInoxToday);
			showsDraculaInox.add(showDracullaInoxTomorrow);
			showsDraculaInox.add(showDracullaInoxDayAfter);
			
			Show showDracullaArcadeToday = new Show().setMovie(dracula).setShowTime(LocalDateTime.now());
			Show showDracullaArcadeTomorrow = new Show().setMovie(dracula).setShowTime(LocalDateTime.now().plusDays(1));
			Show showDracullaArcadeDayAfter = new Show().setMovie(dracula).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showDracullaArcadeToday);
			showDao.create(showDracullaArcadeTomorrow);
			showDao.create(showDracullaArcadeDayAfter);
			
			Set<Show> showsDraculaArcade= new HashSet<>();
			showsDraculaArcade.add(showDracullaArcadeToday);
			showsDraculaArcade.add(showDracullaArcadeTomorrow);
			showsDraculaArcade.add(showDracullaArcadeDayAfter);
			
			
			Show showDracullaTedToday = new Show().setMovie(dracula).setShowTime(LocalDateTime.now());
			Show showDracullaTedTomorrow = new Show().setMovie(dracula).setShowTime(LocalDateTime.now().plusDays(1));
			Show showDracullaTedDayAfter = new Show().setMovie(dracula).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showDracullaTedToday);
			showDao.create(showDracullaTedTomorrow);
			showDao.create(showDracullaTedDayAfter);
			
			Set<Show> showsDraculaTed= new HashSet<>();
			showsDraculaTed.add(showDracullaTedToday);
			showsDraculaTed.add(showDracullaTedTomorrow);
			showsDraculaTed.add(showDracullaTedDayAfter);
//			Dracula shows done
			
//			Wolverine shows
			
			Show showWolverineCarltonToday = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now());
			Show showWolverineCarltonTomorrow = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now().plusDays(1));
			Show showWolverineCarltonDayAfter = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showWolverineCarltonToday);
			showDao.create(showWolverineCarltonTomorrow);
			showDao.create(showWolverineCarltonDayAfter);
			
			
			Set<Show> showsWolverineCarlton= new HashSet<>();
			showsWolverineCarlton.add(showWolverineCarltonToday);
			showsWolverineCarlton.add(showWolverineCarltonTomorrow);
			showsWolverineCarlton.add(showWolverineCarltonDayAfter);
			
			
			Show showWolverineInoxToday = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now());
			Show showWolverineInoxTomorrow = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now().plusDays(1));
			Show showWolverineInoxDayAfter = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showWolverineInoxToday);
			showDao.create(showWolverineInoxTomorrow);
			showDao.create(showWolverineInoxDayAfter);
			
			Set<Show> showsWolverineInox= new HashSet<>();
			showsWolverineInox.add(showWolverineInoxToday);
			showsWolverineInox.add(showWolverineInoxTomorrow);
			showsWolverineInox.add(showWolverineInoxDayAfter);
			
			Show showWolverineChilliToday = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now());
			Show showWolverineChilliTomorrow = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now().plusDays(1));
			Show showWolverineChilliDayAfter = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showWolverineChilliToday);
			showDao.create(showWolverineChilliTomorrow);
			showDao.create(showWolverineChilliDayAfter);
			
			
			Set<Show> showsWolverineChilli= new HashSet<>();
			showsWolverineChilli.add(showWolverineChilliToday);
			showsWolverineChilli.add(showWolverineChilliTomorrow);
			showsWolverineChilli.add(showWolverineChilliDayAfter);
			
			Show showWolverineJackmanToday = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now());
			Show showWolverineJackmanTomorrow = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now().plusDays(1));
			Show showWolverineJackmanDayAfter = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showWolverineJackmanToday);
			showDao.create(showWolverineJackmanTomorrow);
			showDao.create(showWolverineJackmanDayAfter);
			
			Set<Show> showsWolverineJackman= new HashSet<>();
			showsWolverineJackman.add(showWolverineJackmanToday);
			showsWolverineJackman.add(showWolverineJackmanTomorrow);
			showsWolverineJackman.add(showWolverineJackmanDayAfter);
			
			Show showWolverineTedToday = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now());
			Show showWolverineTedTomorrow = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now().plusDays(1));
			Show showWolverineTedDayAfter = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showWolverineTedToday);
			showDao.create(showWolverineTedTomorrow);
			showDao.create(showWolverineTedDayAfter);
			
			Set<Show> showsWolverineTed= new HashSet<>();
			showsWolverineTed.add(showWolverineTedToday);
			showsWolverineTed.add(showWolverineTedTomorrow);
			showsWolverineTed.add(showWolverineTedDayAfter);
			
			
			Show showWolverineArcadeToday = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now());
			Show showWolverineArcadeTomorrow = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now().plusDays(1));
			Show showWolverineArcadeDayAfter = new Show().setMovie(wolverine).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showWolverineArcadeToday);
			showDao.create(showWolverineArcadeTomorrow);
			showDao.create(showWolverineArcadeDayAfter);
			
			Set<Show> showsWolverineArcade= new HashSet<>();
			showsWolverineArcade.add(showWolverineArcadeToday);
			showsWolverineArcade.add(showWolverineArcadeTomorrow);
			showsWolverineArcade.add(showWolverineArcadeDayAfter);
			
//			Wolverine shows done
			
//			Assasins shows
			
			Show showAssasinsFamousToday = new Show().setMovie(assasins).setShowTime(LocalDateTime.now());
			Show showAssasinsFamousTomorrow = new Show().setMovie(assasins).setShowTime(LocalDateTime.now().plusDays(1));
			Show showAssasinsFamousDayAfter = new Show().setMovie(assasins).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showAssasinsFamousToday);
			showDao.create(showAssasinsFamousTomorrow);
			showDao.create(showAssasinsFamousDayAfter);
			
			Set<Show> showsAssasinsFamous= new HashSet<>();
			showsAssasinsFamous.add(showAssasinsFamousToday);
			showsAssasinsFamous.add(showAssasinsFamousTomorrow);
			showsAssasinsFamous.add(showAssasinsFamousDayAfter);
			
			
			Show showAssasinsChilliToday = new Show().setMovie(assasins).setShowTime(LocalDateTime.now());
			Show showAssasinsChilliTomorrow = new Show().setMovie(assasins).setShowTime(LocalDateTime.now().plusDays(1));
			Show showAssasinsChilliDayAfter = new Show().setMovie(assasins).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showAssasinsChilliToday);
			showDao.create(showAssasinsChilliTomorrow);
			showDao.create(showAssasinsChilliDayAfter);
			
			Set<Show> showsAssasinsChilli= new HashSet<>();
			showsAssasinsChilli.add(showAssasinsChilliToday);
			showsAssasinsChilli.add(showAssasinsChilliTomorrow);
			showsAssasinsChilli.add(showAssasinsChilliDayAfter);
			
			Show showAssasinsTedToday = new Show().setMovie(assasins).setShowTime(LocalDateTime.now());
			Show showAssasinsTedTomorrow = new Show().setMovie(assasins).setShowTime(LocalDateTime.now().plusDays(1));
			Show showAssasinsTedDayAfter = new Show().setMovie(assasins).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showAssasinsTedToday);
			showDao.create(showAssasinsTedTomorrow);
			showDao.create(showAssasinsTedDayAfter);
			
			Set<Show> showsAssasinsTed= new HashSet<>();
			showsAssasinsTed.add(showAssasinsTedToday);
			showsAssasinsTed.add(showAssasinsTedTomorrow);
			showsAssasinsTed.add(showAssasinsTedDayAfter);
			
			
			
//			Assasins shows done
			
//			Irobot shows
			
			Show showIrobotCarltonToday = new Show().setMovie(irobot).setShowTime(LocalDateTime.now());
			Show showIrobotCarltonTomorrow = new Show().setMovie(irobot).setShowTime(LocalDateTime.now().plusDays(1));
			Show showIrobotCarltonDayAfter = new Show().setMovie(irobot).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showIrobotCarltonToday);
			showDao.create(showIrobotCarltonTomorrow);
			showDao.create(showIrobotCarltonDayAfter);
			
			Set<Show> showsIrobotCarlton= new HashSet<>();
			showsIrobotCarlton.add(showIrobotCarltonToday);
			showsIrobotCarlton.add(showIrobotCarltonTomorrow);
			showsIrobotCarlton.add(showIrobotCarltonDayAfter);
			
			
			Show showIrobotInoxToday = new Show().setMovie(irobot).setShowTime(LocalDateTime.now());
			Show showIrobotInoxTomorrow = new Show().setMovie(irobot).setShowTime(LocalDateTime.now().plusDays(1));
			Show showIrobotInoxDayAfter = new Show().setMovie(irobot).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showIrobotInoxToday);
			showDao.create(showIrobotInoxTomorrow);
			showDao.create(showIrobotInoxDayAfter);
			
			Set<Show> showsIrobotInox= new HashSet<>();
			showsIrobotInox.add(showIrobotInoxToday);
			showsIrobotInox.add(showIrobotInoxTomorrow);
			showsIrobotInox.add(showIrobotInoxDayAfter);
			
			
			
			Show showIrobotFamousToday = new Show().setMovie(irobot).setShowTime(LocalDateTime.now());
			Show showIrobotFamousTomorrow = new Show().setMovie(irobot).setShowTime(LocalDateTime.now().plusDays(1));
			Show showIrobotFamousDayAfter = new Show().setMovie(irobot).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showIrobotFamousToday);
			showDao.create(showIrobotFamousTomorrow);
			showDao.create(showIrobotFamousDayAfter);
			
			Set<Show> showsIrobotFamous= new HashSet<>();
			showsIrobotFamous.add(showIrobotFamousToday);
			showsIrobotFamous.add(showIrobotFamousTomorrow);
			showsIrobotFamous.add(showIrobotFamousDayAfter);
			
			
			
			
			Show showIrobotJackmanToday = new Show().setMovie(irobot).setShowTime(LocalDateTime.now());
			Show showIrobotJackmanTomorrow = new Show().setMovie(irobot).setShowTime(LocalDateTime.now().plusDays(1));
			Show showIrobotJackmanDayAfter = new Show().setMovie(irobot).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showIrobotJackmanToday);
			showDao.create(showIrobotJackmanTomorrow);
			showDao.create(showIrobotJackmanDayAfter);
			
			Set<Show> showsIrobotJackman= new HashSet<>();
			showsIrobotJackman.add(showIrobotJackmanToday);
			showsIrobotJackman.add(showIrobotJackmanTomorrow);
			showsIrobotJackman.add(showIrobotJackmanDayAfter);
			
			
			Show showIrobotTedToday = new Show().setMovie(irobot).setShowTime(LocalDateTime.now());
			Show showIrobotTedTomorrow = new Show().setMovie(irobot).setShowTime(LocalDateTime.now().plusDays(1));
			Show showIrobotTedDayAfter = new Show().setMovie(irobot).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showIrobotTedToday);
			showDao.create(showIrobotTedTomorrow);
			showDao.create(showIrobotTedDayAfter);
			
			Set<Show> showsIrobotTed= new HashSet<>();
			showsIrobotTed.add(showIrobotTedToday);
			showsIrobotTed.add(showIrobotTedTomorrow);
			showsIrobotTed.add(showIrobotTedDayAfter);
			
			Show showIrobotArcadeToday = new Show().setMovie(irobot).setShowTime(LocalDateTime.now());
			Show showIrobotArcadeTomorrow = new Show().setMovie(irobot).setShowTime(LocalDateTime.now().plusDays(1));
			Show showIrobotArcadeDayAfter = new Show().setMovie(irobot).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showIrobotArcadeToday);
			showDao.create(showIrobotArcadeTomorrow);
			showDao.create(showIrobotArcadeDayAfter);
			
			Set<Show> showsIrobotArcade= new HashSet<>();
			showsIrobotArcade.add(showIrobotArcadeToday);
			showsIrobotArcade.add(showIrobotArcadeTomorrow);
			showsIrobotArcade.add(showIrobotArcadeDayAfter);
			
//			Irobot shows done
			
//			Avengers shows
			
			Show showAvengersInoxToday = new Show().setMovie(avengers).setShowTime(LocalDateTime.now());	
			Show showAvengersInoxTomorrow = new Show().setMovie(avengers).setShowTime(LocalDateTime.now().plusDays(1));	
			Show showAvengersInoxDayAfter = new Show().setMovie(avengers).setShowTime(LocalDateTime.now().plusDays(2));	
			
			showDao.create(showAvengersInoxToday);
			showDao.create(showAvengersInoxTomorrow);
			showDao.create(showAvengersInoxDayAfter);
			
			Set<Show> showsAvengersInox= new HashSet<>();
			showsAvengersInox.add(showAvengersInoxToday);
			showsAvengersInox.add(showAvengersInoxTomorrow);
			showsAvengersInox.add(showAvengersInoxDayAfter);
			
			
			Show showAvengersFamousToday = new Show().setMovie(avengers).setShowTime(LocalDateTime.now());
			Show showAvengersFamousTomorrow = new Show().setMovie(avengers).setShowTime(LocalDateTime.now().plusDays(1));
			Show showAvengersFamousDayAfter = new Show().setMovie(avengers).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showAvengersFamousToday);
			showDao.create(showAvengersFamousTomorrow);
			showDao.create(showAvengersFamousDayAfter);
			
			Set<Show> showsAvengerFamous= new HashSet<>();
			showsAvengerFamous.add(showAvengersFamousToday);
			showsAvengerFamous.add(showAvengersFamousTomorrow);
			showsAvengerFamous.add(showAvengersFamousDayAfter);
			
			Show showAvengersChilliToday = new Show().setMovie(avengers).setShowTime(LocalDateTime.now());
			Show showAvengersChilliTomorrow = new Show().setMovie(avengers).setShowTime(LocalDateTime.now().plusDays(1));
			Show showAvengersChilliDayAfter = new Show().setMovie(avengers).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showAvengersChilliToday);
			showDao.create(showAvengersChilliTomorrow);
			showDao.create(showAvengersChilliDayAfter);
			
			Set<Show> showsAvengerChilli= new HashSet<>();
			showsAvengerChilli.add(showAvengersChilliToday);
			showsAvengerChilli.add(showAvengersChilliTomorrow);
			showsAvengerChilli.add(showAvengersChilliDayAfter);
			
			Show showAvengersTedToday = new Show().setMovie(avengers).setShowTime(LocalDateTime.now());
			Show showAvengersTedTomorrow = new Show().setMovie(avengers).setShowTime(LocalDateTime.now().plusDays(1));
			Show showAvengersTedDayAfter = new Show().setMovie(avengers).setShowTime(LocalDateTime.now().plusDays(2));
			
			showDao.create(showAvengersTedToday);
			showDao.create(showAvengersTedTomorrow);
			showDao.create(showAvengersTedDayAfter);
			
			Set<Show> showsAvengerTed= new HashSet<>();
			showsAvengerTed.add(showAvengersTedToday);
			showsAvengerTed.add(showAvengersTedTomorrow);
			showsAvengerTed.add(showAvengersTedDayAfter);
			
			
			Show showAvengersArcadeToday = new Show().setMovie(avengers).setShowTime(LocalDateTime.now());
			Show showAvengersArcadeTomorrow = new Show().setMovie(avengers).setShowTime(LocalDateTime.now().plusDays(1));
			Show showAvengersArcadeDayAfter = new Show().setMovie(avengers).setShowTime(LocalDateTime.now().plusDays(2));	
			
			
			showDao.create(showAvengersArcadeToday);
			showDao.create(showAvengersArcadeTomorrow);
			showDao.create(showAvengersArcadeDayAfter);
			
			Set<Show> showsAvengerArcade= new HashSet<>();
			showsAvengerArcade.add(showAvengersArcadeToday);
			showsAvengerArcade.add(showAvengersArcadeTomorrow);
			showsAvengerArcade.add(showAvengersArcadeDayAfter);
			
			
//			Avengers shows done
			
			
			
		
					
			

			//Screen
			
			IScreenDao screenDao = DaoFactory.getScreenDao();
			
			Screen carltonCinemaOne = new Screen().setCapacity(80).setShowings(showsJumanjiCarlton);
			Screen carltonCinemaTwo = new Screen().setCapacity(65).setShowings(showsDraculaCarlton);
			Screen carltonCinemaFour = new Screen().setCapacity(95).setShowings(showsWolverineCarlton);
			Screen carltonCinemaThree = new Screen().setCapacity(130).setShowings(showsIrobotCarlton);
			
			Screen inoxOne = new Screen().setCapacity(80).setShowings(showsJumanjiInox);
			Screen inoxTwo = new Screen().setCapacity(90).setShowings(showsDraculaInox);
			Screen inoxThree = new Screen().setCapacity(120).setShowings(showsWolverineInox);
			Screen inoxFour = new Screen().setCapacity(130).setShowings(showsIrobotInox);
			Screen inoxFive = new Screen().setCapacity(100).setShowings(showsAvengersInox);
			
			Screen famousPlayersOne = new Screen().setCapacity(110).setShowings(showsJumanjiFamous);
			Screen famousPlayersTwo = new Screen().setCapacity(85).setShowings(showsAssasinsFamous);
			Screen famousPlayersThree = new Screen().setCapacity(75).setShowings(showsIrobotFamous);
			Screen famousPlayersFour = new Screen().setCapacity(130).setShowings(showsAvengerFamous);

			Screen chilliwackOne = new Screen().setCapacity(150).setShowings(showsJumanjiChilli);
			Screen chilliwackTwo = new Screen().setCapacity(140).setShowings(showsWolverineChilli);
			Screen chilliwackThree = new Screen().setCapacity(100).setShowings(showsAssasinsChilli);
			Screen chilliwackFour = new Screen().setCapacity(100).setShowings(showsAvengerChilli);
			
			Screen arcadeOne = new Screen().setCapacity(95).setShowings(showsJumanjiArcade);
			Screen arcadeTwo = new Screen().setCapacity(75).setShowings(showsDraculaArcade);
			Screen arcadeThree = new Screen().setCapacity(80).setShowings(showsWolverineArcade);
			Screen arcadeFour = new Screen().setCapacity(120).setShowings(showsIrobotArcade);
			Screen arcadeFive = new Screen().setCapacity(135).setShowings(showsAvengerArcade);
			
			Screen jackManOne = new Screen().setCapacity(105).setShowings(showsJumanjiJackman);
			Screen jackManTwo = new Screen().setCapacity(75).setShowings(showsWolverineJackman);
			Screen jackManThree = new Screen().setCapacity(60).setShowings(showsIrobotJackman);
			
			Screen tedRogersOne = new Screen().setCapacity(125).setShowings(showsJumanjiTed);
			Screen tedRogersTwo = new Screen().setCapacity(115).setShowings(showsDraculaTed);
			Screen tedRogersThree = new Screen().setCapacity(90).setShowings(showsWolverineTed);
			Screen tedRogersFour = new Screen().setCapacity(80).setShowings(showsAssasinsTed);
			Screen tedRogersFive = new Screen().setCapacity(100).setShowings(showsIrobotTed);
			Screen tedRogersSix = new Screen().setCapacity(110).setShowings(showsAvengerTed);
			
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
			
			Booking bookJumanjiInox = new Booking().setNumTickets(2).setPrice(discounted1).setShow(showJumanjiInoxToday).setUser(sandeep);
			Booking bookDraculaArcade = new Booking().setNumTickets(2).setPrice(enhanced1).setShow(showDracullaArcadeTomorrow).setUser(sandeep);
			
			bookingDao.create(bookJumanjiInox);
			bookingDao.create(bookDraculaArcade);
			
			
	}

}

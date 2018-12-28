package dao.interfaces;

import java.util.List;

import dao.interfaces.generic.ICreatable;
import dao.interfaces.generic.IDeletable;
import dao.interfaces.generic.IReadable;
import dao.interfaces.generic.IUpdatable;
import model.Booking;
import model.Price;
import model.Show;
import model.User;

public interface IBookingDao extends ICreatable<Booking>, IReadable<Booking>, IUpdatable<Booking>, IDeletable<Booking> {
	
	List<Booking> getBookingsByUser(User user);
	
	List<Booking> getBookingsByNumTickets(int numTickets);
	
	List<Booking> getBookingsByPrice(Price price);
	
	List<Booking> getBookingsByShow(Show show);
	
	
	

}

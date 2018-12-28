package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries({
	@NamedQuery(name = "Booking.all" , query = "SELECT b FROM Booking b"),
	@NamedQuery(name = "Booking.byUser" , query = "SELECT b FROM Booking b WHERE b.user = :user" ),
	@NamedQuery(name = "Booking.byNumTickets" , query = "SELECT b FROM Booking b WHERE b.numTickets = :number"),
	@NamedQuery(name = "Booking.byPrice" , query = "SELECT b FROM Booking b WHERE b.price = :price"),
	@NamedQuery(name = "Booking.byShow" , query = "SELECT b FROM Booking b where b.show = :show")
	
})
public class Booking implements IStorable {

	@Id
	@Column(name = "booking_id")
	@SequenceGenerator(name = "seq_bookingId", sequenceName = "seq_bookingId", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "seq_bookingId")
	private int bookingId;
	@ManyToOne
	@JoinColumn(name = "show_id", referencedColumnName = "show_id", nullable = false)
	private Show show;
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
	private User user;
	@ManyToOne
	@JoinColumn(name = "price_id", referencedColumnName = "price_id", nullable = false)
	private Price price;

	@Column
	private int numTickets;

	public Booking() {

	}

	public int getBookingId() {
		return bookingId;
	}

	public Booking setBookingId(int bookingId) {
		this.bookingId = bookingId;
		return this;
	}

	public Show getShow() {
		return show;
	}

	public Booking setShow(Show show) {
		this.show = show;
		return this;
	}

	public User getUser() {
		return user;
	}

	public Booking setUser(User user) {
		this.user = user;
		return this;
	}

	public Price getPrice() {
		return price;
	}

	public Booking setPrice(Price price) {
		this.price = price;
		return this;
	}

	public int getNumTickets() {
		return numTickets;
	}

	public Booking setNumTickets(int numTickets) {
		this.numTickets = numTickets;
		return this;
	}

}












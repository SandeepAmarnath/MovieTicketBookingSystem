package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries({
	@NamedQuery(name = "Theatre.all" , query = "SELECT t FROM Theatre t"),
	@NamedQuery(name = "Theatre.byName" , query = "SELECT t FROM Theatre t WHERE t.theatreName = :name"),
	@NamedQuery(name = "Theatre.byNameLike" , query = "SELECT t FROM Theatre t WHERE t.theatreName LIKE :theatreLike"),
	@NamedQuery(name = "Theatre.byAddress" , query = "SELECT t FROM Theatre t WHERE t.address = :address"),
	@NamedQuery(name = "Theatre.byCity" , query = "SELECT t FROM Theatre t WHERE t.city = :city")
	
})
public class Theatre implements IStorable {

	@Id
	@Column(name = "theatre_id")
	@SequenceGenerator(name = "seq_theatreId", sequenceName = "seq_theatreId", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "seq_theatreId")
	private int theatreId;

	@Column(name = "theatre_name", nullable = false)
	private String theatreName;

	@Column(name = "address", nullable = false)
	private String address;

	@ManyToOne
	@JoinColumn(name = "city_id", referencedColumnName = "city_id")
	private City city;

	@OneToMany
	@JoinColumn(name = "theatre_id")
	private Set<Screen> screens= new HashSet<>();

	@OneToMany
	@JoinColumn(name = "theatre_id")
	private Set<Price> prices=new HashSet<>();

	public Theatre() {
	}

	public int getTheatreId() {
		return theatreId;
	}

	public Theatre setTheatreId(int theatreId) {
		this.theatreId = theatreId;
		return this;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public Theatre setTheatreName(String theatreName) {
		this.theatreName = theatreName;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public Theatre setAddress(String address) {
		this.address = address;
		return this;
	}

	public City getCity() {
		return city;
	}

	public Theatre setCity(City city) {
		this.city = city;
		return this;
	}

	public Set<Screen> getScreens() {
		return screens;
	}

	public Theatre setScreens(Set<Screen> screens) {
		this.screens = screens;
		return this;
	}

	public Theatre addScreen(Screen screen) {
		if (this.screens == null)
			this.screens = new HashSet<>();
		this.screens.add(screen);

		return this;
	}

	public Set<Price> getPrices() {
		return prices;
	}
	
	//Added later
	public Theatre setPrices(Set<Price> prices) {
		this.prices = prices;
		return this;
	}
	
	public Theatre setPrice(Price price) {
		this.prices.add(price);
		return this;
	}
	//Added now
	public Theatre setScreen(Screen screen) {
		this.screens.add(screen);
		return this;
	}

	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", theatreName=" + theatreName + ", address=" + address + ", city="
				+ city + ", screens=" + screens + ", prices=" + prices + "]";
	}
	
	

	
}
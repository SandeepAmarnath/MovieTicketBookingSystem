package model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import dao.interfaces.BooleanAttributeConverter;

@Entity
@NamedQueries({
	@NamedQuery(name = "Price.all" , query = "SELECT p FROM Price p"),
	@NamedQuery(name = "Price.byPeakRate" , query = "SELECT p FROM Price p WHERE p.isPeakRate = :peak"), //Check this. It might not work.
	@NamedQuery(name = "Price.bydiscountedRate" , query = "SELECT p FROM Price p WHERE p.isDiscounted = :discounted"),
	@NamedQuery(name = "Price.byenhancedRate" , query = "SELECT p FROM Price p WHERE p.isEnhanced = :enhanced"),
	@NamedQuery(name = "Price.byPrice" , query = "SELECT p FROM Price p WHERE p.price = :price")
	
	
})
public class Price implements IStorable {

	@Id
	@Column(name = "price_id")
	@SequenceGenerator(name = "seq_priceId", sequenceName = "seq_priceId", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "seq_priceId")
	private int priceId;
	// @ManyToOne
	// @JoinColumn(name = "theatre_id", referencedColumnName = "theatre_id",
	// nullable = false)
	// private Theatre theatre;
	@Column(nullable = false)
	private double price;

	// TODO: create enum collection of price types; e.g. peak vs off peak /
	// student vs adult / IMAX 3D vs regular screen

	@Column(nullable = false)
	@Convert(converter = BooleanAttributeConverter.class)
	private boolean isPeakRate;
	@Column(nullable = false)
	@Convert(converter = BooleanAttributeConverter.class)
	private boolean isDiscounted;
	@Column(nullable = false)
	@Convert(converter = BooleanAttributeConverter.class)
	private boolean isEnhanced;

	public Price() {
	}

	public int getPriceId() {
		return priceId;
	}

	public Price setPriceId(int priceId) {
		this.priceId = priceId;
		return this;
	}

	
	public double getPrice() {
		return price;
	}

	public Price setPrice(double price) {
		this.price = price;
		return this;
	}

	public boolean isPeakRate() {
		return isPeakRate;
	}

	public Price setPeakRate(boolean isPeakRate) {
		this.isPeakRate = isPeakRate;
		return this;
	}

	public boolean isDiscounted() {
		return isDiscounted;
	}

	public Price setDiscounted(boolean isDiscounted) {
		this.isDiscounted = isDiscounted;
		return this;
	}

	public boolean isEnhanced() {
		return isEnhanced;
	}

	public Price setEnhanced(boolean isEnhanced) {
		this.isEnhanced = isEnhanced;
		return this;
	}

}

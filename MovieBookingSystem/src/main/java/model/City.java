package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
@NamedQueries({
	@NamedQuery(name = "City.all" , query = "SELECT c FROM City c"),
	@NamedQuery(name = "City.readbyName" , query = "SELECT c FROM City c WHERE c.name = :name")
})
public class City implements IStorable{

	@Id
	@Column(name = "city_id")
	@SequenceGenerator(name = "seq_cityId", sequenceName = "seq_cityId", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "seq_cityId")
	private int cityId;
	@Column(name = "name", nullable = false)
	private String name;

	public City() {

	}

	public int getCityId() {
		return cityId;
	}

	public City setCityId(int cityId) {
		this.cityId = cityId;
		return this;
	}

	public String getName() {
		return name;
	}

	public City setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", name=" + name + "]";
	}
	

}

package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries({
	
	@NamedQuery(name="Screen.all" , query = "SELECT s FROM Screen s")
})
public class Screen implements IStorable {

	@Id
	@Column(name = "screen_id")
	@SequenceGenerator(name = "seq_screenId", sequenceName = "seq_screenId", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "seq_screenId")
	private int ScreenId;

	@Column(nullable = false)
	private int capacity;

	@OneToMany
	@JoinColumn(name = "screen_id")
	private Set<Show> showings = new HashSet<>();

	public Screen() {
	}

	public int getScreenId() {
		return ScreenId;
	}

	public Screen setScreenId(int screenId) {
		ScreenId = screenId;
		return this;
	}

	public int getCapacity() {
		return capacity;
	}

	public Screen setCapacity(int capacity) {
		this.capacity = capacity;
		return this;
	}

	public Set<Show> getShowings() {
		return showings;
	}

	public Screen setShowings(Set<Show> showings) {
		this.showings = showings;
		return this;
	}
	//Added
	public Screen setShowing(Show showing) {
		this.showings.add(showing);
		return this;
	}
	
}

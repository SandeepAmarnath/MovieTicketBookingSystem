package model;

import java.time.LocalDateTime;

import javax.persistence.Basic;
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
	@NamedQuery(name = "Show.all" , query = "SELECT s FROM Show s"),
	@NamedQuery(name = "Show.byShowTime", query = "SELECT s FROM Show s WHERE s.showTime = :time"),
	@NamedQuery(name = "Show.byMovie" , query = "SELECT s FROM Show s WHERE s.movie = :movie"),
//	@NamedQuery(name = "Show.byScreen" , query = "SELECT s FROM Show s WHERE s.screen = :screen")
	
})
public class Show implements IStorable {

	@Id
	@Column(name = "show_id")
	@SequenceGenerator(name = "seq_showId", sequenceName = "seq_showId", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "seq_showId")
	private int showId;
	@Basic
	@Column(name = "show_time", nullable = false)
	private LocalDateTime showTime;
	@ManyToOne
	@JoinColumn(name = "movie_id", referencedColumnName = "movie_id", nullable = false)
	private Movie movie;
	
	//Check this. This wasn't there before.
//	@ManyToOne
//	@JoinColumn(name = "movie_id", referencedColumnName = "screen_id", nullable = false)
//	private Screen screen;
	
	
	public Show() {
	}

	public int getShowId() {
		return showId;
	}

	public Show setShowId(int showId) {
		this.showId = showId;
		return this;
	}

	public LocalDateTime getShowTime() {
		return showTime;
	}

	public Show setShowTime(LocalDateTime showTime) {
		this.showTime = showTime;
		return this;
	}

	public Movie getMovie() {
		return movie;
	}

	public Show setMovie(Movie movie) {
		this.movie = movie;
		return this;
	}

	@Override
	public String toString() {
		return "Show [showId=" + showId + ", showTime=" + showTime + ", movie=" + movie + "]";
	}

//	public Screen getScreen() {
//		return screen;
//	}
//
//	public Show setScreen(Screen screen) {
//		this.screen = screen;
//		return this;
//	}

	
	
	
}

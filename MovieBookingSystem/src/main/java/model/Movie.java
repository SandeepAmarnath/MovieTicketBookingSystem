package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries({
	@NamedQuery(name = "Movie.all", query = "SELECT m FROM Movie m"),
	@NamedQuery(name = "Movie.byName", query = "SELECT m FROM Movie m WHERE m.name = :name"),
	@NamedQuery(name = "Movie.byNameLike", query = "SELECT m FROM Movie m WHERE m.name LIKE :name"),
	@NamedQuery(name = "Movie.byKids", query = "SELECT m FROM Movie m WHERE m.cinRating = model.CinemaRating.KIDS"),
	@NamedQuery(name = "Movie.byRating", query = "SELECT m FROM Movie m WHERE m.rating = :rating")
})
public class Movie implements IStorable {

	@Id
	@Column(name = "movie_id")
	@SequenceGenerator(name = "seq_movieId", sequenceName = "seq_movieId", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "seq_movieId")
	private int movieId;
	@Column(name = "movie_name", nullable = false)
	private String name;
	@Column(name = "runtime", nullable = false)
	private int runtime;
	@Column(name = "rating", nullable = false)
	private double rating;

	@Enumerated(EnumType.STRING)
	@Column(length=10)
	private CinemaRating cinRating;

	public Movie() {
		

	}

	public int getId() {
		return movieId;
	}

	public Movie setId(int id) {
		this.movieId = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Movie setName(String name) {
		this.name = name;
		return this;
	}

	public int getRuntime() {
		return runtime;
	}

	public Movie setRuntime(int runtime) {
		this.runtime = runtime;
		return this;
	}

	public double getRating() {
		return rating;
	}

	public int getMovieId() {
		return movieId;
	}

	public Movie setMovieId(int movieId) {
		this.movieId = movieId;
		return this;
	}

	public CinemaRating getCinRating() {
		return cinRating;
	}

	public Movie setCinRating(CinemaRating cinRating) {
		this.cinRating = cinRating;
		return this;
	}

	public Movie setRating(double rating) {
		this.rating = rating;
		return this;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", name=" + name + ", runtime=" + runtime + ", rating=" + rating
				+ ", cinRating=" + cinRating + "]";
	}
	
	

}

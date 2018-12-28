package dao.interfaces;

import java.util.List;

import dao.interfaces.generic.ICreatable;
import dao.interfaces.generic.IDeletable;
import dao.interfaces.generic.IReadable;
import dao.interfaces.generic.IUpdatable;
import model.Movie;
import model.Theatre;

public interface IMovieDao extends IReadable<Movie>, ICreatable<Movie> {

	List<Movie> readByName_Like(String str);
	
	Movie readByName(String str);
	
	List<Movie> readByKidsMovies();
	
	List<Movie> readByRating(double rating);
	
}

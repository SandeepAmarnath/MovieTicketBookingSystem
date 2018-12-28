package businessLogic;

import java.util.List;

import dao.interfaces.ITheatreDao;
import dao.interfaces.generic.IReadable;
import model.Movie;
import model.Theatre;

public class SearchMovieLogic{

	IReadable<Theatre> treReader;
//	IReadable<Movie> movieReader;
	ITheatreDao treDao;
	
	//Search Movies in a theatre
	public List<Movie> findByTheatre(Theatre t) {
		
		
		
		return null;
	}

	public List<Theatre> findByCity(String cityName){
		
		
		
		return null;
	}
	
}

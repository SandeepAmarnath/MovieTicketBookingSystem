package dao.interfaces;

import java.time.LocalDateTime;
import java.util.List;
import dao.interfaces.generic.ICreatable;
import dao.interfaces.generic.IDeletable;
import dao.interfaces.generic.IReadable;
import dao.interfaces.generic.IUpdatable;
import model.Movie;
import model.Screen;
import model.Show;

public interface IShowDao extends IReadable<Show>, ICreatable<Show>, IUpdatable<Show>, IDeletable<Show> {
	
	List<Show> getShowbyShowTime(LocalDateTime showTime); //Can it also be List<Show> if showTime is same for multiple shows? 
	
	List<Show> getShowsbyMovie(Movie movie);
	
//	List<Show> getShowsbyScreen(Screen screen);  Confused with many to one relationship (bidirectional in show. I dont have screen in show so cannot query 
//	                                             by screen in show)
	
	
}

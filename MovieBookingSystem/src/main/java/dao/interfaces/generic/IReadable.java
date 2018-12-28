package dao.interfaces.generic;

import java.util.List;

import model.IStorable;

public interface IReadable<T extends IStorable> {
	
	List<T> readAll();
	
	T readby(int id);
	
    
	
}

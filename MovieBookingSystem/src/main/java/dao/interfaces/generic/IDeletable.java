package dao.interfaces.generic;

import model.IStorable;

public interface IDeletable<T extends IStorable> {
	
	boolean delete(T t);

}

package dao.interfaces;

import java.util.List;

import dao.interfaces.generic.ICreatable;
import dao.interfaces.generic.IDeletable;
import dao.interfaces.generic.IReadable;
import dao.interfaces.generic.IUpdatable;
import model.Price;
import model.Theatre;

public interface IPriceDao extends IReadable<Price>, ICreatable<Price>, IUpdatable<Price>, IDeletable<Price> {
	
	List<Price> getPeakratePrices();
	
	List<Price> getDiscountedPrices();
	
	List<Price> getEnhancedPrices();
	
//	List<Price> getPricesByTheatre(Theatre theatre);  //	Price doesn't have Theatre. Bidirectional relationship necessary? Not sure!!
	
	List<Price> getPricesByPrice(double price);
}

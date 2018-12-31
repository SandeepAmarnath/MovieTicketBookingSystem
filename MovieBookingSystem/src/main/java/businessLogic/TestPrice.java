package businessLogic;

import java.math.BigDecimal;

public class TestPrice {

	public static void main(String[] args) {
		PriceCalculationLogic p = new PriceCalculationLogic();
		BigDecimal price = p.getPrice("1", "Jumanji", "2018-12-30 20:09:32.0", "Famous Players", 'T');
		System.out.println(price);

	}

}

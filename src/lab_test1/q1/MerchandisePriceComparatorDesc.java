package lab_test1.q1;

import java.util.Comparator;

public class MerchandisePriceComparatorDesc implements Comparator<Merchandise> {

	@Override
	public int compare(Merchandise merchandise1, Merchandise merchandise2) {
		// TODO Auto-generated method stub
		if(merchandise1.getPrice() < merchandise2.getPrice()){
			return 1;
		}
		else if(merchandise1.getPrice() > merchandise2.getPrice()) return -1;
		return 0;
	}

}

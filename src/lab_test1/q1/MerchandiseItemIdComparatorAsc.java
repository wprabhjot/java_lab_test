package lab_test1.q1;

import java.util.Comparator;

public class MerchandiseItemIdComparatorAsc implements Comparator<Merchandise> {

	@Override
	public int compare(Merchandise merchandise1, Merchandise merchandise2) {
		// TODO Auto-generated method stub
		return merchandise1.getItemCode().compareTo(merchandise2.getItemCode());
	}

}

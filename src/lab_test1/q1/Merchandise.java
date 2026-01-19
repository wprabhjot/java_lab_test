package lab_test1.q1;


public class Merchandise {
	private String itemCode;
	private int quantity;
	private double unitPrice;
	
	public Merchandise(String itemCode, int quantity, double unitPrice) {
		super();
		this.itemCode = itemCode;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public String getItemCode() {
		return itemCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return unitPrice;
	}

	public void setPrice(double price) {
		this.unitPrice = price;
	}

	@Override
	public String toString() {
		return "Merchandise [itemCode= " + itemCode + ", quantity= " + quantity + ", unitPrice= " + unitPrice + "]";
	}
	
}

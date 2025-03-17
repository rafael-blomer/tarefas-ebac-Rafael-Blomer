package br.com.rafaelblomer.shop;

public class LineItem {

	private final String caption;
	private final Double price;
	int quantity = 1;
	
	public LineItem(String caption, Double price) {
		this.caption = caption;
		this.price = price;
	}

	public LineItem(String caption, Double price, int quantity) {
		this(caption, price);
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCaption() {
		return caption;
	}

	public Double getPrice() {
		return price;
	}
	
	
}

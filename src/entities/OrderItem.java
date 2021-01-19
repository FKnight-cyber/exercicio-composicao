package entities;

public class OrderItem {
	
	private Double price;
	private Integer quantity; 
	
	private Product product;
	
	public OrderItem() {
	}

	public OrderItem(Product product, Integer quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double subTotal() {
		return product.getPrice()*quantity;
	}
	
	public String toString() {
		return product + ", Quantity: " + quantity + ", Subtotal: " + subTotal();
	}
}

package entities;

public class Product {
	private String name;
	private Double price;
	private Integer quantity;
	
	public Product() {
		
	}
	
	public Product(String name, Double price, Integer quantity) {		
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getQuantity() {
		return quantity;
	}
	
	public Double ValorTotal() {
		
		return price * quantity;
	}
	
	@Override
	public String toString() {
		return name + ", " +  String.format("%.2f", ValorTotal());
		
	}
}

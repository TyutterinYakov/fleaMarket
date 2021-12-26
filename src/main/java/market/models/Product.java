package market.models;



public class Product {
	private Long productId;
	private String title;
	private String description;
	private int price;
	private String city;
	private String author;
	
	
	public Product() {
	}


	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public Product(Long productId, String title, String description, int price, String city, String author) {
		super();
		this.productId = productId;
		this.title = title;
		this.description = description;
		this.price = price;
		this.city = city;
		this.author = author;
	}
	
	
}

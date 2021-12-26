package market.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private Long productId;
	@Column(name="title")
	private String title;
	@Column(name="description", columnDefinition = "text")
	private String description;
	@Column(name="price")
	private int price;
	@Column(name="city")
	private String city;
	@Column(name="author")
	private String author;
	
	
	public Product() {
		
	}
	
	public Product(String title, String description, int price, String city, String author) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
		this.city = city;
		this.author = author;
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
	
	@Override
	public String toString() {
		return productId+" "+title+" "+description+" "+price+" "+city+" "+author;
	}



	
	
}

package market.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
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
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="product")
	private List<Image> images;
	private Long previewImageId;
	private LocalDateTime dateOfCreated;
	@ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.LAZY)
	@JoinColumn
	private User user;
	
	@PrePersist
	private void init() {
		dateOfCreated = LocalDateTime.now();
	}
	
	
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


	
	@Override
	public String toString() {
		return productId+" "+title+" "+description+" "+price+" "+city+" ";
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
	



	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Long getPreviewImageId() {
		return previewImageId;
	}


	public void setPreviewImageId(Long previewImageId) {
		this.previewImageId = previewImageId;
	}


	public LocalDateTime getDateOfCreated() {
		return dateOfCreated;
	}


	public void setDateOfCreated(LocalDateTime dateOfCreated) {
		this.dateOfCreated = dateOfCreated;
	}
	

	
	
}

package market.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import market.models.Product;

@Service
public class ProductService {
	private List<Product> products = new ArrayList<>(); 
	private Long productId=0L;
	
	{
		products.add(new Product(productId++, "Sony 4D", "Simple", 6333, "SPB", "Yasha"));
		products.add(new Product(productId++, "Iphone 10", "Good price", 3333, "Syasstroy", "Sasha"));
	}
	
	public List<Product> listProducts(){
		return products;
	}
	public void saveProduct(Product pr) {
		pr.setProductId(productId++);
		products.add(pr);
	}
	
	public void removeProduct(Long id) {
		products.removeIf(product->product.getProductId().equals(id));
	}
	public Product getProductById(Long id) {
		for(Product pr: products) {
			if(pr.getProductId().equals(id)) {
				return pr;
			}
		}
		return null;
	}
}

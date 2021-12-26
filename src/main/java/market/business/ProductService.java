package market.business;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import market.dao.ProductRepository;
import market.domain.Product;

@Service
public class ProductService {
	private static final Logger log = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	private ProductRepository productDao;
	
	
	
	@Transactional
	public List<Product> listProducts(String title){
		log.info("listProduct by title: {}",title);
		List<Product> products = productDao.findByTitle(title);
		if(products.get(0)==null){
			return productDao.findAll();
		} else {
			return productDao.findByTitle(title);
		}
		
		
	}
	@Transactional
	public void saveProduct(Product pr) {
		log.info("Saving new Product: {}", pr);
		productDao.save(pr);
	}
	
	@Transactional
	public void removeProduct(Long id) {
		log.info("remove Product by id: {}", id);
		productDao.deleteById(id);
	}
	@Transactional
	public Product getProductById(Long id) {
		log.info("get Product by id: {}", id);
		return productDao.findById(id).orElse(null);
	}
}

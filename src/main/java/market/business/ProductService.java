package market.business;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import market.dao.ImageRepository;
import market.dao.ProductRepository;
import market.dao.UserRepository;
import market.domain.Image;
import market.domain.Product;
import market.domain.User;

@Service
public class ProductService {
	private static final Logger log = LoggerFactory.getLogger(ProductService.class);
	private static final String uploadDir = System.getProperty("user.dir")+"/src/main/resources/static/productImages";
	
	private List<Image> images = new LinkedList<>();
	@Autowired
	private ProductRepository productDao;
	@Autowired
	private UserRepository userDao;
	@Autowired
	private ImageRepository imageDao;
	
	
	public ProductService(ProductRepository productDao) {
		super();
		this.productDao = productDao;
	}
	@Transactional
	public List<Product> listProducts(String title){
		log.info("listProduct by title: {}",title);
		//List<Product> products = productDao.findByTitle(title);
		if(title==null||title.trim()==""){
			return productDao.findAll();
		} else {
			return productDao.findByTitle(title);
		}
		
		
	}
	@Transactional
	public void saveProduct(Principal principal, Product pr, List<MultipartFile> files) throws IOException {
		pr.setUser(getUserByPrincipal(principal));
		log.info("Saving! Email: {}; Title: {}", pr.getUser().getEmail(), pr.getTitle());
		Product prFromDb = productDao.saveAndFlush(pr);
		String imgName;
		Long id = pr.getProductId();
		if(files.get(0).getOriginalFilename()!="") {
			for(MultipartFile file: files) {
				imgName = file.getOriginalFilename();
				Path fileNameAndPath = Paths.get(uploadDir, imgName);
				Files.write(fileNameAndPath, file.getBytes());
				Image img = new Image();
				img.setOriginalName(imgName);
				img.setProduct(prFromDb);
				imageDao.save(img);
			}
		} else {
			Image img = new Image();
			img.setOriginalName("noimage.png");
			img.setProduct(prFromDb);
			imageDao.save(img);
		}
	}
		
				
		
	//prFromDb.setPreviewImageId(prFromDb.getImages().get(0).getImageId());
		
		
	
	public User getUserByPrincipal(Principal principal) {
		if(principal==null) return new User();
		return userDao.findByEmail(principal.getName());
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

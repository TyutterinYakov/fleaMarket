package market.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import market.business.ProductService;
import market.domain.Product;


@Controller
public class MarketController {
	private final ProductService productService;
	
	
	
	public MarketController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/product/{id}")
	public String productInfo(@PathVariable Long id, Model model) {
		Product pr = productService.getProductById(id);
		model.addAttribute("product", pr);
		model.addAttribute("images", pr.getImages());
		return "product-info";
	}


	@GetMapping("/")
	public String market(@RequestParam(name="title", required = false) String title, Model model) {
		model.addAttribute("products", productService.listProducts(title));
		return "market";
	}
	@PostMapping("/product/create")
	public String createProduct(@RequestParam(name="file", required = false) List<MultipartFile> files, Product product) throws IOException {
		productService.saveProduct(product, files);
		
		return "redirect:/";
	}
	
	@PostMapping("/product/remove/{id}")
	public String removeProduct(@PathVariable Long id) {
		productService.removeProduct(id);
		return "redirect:/";
	}
}

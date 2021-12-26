package market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import market.models.Product;
import market.services.ProductService;


@Controller
public class MarketController {
	private final ProductService productService;
	
	
	
	public MarketController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/product/{id}")
	public String productInfo(@PathVariable Long id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "product-info";
	}


	@GetMapping("/")
	public String market(Model model) {
		model.addAttribute("products", productService.listProducts());
		return "market";
	}
	@PostMapping("/product/create")
	public String createProduct(Product product) {
		productService.saveProduct(product);
		return "redirect:/";
	}
	
	@PostMapping("/product/remove/{id}")
	public String removeProduct(@PathVariable Long id) {
		productService.removeProduct(id);
		return "redirect:/";
	}
}

package market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import market.business.UserService;
import market.domain.User;

@Controller
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/registration")
	public String registration() {
		
		return "registration";
	}
	@PostMapping("/registration")
	public String createUser(User us, Model md) {
		if(userServ.createUser(us)) {
			md.addAttribute("errorMessage", "User email already exists");
			return "registration";
		}
		return "redirect:/";
	}
	
	@GetMapping("/user/{user}")
	public String userInfo(@PathVariable("user") User user, Model md) {
		md.addAttribute("user", user);
		md.addAttribute("products", user.getProducts());
		return "user-info";
	}
	
	
}

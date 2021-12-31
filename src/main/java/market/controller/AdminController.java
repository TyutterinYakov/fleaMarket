package market.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import market.business.UserService;
import market.domain.User;
import market.domain.enums.Role;

@Controller
public class AdminController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String admin(Model md) {
		md.addAttribute("users", userService.findAllUsers());
		return "admin";
	}
	
	@PostMapping("/admin/user/ban/{id}")
	public String userBan(@PathVariable("id") Long id) {
		userService.banUser(id);
		
		return "redirect:/admin";
	}
	
	@GetMapping("/admin/user/edit/{user}")
	public String userEdit(@PathVariable("user") User user, Model md) {
		md.addAttribute("user", user);
		md.addAttribute("roles", Role.values());
		return "user-edit";
	}
	@PostMapping("/admin/user/edit")
	public String userEdit(@RequestParam("userId") User user, @RequestParam Map<String, String> form){
		userService.changeUserRoles(user, form);
		return "redirect:/admin";
	}
	
}

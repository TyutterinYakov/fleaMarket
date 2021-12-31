package market.business;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import market.dao.UserRepository;
import market.domain.User;
import market.domain.enums.Role;

@Service
public class UserService {
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PasswordEncoder passwordEnc;
	
	@Transactional
	public boolean createUser(User us) {
		
		if(userRepo.findByEmail(us.getEmail())!=null) return false;
		us.setActive(true);
		us.setPassword(passwordEnc.encode(us.getPassword()));
		us.getRoles().add(Role.ROLE_USER);
		log.info("Saving new user: {}",us.getName());
		userRepo.save(us);
		return true;
	}
	
	@Transactional
	public List<User> findAllUsers(){
		return userRepo.findAll();
	}

	public void banUser(Long id) {
		User user = userRepo.findById(id).orElse(null);
		if(user!=null) {
		
		if(!user.isActive()) {
			user.setActive(true);
			log.info("User is UNBanned: {}; name: {}", user.getUserId(), user.getUsername());
		} else {
		user.setActive(false);
		log.info("User is banned: {}; name: {}", user.getUserId(), user.getUsername());
		}
		userRepo.save(user);
		}
		
	}

	public void changeUserRoles(User user, Map<String, String> form) {
		Set<String> roles = Arrays.stream(Role.values())
				.map(Role::name)
				.collect(Collectors.toSet());
		user.getRoles().clear();
		for(String key: form.keySet()) {
			if(roles.contains(key)) {
				user.getRoles().add(Role.valueOf(key));
			}
		}
		userRepo.save(user); 
		
	}
	
}

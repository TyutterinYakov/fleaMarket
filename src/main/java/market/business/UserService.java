package market.business;

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
		
		if(userRepo.findByEmail(us.getEmail())!=null) {
			return false;
		}
		
		us.setActive(true);
		us.setPassword(passwordEnc.encode(us.getPassword()));
		us.getRoles().add(Role.ROLE_USER);
		log.info("Saving new user: {}",us.getName());
		userRepo.save(us);
		return true;
	}
	
}

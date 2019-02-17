package project.controller.authentication;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.entity.Account;
import project.entity.User;
import project.repository.UserRepository;

@Controller
@RequestMapping("/login")
public class AuthenticationController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("newAccount")
	public String newAccount(ModelMap map) {
		map.addAttribute(new User());
		return "authentication/newAccount";
	}
	
	@GetMapping
	public String login(ModelMap map) {
		map.addAttribute(new User());
		return "authentication/login";
	}
	
	@PostMapping("/createNewUser")
	public String createAccount(@ModelAttribute User user, ModelMap map) {		
		
		//check for duplicates
		//encrypt password
		Account account = new Account();
		account.setBambeuros(new BigDecimal(10000));
		user.setAccount(account);
		
		userRepository.save(user);
		
		
		return "redirect:/";
	}
}

package project.controller.Home;

import java.math.BigDecimal;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.entity.User;
import project.repository.UserRepository;
import project.service.impl.TransactionServiceImpl;
import project.wrapper.SendBambeurosWrapper;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	TransactionServiceImpl transactionService;
	@GetMapping
	public String home(Principal principal, ModelMap map) {
		
		User user = userRepo.findByUsername(principal.getName());
		
		map.addAttribute("bambeuros", user.getAccount().getBambeuros());
		map.addAttribute("sendBambeurosWrapper",new SendBambeurosWrapper());
		map.addAttribute("users", userRepo.findAll());
		map.addAttribute("transactions",user.getAccount().getOutgoingTransactions());
		return "home/main";
	}

	@PostMapping("/sendBambeuros")
	public String sendBambeuros(Principal principal, SendBambeurosWrapper wrapper) {
		
		User from = userRepo.findByUsername(principal.getName());
		User to = userRepo.findById( wrapper.getTo()).orElse(null);
		BigDecimal amount = wrapper.getAmount();
		
		if( from != null && to != null && amount != null) {
			transactionService.transaction(from, to, amount);
		}
		
		
		return "redirect:/";
	}
}

package io.github.phoebetai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@GetMapping("/login")
	public String loginForm(Model model, String error) {
		if (error != null) {
			model.addAttribute("error", "Invalid username or password");
		}
		return "login";
	}
	
	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerSubmit(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
		
		userValidator.validate(user, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return "register";
		}
		
		userService.save(user);
		
		return "redirect:/home";
	}
}

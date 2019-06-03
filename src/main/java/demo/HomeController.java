package demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/newuser")
	public String newuser() {
		return "newuser";
	}
	
	@RequestMapping("/")
	public String login() {
		return "login";
	}
}

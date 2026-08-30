package in.sp.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.sp.main.entities.User;
import in.sp.main.services.UserService;

@Controller
public class MyController 
{
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String home()
	{
		return "index";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("title") String title, Model model)
	{
		 if (title == null || title.isEmpty()) {
		        model.addAttribute("users", null);
		        return "index";
		    }
		
		List<User> results = userService.searchByTitle(title);
		model.addAttribute("users", results);
		return "index";
	}
}

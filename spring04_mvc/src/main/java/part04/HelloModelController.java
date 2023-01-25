package part04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//  http://localhost:8090/myapp/model.htm

@Controller
public class HelloModelController {

	public HelloModelController() {
		
	}
	
	@GetMapping("/model.htm")
	public String form() {
		return "part04/memForm";
	}
	
	@PostMapping("/model.htm")
	public String submit(String name, int age, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "part04/memPro";
	}
}

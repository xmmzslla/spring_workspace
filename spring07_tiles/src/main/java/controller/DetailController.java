package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//http://localhost:8090/myapp/detail.do

@Controller
public class DetailController {
	
	@RequestMapping("/detail.do")
	public String execute() {
		return "detail";
	}

}

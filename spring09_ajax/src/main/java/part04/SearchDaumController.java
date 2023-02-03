package part04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// http://localhost:8090/myapp/booksearch.do

@Controller
public class SearchDaumController {
	
	public SearchDaumController() {

	}

	@RequestMapping(value = "/booksearch.do", method = RequestMethod.GET)
	public String form() {
		return "part04/form";
	}
	
}

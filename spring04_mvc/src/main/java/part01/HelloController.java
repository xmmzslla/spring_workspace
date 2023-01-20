package part01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// http://localhost:8090/myapp/hello.htm

@Controller
public class HelloController { 
// Web에서 컨트롤러로 사용할 클래스에서는 @Controller이거 꼭 해줘야함
	
	public HelloController() {
		
	}
	
	@RequestMapping(value = "/hello.htm")
	public String search() {
		return "part01/hello";
	} ///hello.htm으로 요청이 들어오면 이 메소드를 수행하라
	
}

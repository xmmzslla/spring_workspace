package part01;

import org.apache.velocity.tools.config.Data;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// http://localhost:8090/myapp/main.do

@Controller
public class HelloController {
	
	@RequestMapping("/main.do")
	public String execute() {
		return "part01/form";
	}
	
//	@Scheduled(fixedDelay = 1000) //1000 = 1초
    public void scheduledProcess() {
    	System.out.println(new Data() + "스케줄링 처리 완료");
    }
	
}

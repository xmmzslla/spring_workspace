package members.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import members.service.MembersService;

// http://localhost:8090/myapp/signup.do

@Controller
public class MembersController {

	private MembersService membersService;
	
	public MembersController() {
		// TODO Auto-generated constructor stub
	}
	
	public void setMembersService(MembersService membersService) {
		this.membersService = membersService;
	}
	
//	회원가입 폼
	@RequestMapping(value = "/member/signup.do", method=RequestMethod.GET)
	public ModelAndView addMember(ModelAndView mav) {
		mav.setViewName("member/signup");
		return mav;
	}
	
}

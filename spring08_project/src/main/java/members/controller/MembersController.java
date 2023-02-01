package members.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import members.dto.AuthInfo;
import members.dto.MembersDTO;
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
	
//	   회원가입 처리
	   @RequestMapping(value="/member/signup.do", method=RequestMethod.POST)
	   public String addMember(MembersDTO membersDTO, HttpSession session) {
	      AuthInfo authInfo = membersService.addMemberProcess(membersDTO);
	      session.setAttribute("authInfo", authInfo);
	      return "redirect:/home.do";
	   }
	
//	로그아웃
	@RequestMapping(value = "/member/logout.do")
	public String logoutMember(HttpSession session) {
		session.invalidate(); 
		return "redirect:/home.do";
	}
	
// 로그인 폼
	@RequestMapping(value = "/member/login.do", method=RequestMethod.GET)
	public String loginMember() {
		return "member/login";
	}
	
//	로그인 처리
	@RequestMapping(value = "/member/login.do", method=RequestMethod.POST)
	public String loginMember(MembersDTO membersDTO, HttpSession session, HttpServletResponse resp) {
		
		AuthInfo authInfo = membersService.loginProcess(membersDTO);
		session.setAttribute("authInfo", authInfo);
		Cookie rememberCookie = new Cookie("REMEMBER", membersDTO.getMemberEmail());
		rememberCookie.setPath("/");
		if(membersDTO.isRememberEmail()) {
			rememberCookie.setMaxAge(60*60*24*30); //60초*60분*24시간*30일 = 한달
		}else {
			rememberCookie.setMaxAge(0);
		}
		resp.addCookie(rememberCookie);
		return "redirect:/home.do";
	}
}

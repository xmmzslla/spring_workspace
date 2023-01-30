package board.Controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import board.dto.BoardDTO;
import board.dto.PageDTO;
import board.service.BoardService;
import common.file.FileUpload;

@Controller
public class BoardController {

	private BoardService boardService;
	
	public BoardController() {
		// TODO Auto-generated constructor stub
	}
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/board/list.do")
	public ModelAndView listExecute(@ModelAttribute("pv") PageDTO pv, ModelAndView mav) {
		//@ModelAttribute("pv")받는 이름과 내보내는 이름이 다를 때 사용
		System.out.println("pv:" + pv.getCurrentPage());
		int totalRecord = boardService.countProcess();
		
		if(totalRecord >= 1)
		mav.addObject("aList", boardService.listProcess(pv));
		mav.setViewName("board/list");
		return mav;
	}
	
	@RequestMapping(value = "/board/write.do", method=RequestMethod.GET)
	public ModelAndView writeExecute(ModelAndView mav) {
		mav.setViewName("board/write");
		return mav;
	}
	
	@RequestMapping(value = "/board/write.do", method = RequestMethod.POST)
	public String writeProExecute(BoardDTO dto, HttpServletRequest req) {
		MultipartFile file = dto.getFilename();
//		System.out.printf("file: " + file.getOriginalFilename());
		
		//첨부파일이 있으면...
		if(!file.isEmpty()) {
			UUID random = FileUpload.saveCopyFile(file, req);
			dto.setUpload(random + "_" + file.getOriginalFilename());
		}
		dto.setIp(req.getRemoteAddr());
		
		boardService.insertProcess(dto);
		
		return "redirect:/board/list.do";
	}
	
	@RequestMapping("/board/view.do")
	public ModelAndView viewExecute(int currentPage, int num, ModelAndView mav) {
		System.out.printf("currentPage:%d, num:%d\n", currentPage, num );
		mav.addObject("dto", boardService.contentProcess(num));
		mav.addObject("currentPage", currentPage);
		mav.setViewName("board/view");
		return mav;
		
	}
	
}//c

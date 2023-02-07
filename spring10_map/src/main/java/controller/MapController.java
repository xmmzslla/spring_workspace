package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dto.LibmapDTO;
import service.LibService;

// http://localhost:8090/myapp/map.do

@Controller
public class MapController {
	
	private LibService service;
	
	public MapController() {
		
	}
	
	public void setService(LibService service) {
		this.service = service;
	}
	
	@RequestMapping("/map.do")
	public String mapForm() {
		return "map";
	}
	
//	@RequestMapping(value = "/libmap.do", method = RequestMethod.POST)
//	public ModelAndView libraryMap(int pageNo, int pageSize, String keyword, ModelAndView mav) {
//		int countAll = service.f_countAllProcess(keyword);
//		int totalPage=countAll/pageSize;
//		if((countAll%pageSize)>0)
//			totalPage++;
//		
//		List<LibmapDTO> aList = service.f_listProcess(pageNo, pageSize, keyword);
//		mav.addObject("aList",aList);
//		mav.addObject("pageNo", pageNo);
//		mav.addObject("totalPage", totalPage);
//		mav.setViewName("jsonView");				
//		return mav;
//
//	}
	
	@ResponseBody
	@RequestMapping(value = "/libmap.do", method = RequestMethod.POST)
	public Map<String, Object> libraryMap(int pageNo, int pageSize, String keyword) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		int countAll = service.f_countAllProcess(keyword);
		int totalPage=countAll/pageSize;
		if((countAll%pageSize)>0)
			totalPage++;
		
		List<LibmapDTO> aList = service.f_listProcess(pageNo, pageSize, keyword);
		
		map.put("aList",aList);
		map.put("pageNo", pageNo);
		map.put("totalPage", totalPage);
		
		return map;

	}

}

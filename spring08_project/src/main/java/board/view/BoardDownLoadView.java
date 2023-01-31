package board.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;

//다운로드 창을 띄우기 위한 뷰 페이지
public class BoardDownLoadView {
	
	private BoardDAO boardDao;
	
	public BoardDownLoadView() {
		// TODO Auto-generated constructor stub
	}
	
	public void setBoardDao(BoardDAO boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse reponse	)throws Exception {
		
	}

}

package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.ISavePostService;
import kr.or.ddit.service.SavePostServiceImpl;
import kr.or.ddit.vo.SavedPostVo;

/**
 * Servlet implementation class Bookmark
 */
@WebServlet("/Bookmark.do")
public class Bookmark extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bookmark() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("post_no"));
		String id = request.getParameter("mem_id");
		System.out.println("글 번호 "+no+"아이디  "+id);
		
		ISavePostService service = SavePostServiceImpl.getInstance();
		
		//해당 회원이 저장한 게시글 리스트 가져오기 
		List<SavedPostVo> list = service.getSavedPostList(id);
				
		System.out.println(list.size());
		
		SavedPostVo spv = new SavedPostVo();
		
		spv.setPost_no(no);
		spv.setMem_id(id);
		
		System.out.println("1");
		int cnt = service.insertSavePost(spv);
		System.out.println("2");
		request.setAttribute("count", cnt);
		
		request.getRequestDispatcher("sonminsooo/jsp/result.jsp").forward(request, response);
		
	}

}

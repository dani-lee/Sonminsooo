package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.BoardServiceImpl;
import kr.or.ddit.service.IBoardService;

/**
 * Servlet implementation class DeleteBoard
 */
@WebServlet("/DeleteBoard.do")
public class DeleteBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("postNo"));
		
		IBoardService service = BoardServiceImpl.getServiece();
		
		int cnt = service.deleteBoard(no);
		
		request.setAttribute("count", cnt);
		
		request.getRequestDispatcher("sonminsooo/jsp/result.jsp").forward(request, response);
		
		/*
		request.setCharacterEncoding("UTF-8");
		
		int cnt = 0;
		
		int post_no = Integer.parseInt(request.getParameter("postNo"));
		
		IBoardService service = BoardServiceImpl.getServiece();
		
		cnt = service.deleteBoard(post_no);
		
		request.setAttribute("count", cnt);
		
		request.getRequestDispatcher("sonminsooo/jsp/result.jsp").forward(request, response);
		*/
		
	}

}

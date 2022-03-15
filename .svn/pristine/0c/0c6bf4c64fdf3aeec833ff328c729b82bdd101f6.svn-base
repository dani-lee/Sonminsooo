package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.HashTagServiceImpl;
import kr.or.ddit.service.IHashTagService;
import kr.or.ddit.vo.HashTagVo;

/**
 * Servlet implementation class SearchHash
 */
@WebServlet("/SearchHash.do")
public class SearchHash extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchHash() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
		
		String content = request.getParameter("hashName");
		
		System.out.println("SearchHash.do : hashName => "+content);
		
		IHashTagService service = HashTagServiceImpl.getInstance();
		
		List<HashTagVo> list = service.searchHash(content);
		
		request.setAttribute("tagList", list);
		
		request.getRequestDispatcher("sonminsooo/jsp/searchHash.jsp").forward(request, response);
	}

}

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
 * Servlet implementation class SelectHashTagList
 */
@WebServlet("/SelectHashTagList.do")
public class SelectHashTagList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectHashTagList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String hash = request.getParameter("hash");
		
		IHashTagService service = HashTagServiceImpl.getInstance();
		
		List<HashTagVo> list = service.getHashtagList(hash);
		
		request.setAttribute("hashList", list);
		
		request.getRequestDispatcher("sonminsooo/jsp/hashList.jsp").forward(request, response);
		
	}

}

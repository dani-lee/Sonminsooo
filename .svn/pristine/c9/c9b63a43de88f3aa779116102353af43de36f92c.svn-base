package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.IPostService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.service.PostServiceImpl;
import kr.or.ddit.vo.FriendsVO;
import kr.or.ddit.vo.PostVO;

/**
 * Servlet implementation class MypostSelect
 */
@WebServlet("/MypostSelect.do")
public class MypostSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypostSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mem_id = request.getParameter("mem_id");

		IPostService service = PostServiceImpl.getService();

		List<PostVO> list = null;
		list = service.mypostSelect(mem_id);
		request.setAttribute("list", list);

		request.getRequestDispatcher("sonminsooo/jsp/mypost.jsp").forward(request, response);
	}
	

}

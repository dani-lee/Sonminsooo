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
import kr.or.ddit.vo.PostLikeVO;

/**
 * Servlet implementation class PostLikeSelect
 */
@WebServlet("/PostLikeSelect.do")
public class PostLikeSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostLikeSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String post_no = request.getParameter("post_no");

		IPostService service = PostServiceImpl.getService();

		List<PostLikeVO> list = service.postlikeSelect(post_no);

		request.setAttribute("list", list);

		request.getRequestDispatcher("sonminsooo/jsp/mypostlike.jsp").forward(request, response);
	}

}

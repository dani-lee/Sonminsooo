package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.IPostService;
import kr.or.ddit.service.PostServiceImpl;
import kr.or.ddit.vo.PostVO;
import kr.or.ddit.vo.ReplyVO;

/**
 * Servlet implementation class ReplySelect
 */
@WebServlet("/ReplySelect.do")
public class ReplySelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplySelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String post_no = request.getParameter("post_no");
		System.out.println("post_no : "+post_no);
		IPostService service = PostServiceImpl.getService();

		List<ReplyVO> list = null;
		list = service.replySelect(post_no);
		
		System.out.println("list_size : "+list.size());
/*		System.out.println("list" : list.get(0).getPost_no());*/
		request.setAttribute("list", list);

		request.getRequestDispatcher("sonminsooo/jsp/reply.jsp").forward(request, response);
	}

}

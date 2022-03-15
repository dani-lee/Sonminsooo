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
import kr.or.ddit.vo.ReplyLikeVO;
import kr.or.ddit.vo.ReplyVO;

/**
 * Servlet implementation class ReplyLikeSelect
 */
@WebServlet("/ReplyLikeSelect.do")
public class ReplyLikeSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyLikeSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String child_id = request.getParameter("child_id");
		IPostService service = PostServiceImpl.getService();

		List<ReplyLikeVO> list = null;
		list = service.replylikeSelect(child_id);
		System.out.println(list.size());
		request.setAttribute("list", list);

		request.getRequestDispatcher("sonminsooo/jsp/replylike.jsp").forward(request, response);
	}

}

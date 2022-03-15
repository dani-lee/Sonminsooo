package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.FriendsVO;
import kr.or.ddit.vo.MemberVO;

/**
 * Servlet implementation class FriendsList
 */
@WebServlet("/FollowerList.do")
public class FollowerList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FollowerList() {
		super();
	
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String userId = request.getParameter("userId");

		IMemberService service = MemberServiceImpl.getService();

		List<MemberVO> list = service.selectAllFollowers(userId);
		System.out.println(list.size());
		System.out.println(list.get(0).getMem_id());
		request.setAttribute("list", list);

		request.getRequestDispatcher("sonminsooo/jsp/friends.jsp").forward(request, response);
	}

}

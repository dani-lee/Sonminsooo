package kr.or.ddit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.FriendsVO;
import kr.or.ddit.vo.MemberVO;

/**
 * Servlet implementation class FriendSelect
 */
@WebServlet("/FriendSelect.do")
public class FriendSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String mem_id = request.getParameter("mem_id");
		IMemberService service = MemberServiceImpl.getService();

		List<FriendsVO> list = null;
		list = service.selectFriend(mem_id);
/*		System.out.println(list.size());
		System.out.println(list.get(0).getMemId());*/
/*		request.setAttribute("list", list);*/
		HttpSession s = request.getSession();
		
		s.setAttribute("FriendList", list);

		request.getRequestDispatcher("sonminsooo/jsp/loginUserFriends.jsp").forward(request, response);
	}

}

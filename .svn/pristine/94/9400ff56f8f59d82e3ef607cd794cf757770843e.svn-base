package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.service.IPostService;
import kr.or.ddit.service.PostServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.SimplePhotoVO;

/**
 * Servlet implementation class LoginUserFriend
 */
@WebServlet("/LoginUserFriend.do")
public class LoginUserFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUserFriend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession s = request.getSession();
		
		MemberVO loginUser = (MemberVO) s.getAttribute("loginUser");
		
		IPostService service = PostServiceImpl.getService();
		
		List<SimplePhotoVO> list = service.loginUserFriend(loginUser.getMem_id());
		
		request.setAttribute("friendList", list);
		
		request.getRequestDispatcher("sonminsooo/jsp/loginUserFriend.jsp").forward(request, response);
		
	}

}












































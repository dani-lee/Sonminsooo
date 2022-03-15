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
import kr.or.ddit.vo.PostVO;

/**
 * Servlet implementation class NewPost
 */
@WebServlet("/NewPost.do")
public class NewPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        request.setCharacterEncoding("utf-8");
		
        HttpSession s = request.getSession();
        
        MemberVO vo = (MemberVO) s.getAttribute("loginUser");
		String memId = vo.getMem_id();
		
		IPostService ps = PostServiceImpl.getService();
		
		List<PostVO> postList = (List<PostVO>) ps.selectMyFollwingNewPost(memId);
		
		System.out.println("postList : " + postList);
		
		request.setAttribute("postList", postList);
		
		request.getRequestDispatcher("sonminsooo/jsp/newPost.jsp").forward(request, response);
		
	}

}

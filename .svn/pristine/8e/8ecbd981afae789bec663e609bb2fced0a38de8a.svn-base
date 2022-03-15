package kr.or.ddit.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import kr.or.ddit.vo.PostLikeVO;
import kr.or.ddit.vo.SimplePhotoVO;

/**
 * Servlet implementation class PostLike
 */
@WebServlet("/PostLike.do")
public class PostLike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostLike() {
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
		
		IPostService service = PostServiceImpl.getService();
		
		List<PostLikeVO> list = service.selectPostLike(vo.getMem_id());
		
		List<SimplePhotoVO> psn_list = new ArrayList<>();
		
		for(int i = 0; i < list.size(); i++) { 
			System.out.println("list.get(i).getPost_no() => " + list.get(i).getPost_no());
			SimplePhotoVO sn = (SimplePhotoVO) service.selectPostImg(list.get(i).getPost_no());
			psn_list.add(sn);
			System.out.println(psn_list.get(i).getAtch_file_id());
			System.out.println(psn_list.get(i).getFile_sn());
		}
		
		
		request.setAttribute("postLike", list);
		request.setAttribute("p_sn", psn_list);
		
		request.getRequestDispatcher("/sonminsooo/jsp/postLike.jsp").forward(request, response);
		
		
		
	}

}

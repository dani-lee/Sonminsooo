package kr.or.ddit.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.HashTagServiceImpl;
import kr.or.ddit.service.IHashTagService;
import kr.or.ddit.vo.HashTagVo;
import kr.or.ddit.vo.MemberVO;

/**
 * Servlet implementation class SearchUser
 */
@WebServlet("/SearchUser.do")
public class SearchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
		
		String content = request.getParameter("userName");
		
		System.out.println("SearchUser.do : userName => "+content);
		
		IHashTagService service = HashTagServiceImpl.getInstance();
		
		List<MemberVO> list = service.searchUser(content);
		
		List<Integer> fsnList = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			int fsn = service.searchUserImg(list.get(i).getMem_photo());
			System.out.println("fsn => " + fsn);
			fsnList.add(fsn);
		}
		
		
		request.setAttribute("userList", list);
		request.setAttribute("imgList", fsnList);
		
		request.getRequestDispatcher("sonminsooo/jsp/searchUser.jsp").forward(request, response);
	}

}












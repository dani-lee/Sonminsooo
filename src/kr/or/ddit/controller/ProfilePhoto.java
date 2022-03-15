package kr.or.ddit.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.AtchFileVo;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.OptionVO;

/**
 * Servlet implementation class ProfilePhoto
 */
@WebServlet("/ProfilePhoto.do")
public class ProfilePhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilePhoto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		long photo_id = Long.parseLong(request.getParameter("mem_photo"));

		IMemberService service = MemberServiceImpl.getService();

		AtchFileVo vo = service.photoSelect(photo_id);
/*		System.out.println(vo.size());
		System.out.println(.get(0).getMem_id());*/

		
		HttpSession session = request.getSession();

		session.setAttribute("loginUser_photo", vo);

		request.getRequestDispatcher("/sonminsooo/jsp/photo.jsp").forward(request, response);
	}

}

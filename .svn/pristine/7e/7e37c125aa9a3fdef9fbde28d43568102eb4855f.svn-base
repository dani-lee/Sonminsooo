package kr.or.ddit.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.FollowVO;
import kr.or.ddit.vo.MemberVO;

/**
 * Servlet implementation class OtherMember
 */
@WebServlet("/OtherMember.do")
public class OtherMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtherMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 0. 클라이언트 요청(전송)시 데이터 전달
		String mem_id = request.getParameter("mem_id");
		System.out.println("mem_id : "+mem_id);

		// 1. service객체 얻기
		IMemberService service = MemberServiceImpl.getService();

		// 2. service메소드 호출하기 : 결과값 받기
		MemberVO vo = service.otherMemberSelect(mem_id);
System.out.println("name : "+vo.getMem_name());
		// 3. 결과값을 request에 저장
				HttpSession s = request.getSession();
		
				s.setAttribute("otherUser", vo);

		// 4. jsp로 forward : 1005/idcheck.jsp

		request.getRequestDispatcher("/sonminsooo/jsp/otherUser.jsp").forward(request, response);
	}

}

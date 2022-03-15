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
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.OptionVO;

/**
 * Servlet implementation class OptionList
 */
@WebServlet("/OptionList.do")
public class OptionList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OptionList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String mem_id = request.getParameter("mem_id");

		IMemberService service = MemberServiceImpl.getService();

		OptionVO vo = (OptionVO) service.optionList(mem_id);
		//System.out.println(list.size());
		//System.out.println(list.get(0).getMem_id());

		request.setAttribute("vo", vo);

		request.getRequestDispatcher("sonminsooo/jsp/option.jsp").forward(request, response);
	}

}

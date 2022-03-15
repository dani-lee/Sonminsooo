package kr.or.ddit.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/Join.do")
public class Join extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");
		
		MemberVO memberVO = new MemberVO();
		
		try {
			BeanUtils.populate(memberVO, req.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		IMemberService service = MemberServiceImpl.getService();
		
		String memid = service.insertMember(memberVO);
		
		req.setAttribute("memid", memid);
		
		req.getRequestDispatcher("sonminsooo/jsp/insertMember.jsp").forward(req, resp);
	
	}
}

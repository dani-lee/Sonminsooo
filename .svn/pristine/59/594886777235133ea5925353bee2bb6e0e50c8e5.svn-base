package kr.or.ddit.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.service.IPostService;
import kr.or.ddit.service.PostServiceImpl;
import kr.or.ddit.vo.PostLikeVO;

@WebServlet("/DeletePostLike.do")
public class DeletePostLike extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		PostLikeVO plv = new PostLikeVO();
		
		try {
			BeanUtils.populate(plv, req.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		IPostService service = PostServiceImpl.getService();
		
		int cnt = service.deletePostLike(plv);
		
		req.setAttribute("count", cnt);
		
		req.getRequestDispatcher("/sonminsooo/jsp/result.jsp").forward(req, resp);
	}
}

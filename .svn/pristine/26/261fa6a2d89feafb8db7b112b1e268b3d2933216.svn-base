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
import kr.or.ddit.vo.ReplyLikeVO;
import kr.or.ddit.vo.ReplyVO;

/**
 * Servlet implementation class ReplyLikeInsert
 */
@WebServlet("/ReplyLikeInsert.do")
public class ReplyLikeInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyLikeInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 0. 클라이언트 요청(전송)시 데이터 전달
		ReplyLikeVO vo = new ReplyLikeVO();
		
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("id : "+vo.getChild_id() );

		// 1. service객체 얻기
		IPostService service = PostServiceImpl.getService();

		// 2. service메소드 호출하기 : 결과값 받기
		int count = service.replylikeInsert(vo);
		if (Integer.toString(service.replylikeInsert(vo))==null) {
			count=1;
		}
		System.out.println("count : "+count);
		// 3. 결과값을 request에 저장
		request.setAttribute("count", count);

		// 4. jsp로 forward : 1005/idcheck.jsp

		request.getRequestDispatcher("/sonminsooo/jsp/result.jsp").forward(request, response);
	}

}

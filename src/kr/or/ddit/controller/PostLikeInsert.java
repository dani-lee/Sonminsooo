package kr.or.ddit.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.IPostService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.service.PostServiceImpl;
import kr.or.ddit.vo.FollowVO;
import kr.or.ddit.vo.PostLikeVO;
import kr.or.ddit.vo.PostVO;
import kr.or.ddit.vo.ReplyLikeVO;

/**
 * Servlet implementation class PostLikeInsert
 */
@WebServlet("/PostLikeInsert.do")
public class PostLikeInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostLikeInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// 0. 클라이언트 요청(전송)시 데이터 전달
		PostLikeVO vo = new PostLikeVO();

		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(vo.getPost_no());
		System.out.println(vo.getMem_id());
		
		PostLikeVO cntlike = new PostLikeVO();
		
		// 1. service객체 얻기
		IPostService service = PostServiceImpl.getService();
	
		// 2. service메소드 호출하기 : 결과값 받기
		int count = service.postlikeInsert(vo);
		System.out.println("count : "+count);
		
		cntlike = service.cntlike(vo.getPost_no());
		System.out.println(cntlike.getCnt_post_like());
		
		
		// 3. 결과값을 request에 저장
		request.setAttribute("count", count);
		request.setAttribute("cnklike", cntlike);
		// 4. jsp로 forward : 1005/idcheck.jsp

		request.getRequestDispatcher("/sonminsooo/jsp/result.jsp").forward(request, response);
	}

}

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

import org.apache.jasper.tagplugins.jstl.core.Redirect;

import kr.or.ddit.service.HashTagServiceImpl;
import kr.or.ddit.service.IHashTagService;
import kr.or.ddit.vo.HashTagVo;
import kr.or.ddit.vo.PostVO;
import kr.or.ddit.vo.SimplePhotoVO;

/**
 * Servlet implementation class HashChoice
 */
@WebServlet("/HashChoice.do")
public class HashChoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HashChoice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*request.setCharacterEncoding("utf-8");
		
		String hash = (String) request.getParameter("v.hash");
		
		System.out.println("HashChoice.do/doPost/hash :" + hash);
		
//		HttpSession s = request.getSession();
//		s.setAttribute("hash", hash);
		
		response.sendRedirect("/Sonminsooo/sonminsooo/html/searchHashChoice.html");
		*/
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String hash = req.getParameter("hash");
//		int count = Integer.parseInt(req.getParameter("count"));
		
		
		System.out.println("HashChoice.do/doGet/hash : " + hash);
		
		IHashTagService service = HashTagServiceImpl.getInstance();
		List<Integer> postNo_list = service.hashChoice(hash);
		
		List<HashTagVo> hashCount = service.searchHash(hash);
		
		List<List<SimplePhotoVO>> photoList = new ArrayList<List<SimplePhotoVO>>();
		for(int i = 0; i < postNo_list.size(); i++) {
			List<SimplePhotoVO> svo = (List<SimplePhotoVO>) service.hashPhoto(postNo_list.get(i));
			for(int j = 0; j<svo.size(); j++) {
				svo.get(j).setPost_no(postNo_list.get(i));
			}
			photoList.add(svo);
		}
		
		hash = "#" + hash;
		
		HttpSession s = req.getSession();
		
		s.setAttribute("hash", hash);
		s.setAttribute("count", hashCount.get(0).getCount());
		s.setAttribute("hashPhoto", photoList);
		
		resp.sendRedirect("/Sonminsooo/sonminsooo/html/searchHashChoice.html");
		
		
	}

}

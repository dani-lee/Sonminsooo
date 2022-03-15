package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.IPostService;
import kr.or.ddit.service.PostServiceImpl;
import kr.or.ddit.vo.PostVO;

@WebServlet("/LikesList.do")
public class PostLikeListforFeed extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		int post_no = Integer.parseInt(req.getParameter("post_no"));
		String mem_id = req.getParameter("mem_id");
		int chk = 0;
		
		IPostService service = PostServiceImpl.getService();
		
		List<PostVO> likelist = service.postGetlikelist(post_no);
		
		for(int i = 0; i < likelist.size(); i++) {
//			System.out.println("post_no : " + likelist.get(i).getPost_no());
//			System.out.println("mem_id : " + likelist.get(i).getMem_id());
//			System.out.println("mem_nane : " + likelist.get(i).getMem_name());
//			System.out.println("-------------------------------------");
			
			if(likelist.get(i).getMem_id().equals(mem_id)){
				chk = 1; //좋아요 리스트에 내가 있을때(그 게시물을 내가 좋아요 눌렀을때)
			}
			else {
				chk = 0;
			}
		}
		
		req.setAttribute("chk", chk);
		req.setAttribute("likelist", likelist);
		
		req.getRequestDispatcher("sonminsooo/jsp/LikelistforFeed.jsp").forward(req, resp);
		
	}

}

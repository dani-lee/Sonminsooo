package kr.or.ddit.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.service.IPostService;
import kr.or.ddit.service.PostServiceImpl;
import kr.or.ddit.vo.LocationVo;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PostLikeVO;
import kr.or.ddit.vo.PostVO;
import kr.or.ddit.vo.ReplyVO;

@WebServlet("/Feed.do")
public class post extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//게시물 불러오기
		req.setCharacterEncoding("UTF-8");
		HttpSession s = req.getSession();
		MemberVO mv = new MemberVO();
		mv = (MemberVO) s.getAttribute("loginUser");
		
		String login_mem_id = (String) mv.getMem_id();
		
		IPostService service = PostServiceImpl.getService();
				
		List<PostVO> postlist = service.selectPost(login_mem_id);
		List<PostLikeVO> likelist = new ArrayList<PostLikeVO>();
		List<ReplyVO> postReply = new ArrayList<ReplyVO>();
		List<LocationVo> postLoca = new ArrayList<LocationVo>();

		List<PostVO> forcontent = new ArrayList<>();

		for(int i = 0; i < postlist.size(); i++) {
			PostLikeVO likevo = service.cntPostLike(postlist.get(i).getPost_no());
			ReplyVO replyvo = service.postGetReply(postlist.get(i).getPost_no());
			LocationVo locavo = service.postGetLocation(postlist.get(i).getPost_no());
			
			
			//해시태그 찾아서 a태그 붙이기
			String content = postlist.get(i).getPost_content();
			PostVO pv = new PostVO();
			
			if(content != null) {
				String words[] = content.split(" ");
				
				for(int j = 0; j < words.length; j++) {
					if(words[j].startsWith("#")) {
						words[j] = String.format("<a href='/Sonminsooo/HashChoice.do?hash="+ words[j].substring(1)+"'>%s</a>", words[j]);
						content = String.join(" ", words);
					}
				}
				
			}else {
				content = " ";
			}
			pv.setPost_content(content);
			
			forcontent.add(pv);
			
			postLoca.add(locavo);
			likelist.add(likevo);
			postReply.add(replyvo);
		}
		
		req.setAttribute("forcontent", forcontent);
		req.setAttribute("postLoca", postLoca);
		req.setAttribute("postReply", postReply);
		req.setAttribute("like_cnt", likelist);
		req.setAttribute("postlist", postlist);

		req.getRequestDispatcher("sonminsooo/jsp/post.jsp").forward(req, resp);
				
	}
}

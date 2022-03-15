package kr.or.ddit.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.service.AtchFileServiceImpl;
import kr.or.ddit.service.BoardServiceImpl;
import kr.or.ddit.service.HashTagServiceImpl;
import kr.or.ddit.service.IAtchFileService;
import kr.or.ddit.service.IBoardService;
import kr.or.ddit.service.IHashTagService;
import kr.or.ddit.util.FileUploadRequestWrapper;
import kr.or.ddit.vo.AtchFileVo;
import kr.or.ddit.vo.BoardVo;
import kr.or.ddit.vo.HashTagVo;
import kr.or.ddit.vo.LocationVo;
import kr.or.ddit.vo.MemberVO;


@WebServlet(value="/InsertBoard.do")
public class InsertBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertBoard() {
        super();
        
    }

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AtchFileVo atchFileVo = new AtchFileVo();
		HttpSession s = request.getSession();
		
		
		if(((FileUploadRequestWrapper) request).isMultipartContent()) {
			
			IAtchFileService fileservice = AtchFileServiceImpl.getInstance();
			Map<String, FileItem[]> fileItemMap = ((FileUploadRequestWrapper)request).getFileItemMap();
			
			System.out.println("파일 아이템 크기: " + fileItemMap.size());
			if(fileItemMap.size() > 0) {
				try {
					atchFileVo = fileservice.saveAtchFileList(fileItemMap);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		String kind = request.getParameter("post_kind");
		String content = request.getParameter("content");  //게시글 내용
		int location_no = Integer.parseInt(request.getParameter("location"));
		
		System.out.println("kind=" + kind);
		System.out.println("content=" + content);
		long fileId = atchFileVo.getAtchFileId();
		System.out.println("파일 아이디 : "+fileId);
		
		
		
		content.replaceAll("\n", " ");
		request.setCharacterEncoding("UTF-8");
		MemberVO mv = new MemberVO();
		mv = (MemberVO)s.getAttribute("loginUser");
		BoardVo bv = new BoardVo();
		
		bv.setPost_kind(kind);
		bv.setMem_id(mv.getMem_id());
		bv.setPost_content(content);
		bv.setLocation_no(location_no);
		bv.setAtchFileId(atchFileVo.getAtchFileId());//184번이후로 들어 오는데 왜 insert가 왜?
		System.out.println(bv.getAtchFileId());
		IBoardService boardService = BoardServiceImpl.getServiece();
		
		int cnt = boardService.insertBoard(bv);
		
        String hashtag[] = content.split(" ");
		
		HashTagVo hv = new HashTagVo();
		
		IHashTagService hashTagService = HashTagServiceImpl.getInstance();
		for(int i = 0; i < hashtag.length; i++) {
			if(hashtag[i].contains("#")) {
				System.out.println(hashtag[i]);
				hv.setHash(hashtag[i]);
				hv.setPost_no(cnt);
				hashTagService.insertHashTag(hv);
			}
		}
		
		
		
		
		
		
		request.setAttribute("count", cnt);
		
		request.getRequestDispatcher("sonminsooo/jsp/result.jsp").forward(request, response);
						    //피드 페이지^여기에 
		
	}

}

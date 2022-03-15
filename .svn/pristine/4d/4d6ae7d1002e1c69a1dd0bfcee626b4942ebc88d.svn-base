package kr.or.ddit.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.service.AtchFileServiceImpl;
import kr.or.ddit.service.BoardServiceImpl;
import kr.or.ddit.service.IAtchFileService;
import kr.or.ddit.service.IBoardService;
import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.util.FileUploadRequestWrapper;
import kr.or.ddit.vo.AtchFileVo;
import kr.or.ddit.vo.BoardVo;
import kr.or.ddit.vo.MemberVO;

/**
 * Servlet implementation class PhotoUpdate
 */
@WebServlet("/PhotoUpdate.do")
public class PhotoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		/*request.getRequestDispatcher("/sonminsooo/html/insert/insertForm.jsp").forward(request, response);
		*/
		request.getRequestDispatcher("/sonminsooo/jsp/loginUser.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여보세요");
		AtchFileVo atchFileVo = new AtchFileVo();
		HttpSession s = request.getSession();
		
		if(((FileUploadRequestWrapper) request).isMultipartContent()) {
			System.out.println("홋시..?");
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
		
		request.setCharacterEncoding("UTF-8");
		MemberVO mv = new MemberVO();
		mv = (MemberVO) s.getAttribute("loginUser");

		mv.setMem_photo(atchFileVo.getAtchFileId());
		
		IMemberService memberService = MemberServiceImpl.getService();
		
		int cnt = memberService.photoUpdate(mv);
		System.out.println("count : "+cnt);
		request.setAttribute("count", cnt);
	
		request.getRequestDispatcher("/sonminsooo/jsp/result.jsp").forward(request, response);
						    //피드 페이지^여기에 
		
	}

}

package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.service.ILocationService;
import kr.or.ddit.service.LocationServiceImpl;
import kr.or.ddit.vo.LocationVo;

/**
 * Servlet implementation class SelectLocationList
 */
@WebServlet("/SelectLocationList.do")
public class SelectLocationList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectLocationList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//입력 창에서는 
		String location = request.getParameter("location");
		
		ILocationService service = LocationServiceImpl.getInstance();
		
		List<LocationVo>list = service.getLocationList(location);
		
		request.setAttribute("locationList", list);
		
		HttpSession s = request.getSession();
		s.setAttribute("locationList", list);
				
		request.getRequestDispatcher("sonminsooo/jsp/locationList.jsp").forward(request, response);
		
		
	}

}

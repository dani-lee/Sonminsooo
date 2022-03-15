package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.util.FileUploadRequestWrapper;

public class MultiPartParser implements Filter{

	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; //3메가
	private static final long MAX_FILE_SIZE = 1024 * 1024 * 40;
	//요청 파일 최대 크기
	private static final long MAX_REQUEST_SIZE = 1024 * 1024 * 50;
	
	@Override
	public void destroy() {

		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fc)
			throws IOException, ServletException {

		try {
			//래퍼 클래스 객체 생성
			FileUploadRequestWrapper requestWrapper = new FileUploadRequestWrapper((HttpServletRequest)req
					, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE, "");
			
			fc.doFilter(requestWrapper, resp);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

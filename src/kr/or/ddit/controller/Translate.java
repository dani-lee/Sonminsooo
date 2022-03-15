package kr.or.ddit.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Translate
 */
@WebServlet("/Translate.do")
public class Translate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Translate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		String originText = request.getParameter("origin");
		System.out.println("이짝은 오는거여?");
		System.out.println("내용: "+ originText);
		PrintWriter out = response.getWriter();
		
		out.print(nmtReturnResult(originText));
		
	}

	
	public String nmtReturnResult(String origin) {
		
		String clientId = "dfxzHOPHRz51tb4UX6uG";
		String clientSecret = "hHYmPks5xw";
		
		String afterTranslation = "";
		
		try {
			String text = URLEncoder.encode(origin,"utf-8");
			
			String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			//post request
			String postParams = "source=en&target=ko&text=" + text;
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(postParams);
			wr.flush();
			wr.close();
			int resposeCode = con.getResponseCode();
			BufferedReader br;
			
			if(resposeCode == 200) { //정상
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			System.out.println(response.toString());
			
			afterTranslation = response.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return afterTranslation;
	}
}


<%@page import="kr.or.ddit.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
   List<PostVO> likelist = (List<PostVO>) request.getAttribute("likelist");
	int chk = (int)request.getAttribute("chk");
%>

 [
 	<%
 	if(likelist != null){
	for(int i = 0; i < likelist.size(); i++){
		
 		PostVO vo = likelist.get(i);
 		
 			
 		if(i > 0)out.print(",");
 		%>
			{
			"chk" : "<%=chk %>",
			"mem_id" : "<%=vo.getMem_id() %>",
			"mem_name" : "<%=vo.getMem_name()%>",
			"mem_photo" : "<%=vo.getMem_photo() %>",
			"mem_sn": "<%=vo.getMem_sn() %>"
 			
			}
	
 		<%
 		
 		}
		}
		
	%>
	
 ]
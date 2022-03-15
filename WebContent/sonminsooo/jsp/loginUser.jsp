<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	  MemberVO vo = (MemberVO) session.getAttribute("loginUser");

   if(vo != null){
	  %>  
  {
  "cnt" : 1,
  "mem_id"  : "<%=vo.getMem_id() %>",
  "mem_pw"  : "<%=vo.getMem_pw() %>",
  "mem_name"  : "<%=vo.getMem_name() %>",
  "mem_email"  : "<%=vo.getMem_email() %>",
  "mem_kind"  : "<%=vo.getMem_kind() %>",
  "mem_status"  : "<%=vo.getMem_status() %>",
  "mem_intro" : "<%=vo.getMem_intro() %>",
  "mem_gender" : "<%=vo.getMem_gender() %>",
  "mem_photo" : "<%=vo.getMem_photo()%>"
}
  
<%  
}else{	
%>
{
    "cnt" : 0
}
	
<% 
}
 %>	  
	  
	  


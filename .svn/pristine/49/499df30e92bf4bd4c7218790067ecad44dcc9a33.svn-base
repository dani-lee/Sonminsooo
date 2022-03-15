<%@page import="kr.or.ddit.vo.AtchFileVo"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	  AtchFileVo vo = (AtchFileVo) session.getAttribute("loginUser_photo");

   if(vo != null){
	  %>  
  {
    "cnt" : "1",
	"atchFileId" : "<%=vo.getAtchFileId() %>",
 	"fileSn" : "<%=vo.getFileSn() %>"
}
  
<%  
}else{	
%>
{
    "cnt" : "0"
}
	
<% 
}
 %>	  
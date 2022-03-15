
<%@page import="kr.or.ddit.vo.ReplyLikeVO"%>
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="kr.or.ddit.vo.FriendsVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//서블릿에서
List<ReplyLikeVO> list = (List<ReplyLikeVO>) request.getAttribute("list");
if( list != null && list.size()>0){
	

%>
{
  "size" :"<%= list.size() %>",
 "datas" :
 
[
<%
	for(int i=0;i<list.size();i++){
		ReplyLikeVO vo =list.get(i);
		if(i>0){
			out.print(",");
		}
		%>
		{
			 "mem_id"  : "<%=vo.getMem_id() %>",
  			 "mem_name"  : "<%=vo.getMem_name() %>",
 			 "child_id"  : "<%=vo.getChild_id() %>",
		     "rl_date"  : "<%=vo.getRl_date()%>",
 			 "mem_photo" : "<%=vo.getMem_photo()%>",
 			 "file_sn" : "<%=vo.getFile_sn()%>"
		}
<% 
	}
%>
]
}
<%
}else{
	%>
	{ "size" : "<%= 0 %>" }
	<%
}
%>
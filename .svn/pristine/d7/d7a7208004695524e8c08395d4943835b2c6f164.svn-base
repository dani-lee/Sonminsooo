
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="kr.or.ddit.vo.FriendsVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//서블릿에서
List<FriendsVO> list = (List<FriendsVO>)session.getAttribute("FriendList");
if( list != null && list.size()>0){
	

%>
{
  "size" :"<%= list.size() %>",
 "datas" :
 
[
<%
	for(int i=0;i<list.size();i++){
		FriendsVO vo =list.get(i);
		if(i>0){
			out.print(",");
		}
		%>
		{
			  "mem_id"  : "<%=vo.getMem_id() %>",
  "mem_pw"  : "<%=vo.getMem_pw() %>",
  "mem_name"  : "<%=vo.getMem_name() %>",
  "mem_email"  : "<%=vo.getMem_email() %>",
  "mem_kind"  : "<%=vo.getMem_kind() %>",
  "mem_status"  : "<%=vo.getMem_status() %>",
  "mem_intro" : "<%=vo.getMem_intro() %>",
  "mem_gender" : "<%=vo.getMem_gender() %>",
  "mem_photo" : "<%=vo.getMem_photo()%>",
  "follower"  : "<%=vo.getFollower()%>",
  "following"  : "<%=vo.getFollowing()%>",
  "fri_date"  : "<%=vo.getFri_date()%>",
  "file_sn" : "<%=vo.getFile_sn() %>",
  "fri_delete" : "<%=vo.getFri_delete() %>"
		}
<% 
	}
%>
]
}
<%
} 
%>
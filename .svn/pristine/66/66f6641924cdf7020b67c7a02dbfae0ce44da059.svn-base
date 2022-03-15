
<%@page import="kr.or.ddit.vo.OptionVO"%>
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="kr.or.ddit.vo.FriendsVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//서블릿에서
OptionVO vo = (OptionVO) request.getAttribute("vo");
%>
{
"mem_id"            : "<%=vo.getMem_id()%>",
"mem_like"          : "<%=vo.getMem_like()%>",
"comments"          : "<%=vo.getComments()%>",
"comments_like"     : "<%=vo.getComments_like()%>",
"follow_request"    : "<%=vo.getFollow_request()%>",
"direct_request"    : "<%=vo.getDirect_request()%>",
"notification"      : "<%=vo.getNotification()%>",
"story"             : "<%=vo.getStory()%>",
"video_views"       : "<%=vo.getVideo_views()%>",
"live_show"         : "<%=vo.getLive_show()%>",
"activities_status" : "<%=vo.getActivities_status()%>",
"story_share"       : "<%=vo.getStory_share()%>",
"mem_status" : "<%=vo.getMem_status() %>"
}
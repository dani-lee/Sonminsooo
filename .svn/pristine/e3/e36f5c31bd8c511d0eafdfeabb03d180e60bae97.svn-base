<%@page import="kr.or.ddit.vo.PostLikeVO"%>
<%@page import="kr.or.ddit.vo.AtchFileVo"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	PostLikeVO vo = (PostLikeVO) request.getAttribute("cntlike");
	int count = (Integer) request.getAttribute("count");

	if (count > 0) {
%>
	{ "flag" : "성공" ,
	  "cnt_post_like" : "<%=vo.getCnt_post_like() %>"
	}
<%
} else {
%>
	{ "flag" : "실패" }
<%
}
%>
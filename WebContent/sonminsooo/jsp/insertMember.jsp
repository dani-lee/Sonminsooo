<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 서블릿에서 저장 된 값 가져오기
	String memid = (String) request.getAttribute("memid");

	if (memid != null) {
%>
		{ "flag" : "성공" }
<%
	} else {
%>
		{ "flag" : "실패" }
<%
	}
%>
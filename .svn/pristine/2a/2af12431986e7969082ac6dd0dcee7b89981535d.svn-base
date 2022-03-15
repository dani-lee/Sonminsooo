<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 서블릿에서 저장 된 값 가져오기
	int cnt = (Integer) request.getAttribute("cnt");

	if (cnt > 0) {
%>
		{ "flag" : "중복" }
		
<%
	} else {
%>
		{ "flag" : "중복없음" }
<%
	}
%>
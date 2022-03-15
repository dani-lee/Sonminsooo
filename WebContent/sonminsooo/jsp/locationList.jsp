<%@page import="kr.or.ddit.vo.LocationVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	List<LocationVo>list = (List<LocationVo>)request.getAttribute("locationList");

	if(list != null && list.size() > 0){
%>
{
	"flag" : "ok",
	"datas" : [
<% 

	for(int i = 0; i < list.size(); i++){
		LocationVo lv = list.get(i);
		if(i > 0)out.print(",");
		
%>
	{ 
	  "location_no" : "<%= lv.getLocation_no() %>",
	  "location" : "<%= lv.getLocation() %>"
	 }
	 
<% 

	}

%>	
	
	]
	
	}
<%
	}else{
%>
	{
		"flag" : "no"
	}
<%
	}
%> 
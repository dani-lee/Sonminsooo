<%@page import="kr.or.ddit.vo.HashTagVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	List<HashTagVo>list = (List<HashTagVo>)request.getAttribute("hashList");

	if(list != null && list.size() > 0){
%>
{
	"flag" : "ok",
	"datas": [
<%
	for(int i = 0; i < list.size(); i++){
		HashTagVo hv = list.get(i);
		if(i > 0)out.print(",");

%>		
	{ "hash_no" : "<%= hv.getHash_no() %>",
	  "post_no" : "<%= hv.getPost_no() %>",
	  "hash"    : "<%= hv.getHash() %>"
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
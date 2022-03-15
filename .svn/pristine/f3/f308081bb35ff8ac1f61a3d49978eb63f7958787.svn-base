<%@page import="kr.or.ddit.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    List<PostVO> postList = (List<PostVO>) request.getAttribute("postList");
    

    System.out.println("NewpostList : " + postList);
    if(postList.size() > 0){
    	
%>
[
<%    	
    	for(int i = 0 ; i< postList.size(); i++){
    		PostVO vo = postList.get(i);
    		if(i>0){
    			out.print(",");
    		}
%>
{
          "success" : "true",
          "post_no"		:  "<%=vo.getPost_no() %>",
	      "post_kind"	:  "<%=vo.getPost_kind() %>",
	      "post_status"	:  "<%=vo.getPost_status() %>",	
	      "mem_id"		:  "<%=vo.getMem_id() %>",
	      "post_date"	:  "<%=vo.getPost_date() %>",		
	      "post_content":  "<%=vo.getPost_content() %>",	
	      "location_no"	:  "<%=vo.getLocation_no() %>",	
	      "atch_file_id":  "<%=vo.getAtch_file_id() %>"
}
<%    	
    	}

%>
]
<%
    }else{

    	%>
    	
    	{
    	     "success" : "false"
    	}
    	
    	
    	<%
    }
%>


































































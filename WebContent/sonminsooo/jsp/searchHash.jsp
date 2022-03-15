<%@page import="kr.or.ddit.vo.HashTagVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    List<HashTagVo> list = (List<HashTagVo>) request.getAttribute("tagList");
%>


<%
    if(list.size() > 0){
%>
{
    "success" : "true",
    "datas"   :
[    	
<%
       for(int i = 0; i<list.size(); i++){
    	   HashTagVo vo = list.get(i);
    	   if(i > 0) out.print(",");  
%>	
   {
          
          "hash" : "<%=vo.getHash() %>",
          "count" : "<%=vo.getCount() %>"
   
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
  
        "success" : "false"
  
  }


<%
    }
%>
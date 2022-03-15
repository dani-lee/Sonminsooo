<%@page import="kr.or.ddit.vo.SimplePhotoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   List<SimplePhotoVO> friendList = (List<SimplePhotoVO>) request.getAttribute("friendList");
%>
<%
    if(friendList.size() > 0){
%>
{
    "success" : "true",
    "datas"   :
[    	
<%
       for(int i = 0; i<friendList.size(); i++){
    	   SimplePhotoVO vo = friendList.get(i);
    	   if(i > 0) out.print(",");  
%>	
   {
          
            "mem_id"  : "<%=vo.getMem_id() %>",
            "afd" : "<%=vo.getAtch_file_id()%>",
            "file_sn" : "<%=vo.getFile_sn() %>"
   
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























































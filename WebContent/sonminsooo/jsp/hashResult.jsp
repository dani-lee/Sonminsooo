<%@page import="kr.or.ddit.vo.SimplePhotoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    List<List<SimplePhotoVO>> photoList = (List<List<SimplePhotoVO>>) session.getAttribute("hashPhoto");
    String hash = (String) session.getAttribute("hash");
    int count = (Integer) session.getAttribute("count");

    if(photoList.size() > 0){   	
%>
{
    "success" : "true",
    "hash"    : "<%= hash %>",
    "count"   : "<%= count %>",
    "datas"   :
[    	
<%
         int cnt = 0;
       for(int i = 0; i<photoList.size(); i++){
    	   List<SimplePhotoVO> voList = photoList.get(i);
     	    if(i > 0 && cnt > 0) out.print(",");
    	   for(int j = 0; j < voList.size(); j++){
    		   SimplePhotoVO vo = voList.get(j);
//     		   if(j > 0) out.print(","); 
    	   
    	    
%>	
   {
          
            "post_no" : "<%=vo.getPost_no() %>",
	        "atch_file_id" : "<%=vo.getAtch_file_id() %>",
	        "file_sn" : "<%=vo.getFile_sn() %>"
   
   }
 
<%
          cnt++;
       }
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







 

























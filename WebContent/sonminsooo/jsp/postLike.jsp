<%@page import="kr.or.ddit.vo.SimplePhotoVO"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.or.ddit.vo.PostLikeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
   List<PostLikeVO> list = (List<PostLikeVO>) request.getAttribute("postLike");
   List<SimplePhotoVO> psn_list = (List<SimplePhotoVO>) request.getAttribute("p_sn");

   SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		
   Date time = new Date();
		
   String time1 = format1.format(time);
   
   // time1 = time1.replaceAll("-", "");
   // time1 = time1.replaceAll(":", "");
   
   String[] nowTime = time1.split(" ");

   if(list != null){
%>
	   [
<% 	   	   
	   for(int i = 0; i < list.size(); i++){
		   PostLikeVO vo = list.get(i);
		   SimplePhotoVO sn = psn_list.get(i);
		   if(i > 0)
			   out.print(",");
		   
           String date = vo.getPl_date();
           
           // date = date.replaceAll("-", ""); 
           // date = date.replaceAll(":", "");
           
           String[] likeTime = date.split(" ");
           
           int day = 0;
           String str ="";
           
           
           
           if(likeTime[0].equals(nowTime[0])){
        	    String[] likeMin = likeTime[1].split(":");
        	    String[] nowMin = nowTime[1].split(":");
        	    day = Integer.parseInt(nowMin[0]) - Integer.parseInt(likeMin[0]);        	          	   
        	    str = "time";
           }else{
        	   String[] nowArr = nowTime[0].split("-");
       	       String[] likeArr = likeTime[0].split("-");
        	   
        	    if(nowArr[1].equals(likeArr[1])){
        	    	day = Integer.parseInt(nowArr[2])-Integer.parseInt(likeArr[2]);
        	    	str = "day";
        	    }else{
        	    	day = vo.getWeek();
        	    	str = "week";
        	    }
        	    
           }
           
		   
%>


{          
           "timeSet" : "<%=str %>",
           "post_no" : "<%=vo.getPost_no() %>",
	       "mem_id"  : "<%=vo.getMem_id()%>",
	       "pl_date" : "<%=day%>",
	       "photo"   : "<%=vo.getMem_photo() %>",
	       "file_sn" : "<%=vo.getFile_sn() %>",
	       "post_aid" : "<%=sn.getAtch_file_id() %>",
	       "post_asn" : "<%=sn.getFile_sn() %>"

}


<%    
	   }
%>
    ]
<%
   }
%>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
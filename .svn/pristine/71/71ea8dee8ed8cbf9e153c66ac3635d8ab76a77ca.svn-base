<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.or.ddit.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    List<PostVO> postList = (List<PostVO>) request.getAttribute("list");
SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
Date time = new Date();
DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
DateFormat y = new SimpleDateFormat("yyyy");
DateFormat m = new SimpleDateFormat("MM");
DateFormat d = new SimpleDateFormat("dd");
DateFormat h = new SimpleDateFormat("HH");
DateFormat mm = new SimpleDateFormat("mm");
DateFormat s = new SimpleDateFormat("ss");

%>
{ "size" : <%=postList.size() %>,
"datas" :
[
<%    	
    	for(int i = 0 ; i< postList.size(); i++){
    		PostVO vo = postList.get(i);
    		if(i>0){
    			out.print(",");
    		}
%>
{
       "post_no" : "<%=vo.getPost_no()%>"	, 
       "post_kind" : "<%=vo.getPost_kind()%>"	, 
       "post_status" : "<%=vo.getPost_status()%>"	, 
       "mem_id" : "<%=vo.getMem_id()%>", 
       <% 
       		if(Integer.parseInt(y.format(vo.getPost_date()))<Integer.parseInt(y.format(time))){ // 1년이상 지남
       		    %>
       	       "post_date" : "<%=Integer.parseInt(y.format(vo.getPost_date()))-Integer.parseInt(y.format(time))+"년 전"%>"	, 	
       			
       			<% 
       		}else{
       			if(Integer.parseInt(m.format(vo.getPost_date()))<Integer.parseInt(m.format(time))){ // 올해안에 일어났으나 하루는 지남
       				
       				    %>
       "post_date" : "<%=Integer.parseInt(m.format(vo.getPost_date()))-Integer.parseInt(m.format(time))+"달 전"%>"	, 
       				<% 
       			}else{ // 오늘 안에 일어남
       				String f_date="";
       			if(Integer.parseInt(d.format(vo.getPost_date()))<Integer.parseInt(d.format(time))){
       				f_date=Integer.parseInt(d.format(time))-Integer.parseInt(d.format(vo.getPost_date()))+"일 전";
       			}
       			else{
           			if(Integer.parseInt(h.format(vo.getPost_date()))==Integer.parseInt(h.format(time))){
           				if(Integer.parseInt(h.format(vo.getPost_date()))==Integer.parseInt(h.format(time))){
           					f_date=Integer.parseInt(mm.format(time))-Integer.parseInt(mm.format(vo.getPost_date()))+"분 전";
           				}else{
           					f_date=Integer.parseInt(s.format(time))-Integer.parseInt(s.format(vo.getPost_date()))+"초 전";
           				}
           			}else{
           				f_date=Integer.parseInt(h.format(time))-Integer.parseInt(h.format(vo.getPost_date()))+"시간 전";
           			}
       			}
           			    %>
       "post_date" : "<%=f_date%>"	, 
           			<% 
           		}
       		}
       			
       %>
       			
       	
   
       
       "post_content" : "<%=vo.getPost_content()%>"	, 
       "location_no" : "<%=vo.getLocation_no()%>"	, 
       "atch_file_id" : "<%=vo.getAtch_file_id()%>"	, 
       "file_sn" : "<%=vo.getFile_sn()%>"	
}
<%    	
    	}

%>
]
}
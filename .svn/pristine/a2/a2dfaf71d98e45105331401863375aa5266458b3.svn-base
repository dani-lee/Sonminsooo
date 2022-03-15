<%@page import="kr.or.ddit.vo.ReplyVO"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    List<ReplyVO> list = (List<ReplyVO>) request.getAttribute("list");
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
{ "size" : <%=list.size() %>,
"datas" :
[
<%    	
    	for(int i = 0 ; i< list.size(); i++){
    		ReplyVO vo = list.get(i);
    		if(i>0){
    			out.print(",");
    		}
%>
{
       "post_no" : "<%=vo.getPost_no()%>"	, 
       "mem_photo" : "<%=vo.getMem_photo()%>"	, 
       "child_id" : "<%=vo.getChild_id()%>"	, 
       "mem_id" : "<%=vo.getMem_id()%>", 
       <% 
       		if(Integer.parseInt(y.format(vo.getReply_date()))<Integer.parseInt(y.format(time))){ // 1년이상 지남
       		    %>
       	       "reply_date" : "<%=Integer.parseInt(y.format(vo.getReply_date()))-Integer.parseInt(y.format(time))+"년 전"%>"	, 	
       			
       			<% 
       		}else{
       			if(Integer.parseInt(m.format(vo.getReply_date()))<Integer.parseInt(m.format(time))){ // 올해안에 일어났으나 하루는 지남
       				
       				    %>
       "reply_date" : "<%=Integer.parseInt(m.format(vo.getReply_date()))-Integer.parseInt(m.format(time))+"달 전"%>"	, 
       				<% 
       			}else{ // 오늘 안에 일어남
       				String f_date="";
       			if(Integer.parseInt(d.format(vo.getReply_date()))<Integer.parseInt(d.format(time))){
       				f_date=Integer.parseInt(d.format(time))-Integer.parseInt(d.format(vo.getReply_date()))+"일 전";
       			}
       			else{
           			if(Integer.parseInt(h.format(vo.getReply_date()))==Integer.parseInt(h.format(time))){
           				if(Integer.parseInt(h.format(vo.getReply_date()))==Integer.parseInt(h.format(time))){
           					f_date=Integer.parseInt(mm.format(time))-Integer.parseInt(mm.format(vo.getReply_date()))+"분 전";
           				}else{
           					f_date=Integer.parseInt(s.format(time))-Integer.parseInt(s.format(vo.getReply_date()))+"초 전";
           				}
           			}else{
           				f_date=Integer.parseInt(h.format(time))-Integer.parseInt(h.format(vo.getReply_date()))+"시간 전";
           			}
       			}
           			    %>
       "reply_date" : "<%=f_date%>"	, 
           			<% 
           		}
       		}
       			
       %>
       			
       	
   
       
       "parent_id" : "<%=vo.getParent_id()%>"	, 
       "reply_content" : "<%=vo.getReply_content()%>"	, 
       "file_sn" : "<%=vo.getFile_sn()%>"	
}
<%    	
    	}

%>
]
}
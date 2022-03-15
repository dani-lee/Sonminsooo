<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.or.ddit.vo.LocationVo"%>
<%@page import="kr.or.ddit.vo.ReplyVO"%>
<%@page import="kr.or.ddit.vo.PostLikeVO"%>
<%@page import="kr.or.ddit.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<PostVO> postlist = (List<PostVO>) request.getAttribute("postlist");
	List<PostLikeVO> like_cnt = (List<PostLikeVO>) request.getAttribute("like_cnt");
	List<ReplyVO> postReply = (List<ReplyVO>) request.getAttribute("postReply");
	List<LocationVo> postLoca = (List<LocationVo>) request.getAttribute("postLoca");
	List<PostVO> forcontent = (List<PostVO>) request.getAttribute("forcontent");
	
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

 [
 	<%
 	if(postlist != null){
	for(int i = 0; i < postlist.size(); i++){
		
 		PostVO vo = postlist.get(i);
 		PostLikeVO likevo = like_cnt.get(i);
 		ReplyVO replyvo = postReply.get(i);
 		LocationVo locavo = postLoca.get(i);
 		PostVO pv = forcontent.get(i);
 			
 		if(i > 0)out.print(",");
 		
 		if(locavo.getLocation() == null){
 			
 		%>
			{
			"mem_id" : "<%=vo.getMem_id() %>",
 			"post_no" : "<%= vo.getPost_no()%>",
 			"post_status" : "<%= vo.getPost_status() %>",
 			"post_content" : "<%= vo.getPost_content() %>",
 			"final_content": "<%=pv.getPost_content() %>",
 			"atchfileid" : "<%=vo.getAtch_file_id() %>",
 			"filesn" : "<%=vo.getFile_sn() %>",
 			"mem_photo" : "<%=vo.getMem_photo() %>",
 			"mem_sn": "<%=vo.getMem_sn()%>",
 			"mem_status": "<%=vo.getMem_status() %>",
 			"cnt_post_like" : "<%=likevo.getCnt_post_like() %>",
 			"reply_id" : "<%= replyvo.getMem_id() %>",
 			"reply_content" : "<%=replyvo.getReply_content() %>",
 			"location" : " ",
 			  <% 
       		if(Integer.parseInt(y.format(vo.getPost_date()))<Integer.parseInt(y.format(time))){ // 1년이상 지남
       		    %>
       	       "post_date" : "<%=Integer.parseInt(y.format(vo.getPost_date()))-Integer.parseInt(y.format(time))+"년 전"%>"	
       			
       			<% 
       		}else{
       			if(Integer.parseInt(m.format(vo.getPost_date()))<Integer.parseInt(m.format(time))){ // 올해안에 일어났으나 하루는 지남
       				
       				    %>
       			"post_date" : "<%=Integer.parseInt(m.format(vo.getPost_date()))-Integer.parseInt(m.format(time))+"달 전"%>"
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
       			"post_date" : "<%=f_date%>"	
           			<% 
           		}
       		}
       			
       %>
		}
		<%
 		}else if(locavo.getLocation() != null){
		%>			
 		{
			"mem_id" : "<%=vo.getMem_id() %>",
 			"post_no" : "<%= vo.getPost_no()%>",
 			"post_status" : "<%= vo.getPost_status() %>",
 			"post_content" : "<%= vo.getPost_content() %>",
 			"final_content": "<%=pv.getPost_content() %>",
 			"atchfileid" : "<%=vo.getAtch_file_id() %>",
 			"filesn" : "<%=vo.getFile_sn() %>",
 			"mem_photo" : "<%=vo.getMem_photo() %>",
 			"mem_sn": "<%=vo.getMem_sn()%>",
 			"mem_status": "<%=vo.getMem_status() %>",
 			"cnt_post_like" : "<%=likevo.getCnt_post_like() %>",
 			"reply_id" : "<%= replyvo.getMem_id() %>",
 			"reply_content" : "<%=replyvo.getReply_content() %>",
 			"location" : "<%=locavo.getLocation()%>",
 			  <% 
       		if(Integer.parseInt(y.format(vo.getPost_date()))<Integer.parseInt(y.format(time))){ // 1년이상 지남
       		    %>
       	       "post_date" : "<%=Integer.parseInt(y.format(vo.getPost_date()))-Integer.parseInt(y.format(time))+"년 전"%>"	 	
       			
       			<% 
       		}else{
       			if(Integer.parseInt(m.format(vo.getPost_date()))<Integer.parseInt(m.format(time))){ // 올해안에 일어났으나 하루는 지남
       				
       				    %>
      			 "post_date" : "<%=Integer.parseInt(m.format(vo.getPost_date()))-Integer.parseInt(m.format(time))+"달 전"%>"	 
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
       "post_date" : "<%=f_date%>"	
           			<% 
           		}
       		}
       			
       %>
		}
 			
 		<% 
 		}else{
 		%>
 		{
			"mem_id" : "<%=vo.getMem_id() %>",
 			"post_no" : "<%= vo.getPost_no()%>",
 			"post_status" : "<%= vo.getPost_status() %>",
 			"post_content" : "<%= vo.getPost_content() %>",
 			"final_content": <%=pv.getPost_content() %>,
 			"atchfileid" : "<%=vo.getAtch_file_id() %>",
 			"filesn" : "<%=vo.getFile_sn() %>",
 			"mem_photo" : "<%=vo.getMem_photo() %>",
 			"mem_sn": "<%=vo.getMem_sn()%>",
 			"cnt_post_like" : "<%=likevo.getCnt_post_like() %>",
 			"reply_id" : "<%= replyvo.getMem_id() %>",
 			"reply_content" : "<%=replyvo.getReply_content() %>",
 			"location" : "<%=locavo.getLocation()%>",
 			  <% 
       		if(Integer.parseInt(y.format(vo.getPost_date()))<Integer.parseInt(y.format(time))){ // 1년이상 지남
       		    %>
       	       "post_date" : "<%=Integer.parseInt(y.format(vo.getPost_date()))-Integer.parseInt(y.format(time))+"년 전"%>" 	
       			
       			<% 
       		}else{
       			if(Integer.parseInt(m.format(vo.getPost_date()))<Integer.parseInt(m.format(time))){ // 올해안에 일어났으나 하루는 지남
       				
       				    %>
       			"post_date" : "<%=Integer.parseInt(m.format(vo.getPost_date()))-Integer.parseInt(m.format(time))+"달 전"%>"
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
      			 "post_date" : "<%=f_date%>"	
           			<% 
           		}
       		}
       			
       %>
		}
 		<%
 			
 		}
 		}
		}
		
	%>
	
 ]
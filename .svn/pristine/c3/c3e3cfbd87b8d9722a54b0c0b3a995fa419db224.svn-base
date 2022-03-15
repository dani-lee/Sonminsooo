<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    List<MemberVO> list = (List<MemberVO>) request.getAttribute("userList");
    List<Integer> fsnList = (List<Integer>) request.getAttribute("imgList");
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
    	   MemberVO vo = list.get(i);
    	   int fsn = fsnList.get(i);
    	   if(i > 0) out.print(",");  
%>	
   {
          
            "mem_id"  : "<%=vo.getMem_id() %>",
            "mem_pw"  : "<%=vo.getMem_pw() %>",
            "mem_name"  : "<%=vo.getMem_name() %>",
            "mem_email"  : "<%=vo.getMem_email() %>",
            "mem_kind"  : "<%=vo.getMem_kind() %>",
            "mem_status"  : "<%=vo.getMem_status() %>",
            "mem_intro" : "<%=vo.getMem_intro() %>",
            "mem_gender" : "<%=vo.getMem_gender() %>",
            "mem_photo" : "<%=vo.getMem_photo()%>",
            "file_sn" : "<%=fsn %>"
   
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
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
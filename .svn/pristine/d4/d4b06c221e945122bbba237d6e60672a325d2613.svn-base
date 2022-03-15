/**
 * 해시 검색해서 누르면 이동하는 페이지의 js
 */

hashChoice = function(){
	
	$.ajax({
		url : '/Sonminsooo/HashResult.do',
		type : 'post',
		success : function(res){
			console.log("res.success => " + res.success);
			
			if(res.success=="true"){
				code = "";
				img_count= 0;
				pCode ="";
				pCode += "<img  title='"+res.hash+"' class='hashMainPhoto' id='"+res.datas[0].post_no+"'";
				pCode += "src='/Sonminsooo/filedownload.do?fileId="+res.datas[0].atch_file_id+"&fileSn="+res.datas[0].file_sn+"'>";
				pCode += "<div class='hashMainContent'>"
				pCode += "<span>"+res.hash+"</span>";
				pCode += "<span>게시물 "+res.count+"</span>";
				pCode += "</div>"
				$.each( res.datas, function(i, v) {
					console.log("v.post_no => " + v.post_no);
					
					if(img_count%3==0){
					    code += "<img  title='"+res.hash+"' class='post_photo1' id='"+v.post_no+"'";
						code +="src='/Sonminsooo/filedownload.do?fileId="+v.atch_file_id+"&fileSn="+v.file_sn+"'>";
					}else if(img_count%3==1){
						code += "<img title='"+res.hash+"' class='post_photo2' id='"+v.post_no+"'";
						code +="src='/Sonminsooo/filedownload.do?fileId="+v.atch_file_id+"&fileSn="+v.file_sn+"'>";
					}else if(img_count%3==2){
						code += "<img title='"+res.hash+"' class='post_photo3' id='"+v.post_no+"'";
						code +="src='/Sonminsooo/filedownload.do?fileId="+v.atch_file_id+"&fileSn="+v.file_sn+"'>";
						code +="<br><br>";
					}
					img_count=img_count+1;
					
				})
				
				console.log(code);
				$('.searchMainHash').html(pCode);
				$('.hotHashPost').html(code);
				$('.recentHashPost').html(code);
			}
			
		},
		error : function(xhr){
			console.log("searchHashChoice.js/상태 : " + xhr.status);
		},
		dataType : 'json'
	})
	
	
	
	
	
}

















































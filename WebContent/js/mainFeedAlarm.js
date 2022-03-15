/**
 * 
 */

alarmScript = function(){
	/* 박소현이 추가한거 */
	$(document).ready(function(){
	    var target = $('.plzplz');
	    
	    // 버튼을 클릭하면 사이드바 열림
	    $(document).on("click", '.dropbtn', function (e){
	    	// console.log("$('.dropbtn').attr('aria-expanded') : " + $('.dropbtn').attr('aria-expanded'));
	    	
	    	if($('.dropbtn').attr('aria-expanded') == "true"){
	    		console.log("제발 js <1>");
	    		$.ajax({
	    			url : '/Sonminsooo/PostLike.do',
	    			type : 'post',
	    			success : function(res){
	    				console.log("제발 js <2>");
	    				if(res != null){
	    					$('li').remove('#alarmLi');
	    					
	    					codeB = "";
	    					codeJ=""
	    					$.each(res, function(i, v){

	    						
	    						if(v.timeSet== "week"){
	    							codeJ += "<li id='alarmLi'>";
	         						codeJ += "<div class='alarmAll'>";
	         						codeJ += "<div class='alarmImg'>";
	         						codeJ += "<img src='/Sonminsooo/filedownload.do?fileId="+v.photo+"&fileSn="+v.file_sn+"'>";
	         						codeJ += "</div>"; 
	    						}else{
	    							codeB += "<li id='alarmLi'>";
	        						codeB += "<div class='alarmAll'>";
	        						codeB += "<div class='alarmImg'>";
	        						codeB += "<img src='/Sonminsooo/filedownload.do?fileId="+v.photo+"&fileSn="+v.file_sn+"'>";
	        						codeB += "</div>";
	    						}
	    						
	    						
	    						if(v.timeSet== "time"){
	    							codeB += "<div class='alarmContent'>";
	    							codeB += "<span class='alarmId'>"+v.mem_id+"</span>님이 회원님의 사진을 좋아합니다. <span class='alarmTime'>"+v.pl_date +"시간 전</span>";
	    							codeB += "</div>";
	    							codeB += "<img src='/Sonminsooo/filedownload.do?fileId="+v.post_aid+"&fileSn="+v.post_asn+"'>";
	    						}else if(v.timeSet== "day"){
	    							codeB += "<div class='alarmContent'>";
	    							codeB += "<span class='alarmId'>"+v.mem_id+"</span>님이 회원님의 사진을 좋아합니다. <span class='alarmTime'>"+v.pl_date +"일 전</span>";
	    							codeB += "</div>";
	    							codeB += "<img src='/Sonminsooo/filedownload.do?fileId="+v.post_aid+"&fileSn="+v.post_asn+"'>";
	    						}else{
	    							if(v.pl_date >= 4){
	    							  codeJ += "<div class='alarmContent'>";
	    							  codeJ += "<span class='alarmId'>"+v.mem_id+"</span>님이 회원님의 사진을 좋아합니다. <span class='alarmTime'>"+v.pl_date +"주</span>";
	    							  codeJ += "</div>";
	    							  codeJ += "<img src='/Sonminsooo/filedownload.do?fileId="+v.post_aid+"&fileSn="+v.post_asn+"'>";
	    							}else{
	    							  codeB += "<div class='alarmContent'>";
	    							  codeB += "<span class='alarmId'>"+v.mem_id+"</span>님이 회원님의 사진을 좋아합니다. <span class='alarmTime'>"+v.pl_date +"주</span>";
	    							  codeB += "</div>";
	    							  codeB += "<img src='/Sonminsooo/filedownload.do?fileId="+v.post_aid+"&fileSn="+v.post_asn+"'>";
	    							}
	    						}
	    						
	    						if(v.timeSet== "week"){
	    							codeJ += "</div>";
	        						codeJ += "</li>";
	    						}else{
	    							codeB += "</div>";
	        						codeB += "</li>";
	    						}
	    						
	        				}) 
	        				
	        				$('.EBD').after(codeB);
	        				$('.EJHD').after(codeJ);
	    					
	    				}else{
	    					console.log("NOT_FOUND_200");
	    				}
	    				
	    			},
	    			error : function(xhr){
	    				console.log("상태 : " + xhr.status);
	    			},
	    			dataType : 'json'
	    		})
	    		
	    		$('#alarm-heart').attr('src', "/Sonminsooo/images/icon/like.png");
	    		$('.dropdown-content').css('display', 'block');
	    	}else{
	    		$('#alarm-heart').attr('src', "/Sonminsooo/images/icon/heart.svg");
	    		$('.dropdown-content').css('display', 'none');
	    	}

	    });
	    // 사이드바 외부를 클릭하면 사이드바 닫힘
	    $(document).mouseup(function (e){
	        if(target.has(e.target).length==0) {
	        	$('#alarm-heart').attr('src', "/Sonminsooo/images/icon/heart.svg");
	    		$('.dropdown-content').css('display', 'none');
	        } 
	    });
	});    
}
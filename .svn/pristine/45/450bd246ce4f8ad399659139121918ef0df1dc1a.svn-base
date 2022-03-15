/**
 * 
 */


selectHashTagList = function(){
	$.ajax({
		url : '/Sonminsooo/SelectHashTagList.do',
		 data : {'hash' : rrhash},
		 type : 'get',
		 dataType : 'json',
		 success : function(res){
			 if(res.flag == "ok"){
				 $.each(res.datas, function(i,v){
					 code += "<p class = 'ptag'>" + v.hash + "</p>";
				 })
			 }else{
				
				 /* code += "<p>데이터없음 </p>";*/
			 }
			$('#here_in').html(code);
		 },
		 error : function(xhr){
			 alert('상태:' +xhr.status);
		 }
	})
}

selectLocationList = function(){
	$.ajax({
		url : '/Sonminsooo/SelectLocationList.do',
		data : { "location" : content },
		type : 'get',
		dataType : 'json',
		success : function(res){
			code ="";
			if(res.flag == "ok"){
				 $.each(res.datas, function(i,v){
					 code += "<p name='loca' class = 'ptag' id = " + v.location_no + ">" + v.location + "</p>";
				 })
			}else{
				 /*code += "<p>데이터없음 </p>";*/
			 }
			$('#there_in').html(code);
		},
		error : function(xhr){
			alert('상태: '+xhr.status);
		}
	})
	
}

deleteBoard = function(){
	$(function(){
		$(document).on('click', '.moreoption-wrapper', function(){
			post_no = $(this).parent().find('.post-no').text();
			
			$('#delete-it').on('click', function(){
				
				$.ajax({
					url : '/Sonminsooo/DeleteBoard.do',
					data : {"postNo" : post_no},
					type : 'get',
					dataType : 'json', 
					success : function(res){
						if(res.flag == "성공"){
							$('.error').fadeIn(400).delay(1000).fadeOut(400);
							$('#recheck_delete').hide();
							location.reload(true);
						}
					},
					error : function(xhr){
						alert('상태: '+xhr.status);
					}
					
				})
				
		})
		
		
		})
	})
}

translateContent = function(){
	$(function(){
		$(document).on('click','.translate', function(){
			origin = $(this).parents('.reactionarea').find('.content');
			$.ajax({
				 url : '/Sonminsooo/Translate.do',
				 data : { "origin" : origin.text() },
				 dataType : 'json',
				 type : 'post',
				 success : function(res){
					 afterTL = res.message.result.translatedText;
					 console.log(afterTL);
					 origin.html(afterTL);
				 },
				 error : function(xhr){
					 alert("상태: " +xhr.status)
				 }
			})
		})
	})
}

clickReport = function(){
	$(function(){
		$('.report').on('click', function(){
			$('.reportAlert').fadeIn(400).delay(1000).fadeOut(400);
			$('#moreoptionModal').hide();
		})
	})
}

bookMark = function(){
	$(function(){
		$(document).on('click', '.fa-bookmark', function(){
			no = $(this).parents('.post').find('.post-no').text();
			id = mem_id;
			
			$.ajax({
				url :'/Sonminsooo/Bookmark.do',
				data : { "post_no" : no, 
						 "mem_id" : id },
				dataType : 'json',
				type : 'get',
				success : function(res){
					if(res.flag == "성공"){
						
						$('.fa-bookmark').attr('class','fas fa-bookmark');
					}
				},
				error : function(xhr){
					alert('상태: ' + xhr.status)
				}
			})
		})
		
	})
	
}


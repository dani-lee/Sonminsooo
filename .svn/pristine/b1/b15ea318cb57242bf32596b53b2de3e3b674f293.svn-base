/**
 * 
 */

// var script = document.createElement('script');
// script.src = '../../js/jquery-3.6.0.min.js';
// script.type = 'text/javascript';
// document.getElementsByTagName('head')[0].appendChild(script);



//이모티콘버튼 눌렀을때 이모티콘 창 열리기  
/*const emoji_btn = document.querySelector('.emoji_btn');
const msginput = document.querySelector('.add_comment');

const picker = new EmojiButton();
	
	document.addEventListener('click',() => {
		picker.togglePicker(emoji_btn);
	});
	document.picker.on('emoji', emoji => {
		add_comment.value += emoji;
	});*/

	

//const emoji_btn = document.querySelector('.emoji_btn');
const add_comment = document.querySelector('.add_comment');
const picker = new EmojiButton();

emojifunction = function(){
	
	$(document).on('click', function(){
		picker.togglePicker($('.emoji_btn'));
	});
	picker.on('emoji', emoji => {
//		add_comment = $(this).parents('.post').find('.add_comment').text();
//		console.log(add_comment);
//		add_comment.text(emoji);
		add_comment.value += emoji;
	});
}

	
//헤더 프로필 클릭시 프로필 편집 사이트로 이동
function move_profile(){
	window.location.href = "profile/profile.html";
}
$('.hearder-profile-img-wrapper').on('click', move_profile);

const post = document.querySelector('.post')


$(function(){
	
	friend =[];
//	likechk();
	
	//로그인 유저 프로필 가져오기
	$.ajax({
		url : '/Sonminsooo/LoginUser.do',
		type : 'post',
		dataType : 'json',
		success : function(res) {
			//id 가져오기
			$('.side_id_a').html(res.mem_id);
			mem_id = res.mem_id
			//이름 가져오기
			$('.name_wrapp_span').html(res.mem_name);
			
			if(res.mem_photo > 0){
				$.ajax({
	               url : '/Sonminsooo/ProfilePhoto.do',
	               type : 'post',
	               data : {"mem_photo" : res.mem_photo},
	               success : function(res1){
	                	//헤더부분 프로필 사진 가져오기
	            	   
	                	imgcode = "/Sonminsooo/filedownload.do?fileId="+res1.atchFileId+"&fileSn="+res1.fileSn;
	  					$('.hd-profile-img-img').attr("src", imgcode);
	  					//사이드부분 프로필 사진 가져오기
	  					$('.side-userprofile-img').attr("src", imgcode);
	               },
	               error : function(xhr){
	                  console.log("상태 : " + xhr.status);
	               },
	               dataType : 'json'
	               
	            }) 
			}else{
				imgcode= "../../images/default_profile.jpg"
	            $('.hd-profile-img-img').attr("src", imgcode);
	            $('.side-userprofile-img').attr("src", imgcode);
			}
		},
		error : function(xhr) {
			alert('상태 : ' + xhr.status);
		}	

	})
	
	//포스트 불러오기
	//게시글
	$.ajax({
		url : '/Sonminsooo/Feed.do',
		type : 'get',
		dataType : 'json',
		success : function(res) {
			
				$.each(res, function(i,v){
//					likechk();
//					if(v.mem_photo > 0){
//						imgcode = "../../images/default_profile.jpg";
//						$('.post-profile-img').attr("src", imgcode);
//					
//					}
//					
					
					
				post_code = '<div class="blank"></div>'
							+'<div class="post">'
							+'<div class="profile-area">'
							+	'<div class="profile">'
						 	+		'<div class="post-profile-wrapper">'
						 	+			'<img class="post-profile-img" src="/Sonminsooo/filedownload.do?fileId='+v.mem_photo+'&fileSn='+v.mem_sn +'">'
						 	+		'</div>'
						 	+	 '<div class="userid-wrapper">'
						 	+		'<span><span class="friend_link">'+ v.mem_id+'</span></span>'
						 	+ 		'<span style="display:none" class="post-no">'+v.post_no+'</span>'
							+  	 '<div class="location_name_wrapper">'
							+		'<span id="location">'+v.location+'</span>' 
							+     '</div>' 
						 	+	  '</div>'
						 	+	'</div>';
						 	
						 	if(v.mem_id != mem_id){
						 		post_code +='<button class="moreoption-wrapper" data-toggle = "modal" data-target = "#moreoptionModal">'
						 		
						 	}else{
						 		post_code +='<button class="moreoption-wrapper" data-toggle = "modal" data-target = "#moreoptionModalMine">'
						 	}
						 		post_code +=	'<i id="moreoption" class="fas fa-ellipsis-h"></i>'
						 	+'</button>'
						 	+'</div>'
						 	
						 	+'<div class="image-area">'
						 	+	'<div class="image-wrapper">'
						 	+	'	<img class="images" src="/Sonminsooo/filedownload.do?fileId='+v.atchfileid+'&fileSn='+v.filesn +'">'
							
							+	'</div>'
							+'</div>'

							+'<div class="reactionarea">'
							+'<section class="reaction">'
							+'	<ul>'
							+'		<li class="heart" name="like"><i id="heart" class="far fa-heart"></i></li>'
							+'		<li class="comment" name="comment"><i class="far fa-comment"></i></li>'
							+'		<li class="sharePost" name="sharePost"><i class="far fa-paper-plane"></i></li>'
							+'		<li class="bookmark" name="bookmark"><i class="far fa-bookmark"></i></i></li>'
							+'	</ul>'
							+'</section>'
									
							+'<section class="likes-area">'
							+'	<div class="likes"  data-toggle="modal" data-target="#likeListModal">'
//							+'		<a href="">좋아요 <span>00개</span></a>'
							+'		<a>좋아요 <span class="cnt_like">'+v.cnt_post_like+'개</span></a>'
							+'	</div>'
							+'</section>'
									
							+'<section class="post_content-area">'
							+'	<div class="post_content">'
							+'		<span class="post_mem_id"><a href="profile/other_profile.html" class=".friend_link">' + v.mem_id + '</a></span>'
							+'		<span class="post_content content" id="post-content">'+ v.final_content +'</span>'
							+'	</div>'
							+'</section>'
							+'<section class="reply-area">'
							+'	<div class="comments">'
							+'		<a class="memid" href="profile/other_profile.html" class=".friend_link"><span class="memid" name="mem_id" title="">'+ v.reply_id +'</span></a>'
							+'		<span class="comment_content" name="REPLY_CONTENT">'+ v.reply_content+'</span>'
							+'	</div>'
							+'</section>'
							+'<div class="time-area">'
							+'	<div class="time-ago">'
							+'		<a href="">'
							+'			<time class="time">'+v.post_date+'</time>'
							+'		</a>'
							+'	</div>'
							+'</div>'
							+'<div class = "translation-area">'
							+'	<span class = "translate">번역하기</span>'
							+'</div>'
						
							+'<section class="comment-area">'
							+'<div class="comment-area-div">'
							+'	<form class="comment-form">'
							+'		<button class="emoji_btn" type="button">'
							+'			<div class="emoji_icon"><i class="far fa-smile"></i></div>'
							+'		</button>'
							+'		<textarea class="add_comment" placeholder="댓글 달기"></textarea>'
							+'		<button class="add_comment_btn" type="button">게시</button>'
							+'	</form>'
							+'</div>'
							+'</section>'
							+'</div>'
							+'</div>'
					
							$('#postarea').css('visibility','visible');
							$('#postarea').prepend(post_code).trigger("create")
//							$('.add_comment_btn').attr('disabled',true);
							console.log(v.mem_status)
							if(v.mem_status == "MK004"){
								chkicon = '<span><i class="fas fa-check-circle"></i></span>'
								text = $(this).parents('.post').find('.post-no').text();
								$(this).parents('.post').find('.userid-wrapper').append(chkicon);
							}
							
			})
			
		},
		error : function(xhr) {
			console.log('상태 : ' + xhr.status);
		}
	})
	
	
//	post_no = $('.userid-wrapper').find('.post-no').text();
//	id = $('.userid-wrapper').find('.post-userid').text();
//	console.log(post_no);
//	console.log(id);
//	
	//좋아요리스트 가져오기(모달창에 띄우기)	
	$(document).on('click', '.likes', function(){
						
		    $('#like-body').empty();
			post_no = $(this).parents('.post').find('.post-no').text();
			
			$.ajax({
				url : '/Sonminsooo/LikesList.do',
				type : 'get',
				data : {"post_no" : post_no},
				dataType : 'json',
				success : function(res) {
							
					$.each(res, function(a,b){
								
					if(b.mem_id != 0){
								
						modal_code = '<div id="like-body-profilewrapper">'
								   +'<div class="modal-profile-wrapper">'
								   +	'<img class="likemodal-profile-img" src="/Sonminsooo/filedownload.do?fileId='+b.mem_photo+'&fileSn='+b.mem_sn +'">'
								   +'</div>'
							
								   +'<div class="modal_id_name_wrapper">'
								   +'<div class="modal_id_wrapp">'
								   +	'<a class="modal_id_a">'+ b.mem_id +'</a>'
								   +	'</div>'
								   +'<div class="modal_name_wrapp">'
								   +	'<span class="modal_wrapp_span">'+ b.mem_name +'</span>'
								   +'</div>'
								   +'</div>'
								   +'</div>'
								$('#like-body').css('visibility','visible');
								$('#like-body').append(modal_code).trigger("create")
								
					}else{
						modal_code = "";
						$('#like-body').css('visibility','visible');
						$('#like-body').append(modal_code).trigger("create")
					}
			})
		},
		error : function(xhr) {
			console.log('상태 : ' + xhr.status);
		}	
		})			
	})
	
	//좋아요
	$(document).on('click', '#heart', function(){
		
		post_no = $(this).parents('.post').find('.post-no').text();
	
			 $.ajax({
					url : '/Sonminsooo/PostLikeInsert.do',
					data : {"post_no" : post_no,
							"mem_id" : mem_id	},
					type : 'post',
					dataType : 'json',
					success : function(res) {
						console.log('성공')
						$('#heart').attr('class', 'fas fa-heart');
						$('#heart').css('color', 'red');
						$('.cnt_like').html(res.cnt_post_like);
//						chk = false
					},
					error : function(xhr) {
						console.log("상태 : " + xhr.status)
					} 
			 })
			 
			 
//		}
//		else{
//			$.ajax({
//				url : '/Sonminsooo/DeletePostLike.do',
//				data : {"post_no" : post_no,
//						"mem_id" : mem_id	},
//				type : 'post',
//				dataType : 'json',
//				success : function(res) {
//					console.log('좋아요삭제성공')
//					$(this).attr('class', 'far fa-heart');
//					$(this).css('color', 'black');
//				},
//				error : function(xhr) {
//					console.log('실패???')
//					alert("상태 : " + xhr.status)
//				} 
//			})
//		}
		
		
		
	})

//내가 좋아요 누른 게시물 하트 빨간색으로 남겨두기
likechk =function(){
	
	post_no = $(this).parents('.post').find('.post-no').text();
	
	$.ajax({
		url : '/Sonminsooo/LikesList.do',
		data : {"post_no" : post_no,
				"mem_id" : mem_id},
		type : 'get',
		dataType : 'json',
		success : function(res) {
			
			$.each(res, function(i,v){
				if(v.chk = 1){
					console.log('v : ' + v.mem_id);
					console.log(mem_id);
					$('#heart').attr('class', 'fas fa-heart');
					$('#heart').css('color', 'black');
				}
			})
			
		},
		error : function(xhr) {
			console.log("상태 : " + xhr.status)
		} 
	})
	
}
		
		
	//댓글 게시
	$(document).on('click', '.add_comment_btn', function(){
		
		post_no = $(this).parents('.post').find('.post-no').text();
		comment = $(this).parents('.post').find('.add_comment').val();
		chkcom = $(this).parents('.post').find('.comment_content').text();
		console.log('체크 : ' + chkcom);
		console.log(comment);
		
		$('.add_comment').empty();
//		$('.add_comment').detach();
	
			$.ajax({
					url : '/Sonminsooo/ReplyInsert.do',
					data : {
						"post_no" : post_no,
						"mem_id" : mem_id,
						"reply_content" : comment
					},
					type : 'post',
					dataType : 'json',
					success : function(res) {
						if(chkcom != null){
							code = '<a class="memid" href=""><span class="memid" name="mem_id" title="">'+ mem_id +'</span></a>'
							 +'<span class="comment_content" name="REPLY_CONTENT">'+comment+'</span>'
							 $(this).parents('.post').find('.comments').append(code);
						}
						console.log('댓글 성공')
						$('.add_comment').val('');
					},
					error : function(xhr) {
						console.log("상태 : " + xhr.status)
					} 
			})
//		} 
		
		$('.add_comment').on('keyup', function() {
			$(this).parents('.post').find('.add_comment_btn').prop('disabled',false);
			$('.add_comment_btn').css('color', '#0597F2');
		})
	
		$('.add_comment').on('click', function() {
			$('.add_comment_btn').prop('disabled',false);
			$('.add_comment_btn').css('color', '#0597F2');
			$('.add_comment').val('');
		})
	
	})
	
	
	
	//다른 사람페이지로 넘어갈때
	 $(document).on('click', '.friend_link', function() {
		 
		 post_id = $(this).parents('.post').find('.friend_link').text();
		 console.log(post_id);
		 
          $.ajax({
               url : '/Sonminsooo/OtherMember.do',
               data : {
                  "mem_id" : post_id
               },
               type : 'post',
               dataType : 'json',
               success : function(res) {
					if(res.cnt>0)
						var win = window.open("profile/other_profile.html", "_self");
               },
               error : function(xhr) {
            	   console.log("상태 : " + xhr.status)
               } 
         }) 
            
      }) 
	
      
      
       $.ajax({
               url : '/Sonminsooo/FriendSelect.do',
               type : 'get',
               data : {"mem_id" : mem_id},
               dataType : 'json',
               success : function(res1) {
               /*    console.log("시작됨 : "+mem_id); */
                                          fcount=0;

                  $.each( res1.datas, function(i1, v1) {
               
                     if(mem_id!=v1.mem_id){
                        if(mem_id==v1.follower || mem_id==v1.following){
                     if(mem_id==v1.follower){
                        friend[fcount]=v1.following;
                        fcount=fcount+1;
                     }
                        }
                     }
                  })
               },
               error : function(){
               }
       })
      
      
      $(document).on('click', '.comment', function() {
			
//			$('#big_heart').attr('class','far fa-heart');
//			$('#big_heart').css('color', 'black');
			content = $(this).parents('.post').find('#post-content').text();
			post_no = $(this).parents('.post').find('.post-no').text();
			time = $(this).parents('.post').find('.time').text();
			img = $(this).parents('.post').find('.images').attr('src');
			id = $(this).parents('.post').find('.friend_link').text();
//			console.log(id);
//			console.log(img);
//			console.log(time);
//			console.log(content);
//			console.log(post_no);
			reply(post_no);
			
			 $.ajax({
					url : '/Sonminsooo/Feed.do',
//					data : { "post_no" : post_no },
					type : 'get',
					dataType : 'json',
					success : function(res) {
						codew="";
						if(res.size>0){
							//모달 넣기
							$.each( res, function(i, v) {
								console.log(v.mem_id);
								if(v.mem_id==id){
//									$('#big_heart').attr('class','fas fa-heart');
//									$('#big_heart').css('color', 'red');
								}else{
									if(v.mem_photo == 0){
										$('.profile_img').attr('src',"../../../images/default_profile")
//										 codew += "<li><img class='li_photo' src='../../../images/default_profile.jpg'alt='profile_photo'>"
									}else{
										  $('.profile_img').attr('src',"/Sonminsooo/filedownload.do?fileId="+v.mem_photo+"&fileSn="+v.file_sn+"'alt='profile_photo'")
//										 codew += "<li><img class='li_photo' src='/Sonminsooo/filedownload.do?fileId="+v.mem_photo+"&fileSn="+v.file_sn+"'alt='profile_photo'>"
									}
//									if(v.mem_id == friend[i]){
//								     codew += "<div class='li_list'> <a class='friend_link' id='"+ id +"' href='' target='_blank'>"
//										  + v.mem_id
//										  + "</a><br><span id='li_username'>"
//										  + v.mem_name;
//								     codew += "</span></div><input class='li_bnt follow_bnt' type='button' id='"+ id +"'value='팔로잉'"+"></li>";
//									}else{
//									     codew += "<div class='li_list'> <a class='friend_link' id='"+ id +"' href='' target='_blank'>"
//											  + v.mem_id
//											  + "</a><br><span id='li_username'>"
//											  + v.mem_name;
//									     codew += "</span></div><input class='li_bnt follow_bnt' type='button' id='"+ id +"'value='팔로워'"+"></li>";
//									}
								}
								
							})
//							$('#like_list').html(codew);
						
							console.log(friend);
							$('.date2').prepend("<span id='post_like_btn'> 좋아요 "+res.cnt_post_lik+"개</span><br>");
						}else{
							//좋아요가 없으니 눌러보라고 뜨기
							$('.date2').prepend("<span id='post_like_btn'>가장 먼저 좋아요를 눌러보세요.</span><br>");
						}
					},
					error : function(xhr) {
						console.log("상태 : " + xhr.status)
					} 
			})
			
	/* 		alert($(this).attr('alt')) */
			if(content!="null"){
				$('#modal-post_content').html(content);
			}else{
				$('#modal-post_content').html('');
			}
			
			$('.post_user').html(id);
			$('.post_date').html(time);
			$('#select_img').attr('src', img); 
			$('#photo_click').modal('show');
		
		})

      
	
	//링크 연결
	$('.logoarea img').on('click',function(){
		window.location.href = "feedpage.html"
	})

	$('#homeicon').on('click', function(){
		window.location.href = "feedpage.html"
	})

	$('#dmicon').on('click', function(){
		window.location.href= "chat.html"
	})

})



	function reply(post_no) {
		$('.append_comments').empty();
		$('.append_comments').detach();
		$.ajax({
			url : '/Sonminsooo/ReplySelect.do',
			data : {
				"post_no" : post_no
			},
			type : 'post',
			dataType : 'json',
			success : function(res) {
				if(res.size>0){
					
					$.each( res.datas,
							function(i, v) {
						console.log(i);
						
						content=v.reply_content;

					 		$.ajax({
							url : '/Sonminsooo/ReplyLikeSelect.do',
							data : {
								"child_id" : v.child_id
							},
							type : 'post',
							dataType : 'json',
							success : function(res1) {
								codeap="";
								console.log("확인")
								if(res1.size>0){
									console.log("확인1")
							     	codeap+="<div class='append_comments'>"
										+"<div class='pl'>"
										if(v.mem_photo > 0){
											codeap+="<img class='profile_img' src='/Sonminsooo/filedownload.do?fileId="+v.mem_photo+"&fileSn="+v.file_sn+"'alt='"+v.post_date+"'>"
										}else{
											codeap+="<img class='profile_img' src='../../../images/default_profile.jpg' alt='profile_photo'>"
										}
										codeap+="</div>"
											+"<div  class='pr' id='post_r'>"
											$.each( res1.datas,
													function(i, v) {
													console.log(v.mem_id)
												if(mem_id==v.mem_id){
													codeap+="<span class='post_user'>"+v.mem_id+"</span> <i class='fas fa-heart red_heart' id='comment-heart' name='"+v.child_id+"'></i><span id='post_content'>"
												}else{
													if(i+1 == res1.size)
													codeap+="<span class='post_user'>"+v.mem_id+"</span> <i class='far fa-heart' id='comment-heart' name='"+v.child_id+"'></i><span id='post_content'>"
												}
												})
											codeap+="<br>"+v.reply_content
											+"</span>"
											+"<br>"
											+"<span class=post_date date1>"+v.reply_date+"</span>"
									codeap += " <span class='bold_span comment_size' id='comment_like_count'>좋아요 "+res1.size+"개</span>"	;
										codeap+=" <span class='bold_span comment_size' id='comment_reply'> 답글 달기</span></div></div>";
								}else{
									console.log("확인2")
							     	codeap+="<div class='append_comments'>"
										+"<div class='pl'>"
										if(v.mem_photo > 0){
											codeap+="<img class='profile_img' src='/Sonminsooo/filedownload.do?fileId="+v.mem_photo+"&fileSn="+v.file_sn+"'alt='"+v.post_date+"'>"
										}else{
											codeap+="<img class='profile_img' src='../../../images/default_profile.jpg' alt='profile_photo'>"
										}
										codeap+="</div>"
											+"<div  class='pr' id='post_r'>"
											+"<span class='post_user'>"+v.mem_id+"</span> <i class='far fa-heart' id='comment-heart' name='"+v.child_id+"'></i><span id='post_content'>"
											+"<br>"+v.reply_content
											+"</span>"
											+"<br>"
											+"<span class=post_date date1>"+v.reply_date+"</span>"
										codeap+=" <span class='bold_span comment_size' id='comment_reply'> 답글 달기</span></div></div>";									
								}
								$('#post_content_div').append(codeap);
							},
							error : function(xhr) {
								alert("상태 : " + xhr.status)
							} 
							})  
					
					/* 	console.log(codeap); */

					})
					
				}else{
					
				}
			},
			error : function(xhr) {
				alert("상태 : " + xhr.status)
			} 
 		})
	}
	




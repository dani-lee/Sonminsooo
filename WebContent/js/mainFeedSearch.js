/**
 * 
 */




searchHashNUser = function(){

	$(document).ready(function(){
	    var target = $('.searcharea');
	    
	    
	    $(document).on('click', '.SRCU', function (e){
	    	
	    	name = $(this).attr('name');
	    	
	    	$('.contentDIV').empty();
	    	
	    	name = name.substring(1);
	        
	    	location.href = "/Sonminsooo/HashChoice.do?hash="+name;
	    });
	    
	    
	    // 검색을 클릭하면 drop이 보임.
	    $(document).on('click', '#search', function (e){
	    	
	    	// 전체 비우기
	    	$('.contentDIV').empty();
	    	
			$('.contentS').css('display', 'block');
			$('.searchCancelBTN img').css('display', 'block');
			$('#serachICON').css('display', 'none');
			
			$(this).on('keyup', function(){
				content = $(this).val();
				
				if(content == ""){
					$('.serach_input span').show();
					dCode = "<ul>";
					dCode += "<li class='DTN'>최근 검색 항목</li>";
					dCode += "<li class='DCT'>최근 검색 내역 없음.</li>";
					dCode += "</ul>";
					
					$('.contentS .contentDIV').html(dCode);
				}else{
					$('.serach_input span').hide();
					
					// 해시태그, 사용자이름 테이블에서 뽑아오기
					ck = content.substr(0,1);
					if(ck == "#"){
						console.log("#content = " + content);
						
						hashName = content.substring(1);
						console.log("hashName => " + hashName);
						if(hashName != ""){
							$.ajax({
								url: '/Sonminsooo/SearchHash.do',
								data: { "hashName": hashName },
								type: 'post',
								success: function(res) {
									console.log("res.success => " + res.success);
									
									if(res.success == "true"){
										code = "";
										code += "<ul>";
										$.each(res.datas, function(i, v) {
											console.log("v.hash => " + v.hash);
											code += "<li class='searchResult'><a class='SRCU' name="+  v.hash +" href='#'>";
											code += "<div class='SPIMG'>#</div>";
											code += "<div class='SRCT' name='" + v.count + "'>";
											code += "<span>" + v.hash + "</span>";
											code += "<span>게시물 " + v.count + "</span>";
											code += "</div>";
											code += "</a></li>";
										})
										code += "</ul>";
										
										$('.contentS .contentDIV').html(code);
									}else{
										Fcode = "<li class='SFCT'>검색 결과가 없습니다.</li>";
										$('.contentS .contentDIV').html(Fcode);
									}
								},
								error: function(xhr) {
									console.log("error : " + xhr.status);
								},
								dataType: 'json'
							})
							
						}
					}else{
						console.log("content = " + content);
						
						$.ajax({
							url: '/Sonminsooo/SearchUser.do',
							data: { "userName": content },
							type: 'post',
							success: function(res) {
								console.log("res.success => " + res.success);
								
								if(res.success == "true"){
									code = "";
									code += "<ul>";
									$.each(res.datas, function(i, v) {
										code += "<li class='searchResult'><a class='SRCU' id='" + v.mem_id + "' href='/Sonminsooo/sonminsooo/html/profile/other_profile.html'>";
										if(v.mem_photo == 0){
											code += "<div class='RUIMG'><img class='RUP' src='/Sonminsooo/images/default_profile.jpg' alt='default_profile.jpg'></div>";
										}else{
											code += "<div class='RUIMG'><img class='RUP' src='/Sonminsooo/filedownload.do?fileId="+v.mem_photo+"&fileSn="+v.file_sn+"'></div>";
										}
										code += "<div class='SRCT'>";
										code += "<span>" + v.mem_id + "</span>";
										code += "<span> " + v.mem_name + "</span>";
										code += "</div>";
										code += "</a></li>";
									})
									code += "</ul>";
									
									$('.contentS .contentDIV').html(code);
								}else{
									Fcode = "<li class='SFCT'>검색 결과가 없습니다.</li>";
									$('.contentS .contentDIV').html(Fcode);
								}
								
							},
							error: function(xhr) {
								console.log("error : " + xhr.status);
							},
							dataType: 'json'
						})
					}
				}
				
				
				
				
			})
	    		
	    });
	    
	    // drop 외부를 클릭하면 사이드바 닫힘
	    $(document).mouseup(function (e){
	        if(target.has(e.target).length==0) {
	        	$('#search').val('');
	        	$('.contentS').css('display', 'none');
	        	$('.searchCancelBTN img').css('display', 'none');
	        	$('#serachICON').css('display', 'block');
	        	$('.serach_input span').css('display', 'block');
	        } 
	    });
	});    
	
	// 검색창에 있는 엑스(X)버튼 누르면 닫기
	$(document).on('click', '.searchCancelBTN', function(){
//		console.log("btn이 눌렸습니다.");
		$('#search').val('');
		$('.contentS').css('display', 'none');
		$('.searchCancelBTN img').css('display', 'none');
		$('#serachICON').css('display', 'block');
		$('.serach_input span').css('display', 'block');
	})
	
	
	// 친구이름 눌렀을때 이동
	$(document).on('click', '.SRCU', function() {
			 $.ajax({
					url : '/Sonminsooo/OtherMember.do',
					data : {
						"mem_id" : $(this).attr('id')
					},
					type : 'post',
					dataType : 'json',
					error : function(xhr) {
						console.log("상태 : " + xhr.status)
					} 
			}) 
				
		})
	
}



















/**
 * 로그인한 유저의 팔로잉을 찾아서 보여주기
 */


loginUserFriend = function(){
	
	$.ajax({
		url : '/Sonminsooo/LoginUserFriend.do',
		type : 'post',
		success : function(res){
			// alert("일단 성공!");
			code = "";
			$.each(res.datas, function(i, v){
				if(i < 6)
				code += "<li>";
				code += "  <div class='story'>";
				code += "    <div class='profile-img-wrapper'>";
				code += "      <img class='profile-img-img' src='/Sonminsooo/filedownload.do?fileId="+v.afd+"&fileSn="+v.file_sn+"'>";
				code += "    </div>";
				code += "    <div class='story_id' name='mem_id'>"+v.mem_id+"</div>";
				code += "  </div>";
				code += "</li>";
							
			})
			
			$('.stories').html(code);
			
		},
		error : function(xhr){
			console.log("loginUserFriend.js 오류! / 상태 : " + xhr.status);
		},
		dataType : 'json'
	})
	
	
}
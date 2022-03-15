<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src = "/Sonminsooo/js/jquery-3.6.0.min.js"></script>
<link rel ="stylesheet" href = "../../css/insertForm_style.css">
<title>Insert title here</title>
<style>

</style>
<script>
	$(function(){
		$(document).on('change','select[name=post_kind]', function(){
			kind = $(this).find('option:selected').val();
			console.log(kind);
			
			flag = false;
			//content = $('#board_content').attr();
			//console.log(content);
			if(kind != "게시물"){
				flag = true;
			}
			$('#board_content').attr("disabled", flag);
			$('#location_content').attr("disabled", flag);
		})
		//해시태그 및 위치태그 목록 불러오기
		$('#board_content').on('keyup', function(){
			hashtag = $(this).val();
			console.log(hashtag);
			if(hashtag.match("#","\r")){
				alert('포함')
			}
		})
		$('#submit').on('click', function(){
			alert('야')
		})
		
		$('.prebtn').on('click', function(){
			idx = $('#input_pic img:not(\'disabled\', true)').attr("idx");
			
			$('#input_pic img:eq('+idx+')').hide();
			$('#input_pic img:eq('+(idx - 1)+')').show();
			
		})
		
		$('.nextbtn').on('click', function(){
			idx = $('#input_pic img:not(\'disabled\', true)').attr("idx");
			
			$('#input_pic img:eq('+idx+')').hide();
			$('#input_pic img:eq('+(idx + 1)+')').show();
			
		})

		
	})
	
	function setThumbnail(event) { 
		$('#input_pic img').remove();
		$('#input_pic').show();
		cnt = 0;
			for (var image of event.target.files) { 
				var reader = new FileReader(); 
								
				reader.onload = function(event) { 
					if($('.same img').attr('sw') == 0){
						$('.same img').attr('sw', 1);
						$('.same img').hide();
						$('.same h3').hide();
					}
					
					var img = document.createElement("img"); 
					img.setAttribute("src", event.target.result); 
					img.setAttribute("id", cnt)
					img.setAttribute("idx", cnt); 
					
					document.querySelector("div#input_pic").appendChild(img); 
					img.hide();
					cnt = cnt+1;
					
				}; 
				
				console.log(image); 
				reader.readAsDataURL(image); 
				
			} 
			
		}
	
// 	:eq(index)
</script>
</head>
<body>

	<form id="uploadFile" action = "/Sonminsooo/InsertBoard.do" enctype="multipart/form-data" method="post">
		<table border = "1">
			<tr>
				<td class = "same" id = "picture_space" rowspan = "5" >
					<img sw=0 src="../../../images/icon/picture.png" alt="동영상과 사진 중 아무거나 넣으십시오">
					<h3 sw=0>사진과 동영상을 선택해주세요.</h3>
					<div id="input_pic" style="display:none">
					</div>
					<!-- <input type = "file" name ="atchFile" id ="file" multiple = "multiple"> -->
					<label for="file">컴퓨터에서 선택</label> <input name = "atchFile" type="file" id="file"
						accept="image/*" onchange="setThumbnail(event);" multiple="multiple">
					<!-- <div id="next">
					<a href="/Sonminsooo/InsertBoard.do">다음</a> -->
			
		
				</td>
				<td> 프사랑 이름자리</td>
			</tr>
			
			<tr>
				<td><select id = "kind" name = "post_kind">
					<option value = "게시물">게시물</option>
					<option value = "스토리">스토리</option>
					<option value = "라이브">라이브</option>		
				</select></td>
			</tr>
			
			<tr>
				<td><textarea name = "content" id = "board_content" cols="70" rows="10" placeholder="설명을 입력하세요..."></textarea></td>
			</tr>
			
			<tr>
				<td><input name = "location" id = "location_content" class = "same" type = "text" placeholder="위치 추가..."></td>
			</tr>
		</table>
		
		<input type = "submit" id = "submit">

	</form>

</body>
</html>
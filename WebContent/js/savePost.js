/**
 * 
 */
printMySavedPost = function(){
	$(function(){
		$('#storage').on('click', function(){
			
			
			$.ajax({
				url : '/Sonminsooo/GetMySavedPost.do',
				data : { "mem_id" : mem_id },
				type : 'get',
				dataType : 'json',
				success : function(res){
					
				},
				error : function(xhr){
					
				}
			})
			
			
			
			
		})
		
	})
	
}
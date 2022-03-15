const joinform = document.querySelector('.joinform');
const button = document.querySelector('#join');
const email = document.querySelector('#email');
const name = document.querySelector('#name');
const id = document.querySelector('#id');
const pw = document.querySelector('#pw');
const datas = document.querySelectorAll('input');

button.disabled = true;

window.addEventListener('load', function(e){
	
	console.log(datas.value);
	joinform.addEventListener('click',function(e){

		// $.ajax({
		// 		url : '/Sonminsooo/Join.do',
		// 		type : 'post',
		// 		data : datas,
		// 		success : function(res){
		
		// 		},
		// 		error: function(xhr){
		// 			alert('상태 : ' + xhr.status);
		// 		},
		// 		dataType: 'json'
		// })
	})
})

	email.addEventListener('keyup', function(){
		emailchk();
	})

	email.addEventListener('keydown', function(){
		emailchk();
	})
	
	email.addEventListener('change', function(){
		emailchk();
	})
	
	email.addEventListener('blur', function(){
		emailchk();
	})
	
	

	name.addEventListener('keyup', function(){
		namechk();
	})

	name.addEventListener('keydown', function(){
		namechk();
	})
	
	name.addEventListener('change', function(){
		namechk();
	})
	
	name.addEventListener('blur', function(){
		namechk();
	})


	
	id.addEventListener('keyup', function(){
		idchk();
	})

	id.addEventListener('keydown', function(){
		idchk();
	})
	
	id.addEventListener('change', function(){
		idchk();
	})
	
	id.addEventListener('blur', function(){
		idchk();
	})
	


	pw.addEventListener('keyup', function(){
		pwchk();
	})
	
	pw.addEventListener('keydown', function(){
		pwchk();
	})

	pw.addEventListener('change', function(){
		pwchk();
	})
	
	pw.addEventListener('blur', function(){
		pwchk();
	})
	
	var space = /\s/g;
	var title = "";
	var join = {
		common: {
			empty: {code: 'invalid', desc:'입력하지않음'},
			space: {code: 'invalid', desc:'공백'}
			//		min: {code: 'invalid'}
			//		max: {code: 'invalid'}
		},
		email: {
			valid: { code: 'valid', desc:'유효함'},
			invalid: { code: 'invalid', desc:'유효하지않음'},
			usable: { code: 'valid', desc:'사용가능'},
			unusable: { code: 'invalid', desc:'사용불가능'}
		},
		
		email_status: function(email) {
			email = $('#email').val();
			var reg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			title = $('[name = email').attr('title');
			if( email == '' ) return this.common.empty;
			else if(email.match(space)) return this.common.space;
			else if( reg.test(email) ) return this.email.valid;
			else return this.email.invalid;  
		},
		
		name1: {
			valid: { code: 'valid', desc:'유효함'},
			invalid: { code: 'invalid', desc:'유효하지않음'},
		},
		
		name1_status: function(name){
			name1 = $('#name').val();
			var reg = /^[가-힣]{2,4}$/;
			title = $('[name = name').attr('title');
			if( name1 == '' ) return this.common.empty;
			else if(name1.match(space)) return this.common.space;
			else if( reg.test(name1) ) return this.name1.valid;
			else return this.name1.invalid;  
		},
		
		id: {
			valid: { code: 'valid', desc:'유효함'},
			invalid: { code: 'invalid', desc:'유효하지않음'},
			usable: { code: 'valid', desc:'사용가능'},
			unusable: { code: 'invalid', desc:'사용불가능'}
		},
		
		id_usable: function(iddata) {
			if(iddata) return this.id.usable;
			else return this.id.unusable;
		},
		
		id_status: function(id) {
			id = $('#id').val();
			var reg = /^[\w](?!.*?\.{2})[\w.]{1,28}[\w]$/;
			title = $('[name = id]').attr('title');
			if(id == '') { 
				return this.common.empty;
			} else if(id.match(space)) {
				return this.common.space;
			} else if(reg.test(id)) {
				return this.id.invalid;
			} else {
				return this.id.valid;
			}
		},
		
		pw: {
			valid: { code: 'valid', desc:'유효함'},
			invalid: { code: 'invalid', desc:'유효하지않음'},
			lack: { code:'invalid', desc:'부족'}
		},
		
		pw_status: function(pw) {
			pw = $('#pw').val();
			var reg = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/;
			// var reg = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/; //between 8 to 20 characters which contain at least one numeric digit and a special character
			// var reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/; //특수기호 포함 8자이상
			title = $('[name = pw]').attr('title');
			var upper = /[A-Z]/g, lower = /[a-z]/g, digit = /[0-9]/g, char = /[#?!@$%^&*-]/g;
			if(pw == '') return this.common.empty;
			else if(pw.match(space)) return this.common.space;
			else if(reg.test(pw)) return this.pw.invalid;
			else if ( !upper.test(pw) || !lower.test(pw) || !digit.test(pw) || !char.test(pw)) return this.pw.lack;
			else return this.pw.valid;
		},
		
		tag_status: function(tag) {
			tag = tag.attr('name');
			var data = tag.value;
			if(tag == 'id') {
				data = this.id_status(data);
			} else if(tag == 'pw') {
				data = this.pw_status(data);
			}else if(tag == 'name1') {
				data = this.name1_status(data);
			}else if(tag == 'email') {
				data = this.email_status(data);
			} 
			return data;
		}
	}
	
	emailchk = function() {
		
		$email = $('[name = email]');
		emaildata = join.tag_status($email);
		if(emaildata.code == 'valid'){
			$('.email #valid').show().css('margin-top', '15px');
		}else if(emaildata.code == 'invalid'){
			$('.email #invalid').show().css('margin-top', '15px');
		}
	}

	emailchkDupli = function(){//이메일 중복체크

		emailval = email.value;

		$.ajax({
			url : '/Sonminsooo/Join.do',
			type : 'post',
			data : datas,
			dataType: 'json',
			success : function(res){
	
			},
			error: function(xhr){
				alert('상태 : ' + xhr.status);
			}
		})
	}
	
	namechk = function(){
		
		$name1 = $('[name = name1]');
		namedata = join.tag_status($name1);
		
		if(namedata.code == 'valid'){
			$('.name #valid').show().css('margin-top', '15px');
		}else if(namedata.code == 'invalid'){
			$('.name #invalid').show().css('margin-top', '15px');
		}
	}
	idchk = function(){
		
		$id = $('[name = id]');
		iddata = join.tag_status($id);
		
		if(iddata.code == 'valid'){
			$('.id #valid').show().css('margin-top', '15px');
		}else if(iddata.code == 'invalid'){
			$('.id #invalid').show().css('margin-top', '15px');
		}
		
		//중복 체크해야함
		
	}
	
	pwchk = function(){
		
		$pw = $('[name = pw]');
		pwdata = join.tag_status($pw);
		
		if(pwdata.code == 'valid'){
			alert('ggggg')
			$('.pw #valid').show().css('margin-top', '15px');
		}else if(pwdata.code == 'invalid'){
			$('.pw #invalid').show().css('margin-top', '15px');
		}
	}
	
	checkAll = function(){
		$email = $('[name = email]');
		$name1 = $('[name = name1]');
		$id = $('[name = id]');
		$pw = $('[name = pw]');

		if(join.tag_status($email).code == 'valid' &&
		   join.tag_status($name1).code == 'valid' &&
		   join.tag_status($id).code == 'valid' &&
		   join.tag_status($pw).code == 'valid'){
			
			// $('#join').prop('disabled',false);
			button.disabled = false;
		}
	}
	




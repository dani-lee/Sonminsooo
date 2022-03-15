const email = document.querySelector('#email');
const name = document.querySelector('#name');
const id = document.querySelector('#id');
const pw = document.querySelector('#pw');


 $('#join').prop('disabled',true);

	email.addEventListener('keyup', function(){
		emailchk();
		checkAll();
	})

	email.addEventListener('keydown', function(){
		emailchk();
		checkAll();
	})
	
	email.addEventListener('change', function(){
		emailchk();
		checkAll();
	})
	
	email.addEventListener('blur', function(){
		emailchk();
		checkAll();
	})
	
	

	name.addEventListener('keyup', function(){
		namechk();
		checkAll();
	})

	name.addEventListener('keydown', function(){
		namechk();
		checkAll();
	})
	
	name.addEventListener('change', function(){
		namechk();
		checkAll();
	})
	
	name.addEventListener('blur', function(){
		namechk();
		checkAll();
	})


	
	id.addEventListener('keyup', function(){
		idchk();
		checkAll();
	})

	id.addEventListener('keydown', function(){
		idchk();
		checkAll();
	})
	
	id.addEventListener('change', function(){
		idchk();
		checkAll();
	})
	
	id.addEventListener('blur', function(){
		idchk();
		checkAll();
	})
	


	pw.addEventListener('keyup', function(){
		pwchk();
		checkAll();
	})
	
	pw.addEventListener('keydown', function(){
		pwchk();
		checkAll();
	})

	pw.addEventListener('change', function(){
		pwchk();
		checkAll();
	})
	
	pw.addEventListener('blur', function(){
		pwchk();
		checkAll();
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
		email1: {
			valid: { code: 'valid', desc:'유효함'},
			invalid: { code: 'invalid', desc:'유효하지않음'},
			usable: { code: 'valid', desc:'사용가능'},
			unusable: { code: 'invalid', desc:'사용불가능'}
		},
		
		email_status: function(email) {
			email = $('#email').val();
			var reg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			title = $('#email').attr('title');
			if( email == '' ) return this.common.empty;
			else if(email.match(space)) return this.common.space;
			else if( reg.test(email) ) return this.email1.valid;
			else return this.email1.invalid;  
		},
		
		name1: {
			valid: { code: 'valid', desc:'유효함'},
			invalid: { code: 'invalid', desc:'유효하지않음'},
		},
		
		name_status: function(name){
			name = $('#name').val();
			var reg = /^[가-힣]{2,4}$/;
			title = $('#name').attr('title');
			if( name == '' ) return this.common.empty;
			else if(name.match(space)) return this.common.space;
			else if( reg.test(name) ) return this.name1.valid;
			else return this.name1.invalid;  
		},
		
		id1: {
			valid: { code: 'valid', desc:'유효함'},
			invalid: { code: 'invalid', desc:'유효하지않음'},
			usable: { code: 'valid', desc:'사용가능'},
			unusable: { code: 'invalid', desc:'사용불가능'}
		},
		
		id_usable: function(iddata) {
			if(iddata) return this.id1.usable;
			else return this.id1.unusable;
		},
		
		id_status: function(id) {
			id = $('#id').val();
			var reg = /^[\w](?!.*?\.{2})[\w.]{1,28}[\w]$/;
			title = $('#id').attr('title');
			if(id == '') { 
				return this.common.empty;
			} else if(id.match(space)) {
				return this.common.space;
			} else if(reg.test(id)) {
				return this.id1.valid;
			} else {
				return this.id1.invalid;
			}
		},
		
		pw1: {
			valid: { code: 'valid', desc:'유효함'},
			invalid: { code: 'invalid', desc:'유효하지않음'},
			lack: { code:'invalid', desc:'부족'}
		},
		
		pw_status: function(pw) {
			pw = $('#pw').val();
			var reg = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/;
			// var reg = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/; //between 8 to 20 characters which contain at least one numeric digit and a special character
			// var reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/; //특수기호 포함 8자이상
			title = $('#pw').attr('title');
			var upper = /[A-Z]/g, lower = /[a-z]/g, digit = /[0-9]/g, char = /[#?!@$%^&*-]/g;
			if(pw == '') return this.common.empty;
			else if(pw.match(space)) return this.common.space;
			else if(reg.test(pw)) return this.pw1.valid;
			else if ( !upper.test(pw) || !lower.test(pw) || !digit.test(pw) || !char.test(pw)) return this.pw1.lack;
			else return this.pw1.invalid;
		},
		
		tag_status: function(tag) {
			tag = tag.attr('id');
			var data = tag.value;
			if(tag == 'id') {
				data = this.id_status(data);
			} else if(tag == 'pw') {
				data = this.pw_status(data);
			}else if(tag == 'name') {
				data = this.name_status(data);
			}else if(tag == 'email') {
				data = this.email_status(data);
			} 
			return data;
		}
	}
	
	emailchk = function() {
		
		$email = $('#email');
		emaildata = join.tag_status($email);
		if(emaildata.code == 'valid'){
			$('.email #valid').show().css('margin-top', '15px');
			$('.email #invalid').hide();
		}else if(emaildata.code == 'invalid'){
			$('.email #invalid').show().css('margin-top', '15px');
			$('.email #valid').hide();
		}
	}

	emailchkDupli = function(){//이메일 중복체크

		emailval = email.value;

		$.ajax({
			url : '/Sonminsooo/EmailCheck.do',
			type : 'post',
			data : {"memEmail" : memEmail},
			dataType: 'json',
			success : function(res){
				
			},
			error: function(xhr){
				alert('상태 : ' + xhr.status);
			}
		})
	}
	
	namechk = function(){
		
		$name1 = $('#name');
		namedata = join.tag_status($name1);
		
		if(namedata.code == 'valid'){
			$('.name #valid').show().css('margin-top', '15px');
			$('.name #invalid').hide();
		}else if(namedata.code == 'invalid'){
			$('.name #invalid').show().css('margin-top', '15px');
			$('.name #valid').hide();
		}
	}
	idchk = function(){
		
		$id = $('#id');
		iddata = join.tag_status($id);
		
		if(iddata.code == 'valid'){
			$('.id #valid').show().css('margin-top', '15px');
			$('.id #invalid').hide();
		}else if(iddata.code == 'invalid'){
			$('.id #invalid').show().css('margin-top', '15px');
			$('.id #valid').hide();
		}
		
		//중복 체크해야함
		
	}
	
	pwchk = function(){
		
		$pw = $('#pw');
		pwdata = join.tag_status($pw);
		
		if(pwdata.code == 'valid'){
			$('.pw #valid').show().css('margin-top', '15px');
			$('.pw #invalid').hide();
		}else if(pwdata.code == 'invalid'){
			$('.pw #invalid').show().css('margin-top', '15px');
			$('.pw #valid').hide();
		}
	}
	
	checkAll = function(){
		$email = $('#email');
		$name1 = $('#name');
		$id = $('#id');
		$pw = $('#pw');

		if(join.tag_status($email).code == 'valid' &&
		   join.tag_status($name1).code == 'valid' &&
		   join.tag_status($id).code == 'valid' &&
		   join.tag_status($pw).code == 'valid'){
			
			 $('#join').prop('disabled',false);
//			button.disabled = false;
		}
	}
	




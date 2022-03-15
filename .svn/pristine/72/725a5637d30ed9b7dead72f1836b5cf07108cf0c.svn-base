//이모티콘버튼 눌렀을때 이모티콘 창 열리기
//import { EmojiButton } from '@joeattardi/emoji-button';

const emoji_btn = document.querySelector('.emoji_icon');
const msginput = document.querySelector('.msginput');

const picker = new EmojiButton();
	
	emoji_btn.addEventListener('click', () => {
		picker.togglePicker(emoji_btn);
	});
	picker.on('emoji', emoji => {
		msginput.value += emoji;
	});

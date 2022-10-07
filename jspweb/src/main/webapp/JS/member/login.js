/* HTML과 서블릿 통신 */

function login() {
	
	// 1. html 입력된 데이터 가져오기 [ DOM객체 ] \
	let mid = document.querySelector('#mid').value
	let mpassword = document.querySelector('#mpassword').value
	let loginconfirmbox = document.querySelector('#loginconfirmbox')

	// $.ajax({ 속성명 = 값, 속성명 = 값, 속성명 = 값 })
		// url : '서블릿URL'
		// data : 전송할 데이터 { '키' : 값, '키' : 값 },
		// success : function( 매개변수 ) { }

	$.ajax({ // 기본통신 GET방식
		url : "/jspweb/member/login",
		data : { "mid" : mid, "mpassword" : mpassword },
		success : function( re ) {
			alert(re)
			if(re === '1') {
				location.href = '/jspweb/index.jsp';
			} else if(re === '2'){
				loginconfirmbox.innerHTML = '회원정보가 다릅니다.';
			} else if(re === '3') {
				loginconfirmbox.innerHTML = '데이터베이스 오류[관리자에게 문의]';
			} else if(re === '0') {
				loginconfirmbox.innerHTML = '존재하지 않는 아이디 입니다.';
			}
		}
	});

}

























/*----------------------------------*/



















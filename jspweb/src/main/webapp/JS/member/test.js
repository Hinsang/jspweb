function fpw() {
	
	let mid = document.querySelector("#mid").value
	let memail = document.querySelector("#memail").value
	let fpwbox = document.querySelector("#fpwbox")
	
	$.ajax({
		url: "/jspweb/member/test",
		data: { "mid" : mid, "memail" : memail},
		success: function(result) {
			if(result === '') {
				fpwbox.innerHTML = '동일한 회원정보가 없습니다.'
			} else {
				fpwbox.innerHTML = '임시비밀번호 : ' + result
			}
		}
	})
	
}

function findid() {
	let mname = document.querySelector("#mname").value
	let memail = document.querySelector("#memail").value
	let findidconfirmbox = document.querySelector("#findidconfirmbox")


	// 서블릿에 데이터 보내기
	$.ajax({
		url : "/jspweb/member/findid",
		data : { "mname" : mname, "memail" : memail }, /* 보낼 데이터 : { "이름" : 값, "이름" : 값 } */
		success : function(받은데이터) {
			if(받은데이터 !== 'null') {
				findidconfirmbox.innerHTML = '회원아이디 : ' + 받은데이터
			} else {
				findidconfirmbox.innerHTML = '동일한 회원정보가 없습니다.'
			}
		}
	})

}

function findpassword() {
	let mid = document.querySelector("#mid").value
	let memail = document.querySelector("#memail").value
	let findpasswordconfirmbox = document.querySelector('#findpasswordconfirmbox')
	
	$.ajax({
		url : "/jspweb/member/findpassword",
		data : { "mid" : mid, "memail" : memail },
		success : function(result) {
			if(result === '') {
				findpasswordconfirmbox.innerHTML = '동일한 회원정보가 없습니다.';
			} else {
				findpasswordconfirmbox.innerHTML = '임시비밀번호 : ' + result;
			}
		}
	})
}

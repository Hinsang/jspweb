/* 썸머노트 실행 */
$(document).ready(function() {
	
  $('#summernote').summernote({
		placeholder : '내용을 입력 해주세요' ,
		maxHeight : null,
		minHeight : 300,
		lang: 'ko-KR'
	});

});

function bwrite(){
	
	// form 있는 버전
	let form = document.querySelector('form')
	console.log(form)
	
	let formdata = new FormData(form) // 객체화된 form 정보 호출 [form 안에 입력받은 데이터 input 모두 가져오기]
	console.log(formdata)
	
	$.ajax({
		url : "/jspweb/board/write", // 서블릿주소
		data : formdata, // ajax 기본값으로 form 전송 불가능

		// 첨부파일 전송시 : 아래 코드 추가 [ 1. post방식[get방식 불가]
		type : 'POST', // http메소드 [get(첨부파일x) vs post] ( 전송할타입, 전송할url을 멀티파트와 url뒤에 뭐 안붙이게 바꿔줌)
		contentType : false, // application x-www-form-urlencoded; charset UTF-8 : 기본값(바이트, 첨부파일 지원x) vs multipart/form-data(대용량바이트, 첨부파일 지원O)
		processData : false, // string : 기본값 vs 전송시 사용되는 타입
		// 기본값 : 전송url 데이터 명시	http://example.com?title=tit&content=cont vs false : http://example.com (post에서 url 뒤에 뭐 안붙이는 차이)
		success : function(re) {
			if(re === 'true') {
				alert('글등록');
				location.href="list.jsp"
			}
			else {
				alert('글등록실패')
			}
		}
	})
	
//	form 없는 버전
//	let inputs = document.querySelectorAll('input')
//	console.log( inputs ) // inputs[0] : 헤더에 검색 입력창
//	let data = {
//		btitle : inputs[1].value , 	
//		bcontent : inputs[2].value
//	}
//	console.log( data )
//	$.ajax({
//		url : "http://localhost:8080/jspweb/board/write" ,
//		data : data ,
//		success : function ( re ){
//			if( re === 'true'){ alert('글등록'); location.href="list.jsp"}
//			else{ alert('글등록실패') }
//		 }
//	})
}

/*
	let 객체 = { 속성명 : 데이터 , 속성명 : 데이터 ~~ }
*/

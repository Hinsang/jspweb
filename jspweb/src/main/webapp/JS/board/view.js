bview()

function bview(){
	$.ajax({
		url : "/jspweb/board/view" , 
		async : false ,	/* 동기식 */
		success : function( re ){ 
			let board  = JSON.parse( re )
			console.log( board )
			document.querySelector('.bno').innerHTML = board.bno;
			document.querySelector('.btitle').innerHTML = board.btitle;
			document.querySelector('.bcontent').innerHTML = board.bcontent;
			document.querySelector('.mid').innerHTML = board.mid;
			/* 절대경로 : 				http://localhost:8080/jspweb/board/filedown */
			/* 상대경로 : 현재 위치 기준[ http://localhost:8080/jspweb/js/view.js ]
						../board/filedown
			 */
			 /*
			 	<a href="URL?변수명=데이터">	: get메소드로 해당 URL 데이터 전송가능 
			 	'<a href="URL?변수명='+변수+'">'
			 */
			console.log( board.bfile )
			
			if( board.bfile !== null ){	// null , undefined , 0 , false
				let filelink = '<a href="../board/filedown?bfile='+board.bfile+'">'+board.bfile+'</a>'
				// ' ' : 전체 문자열 처리
				// " " : 전체 문자열내 문자열 구분  
				document.querySelector('.bfile').innerHTML = filelink;
			}
			
			console.log( board.btnaction )
			let btnbox = document.querySelector('.btnbox')
			
			if( board.btnaction == true ){
				// 삭제 버튼 활성화
				let deletebtn = '<button onclick="bdelete('+board.bno+')"> 삭제 </button>'
				btnbox.innerHTML += deletebtn;
				// 수정 버튼 활성화 
				let updatebtn = '<button><a href="../board/update.jsp">수정</a></button>'
				btnbox.innerHTML += updatebtn;
			}

		}
	})
	////////////////// 댓글출력 ///////////////////
	rlist()
	
}
function bdelete( bno ){ // 삭제 버튼 클릭시 삭제할 번호를 인수[식별]
	$.ajax({
		url : "/jspweb/board/delete" , 
		data : { "bno" : bno } , // 삭제할 게시물의 식별번호[pk->bno]
		success : function( re ){
			if( re === 'true'){
				alert('글삭제 성공 ');
				location.href="../board/list.jsp"
			}
			else{ alert('글삭제 실패 : [관리자에게문의]') }
		}
	})
}

function rwrite(){
	let rcontent = document.querySelector(".rcontent").value;
	$.ajax({
		url : "/jspweb/reply/rwrite" ,
		data : {"rcontent" :  rcontent, "type" : "reply" } , 
		type : "POST" , /* HTTP 메소드 : 1.GET방식=기본값 2. POST방식 */
		success : function( re ){
			 if( re == 1 ){
				alert('댓글작성') // location.reload();
				rlist()
			}else if( re == 0){
				alert('로그인후 작성가능합니다.')
				location.href='../member/login.jsp'
			}else{
				alert('댓글실패')
			}
		}
	})
}

// 댓글들의 리스트 호출 함수
function rlist(){
	$.ajax({
		url : "/jspweb/reply/rlist" ,
		data : { "type" : "reply" } ,	// type : reply 댓글용
		success : function(re){
			let replylist = JSON.parse(re)
			let html = ''
			for( let i = 0 ; i<replylist.length ; i++){
				let reply = replylist[i]
				
				// 대댓글 호출 = rno ----> rindex
				$.ajax({
					url : "/jspweb/reply/rlist" ,
					data : { "type" : "rereply" , "rno" : reply.rno }, // type : rereply 대댓글용
					async : false, /* 동기식 */
					success : function(re) {
						let rereplylist = JSON.parse(re)
						
						html += '<div>'+
							'<span>'+reply.rcontent+' &nbsp;&nbsp;</sapn>'+
							'<span>'+reply.rdate+' &nbsp;&nbsp;</sapn>'+
							'<span>'+reply.mid+' &nbsp;&nbsp;</sapn>'+
							'<button type="button" onclick="rereplyview('+reply.rno+')">답글</button>'+
							'<div class="reply'+reply.rno+'"></div>';	// 댓글마다 사용되는 구역
							
						for(let j = 0 ; j<rereplylist.length ; j++) {
							let rereply = rereplylist[j]
							html += '<div style="margin : 20px;">'+
										'<span>'+rereply.rcontent+' &nbsp;&nbsp;</sapn>'+
										'<span>'+rereply.rdate+' &nbsp;&nbsp;</sapn>'+
										'<span>'+rereply.mid+' &nbsp;&nbsp;</sapn>'+
									'</div>';
						}
							
						html += '</div>';
					}
				})
				
			}
			document.querySelector('.replylist').innerHTML = html;
			
		}
	})
}
function rereplyview( rno ) {
	let replydiv = document.querySelector('.reply'+rno)
	replydiv.innerHTML = '<input type="text" class="rerecontent'+rno+'"><button onclick="rereplywrite('+rno+')">답글작성</button>'
}
// 대댓글 작성
function rereplywrite( rno ) {
	let rcontent = document.querySelector('.rerecontent'+rno).value
	$.ajax({
		url : "/jspweb/reply/rwrite",
		data : {"rcontent" : rcontent, "rno" : rno, "type" : "rereply"},
		type: "POST",
		success : function(re) {
			if( re == 1 ){
				alert('답글 작성') // location.reload();
				rlist()
			}else if( re == 0){
				alert('로그인후 작성가능합니다.')
				location.href='../member/login.jsp'
			}else{
				alert('답글 실패')
			}
		}
	})
}

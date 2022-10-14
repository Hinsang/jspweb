bview()

function bview(){
	$.ajax({
		url : "http://localhost:8080/jspweb/board/view" , 
		success : function( re ){ 
			let board  = JSON.parse( re )
			console.log( board )
			document.querySelector('.bno').innerHTML = board.bno;
			document.querySelector('.btitle').innerHTML = board.btitle;
			document.querySelector('.bcontent').innerHTML = board.bcontent;
			document.querySelector('.mid').innerHTML = board.mid;
			
			/*
				<a href="URL?변수명=데이터"> : get메소드로 해당 URL 데이터 전송가능
				<a href="URL?변수명='+변수명+'">
			*/
			console.log(board.bfile)
			
			if(board.bfile !== null) {	// null, undefined, 0, false
				let filelink = '<a href="../board/filedown?bfile='+ board.bfile +'">' + board.bfile +'</a>'
				document.querySelector('.bfile').innerHTML = filelink;
			}
			console.log(board.btnaction)
			let btnbox = document.querySelector(".btnbox")
			
			if(board.btnaction === true) {
				// 삭제 버튼 활성화
				let deletebtn = '<button onclick="bdelete('+board.bno+')">삭제</button>'
				btnbox.innerHTML += deletebtn;
				// 수정 버튼 활성화
				let updatebtn = ' <button><a href="../board/update.jsp">수정</a></button>'
				btnbox.innerHTML += updatebtn;
			}
			
		}
	})
}

function bdelete( bno ){
	// let bno = document.querySelector(".bno").value;
	$.ajax({
		url : "/jspweb/board/delete",
		data : { "bno" : bno },
		success : function( re ) {
			if(re === "true") {
				alert("삭제성공!!");
				location.href="../board/list.jsp";
			} else {
				alert("삭제실패!!");				
			}
		}
	})
}

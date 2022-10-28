getproduct()
// 모든 제품 호출 메소드
function getproduct() {
	$.ajax({
		url: "/jspweb/admin/regist",
		data: { "type" : 1, "option" : "all" },
		type: "get",
		success: function(re) {
			let json = JSON.parse(re)
			//let img = "/jspweb/admin/pimg/"+json[0].pimg
			//let html = '<img src="'+img+'">'
			//document.querySelector('table').innerHTML = html;
			let html = '';
			for(let i = 0 ; i<json.length ; i++) {
				
				let img = "/jspweb/admin/pimg/"+json[i].pimg
				let discount = json[i].pprice*json[i].pdiscount
				console.log(discount)
				
				html += '<tr>' +
							'<td><img style="width:100px; height:100px;" src="'+img+'"></td>'+
							'<td>'+json[i].pno+'</td>'+
							'<td>'+json[i].pcno+'</td>'+
							'<td>'+json[i].pname+'</td>'+
							'<td>'+json[i].pprice+'</td>'+
							'<td>'+json[i].pdiscount+'</td>'+
							'<td>'+discount+'</td>'+
							'<td>'+json[i].pactive+'</td>'+
							'<td>'+json[i].pdate+'</td>'+
							'<td>' +
								'<button type="button" onclick="updatemodal('+json[i].pno+')">수정</button>' +
								'<button type="button" onclick="deleteproduct('+json[i].pno+')">삭제</button>' +
							'</td>' +
						'</tr>'
						
			}
			document.querySelector('table').innerHTML += html;
		}
	})
}

// 모달 열어주는 함수
function updatemodal( pno ) {
	document.querySelector('.updatemodalhtn').click() // 해당 버튼을 클릭하는 이벤트 설정
	
	$.ajax({
		url : "/jspweb/admin/regist",
		data : { "type" : 2, "pno" : pno }, // 타입이 2이면 모든 제품 호출
		type : "get",
		success : function(re) {
			let json = JSON.parse(re)
			
			console.log(json)
			
			document.querySelector('.pno').value = json.pno
			document.querySelector('.pname').value = json.pname
			document.querySelector('.pcomment').value = json.pcomment
			document.querySelector('.pprice').value = json.pprice
			document.querySelector('.pdiscount').value = json.pdiscount
			document.querySelector('.pcno').value = json.pcno
			document.querySelector('.pimgbox').innerHTML = json.pimg

		}
	})
}

// 모달 버튼실행 함수
function updateproduct(){
	
	// 수정할 정보
	let form = document.querySelector('.updateform')
	// 수정할 내용
	let formdata = new FormData(form)
		// formdata 속성 추가
		// formdata.set('속성명' : 데이터)

	// 수정할 대상
		// formdata.set('pno')
	
	$.ajax({
		url : "/jspweb/admin/regist",
		type : "put",
		data: formdata,
		processData : false,
		contentType : false,
		success : function(re) {
			if(re === 'true'){				
				alert("수정성공!!")
				document.querySelector(".modelclosebtn").click()
				pagechange('list.jsp')
			} else {
				alert("수정실패!!")
			}
		}
	})
}

function deleteproduct(pno) {
	if( confirm("정말 삭제하시겠습니까?") ){
		
		$.ajax({
			url: "/jspweb/admin/regist",
			data : {"pno" : pno}, // 톰캣 서버의 기본설정값은 get, post 방식만 객체전송
			// Servers 프로젝트 폴더 클릭 -> server.xml -> 63번째줄 정도
			// 이렇게 타입을 추가해준다. <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" parseBodyMethods="GET,POST,PUT,DELETE"/>
			type: "delete", // server.xml에 추가된 delte메소드로 통신
			success: function(re){
				alert( re );
				pagechange('list.jsp')
				if(re === 'true') {
					alert('삭제성공!!')
					
					
					// pagechange() : dashboard.jsp내 dashboard.js가 포함되어 있기때문에 호출이 가능하다.
						// 현재 구조상 dashboard.jsp내 특정태그에 list.jsp 포함
				} else {
					alert('삭제실패')
				}
			}
		})
		
	}
}



















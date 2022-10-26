getproduct()
// 모든 제품 호출 메소드
function getproduct() {
	$.ajax({
		url: "/jspweb/admin/regist",
		type: "get",
		success: function(re) {
			let json = JSON.parse(re)
			//let img = "/jspweb/admin/pimg/"+json[0].pimg
			//let html = '<img src="'+img+'">'
			//document.querySelector('table').innerHTML = html;
			
			for(let i = 0 ; i<json.length ; i++) {
				
				let img = "/jspweb/admin/pimg/"+json[i].pimg
				let discount = json[i].pprice*json[i].pdiscount
				console.log(discount)
				
				html = '<tr>' +
							'<td><img style="width: 100px; height:60px;" src="'+img+'"></td>'+
							'<td>'+json[i].pno+'</td>'+
							'<td>'+json[i].pcno+'</td>'+
							'<td>'+json[i].pname+'</td>'+
							'<td>'+json[i].pprice+'</td>'+
							'<td>'+json[i].pdiscount+'</td>'+
							'<td>'+discount+'</td>'+
							'<td>'+json[i].pactive+'</td>'+
							'<td>'+json[i].pdate+'</td>'+
						'</tr>'
						
				document.querySelector('table').innerHTML += html;
			}
		}
	})
}

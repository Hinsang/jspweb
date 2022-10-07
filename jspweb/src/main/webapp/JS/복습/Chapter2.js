console.log("가나다라")
console.log('가나다라')
console.log("가나"+"다라")
console.log("가나다라".length)
console.log( 273 )
console.log( 273.275 )

const pi = 3.141592
console.log(pi)

let pi2 = 3.141592
console.log(pi2)
pi2 = 4.14

/*
	문제1 : 지폐 세기
		조건 : 금액 입력받아
		출력 : console.log에 아래와 같이 출력
			십만원 3장
			만원 2장
			천원 1장
			백원 0개
*/

let 금액 = Number(prompt("금액 : "));
let 십만원 = parseInt(금액/100000) // parseInt(숫자) : 정수로 변환

console.log("10만원권은 "+ 십만원 + "개 입니다.")

금액 -= 십만원 * 100000;
let 만원 = parseInt(금액/10000);

console.log("1만원권은 "+ 만원 + "개 입니다.")

금액 -= 만원 * 10000;
let 천원 = parseInt(금액/1000);

console.log("1천원권은 "+ 천원 + "개 입니다.")

금액 -= 천원 * 1000;
let 백원 = parseInt(금액/100);
console.log("100원은 "+ 백원 + "개 입니다.")

//
let 정수1 = Number( prompt('정수1 : ') )
console.log('홀수 여부 : ' + (정수1%2 === 1))
//
let 정수2 = Number( prompt('정수2 : ') )
console.log('7배수 여부 : ' + (정수2%7 === 0))


















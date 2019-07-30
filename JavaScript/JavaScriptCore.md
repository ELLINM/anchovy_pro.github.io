Java Script
=======
+ 컴파일 없이 인터프리터로 인해 한 행씩 실행되는 언어


코드 작성
------
+ HTML head 태그 또는 body 태그 내부에  script 태그 작성
> head 태그 내부에 script 태그를 작성하는 것이 일반적
  script 태그 내부에 javascript 코드 작성


+ JavaScript 의 주석은 Java 와 같음
>「//」,「/* */」


+ 변수명, 메서드명 선언 규칙은 Java  와 동일
> 키워드 사용 금지
  숫자로 시작 금지
  특수 문자는 $ 또는 _ 만 허용
  공백 문자를 포함할 수 없음


+ 코드의 마지막「;」은 강제는 아니지만 붙이는 것이 좋음


선언
------
+ var␣변수명
> 데이터 타입을 지정하지 않고 var 로 통일


+ 변수 선언 후, 값을 초기화 하지 않으면 undefined 를 가짐
> 자바에서 필드에 해당하는 것이 global variable
  자바에서 지역 변수에 해당하는 것이 local variable


Data Type
------
+ String
> 문자열 자료형 
  자바와 달리 문자, 문자열의 구분이 없음 「’」또는 「”」으로 표현


+ Number
> 숫자 자료형 정수, 유리수 모두 포함


+ NaN
> NaN(Not a Number) -> 숫자로 나타낼 수 없는 데이터, 보통 숫자로 나타낼 수 없는 데이터를 형 변환 했을 때 반환되는 속성값
  NaN 을 비교 판단하기 위해서는 isNaN 함수를 호출


+ Boolean
> true, false 를 표현하는 자료형
  자바와 동일한 비교,논리 연산자를 사용하여 true , false 를 반환 받을 수 있음
  비교 연산자가 여러 개 있을 경우, 왼쪽부터 차례대로 연산함
  true 를 1, false 를 0 으로 표현하기도 함


+ undefined
> 선언하지 않은 변수, 초기화 하지 않은 변수


+ null
> 아무것도 참조하고 있지 않음을 의미
  null은 아무런 값도 나타내지 않음을 의미하도록 의도적으로 집어넣은 것
  아무런 값이 대입되지 않음을 뜻하는 undefined 와는 다름


+ javascript 는 기본값이 없음
> 기본형 데이터인 string, number, bool 은 자바의 래퍼클래스와 마찬가지로 String, Number, Boolean 과 같은 클래스가 존재
  기본형 데이터인 string, number, bool 에서 메서드 호출이 가능한 이유 -> 기본형 데이터를 해당 참조형 객체로 자동 형 변환 해줌
  undefined 는 등가비교연산자 == 로 판단 가능


+ 참조형
> Object / Array / Function


String
-----
+ property
> length	: 문자열의 길이

+ global method
> String(arg)	: 매개변수의 데이터를 문자열로 변환하여 반환


String object method
-------
+ charAt(number) : 매개변수 위치의 문자 반환

+ concat(string) : 매개변수의 문자열을 결합하여 반환

+ indexOf(string[, number])	: string 과 일치하는 문자열의 위치를 반환
> 첫 번째로 일치하는 문자열의 위치만 반환 매개변수로 전달한 문자열이 존재하지 않을 경우, -1 반환

+ lastIndexOf(string[, number]) : 뒤에서부터 string 과 일치하는 문자열의 위치를 반환
> indexOf와 같은 값을 반환

+ slice([startidx, endidx])	: startidx, endidx 사이에 위치하는 문자열 반환
> 두 번째 매개변수 만큼 문자를 추출하고 첫 번째 매개변수 만큼 잘라냄

+ split([string, number])	: string 을 기준으로 문자열을 분리하여 배열로 반환
> 첫 번째 매개변수를 기준으로 문자열을 분리하여 두 번째 매개변수 만큼 요소를 담은 배열을 반환

+ search(regExp) : 앞에서부터 정규표현과 일치하는 문자열의 위치를 반환

+ toLowerCase() : 모든 문자열을 소문자로 변환 후 반환

+ toUpperCase() : 모든 문자열을 대문자로 변환 후 반환

+ replace(regExp, string) : 첫 번째 매개변수로 전달한 문자열(또는 정규표현)에 해당하는 문자열을 두 번째 매개변수로 변환한 문자열을 반환


Number global method
------
+ Number(string) : string 을 number 로 변환하여 반환

+ parseInt(string[, number]) : string 을 number 로 변환하여 반환

+ parseFloat(string) : string 을 number 로 변환하여 반환

+ Number(string[, number]) : 매개변수의 데이터가 number 로 변환 불가능할 경우, NaN 을 반환

+ parseInt(string, radix) : 매개변수의 데이터가 number 로 변환 불가능할 경우, NaN 을 반환
> 소수점 이하 버림
  첫 번째 매개변수에 해당하는 기수를 두 번째 매개변수로 전달, 10진수로 반환
  ex) parseInt(“11”, 2)	-> 2진수 11을 10진수로 변환하여 반환(3이 반환됨)
  두 번째 매개변수를 전달하지 않을 경우, 10진수로 처리함

+parseFloat(string) : 매개변수의 데이터가 소수일 경우, 소수형 number 로 변환하여 반환

+ number 관련 함수
> isNaN(arg)	: 매개변수로 전달받은 데이터가 NaN 일 경우 true를 반환(NaN은 등가 비교 연산자 == 로 비교할 수 없음)


Object
-----
+ HashMap과 비슷하게 사용
+ 참조형 데이터
+ name 과 value 를 쌍으로 이루는 요소를 가짐

+ 선언
> {}
  { name : value, name : value, ...}
  new Object();
  new Object(arg)

+ Object method
> keys(arg)	: 매개변수로 전달한 object 의 모든 name 값을 배열로 반환


Array
----
+ 참조형 데이터
+ 자바의 Object 배열 처럼 모든 타입의 데이터를 요소로 가질 수 있음
+ 크기가 유동적으로 변함
+ index 번호로 요소에 접근
  index 번호로 요소 추가 가능
  ex) <pre>var arr = [1,2,3];	// 배열 선언
       arr[5] = 9;		// 인덱스 5번에 숫자 9 추가 -> [1,2,3,,,9]</pre>

+ 선언
> [arg, arg, arg, ...] : 전달한 데이터를 요소로 갖는 배열을 생성
  new Array() : 빈 배열을 생성
  new Array(number) : number 만큼의 크기를 갖는 배열 생성(빈 요소에는 undefined가 들어감)
  new Array(arg, arg, arg, ...)	: 매개변수로 전달한 데이터를 요소로 갖는 배열을 생성

+ property
> length	: 배열이 가진 요소의 수


Array object method
------
+ pop() : 마지막 부분의 요소를 반환하고 삭제함 (사용↑)
+ push(arg)	: 매개변수로 전달한 값을 마지막 부분에 추가하고 새로운 배열의 길이를 반환 (사용↑)
+ shift()	: 가장 앞부분의 요소를 반환하고 삭제함
+ unshift(arg) : 매개변수로 전달한 값을 가장 앞부분에 추가하고 새로운 배열의 길이를 반환
+ indexOf(arg) : 매개변수로 전달한 값이 첫 번째로 검색된 인덱스 번호를 반환(앞에서부터 검색하며 존재하지 않을 경우, -1) (사용↑)
+ sort() : 요소를 정렬함 (사용↑)
+ reverse() : 요소의 위치를 반전
+ join(arg)	: 요소를 문자열로 반환, 매개변수로 전달한 값을 각 요소의 구분자로 연결함
+ forEach(callback)	: 매개변수로 전달한 함수를 요소 수 만큼 호출, 콜백 함수 에는 3가지 매개변수(배열의 요소, 인덱스 번호, 배열)가 전달됨 (사용↑)
	ex) <pre>var arr = [1, 2, 3];
	arr.forEach(function(element, index, array) {
	alert(element);		// 1, 2, 3이 차례대로 출력됨
  });</pre>


반복문
-----
+ for(var i=0; i<10; i++) {...}
+ for(var i in [‘a’, ‘b’, ‘c’, ‘d’]) {alert(i); }
> for in 반복문 주의사항
<pre>for (var i in [‘a’, ‘b’, ‘c’, ‘d’]) {
	alert(i);
  //0,1,2,3으로 출력됨
}</pre>
> 위 코드에서 i 는 배열의 요소가 아닌, index



연산자
------
+ 산술 연산자
> +, -, *, **, /, %

+ 대입 연산자
> 변수에 값이나 연산 결과를 저장
  =, +=, -=, *=, /=, %=, **=

+ 증감 연산자
> 변수의 값을 1씩 증가 또는 1씩 감소
>  ++, --

+ 비교 연산자
> 두 피연산자를 비교하여 결과값으로 boolean 타입을 반환
> >, <, >=, <=, ==, !=, ===, !== 

+ 삼항 연산자
> 관계식이 참이면 첫 번째 문장을, 거짓이면 두 번째 문장의 실행 결과를 반환
> 관계식 ? 문장1 : 문장2;

+ 산술 연산자
> ** -> 거듭 제곱 (ECMA7 에서 사용가능)
 「+」 연산자를 제외한 모든 연산자는 문자열을 숫자형으로 변환함
 「+」 연산자로 숫자형 데이터와 문자열 데이터를 연산할 경우, 숫자형 데이터를 문자열로 변환(연산은 왼쪽에서 오른쪽으로 처리됨)

+ 대입 연산자
> **= (ECMA7 에서 사용가능)

+ 비교연산자
+ === -> 자료형과 값 모두 같으면 true
+ !== -> 자료형 또는 값 하나라도 다를 경우 true


입출력
-----
+ prompt() 함수 : 첫 번째 매개변수를 메시지로 출력, 입력받은 값을 문자열로 반환
+ confirm() 함수 : 매개변수로 전달한 값을 메시지로 출력, 클릭한 버튼에 따라 true, false 를 반환
+ alert() 함수 : 매개변수로 전달한 값을 문자열로 변환하여 출력
+ alert(arg) 함수 : 매개변수에는 이스케이프 문자를 사용할 수 있음


자료형 검사
----
+ typeof : (데이터) 단항 연산자의 하나
> 데이터의 자료형을 문자열로 반환


함수
-----
+ 코드의 집합으로 이루어진 기능
+ 선언적 함수
+ 익명 함수

+ 함수
> 자바의 메서드와 비슷, 함수의 매개변수로 함수를 전달할 수 있음(매개변수로 전달된 함수를 콜백 함수 라고 표현)

+ 클로저 : 함수 내부에 선언된 내부함수는 외부 함수의 자원(변수, 함수)를 사용할 수 있음
ex)
<pre>function outer () {
	var count = 0;
    var inner = function () {
    	return ++count;
    };
    return inner; // 익명함수의 주소값을 반환
}</pre>

> var increase = outer(); // outer 함수를 호출 결과는 익명 함수의 주소값을 반환
  alert(increase());	// 1 출력
  alert(increase());	// 2 출력(increase 변수에 동일한 익명 함수의 객체 주소가 보관돼 있으므로 2가 출력됨)


선언적 함수
----
+ 함수명을 갖는 함수
+ 매개변수 생략가능
+ 매개변수 지정시, var 키워드 없이 변수명만 기입
+ 매개변수 지정은 매개변수로 전달한 값을 함수 내부에서 변수명으로 호출하기 위한 상징적 의미
  (매개변수를 지정하지 않아도 함수 호출시, 매개변수 전달 가능 / 지정된 매개변수 이상의 데이터 전달 가능 -> arguments 라는 property로 접근 가능)
  (arguments 는 배열과 비슷한 형식으로 인덱스 번호로 요소에 접근 하지만 배열은 아님 -> 배열의 메서드 사용 불가, length 요소는 사용 가능)
+ 자바와 달리 반환형을 선언하지 않음
+ 함수 호출 결과로 값을 반환할 경우, return 키워드를 사용
+ 함수 내부에서 또 다른 함수를 선언 가능


익명 함수(arrow functions)
--------
+ 함수명을 갖지 않는 함수
+ 변수는 함수를 담을 수 있음(정확히는 함수의 주소)
ex)
<pre>var test = function() { alert(“test”); }
test();		// test 가 출력됨</pre>

+ 선언적 함수가 먼저 생성되고 익명 함수가 생성됨
ex)
<pre>var test = function() { alert(2); }
fucntion test() { alert(1); }
test();		// 2가 출력됨</pre>

+ javascript 는 선언적 함수를 먼저 생성하고 나머지 코드를 순서대로 로딩함
ex)
<pre>test();		// 1이 출력됨
var test = function() { alert(2); }
function test() { alert(1); }</pre>


내장 함수
----
+ 별도의 import 없이 사용할 수 있는 함수

+ setTimeout(func, millisecond) : millisecond 후, func 를 한 번 실행
+ setInterval(func, millisecond) : millisecond 마다, func 를 실행
> setTimeout 과 setInterval 호출 시, 타이머 아이디를 반환함

+ clearTimeout(id) : 특정 setTimeout 의 호출을 중지
+ clearInterval(id) : 특정 setInterval 의 호출을 중지
> clearTImeout 또는 clearInterval 함수의 매개변수에 타이머 아이디를 전달

+ eval(string) : string 을 자바스크립트로 실행
+ isNaN(value) : 해당 데이터가 NaN 일 경우 true 를 반환
+ parseInt(string) : string 을 정수로 변환하여 반환

> 문자열을 정수로 변환하는 함수는 Number 와 parseInt 가 있음
  parseInt 는 매개변수로 전달받은 문자열이 앞에서부터 숫자로 변환 가능한 범위까지 바꿔줌
  Number 는 매개변수로 전달받은 문자열에 숫자로 변환 불가능한 값이 하나라도 존재할 경우, NaN 을 반환
  ex)
  parseInt(‘123abc’)	// 123 반환
  Number(‘123abc’)	// NaN 반환
  parseInt(‘abc123’)	// NaN 반환




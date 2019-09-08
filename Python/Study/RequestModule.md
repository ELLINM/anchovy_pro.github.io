Requests Module
=====
+ Http 요청을 보내는 Module
+ 연결 풀링은 자동


기능
------
+ 연결 유지 및 연결 풀링
+ 국제 도메인 및 URL
+ 쿠키 지속성이있는 세션
+ 브라우저 스타일 SSL 확인
+ 자동 컨텐츠 디코딩
+ 기본 / 다이제스트 인증
+ 우아한 키 / 값 쿠키
+ 자동 감압
+ 유니 코드 응답 바디
+ HTTP (S) 프록시 지원
+ 멀티 파트 파일 업로드
+ 스트리밍 다운로드
+ 연결 시간 초과
+ 청크 요청
+ .netrc 지원하다


사용 방법
-----
+ Basic
<pre>
import requests 
URL = 'adress' 
response = requests.get(URL) 
response.status_code response.text
</pre>
  웹브라우져에서  접속한 것과 똑같음
  주소로 GET 요청(request)를 보냄 ->
  서버에서는 그 요청을 받아 뭔가를 처리한 후 요청자에게 응답(response)
  응답은 HTML 코드로 옴
  
+ GET 요청시 parameter전달법
<pre>
params = {'param1': 'value1', 'param2': 'value'} 
res = requests.get(URL, params=params)
</pre>
  응답 객체인 res를 통해서 실제로 던진 URL이 뭔지 확인
  URL과 파라미터를 requests 모듈이 엮어서 적절한 새로운 요청
  URL을 저렇게 타이핑하는 것보다 파라미터를 딕셔너리 형식으로 정리하고 requests 모듈에 던져주는 형식


+ POST 요청시 data 전달
<pre>
import requests, json
data = {'outer': {'inner': 'value'}}
res = requests.post(URL, data=json.dumps(data))
</pre>
  조금 더 복잡한 구조로 POST 요청을 해야 할 때 딕셔너리의 구조를 유지하면서 문자열로 바꿔서 전달
  python에서 json 모듈 사용


+ Header, Cookie 추가
<pre>
headers = {'Content-Type': 'application/json; charset=utf-8'} 
cookies = {'session_id': 'sorryidontcare'} 
res = requests.get(URL, headers=headers, cookies=cookies)
</pre>
  별도의 헤더 옵션을 추가하고자 할 때는 headers 옵션
  쿠키를 심어서 요청을 보내고 싶으면 cookies 옵션
  
  
+ Response 객체
Python 객체로 응답을 받음 

|종류|기능|
|----|----|
|res.request|클라이언트가 보낸 request 객체에 접근|
|res.status_code|응답코드|
|res.raise_for_status()|200 OK 코드가 아닌 경우 에러 발동|
|res.json()|json response일 경우 딕셔너리 타입으로 바로 변환|

etc)
res.apparent_encoding
res.close
res.connection
res.content
res.cookies
res.elapsed
res.encoding
res.headers
res.history
res.is_permanent_redirect
res.is_redirect
res.iter_content
res.iter_lines
res.links
res.ok
res.raise_for_status
res.raw
res.reason
res.text (불러온 html 정보)
res.url (요청한 url 정보)


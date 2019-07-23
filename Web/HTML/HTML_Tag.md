Tag
========
+ padding : 안에있는 영역을 유지하면서 그외의 영역을 늘리는것  
+ margin : padding밖에 간격을 조정 상하좌우 지시한 영역만큼 magin이 생김  
> top, bottom, left,right로 각각 원하는 곳에 padding, magin생성 가능  
+ boarder : 영역을 나누는 선    
+ font-size : 글자의 크기를 정해주는 것 (header tag가 없다면 일반적인 상태에서 크기가 변형 header tag로 자유롭게 변경 가능)    
+ color : 글자의 색을 정해주는 것 (color picker)로 color code확인    
+ float : 지정한 요소의 배치를 지정 text-align보다 자주 사용됨  
+ text-align : text의 위치를 지정    
+ form : 서버로 전송하는 값을 입력  
+ action : 서버에 어떤 요청을 할것인가에 대한 값 필수적으로 사용  
+ method : get, post 둘 중하나를 선택, 기본적으로 사용됨  
+ get : 조회 값을 가지고 오는것에 사용함, url에 어떠한 전송값이 남는지 보여줌  
ex)  
> http://www.inven.co.kr/board/lol/2766?sort=PID&p=5  
                             action 값 ?까지 / get값  
+ post : 값을 수정할때 사용  
+ input : 사용자가 보내는 값  
+ name : 사용자를 구분하는 값  
+ type : input에 사용되는 데이터 종류의 구분   
> submit, date, email, file, number 등 다양하게 있지만 브라우저마다 호환이 달라서 사용하지 않고 text로 받아서 자바로 유효성검사를 함  


textarea
------
|tag|use|contents|
|----|----|----|
|cols|숫자|텍스트 영역이 보이는 너비 기본값 : 20|
|rows|숫자|텍스트 영역에서 보이는 줄의 개수 기본값 : 2|
|disabled|disabled|텍스트 영역이 비활성화|
|name|text|텍스트 영역의 이름|
|readonly|readonly|텍스트 영역이 읽기만 가능함|
|autofocus|autofocus|텍스트 영역이 자동으로 포커스됨|
|form|form_id|<textarea>요소가 속한 form 요소를 지정 속성값은 <form>요소의 id속성이 되어야함|
|maxlenght|숫자|텍스트 영역에서 허락된 문자의 최대 숫자|
|placeholder|text|텍스츠 영역의 예상값을 설명하는 짧은 힌트 영역이 비면 나타나고, 영역이 포커스 되면 사라짐|
|required|required|텍스트 입력이 필수임을 나타냄|
|wrap|hard/soft|텍스트 줄바꿈 지정 기본값 : 줄바꿈 되지 않음, 줄바꿈 됨 p.s : hard를 사용하려면 cols속성이 지정되어야함|

form Tag
------
+ method, action, enctype 등은 입력받은 데이터를 어떻게 처리할 것인지 세부적으로 설정
+ method는 전송 방식
+ action은 전송 목적지
+ enctype은 전송되는 데이터 형식을 설정
 

enctype
------
|Type|Content|
|----|-----|
|application/www-form-urlencoded|디폴트값 enctype을 따로 설정하지 않으면 이 값이 설정 FormData는 서버로 전송되기 전에 URL-Encode 됨|
|multipart/form-data|파일이나 이미지를 서버로 전송할 경우 이 방식을 사용|
|text/plain|이 형식은 인코딩을 하지 않은 문자 상태로 전송|

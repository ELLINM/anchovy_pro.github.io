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

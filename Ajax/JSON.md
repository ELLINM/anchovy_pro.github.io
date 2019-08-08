JSON (JavaScript Object Notation)
==========
+ 경량의 DATA-교환 형식 : 사람이 읽고 쓰기에 용이, 기계가 분석하고 생성함에도 용이
+ 언어로 부터 독립적이지만 프로그래머들에게 친숙한 관습을 사용하는 텍스트 형식
+ 두개의 기본 구조
  + name/value 형태의 쌍으로 collection 타입
    다양한 언어들에서, 이는 object, record, struct(구조체), dictionary, hash table, 키가 있는 list, 또는 연상배열로서 실현

  + 값들의 순서화된 리스트. 대부분의 언어들에서, 이는 array, vector, list, 또는 sequence로서 실현


JSON 형식
------
+ object는 name/value 쌍들의 비순서화된 SET    
  object는 {좌 중괄호로 시작하고 }우 중괄호로 끝내어 표현      
  각 name 뒤에 :colon을 붙이고 ,comma로 name/value 쌍들 간을 구분
+ array은 값들의 순서화된 collection      
  array는 [left bracket로 시작해서 ]right bracket로 끝내어 표현     
  ,comma로 array의 값들을 구분
+ value는 큰따옴표안에 string, number ,true ,false , null, object ,array이 올수 있다. 이러한 구조들을 포함
+ string은 큰따옴표안에 둘러 싸인 zero 이상 Unicode 문자들의 조합 쌍다옴표안에 감싸지며,backslash escape가 적용 
+ 하나의 문자(character)도 하나의 문자열(character string)로서 표현 string은 C 또는 Java 문자열 처럼 매우 많이 비슷
+ number는 8진수와 16진수 형식을 사용하지 않는것을 제외하면 C와 Java number 처럼 매우 많이 비슷
+ 토근들의 어떤 쌍 사이에 공백을 삽입할수 있다. 드물게 encode된 세부 항목을 제외하면, 이렇게 설명된 JSON의 형식은 완벽하게 그 언어를 설명



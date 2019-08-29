Decorator Pattern
=====
+ 원래 코드는 전혀 바꾸지 않고도 다른 사람이 만든 객체에 새로운 임무를 부여할 수 있음
+ 객체에 추가적인 요건을 동적으로 첨가
+ Decorator는 SubClass를 만드는 것을 통해서 기능을 유연하게 확장 할 수 있는 방법을 제공
> Sub Class를 만드는 경우에 비해 훨신 유연하게 기능을 확장 할 수 있음

OCP(Open-closed-Principle)
------
+ Class는 확장에 대해서는 열려 있어야하지만 Code변경에 대해서는 닫혀 있어야 함


java.io
-----
+ FileInputStream
  :Decorator로 포장될 구성 요소, 데이터를 읽어 들일 수 있게 해주는 기본 구성 욧 역할
+ BufferrdInputStream
  :구상 Decorator 
   속도를 향상 시키기 위해 입력된 내용을 버퍼에 저장
   문자로 입력된 내용을 한번에 한 줄씩 읽어 들이기 위한 readLine() Method가 들어있는 Interface를 구현
+ LineNunberInputStream
  :구상 Decorator 데이터를 읽을때 행번호를 붙여주는 기능을 추가


Decorator Pattern 특징
------
+ 구상 구성요소를 감사주는 Decorator들을 사용
+ Decorator Class의 형식은 Class가 감싸고 있는 Class 형식을 반영
+ Decorator에서는 자기가 감싸고 있는 구성요소의 Method를 호출한 결과에 새로운 기능을 더함으로써 행동을 확장
+ 구성요소를 감싸는 Decorator의 개수에는 제한이 없음
+ 구성요소의 클라이언트 입장에서는 Decorator의 존재를 알 수 없음 but 구체적인 형식에 의존하게 되는 경우는 제외
+ Decorator Pattern을 사용하면 자잘한 객체들이 매우 많이 추가 될 수 잇고, 너무 많이 사용하면 코드가 필요이상으로 

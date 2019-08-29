Decorator Pattern
=====
+ 원래 코드는 전혀 바꾸지 않고도 다른 사람이 만든 객체에 새로운 임무를 부여할 수 있음
+ 객체에 추가적인 요건을 동적으로 첨가
+ Decorator는 SubClass를 만드는 것을 통해서 기능을 유연하게 확장 할 수 있는 방법을 제공


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

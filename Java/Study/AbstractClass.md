AbstractClass
===========
+ Class 내에 일부 method가 구현되지 않고 interface만을 가진 형태의 method로 포함 되어 있을때 그 Class를 AbstractClass라고 부른다.
+ 일부 method가 미완성된 상태로 구현된 Class (AbstractMethod)


특징
---------
+ abstract 한 method가 하나 이상 포함되어 있으면 해당 Class는 Abstract Class로 선언되어야 한다.
+ abstract한 method가 없어도 Abstract Class로 선언할 수 없다.
+ new keyword를 이용해서 object를 생성할 수 없다.
+ Abstract Class 상속받는 Calss는 반드시 Abstract Class의 모든 Abstract Method를 overriding해야한다.


장점
---------
+ 반드시 overriding해야 한다는 강제성을 부여한다.
+ Class의 일관성을 줄 수 있다.


단점
--------
+ 수정단계에서 번거러움이 많아지면서 생산성이 떨어진다.


Abstract Method
----------
+ Abstract Method는 실체가 없는 empty method이다.
+ Parents Class 의 Method를 Childre Class가 반드시overriding 해야 할 때 사용 되며 {}대신 ;으로 내용을 대신한다.

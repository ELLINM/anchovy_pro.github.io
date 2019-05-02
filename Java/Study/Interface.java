Interface
=========
+ 100% Abstract Method로 이루어져 있음
+ 여러번 상속이 가능함
+ Class가 아니라 Interface로 존재함
+ implements로 다른 Class에 상속 시킬 수 있음


구조
<pre>[modifier]interface interface_name{
  [modifier]return_value method_name(argument);
}</pre>


장점
----------
+ 서로의 기능 구현 방법에 상관없이 작업할 수 있다. => 규격을 제공
> ex) 리모컨 => 제조사에 상관없이 어느 리모컨에서 같은 기능을 할 수 있음
+ Method만 구현 된다면 각 다른 Class에서는 호출만 하면 작성이 가능 동시 작업이 가능


Abstract Class와 차이점
----------
+ 다중 상속이 가능
+ 다중 상속에 대한 것을 구현
+ Children Class 간 공통점이 많다면 Abstract Class로 만드는것이 좋음
+ Interface로 만들면 getter, setter를 계속해서 만들어 줘야함
+ Interface는 Childre Class간 공통점이 적을때 사용하는 것이 

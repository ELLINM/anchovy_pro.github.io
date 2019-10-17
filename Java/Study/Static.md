Static?
=========


Static
---------------
+ 마법같은 단어 HeapMemry에 생성하지않고 사용할 수 있도록 해줌
+ 계속 사용하게 되면 Memory를 차지하게됨
+ 공유의 개념 = static 으로 설정하면 같은 곳의 메모리 주소만을 바라보기 때문에 static 변수의 값을 공유하게 되는 것


static의 특징
------
+ Class를 설계할 때, 멤버변수 중 모든 instance에 공통적으로 사용해야하는 것에 static을 붙임
  instance를 생성하면, 각 instance들은 서로 독립적기 때문에 서로 다른 값을 유지   
  경우에 따라서는 각 instance들이 공통적으로 같은 값이 유지되어야 하는 경우 static을 붙임
+ static이 붙은 MemberVariable는 instance를 생성하지 않아도 사용 가능   
  static이 붙은 MemberVariable(ClassVariable)는 Class가 Memory에 올라갈때 이미 자동적으로 생성되기 때문
+ static이 붙은 Method(Function)에서는 Instance Variable를 사용할 수 없음
  static이 Method는 Instance 생성 없이 호출가능한 반면, Instance Variable는 Instance를 생성해야만 존재하기 때문에   
  static이 붙은 Method(ClassMethod)를 호출할 때 Instance가 생성되어있을수도 그렇지 않을 수도 있어서 static이 붙은 Method에서     
  InstanceVariable의 사용을 허용하지 않음 (반대로, InstanceVariable나 InstanceMethod에서는 static이 붙은 멤버들을 사용하는 것이 언제나 가능   
  InstanceVariable가 존재한다는 것은 static이 붙은 Variable가 이미 Memory에 존재한다는 것을 의미)
+ Method 내에서 인스턴스 변수를 사용하지 않는다면, static을 붙이는 것을 고려    
  Method의 작업내용중에서 InstanceVariable를 필요로 한다면, static을 붙일 수 없음 반대로 InstanceVariable를 필요로 하지 않는다면,    
  가능하면 static을 붙이는 것이 좋음, Method 호출시간이 짧아지기 때문에 효율이 높아짐   
  (static을 안붙인 Method는 실행시 호출되어야할 Method를 찾는 과정이 추가적으로 필요하기 때문에 시간이 더 소비)
+ 클래스 설계시 static의 사용지침
  먼저 Class의 MemberVariable중 모든 Instance에 공통된 값을 유지해야하는 것이 있는지 살펴보고 있으면, static을 붙임   
  작성한 Method 중에서 InstanceVariable를 사용하지 않는 Method에 대해서 static을 붙일 것을 고려   

+ 일반적으로 InstanceVariable와 관련된 작업을 하는 Method는 InstanceMethod(static이 안붙은 Method)이고 
  static변수(클래스변수)와 관련된 작업을 하는 Method는 ClassMethod(static이 붙은 Method)

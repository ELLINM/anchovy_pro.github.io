Base
-----
+ abstraction(추상화)
+ encapsulation(캡슐화)
+ Polymorphism(다형성)
+ extends(상속)


Design Principle
----
+ Application에서 달라지는 부분을 찾아내고, 달라지지 않는 부분으로 부터 분리 시킨다.
+ 바뀌는 부분은 따로 뽑아서 캡슐화 시킨다 그렇게 하면 나중에 바뀌지 않는 부분에는 영향을 미치지 않은 채로 
  그 부분만 고치거나 확장 할 수 있다.
+ 구현이 아닌 인터페이스에 맞춰서 프로그래밍 한다.
  - 상위 형식에 맞춰 프로그래밍한다는 것을 뜻함
  
  Ex)
  구현에 맞춘 프로그래밍
  <pre>
  Dog d = new Dog();
  d.bark();
  </pre>
  
  인터페이스/상위 형식에 맞춰서 프로그래밍
  <pre>
  Animal animal = new dog();
  animal.makeSound();
  </pre>
  
  구체적으로 구현된 객체를 실행시에 대입
  <pre>
  a = getAnimal();
  a.makeSound();
  </pre>
  
+ 상속 보다는 구성을 활용한다.


Strategy Pattern
----
+ 알고리즘군을 정의하고 각각을 캡슐화하여 교환해서 사용할 수 있도록 만든다.
+ Stratrgy를 사용하면 알고리즘을 사용하는 클라이언트와는 독입적으로 알고리즘을 변경 할 수 있다.


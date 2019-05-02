Polymorphism
================
+ 상속 관계에서 같은 기능이 여러 형태로 존재하는 것을 말한다.
+ 같은 기능을 하는 Method가 여러 Class에서 정의 될 수 있는 것
+ 다른 상황에서 다르게 작동한다. => Class의 내용에 따라 다르게 구현될 수 있음

+ ex)
<pre>public static void main(String[] args){
  Animal ani = new Animal();
  ani.useLegs();
  
  Animal f = new Fish();
  
  f.useLegs();
}</pre>

동물은 다리를 사용한다는 method 가 있을때 물고기로 method가 상속되면 헤엄을 친다로 정의된다.


+ 처음 보는 사용자라면 모든 로직을 이해해야 되기 때문에 자주 사용되지 않음


![Polymorphism](https://i1.wp.com/www.brightdevelopers.com/wp-content/uploads/2017/08/polymorphism-big.png?fit=562%2C382&ssl=1)

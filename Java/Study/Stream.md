Stream
=========
+ 입출력을 뜻한다.
+ 데이터가 있던 장소에서 다른곳으로 흘러가는것을 stream으로 표현
+ 단반향으로 진행된다.


In&Out put Stream
-------------
+ Input Stream 대상의 입장에서 data를 받으면 Input Stream
+ Output Stream 대상의 입장에서 data를 보내면 Output Stream
+ System.out.print : 표준 출력, Output Stream


특징
---------
+ 스트림은 데이터 소스를 변경하지 않는다.
> 스트림은 데이터 소스로 부터 데이터를 읽기만할 뿐, 데이터 소스를 변경하지 않는다. 필요하다면, 정렬된 결과를 컬렉션이나 배열에 담아서 반환
 <pre>List<String> sortedList = listStream.sorted().collect(Collections.toList());</pre>

+ 스트림은 일회용이다.
> 스트림은 Iterator처럼 일회용이다. Iterator로 컬렉션의 요소를 모두 읽고 나면 다시 사용할 수 없는 것처럼, 스트림도 한번 사용하면 닫혀서 다시 사용할   수 없다. 필요하다면 스트림을 다시 생성해야함
  <pre>listStream.sorted().forEach(System.out::print);
  int numOfElement = listStream.count(); //에러. 스트림이 이미 닫힘</pre>

+ 스트림은 작업을 내부 반복으로 처리한다.
> 스트림을 이용한 작업이 간결할 수 있는 비결중의 하나가 바로 '내부 반복'이다. 내부 반복이라는 것은 반복문을 메서드의 내부에 숨길 수 있다는 것을 의미

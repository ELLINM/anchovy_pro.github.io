Class
======
+ 빵을 만드는 틀과 같은것
+ Object(객체)를 포함 -> 만들어지는 빵
+ Object는 각각마다 고유한 속성을 가짐

+ 선언
<pre>
class x:
  function, variable, object
</pre>


Self
----
+ Class Method의 첫 번째 인수로 self를 사용해야만 해당 Method를 instance의 Method로 사용할 수 있음
+ Method를 부르는 Obect가 해당 Class의 Instance인지 확인하는 장치
+ 또한 self를  이용하여 Object내의 정보를 저장하거나 불러 올 수 있음
+ Constructor를 포함한 모든 Method들은 첫번째 매개변수로 self매개변수를 갖고있음

Ex)
<pre>
class Car:
  honk = "빵빵"
  
  def set_info(self, color, year):
    self.color = color
	self.year = year

  def get_info(self):
	print "color : %s ,year: %d" % (self.color, self.year)

my_car = Car()
my_car.set_info("Red", 2017)
</pre>


Constructor
------
+ initializer(__init__) : __init__ Method를 사용하여 Constructor를 만든경우 이 Constructor를 initializer라고 부름
+ constructor : initializer(__init__) Method를 이용하여 정의한 Constructor를 사용할 경우 이 constructor를 constructor라고 부름
+ 사용할 Class의 메모리에 Object를 생성
+ Class의 __init__ Method를 호출하여 Object를 초기화
+ __init__함수의self매개 변수는 방금 생성된 Object를 자동으로 참조
+ constructor를 사용할 때 constructor의 인자 들은 self를 제외한 __init__ Method의 매개변수와 일치


Observer Pattern
=====
+ 주제 객체(Subjet Object)에서 일부 데이터를 관리
+ 주제의 데이터가 달라지면 옵저버(Obsever)한테 소식이 전달
+ 데이터가 바뀌면 새로운 데이터 값이 어떤 방법으로든 옵저버(Observer)들에게 전달
+ 옵저버 객체(Observer Object)들은 주제 객체(Subject Object)에 등록 되어 있으며 주제의 데이터가 바뀌면 갱신내용은 전달받음
+ 옵저버(Observer)가 아닌 객체는 주제 객체(Subject Object)의 데이터가 바뀌어도 변화가 없음

> 한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체들한테 연락이 가고 자동으로 내용이 갱신되는 방식으로 일대다(one-to-many) 의존성을 정의


Loose Coupling(느슨한 결합)
------
+ 두 객체가 느슨하게 결합되어 있다는 것은 , 그 둘이 상호작용을 하긴 하지만 서로에 대해 잘 모른다는 것을 의미
+ 옵저버 패턴(Observer Pattern)에서는 주제(Subject)와 옵저버(Observer)가 느슨하게 결합(Loose Coupling)되어 있는 개게 디자인을 제공

Why?
-----
+ 주제(Subject)가 옵저버(Observer)에 대해서 아는 것은 옵저버(Observer)가 특정 인터페이스(Interface)를 구현한다는 것
+ 옵저버(Observer)는 언제든지 새로 추가 할 수 있음
+ 새로운 형식의 옵저버(Observer)를 추가하려고 할 때도 주제(Subject)를 전혀 변경할 필요가 없음
+ 주제(Subject)와 옵저버(Observer)는 서로 독립적으로 재사용 할 수 있음
+ 주제(Subject)나 옵저버(Observer)가 바뀌더라도 서로한테 영향을 미치지는 않음


Design Principle
------
+ 서로 상호작용을 하는 객체 사이에서는 가능하면 느슨하게 결합하는 디자인을 사용해야함
> 느슨하게 결합하는 디자인을 사용하면 변경사항이 생겨도 무난히 처리 할 수 있는 유연한 객체지향 시스템을 구축 할 수 있음
  객체 가이의 상호 의존성을 최소화!


Ex)
----------------
<pre>
WeatherData
getTemperature()
getHumidity()
getPressure()
measurementsChanged()
//3개의 Method는 각각 최근에 측정된 온도, 습도, 기압값을 리턴하는 Method
//기상관측값이 갱신될때 마다 알려주기 위한 Method
</pre>

조건)
1. WeatherData Class에는 3가지 측정값(온도, 습도, 기압)을 알아내기 위한 게터 메소드가 있음
2. 새로운 기상 측정 데이터가 나올때마다 measurementsChanged() Method가 호출 
3. 기상데이터를 사용하는 3개의 디스플레이 항목을 구현해야 함
  - 하나는 조건 다른 하나는 기상 통계 나머지 하나는 기상 예보를 표시
  - 새로운 측정값이 들어올 때 마다 디스플레이를 갱신 해야함
4. 시스템 확장이 가능 해야함
  - 다른 개발자들이 별도의 디스플레이 항목을 만들 수 있도록 해야하고 
    사용자들이 애플리케이션에 마음대로 디스플레이 항목을 추가/제거 할 수 있도록 해야함
    
   
Proto Type)
<pre>
public class WeatherData{
// 인스턴스 변수 선언
  public void measurementschanged(){
    float temp = getTemperature();
    float humidity = getHumidity();
    float pressure = getPressure();
    //이미 구현되어 있는 WeatherData의 getter Method를 써서 최신 측정값을 갖고옴
    
    //Display 갱신
    currentConditionsDisplay.update(temp, humidity, pressure);
    statisticsDisplay.update(temp, humidity, pressure);
    forecastDisplay.update(temp, humidity, pressure);
    // 각 Display 항목을 불러서 Display를 갱신하도록 함, 이때 최신 측정값을 전달
    //하지만 지금의 Display부분은 캡슐화 해줘야함
    //구체적인 구현에 맞춰서 코딩했기 때문에 프로그램을 고치지 않고 다른 Display항목을 추가/제거 할 수 없음
    //공통된 Method인 update를 주목
</pre>


Virtual Station)
<pre>
public interface Subject{
  public void registerObserver(Observer o);
  piblic void removeObserver(Observer o);
  // 위의 두 Method에서 모두 Observer를 인자로 받음 각각 Observer를 등록하고 제거
  public void notifyObserver();
  // 주제 객체의 상태가 변경되었을 때 모든 Observer에게 알리기 위해 호출되는 Method
}

public interface Observer{
//Observer interface는 모든 Observer Class에 구현해햐함 따라서 모든 Observer는 update() Method를 구현해야함
  public void update(float temp, float humidity, float pressure);
  // 기상정보가 변경되었을 때 Observer한테 전달 되는 상태값
}

public interfae DisplayElement{
//DisplayElement interface에는 display()라는 Method하나 밖에 없음 Display 항목을 화면에 표시해야 하는 경우에 그 Method를 
  public void display();
}
</pre>

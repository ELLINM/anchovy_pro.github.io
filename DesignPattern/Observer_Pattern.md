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


> Java.tuil pakage에 들어있는 Observer Interface와 Observeable Class를 사용하여 Observer Pattern을 사용할 수 있음


Java 내장 Observer Pattern 작동 방식
-----------
+ 차이점 : WeatherData에서 Observable Class를 확장하면서 Method를 상속받음
+ Object Observer가 되는 방법은 같음 삭제도 마찬가지
+ java.util.Observable Super Class를 확장하여 Observable Class를 생성
  -> setChanged() Method를 호출해서 Object의 상태가 바뀌었다는것을 전달
  -> 다음에 notifyObservers() or notifyObservers(Object arg)를 호출
+ Observer가 전달을 받을때
  <pre>
  update(Observalbe o, Object arg)
  // 연락을 보내는 Subject Object가 Observable 인자로 전달
  //Object arg : notifyObservers() Method에서 인자로 전달된 Data Object. Data Object가 지정되지 않을 경우 null이됨
  </pre>
  
+ setChanged() Method : Observer들에게 전달하는 조건을 정해줄때 설정
  <pre>
  setChanged(){
    changed = true
  }
  //setChanged() Method에서 changed flag의 값을 참으로 설정
  
  notifyObservers(Object arg){
    if (changed){
      목록에 있는 모든 Observer에 대해{
        update(this, arg)
      //notifyObservers()에서는 changed flag가 참인 경우에만 Observer들한테 전달
       }
     changed = false
     //Observer들에게 전달을 하고나면 changed flag를 다시 거짓으로 바꿈
     }
   }
  notidyObservers(){
    notifyObservers(null)
  }
  </pre>


> Observer는 전달되는 순서에 의존하면 안됨 "느슨한 결합(Loose Coupling)" 을 


Java 내장 Observer Pattern의 단점
------
+ Observable은 Class기 때문에 sub class를 만들어 줘야함 : 재사용성에 제약이 생김
+ Observable interface라는 것이 없기 때문에 Java네 내장된 Observer API하고 잘 맞는 class 구현이 불가능
+ Observable Class의 핵심 Method를 외부에서 호출 할 수 


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
import java.util.Observable;
import java.util.Observer;

public class WeatherData extends Obsservable{
// 인스턴스 변수 선언
  private float temperature;
  private float humidity;
  private float pressure;
  
  //Observer들을 직적 챙기고 등록/탈퇴 등을 직접 관리하지 않아도 됨(Super class에서 다해줌)
  
  public WeatherData(){ }
    //생성자에서 Observer들을 저장하기 위한 자료구조를 만들 필요가 없음
  
  public void measurementschanged(){
    /*
    
    float temp = getTemperature();
    float humidity = getHumidity();
    float pressure = getPressure();
    //이미 구현되어 있는 WeatherData의 getter Method를 써서 최신 측정값을 갖고옴 
    
    */
    
      setChanged();
      notifyObservers();
      //notifyObservers()를 호출할때 DataObject를 보내지 않음-> 풀 모델을 사용중이라는 뜻
      //notifyObservers()를 호출하기 전에 setChanged()를 호출 해서 상태가 바뀌었다는것을 전달
    }
    
    public void setMeasurementschanged(){
      this.temperature = temperature;
      this.humidity = humidity;
      this.pressure = pressure;
      measurementsChanged();
    }
    
    /*
    Display 갱신
    currentConditionsDisplay.update(temp, humidity, pressure);
    statisticsDisplay.update(temp, humidity, pressure);
    forecastDisplay.update(temp, humidity, pressure);
    // 각 Display 항목을 불러서 Display를 갱신하도록 함, 이때 최신 측정값을 전달
    //하지만 지금의 Display부분은 캡슐화 해줘야함
    //구체적인 구현에 맞춰서 코딩했기 때문에 프로그램을 고치지 않고 다른 Display항목을 추가/제거 할 수 없음
    //공통된 Method인 update를 주목
    */
    
    public float getTemperature() {
      return temperature;
    }
    
    public float getHumidity() {
      return humidity;
    }
    
    public float getPressure() {
      return pressure;
    }
 }
    
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


WeatherData의 Subject interface)
<pre>
public class WeatherData implements Subject{
//WeatherData에서 Subject interface를 구현
  private ArrayList observers;
  private float temperature;
  private float humidity;
  private float pressure;
  
  public WeatherData(){
    observers = new ArrayList();
    //Observer 객체들을 저장하기 위해 ArrayList를 추가 그리고 생성자에서 그 객체를 생성
  }
  
  public void registerObserver(Observer o){
  //Observer가 등록을 하면 목록 맨 뒤에 추가하면 됨
    observers.add(o);
  }
  
  public void removerObserver(Observer o){
  //Observer가 빠지면 목록에서 빼면됨
    int i = observers.indexOf(o);
    if (i >= 0){
      observers.remove(i);
    }
  }
  
  public void notifyObservers(){
  // 상태에 대해서 모든 Observer들에게 알려주는 부분
  // Observer interface를 구현하는 update() Method가 있는 객체들
    for(int i = 0; i < observers.size(); i++){
      Observer observer = (Observer)observers.get(i);
      observer.update(temperature, humidity, pressure);
    }
  }
  
  public void measurementsChanged(){
  //Virtual Station으로 부터 갱신된 측저이를 받으면 Observer들에게 알림
    notifyObservers();
  }
  
  public void setMeasurements(float temperature,  float humidity, float pressure){
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }
}
</pre>


Display)
<pre>
import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement{
//weatherData Object로 부터 변경사항을 받기 위해 Observer를 구현
//API 구조상 모든 Display 항목에서 DisplayElment를 구현하기로 했기 때문에 이 Interface도 구현

//java.util pakage에 들어있는 Observer interface를 구현
  Observable observable;
  private float temprature;
  private float humidity;
  //private Subject weatherData;

  public CurrentConditionsDisplay(/* Subject weatherData*/ Oservable observable){
  //Observable 인자를 받아들인 다음 그 reference를 써서 observer를 등록
  /*
  //생성자에 weatherData라는 Subject Object가 전달되며, Object를 사용해서 Display를 Observer로 등록
    this.weatherData = weathweData;
    weatherData.registerObserver(this); */
    
    this.observable = observable;
    observable.addObserver(this);
  }

  public void update(/* float temperature, float humidity, float pressure*/Observable obs, Object arg) {
  //Observable과 추가 Data인자를 모들 받아들임
    /*
    this.tempreture = tempreture;
    this.humidity = humdity;
    //update가 호출되면 기온과 습도를 저장하고 display()를 호출
    */
    
    if (obs instanceof WeatherData){
      WeatherData weatherData = (WeatherData)obs;
      this.temprature = weatherData.getTempreture();
      this.humidity = weatherData.getHumidity();
      display();
    }
    //update() Method에서는 우선 Observabledl WeatherData 형식이지 확인한 다음 getter Method를 써서 기온과 습도를 갖고옴
    // 그 다음 display() Method를 
  }

  public void display() {
    System.out.println("Current conditions: " + tempreture + "F degrees and " + humidity + "% humidity");
    //display() Method에서 가장 최근에 얻은 기온과 습도를 출력
  }
}
</pre>


WeatherStation)
<pre>
public class WeatherStation{
  public static void main(String [] args) {
    WeatherData weatherdata = new WeatherData();
    //weatherdata Object를 생성
    
    CurrentConditionsDisplay currentDisplay =  new CurrentConditionsDisplay(weatherData);
    StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
    ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
    //세개의 Display를 생성 하면서 WeatherData 객체를 인자로 전달합니다.
    
    weatherData.setMeasurements(80, 65, 30.4f);
    weatherData.setMeasurements(82, 70, 29.2f);
    weatherData.setMeasurements(78, 90, 29.2f);
    //새로운 기상 측정값이 들어온 것 처럼 
</pre>

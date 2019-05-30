Class.forname()
-----------
+ Class.forName()은 클래스로더 라는 녀석을 통해서 해당 데이터베이스 드라이버를 로드
  할 뿐 데이터베이스와의 연결에 관해서는 아무런 동작도 하지 않음
+ API
<pre>public static Class<?> forName(String className) throws ClassNotFoundException</pre>]
> A call to forName("X") causes the class named X to be initialized.
  Returns:
  the Class object for the class with the specified name.
  
<pre>public class SomeDriver implements Driver {
  static {
    try {
      DriverManager.registerDriver(new SomeDriver());
    } catch (SQLException e) {
      // TODO Auto-generated catch block
    }
  }

  //etc: implemented methods
}</pre>
> Class 클래스는 클래스들의 정보(클래스의 필드, 메서드, 클래스의 종류(인터페이스 등))를 담는 메타 클래스
  JVM은 이 Class 클래스를 통해 클래스들에 대한 정보를 로드
  따라서 위 API문서의 "class name x to be initialized."란 "JVM에게 해당 클래스의 정보를 로드한다." 
  이 때 한 가지 생각해야 할 것은 JVM에게 해당 클래스의 정보가 로딩된다는 것은 JVM이 할당하는 메모리 (클래스 영역)에 로드되고 
  그 때 위의 static 절이 실행되면서 DriverManager에 해당 드라이버가 레지스터 되는 것
  따라서 DriverManager는 이 정보를 가지고 getConnection을 할 수 있는 것
  
  
+ Class 클래스는 JVM에서 동작할 클래스들의 정보를 묘사하는 일종의 메타 클래스(Meta-Class)입니다. 
  —> 클래스의 이름, 멤버 필드와 메소드, 클래스 종류(자바의 interface는 내부적으로 클래스와 동일하게 취급)

+ 클래스를 인스턴스화 하는 과정 
  <pre>A a = new A();</pre> 
  위의 코드가 호출되는 순간 JVM은 A라는 클래스가 JVM에 로드되어 있는지 검색
  로드되어 있지 않다면 ClassLoader 클래스 혹은 그를 상속받은 클래스들을 이용하여 A 클래스를 로드
  찾지 못하면 ClassNotFoundException이 발생


+ 로드되어 있을 경우
  A 클래스의 인스턴스를 하나 생성 -> 생성자를 호출
  생성자가 호출 -> 인스턴스 초기화 -> a라는 참조 변수가 생성된 인스턴스를 가리키게 함
> 이 때 내부적으로 a라는 참조변수가 새로 생성된 인스턴스를 가리키고 있기 때문에 해당 인스턴스의 참조 카운트를 1로 지정
  (참조 카운트가 0이라면 가비지 컬렉터의 대상)


+ Class.forName("some.pakage.SomeClass").newInstance()
  forName() 메소드에 의해서 반환된 Class 클래스의 인스턴스에는 some.pakage.SomeClass의 정보가 보관
  newInstance()를 호출하면 인스턴스를 생성한 다음 기본 생성자로 초기화하고 그 인스턴스를 리턴
  이 과정은 some.pakage.SomeClass obj = new some.pakage.SomeClass(); 와 같은 동작


+ 리턴된 인스턴스를 받는 참조 변수도 없고 대입도 없을 경우 참조 카운트가 0이 되어 카비지 컬렉션의 대상이 됨
> static 블럭
  static 블럭은 클래스가 로딩된 직후 어떤 생성자보다도 먼저 실행되는 코드
  JDBC 드라이버와 같이 인스턴스를 별도로 관리하지 않는 대부분의 클래스의 경우 정적 블록을 통해 생성하고 관리
  따라서 Class.forName() 메소드를 호출하면 인스턴스 생성과 초기화가 진행
  Class.forName()은 JDBC 4.0 이후로는 메소드를 호출하지 않아도 자동으로 드라이버를 초기화
  

getConnection
-----------------
<pre>public java.sql.Connection getConnection(java.lang.String username,  
                                         java.lang.String password)</pre>

> 매개 변수 
  username : 사용자 이름을 포함하는 문자열입니다.
  password : 암호가 포함된 문자열입니다.

> 반환 값
  SQLServerConnection 개체입니다.

> 예외
  java.sql.SQLException

+ Remarks
  getConnection 메서드는 javax.sql.DataSource 인터페이스의 getConnection 메서드에 의해 지정
  Null이 아닌 사용자 이름이 나 암호를 사용 메서드 호출의 getConnection SQLServerConnection 개체를 초기화할 때 
  SQLServerDataSource 클래스에 설정 된 사용자 이름 및 암호 속성을 대체
  Ex) 호출자가 데이터 원본에 대해 setUser 및 setPassword를 호출한 
  -> getConnection을 호출하고 null이 아닌 사용자 이름이나 null이 아닌 암호를 제공
  -> setUser 및 setPassword로 설정된 사용자 이름과 암호 getConnection에 전달된 사용자 이름 및 암호로 대체
  
 + 참고 링크 
   https://m.blog.naver.com/heartflow89/221003777591
  https://docs.microsoft.com/ko-kr/sql/connect/jdbc/reference/getconnection-method-java-lang-string-java-lang-string?view=sql-server-2017
  https://kyun2.tistory.com/23

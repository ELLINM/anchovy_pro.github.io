Mapper?
=======
+ Mapping File에 기재된 SQL을 호출하기 위한 Interface
+ Mapping File에 있는 SQL을 Interface로 호출

Mapper Interface 작성
---------
+ 반드시 Interface로 선언해 주어야 함   
+ Name Space의 명은 패키지 포함 Interface 이름으로 작성   
+ Method Name은 SQLID와 동일하게 작성

RequsestMapping
------
+ Client는 URL로 요청을 전소
+ 요청 URL을 어떤 Method가 처리할지 여부를 결정하는 것이 @RequsestMapping

<pre>@Controller
public class MemberController {
  
  @RequestMapping("/test/member")
  public String member(Model model){
  }
}</pre>

+ 여러 경로를 한 Method에 처리 하고 싶다면, 배열로 경로 목록을 지정

<pre>@Controller
public class HomeController {
  
  @RequestMapping({"/test","/member"})
  public String member(Model model){
  }
}</pre>

+ Class와 Method에 @RequestMapping 적용
> Controller와 Method에 @RequestMapping Annotation을 모두 사용하면, Class에 적용한 값과 Mehtod에 적용한 값을 조합해서 Mapping Root를 결정

<pre>@Controller
@RequestMapping("/test")
public class EventController {
  
  @RequestMapping("/member")
  public String member(Model model){
  
  return "test/member";
  }
  
  @RequestMapping("/main")
  public String main(Model model){
  }
}</pre>


HTML 전송 방식
-----------
+ <form> tag에서 method 속성값을 "post"로 지정하는 것이 일반적
+ @RequestMapping Annotation은 Method 속성을 이용해서 Method에서 처리할 전송방식을 지정
+ 동일한 경로를 값으로 갖고 method속성만 다를 수 있음


Annotation
------
+ @Override, @Deprecated이 대표적인 예
+ AOP(Aspect Oriented Programing; 관심지향프로그래밍)을 편리하게 구성

|Annotation|Contents|
|-----|-----|
|@Override|메소드가 오버라이드 됐는지 검증, 만약 부모 클래스 또는 구현해야할 인터페이스에서 해당 메소드를 찾을 수 없다면 컴파일 오류 발생|
|@Deprecated|메소드를 사용하지 말도록 유도 만약 사용한다면 컴파일 경고|
|@SuppressWarnings|컴파일 경고를 무시|
|@SafeVarargs|제너릭 같은 가변인자 매개변수를 사용할 때 경고를 무시 (자바7 이상)|
|@FunctionalInterface|람다 함수등을 위한 인터페이스를 지정, 메소드가 없거나 두개 이상 되면 컴파일 오류 발생 (자바 8이상)|
|Meta Annotations|Meta Annotation을 활용해 Custom Annotation 생성 가능|
|@Retention|어노테이션의 Life Time|
|@Documented|문서에도 어노테이션의 정보가 표현|
|@Target|적용할 위치를 결정|
|@Inherited|자식클래스가 어노테이션을 상속|
|@Repeatable|반복적으로 어노테이션을 선언|



Annotation 구조
------
|Annotation|Contents|
|-----|-----|
|@Inherited|상속|
|@Documented|문서에 정보가 표현|
|@Retention(RetentionPolicy.RUNTIME)|컴파일 이후에도 JVM에 의해서 참조가 가능|
|@Retention(RetentionPolicy.CLASS)|Compiler가 클래스를 참조할 때까지 유효|
|@Retention(RetentionPolicy.SOURCE)|컴파일 이후 이후 사라짐|
|@Target ElementType.PACKAGE,|패키지 선언시|
|@Target		ElementType.TYPE,|타입 선언시|
|@Target		ElementType.CONSTRUCTOR,|생성자 선언시|
|@Target		ElementType.FIELD,|멤버 변수 선언시|
|@Target		ElementType.METHOD,|메소드 선언시|
|@Target		ElementType.ANNOTATION_TYPE,|어노테이션 타입 선언시|
|@Target		ElementType.LOCAL_VARIABLE,|지역 변수 선언시|
|@Target	ElementType.PARAMETER,|매개 변수 선언시|
|@Target		ElementType.TYPE_PARAMETER,|매개 변수 타입 선언시|
|@Target		ElementType.TYPE_USE|타입 사용시|


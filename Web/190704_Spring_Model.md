Model
=======
+ Controller의 Method에서  view에 data를 전달하는 용도로 사용   
+ addAttribute(String-인자값, Object-데이터객체) 메서드로 데이터를 저장하여 view 로 전달
+ view 에 전달된 Model 객체의 데이터는 request 영역에 보관됨
+ Servelt의 request.setAttribute()와 유사한 역할

> Controller의 인자값으로 지정이 되면 new키워드를 사용하지 않아도 객체가 생성이됨

Model Attribute
--------
+ 강제로 전달받은 Parameter를 Model에 담아서 전달하도록 할 때 필요한 annotation
+ Spring에서 Java beans 규칙(Getter, Setter, 생성자 포함)에 맞는 객체는 Parameter 전달이 자동으로 가능
+ 일반 변수의 경우, 자동 전달 불가능. model 객체를 통해서 전달 필요


Model vs ModelMap
-----------
+ model.addAttribute()와 modelmap.addAttribute() 함수를 하용하여 Model에 데이터를 저정 후 view에서 데이터에 접근이 가능
+ 차이점으로는 Model은 인터페이스이며 ModelMap은 구현체
> Spring에서 내부적으로 사용하는 객체의 타입은 동일하며 사용의 구분은 개발자의 취향 => 같은 기능

ModelAndView
-----------
+ ModelAndView객체는 Model객체와 데이터를 넘길 페이지값을 가진 return을 합친 것
+ 데이터와 넘길 페이지의 값을 모두 가지고 있는 객체
+ Model과 View를 동시에 설정이 가능하며 컨트롤러는 ModelAndView객체만 리턴하지만 Model과 View가 모두 리턴 가능
+ addObject("key",value) 데이터 입력


Spring MVC
--------
+ Model, View, Controller를 분리한 디자인 패턴 (개발자가 직접 구현해야 하는 것)   
+ Model   
> 애플리케이션의 상태(data)를 표현   
  일반적으로 POJO로 구성   
  Java Beans   

+View
> 디스플레이 데이터 또는 프리젠테이션 Model data의 렌더링을 담당하며, HTML ouput을 생성   
  JSP 이외에도 Thymeleaf, Groovy, Freemarker 등 여러 Template Engine이 존재   

+ Controller   
> View와 Model 사이의 인터페이스 역할   
  Model/View에 대한 사용자 입력 및 요청을 수신하여 그에 따라 적절한 결과를 Model에 담아 View에 전달   
  즉, Model Object와 이 Model을 화면에 출력할 View Name을 반환   
  Controller —> Service —> Dao —> DB
  Servlet

Spring의 @ModelAttribute
------------
+ Spring의 모델에 데이터나 객체를 추가하는 방법
  데이터나 객체는 흔히 컨트롤러(controller)에 쓰인 어노테이션(annotation, 주석)을 통해 추가

+ Spring Model Data 저장
> MyCommandBean은 모델이지만, 처리기 메서드가 실행될 때는 요청 객체는 아님
  Spring은 처리기 메서드의 실행과 다음 뷰 표시 전까지 애트리뷰트로서 요청에 모델 데이터를 추가하지 않음

+ Spring Model vs 요청 선택의 이유
> (요청 애트리뷰트로서) HttpServletRequest에 바로 요소를 추가하는 것은 같은 목적
  MVC 프레임워크에 정한 요구 사항 중 하나를 충족하기 위함 -> HttpServletRequest에 바인딩되지 않은 뷰 기술을 통합하길 바란다는 것

+ Spring의 @SESSIONATTRIBuTES
> Spring의 @SessionAttributes는 어떤 모델 애트리뷰트가 세션에 저장되어야 하는지를 컨트롤러에게 지시하는데 사용
  Spring 문서는 @SessionAttributes 어노테이션이 세션과 일부 대화식 저장소에 투명하게 저장되어야 하는 모델 애트리뷰트의 이름을 나열
  "일부 대화식 저장소"는 Spring MVC가 디자인에 구애받지 않는 기술을 유지하력 노력하는 방법을 제시

+ Session Attribute 제어
> Spring은 Spring Session Attribute를 제거하고, (HttpSession 전체를 없애지 않고) HttpSession으로부터 삭제하는 수단을 제공
  Spring SessionStatus 객체를 매개변수로 컨트롤러 처리기 메서드에 추가만 하면 됨
  이 방법에선 SessionStatus 객체를 사용하여 Spring 세션을 끝냄

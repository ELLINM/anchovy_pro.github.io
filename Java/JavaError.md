Java Error
==============
+ Java의 각종 Error들을 모아서 조금이나마 익숙해져 보자


+ Exception in thread "main" java.lang.NoClassDefFoundError:FileName
* Not found Class File
> 실행하려는 Class File Name이 제대로 설정되어있는지 확인한다. 또한 CLASSPATH설정이 제대로 되어있는지 확인하며 만약 되었지 않다면 설정한다.


+ cannot resolve symbol
  symbol:class in (Error part)
  location:classStackTest(find locate)
* 이해할 수 없는 Class, Method, Variable Name이 올경우
> 절차가 틀렸을 경우에 많이 발생한다. Class, Method, Variable의 철자를 세심히 확인해본다.
  특히 대소문자 구분을 확실히 체크한다.
  그리고 Class에서 발생할 경우 import!를 해주었는지 확인하자
  

+ non-static variavle Name(or Method Name) connot br referenced from a static context
* static method 안에서 static으로 선언되지 않은 method나 variable을 참조(사용) 했을 경우 
  특히, Method의 경우는 인스턴스를 사용하지 않고 static method내에서 바로 선언한 경우!!
> Static 선언자의 사용여부를 살펴보고 static method안에 static으로 선언되어지지 않은 method나 variable이 있는지 확인해본다.
  만약 그런것이 있으면 method를 새로만들어 그쪽에서 선언한다. 단, 인스턴스르 생성해서 불러줘야 한다.
  

+ valiable 변수명 might not have been initialized
* Local Variable인 Variable Name의 Varialbe이 초기화 되어 있지 않았을 경우
> Local Variable(Method내에서 선언한 Variable)를 초기화 하지 않은채 선언했을 경우 발생한다.
  멤버 필드가 아닌 경우에는 반드시 Variable 선언시 초기화를 해주어야 한다.
  (멤버 필드는 자바 프로그램 자체에서 자동으로 default값으로 초기화 해준다.)
  

+ Class Name is public, should be declared in a file named ClassName.java
* Class Name이 Public으로 선언 되었는데 File Name과 다를경우
> public으로 선언된 Class가 있다면 반드시 그 Class Name과 File Name이 같아야 한다.
  Class Name과 File Name의 대소문자 및 철자가 같은지 비교해 본다.
  또한, public으로 선언된 Class가 하나 이사 있는지 찾아본다.(반드시 하나만 있어야 한다.)
  
+ push(java.lang.object)[Method]in java.util.Stack(Method Class) cannot be applies to (int)[Unable Type]
* Method에서 인자를 받을때 받을 수 있는 Type이 아닌 Data or Class Type을 사용할 경우
> 사용하는 Method의 API르 참고하여 어떤 Type을 인자로 받을 수 있는지 찾아본다.
  API를 보지못할 경우는 각 Data Type으로 인자를 직접 빠꾸어 본다.

+ java.lang.No.SuchMethodError:main
  Exception in thread"main"
* Class File 안에서 main() Method를 찾을수 없는 경우
> 자바 애플릿이 아닌 이상 자바 애플리케이션은 반드시 main() Method를 사용해야 합니다.
  main() Method를 빼먹지 않았는지 확인해 볼것 또한 public static void main(String [] args)형식으로 씌여졌는지도 확인
  (main Class는 반드시 위와 같은 형식으로 만들어 져야 합니다.)
  
+ unreportes exception java.io.IOException(ExceptionName);must be caught or declared to be thrown
* 예외가 발생하는데 예외를 처리해주지 않았을 경우
> 예외를 발생하는 메소드 같은 경우는 반드시 예외 처리르 해주어야 합니다. 예외를 발생하거나 예외 처리리를 해야하는 Method는 API를 확인해보면 알수있음
  그렇지 않다면 Compile 후 지금처럼 Error가 난 예외를 예외처리해주면 가능
  또한, 예외르 처리할 때는 Method 차원에서 throws 예외명을 이용하여 처리할 수있고 try{} catch{}구문을 이용해서 직접 처리해줄수있음
  특히, 예외도 Class이므로 반드시 예외가 들어간 패키지를 import!해주어야 합니다.
  
+ Note : Calculator.java(FileName) user or overrides a deprecated API.
  Note : Recompile with-deprecation for details.
* JDK 버전이 높아졌거나 보안들의 기타 이유로 사용이 deprecated된 Method를 사용한 경우
> 예외라기 보다 경고(실행X) JDK가 버전이 높아지거나 보안등의 이유에 따라 예전에 만들어졌지만 필요가 없어지거나 대체된 Method가 생겨남
  그런 Method를 deprecated되었다고 하는데 이것은 API상에 나와있다.
  또한 Compile -deprecation 옵션주면 어떤 Method가 deprecate됐는지 알수 있습니다. 대치되었거나 버전업된 Method를 사용하면됨
  
+ MousEvent(ClassName) should be declared abstract; it does not define mouseDragged(java.awt.event.MouseEvent)
  [Method Name(Method가 포함된 Class)] in MouseEvent(ClassName)
* implements한 Interface의 모든 Method를 구현하지 않아서 발생됨
> Interface는 모든 Method가 선언만 되고 구현되지 않은 추상(abstract) Method입니다.
  만약 Interface를 Implements하려면 Implements한 Class가 Interface에서 선언한 모든 Method를 구현해 주어야 합니다.
  하나라도 빠질경우 Implements한 Class도 Abstract Class로 보고 Error가 발생합니다.
  Error에 구혀해 주어야할 Method Name이 나오므로 그곳에 쓰여있느 Method를 구현해 주면 됩니다.
  만약 Method를 구현해 주었는데 Error가 나면 철자 및 대소문자를 다시 확인
  

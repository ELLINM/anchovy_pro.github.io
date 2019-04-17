Java Error
==============

Java의 각종 Error들을 모아서 조금이나마 익숙해져 보자
-----------------------------------


### Exception in thread "main" java.lang.NoClassDefFoundError:FileName
+ Not found Class File
> 실행하려는 Class File Name이 제대로 설정되어있는지 확인한다. 또한 CLASSPATH설정이 제대로 되어있는지 확인하며 만약 되었지 않다면 설정한다.



### cannot resolve symbol
###  symbol:class in (Error part)
###  location:classStackTest(find locate)
+ 이해할 수 없는 Class, Method, Variable Name이 올경우
> 절차가 틀렸을 경우에 많이 발생한다. Class, Method, Variable의 철자를 세심히 확인해본다.
  특히 대소문자 구분을 확실히 체크한다.
  그리고 Class에서 발생할 경우 import!를 해주었는지 확인하자
  


### non-static variavle Name(or Method Name) connot br referenced from a static context
+ static method 안에서 static으로 선언되지 않은 method나 variable을 참조(사용) 했을 경우 
  특히, Method의 경우는 인스턴스를 사용하지 않고 static method내에서 바로 선언한 경우!!
> Static 선언자의 사용여부를 살펴보고 static method안에 static으로 선언되어지지 않은 method나 variable이 있는지 확인해본다.
  만약 그런것이 있으면 method를 새로만들어 그쪽에서 선언한다. 단, 인스턴스르 생성해서 불러줘야 한다.
  


### valiable 변수명 might not have been initialized
+ Local Variable인 Variable Name의 Varialbe이 초기화 되어 있지 않았을 경우
> Local Variable(Method내에서 선언한 Variable)를 초기화 하지 않은채 선언했을 경우 발생한다.
  멤버 필드가 아닌 경우에는 반드시 Variable 선언시 초기화를 해주어야 한다.
  (멤버 필드는 자바 프로그램 자체에서 자동으로 default값으로 초기화 해준다.)
  


### Class Name is public, should be declared in a file named ClassName.java
+ Class Name이 Public으로 선언 되었는데 File Name과 다를경우
> public으로 선언된 Class가 있다면 반드시 그 Class Name과 File Name이 같아야 한다.
  Class Name과 File Name의 대소문자 및 철자가 같은지 비교해 본다.
  또한, public으로 선언된 Class가 하나 이사 있는지 찾아본다.(반드시 하나만 있어야 한다.)
  
  
  
### push(java.lang.object)[Method]in java.util.Stack(Method Class) cannot be applies to (int)[Unable Type]
+ Method에서 인자를 받을때 받을 수 있는 Type이 아닌 Data or Class Type을 사용할 경우
> 사용하는 Method의 API르 참고하여 어떤 Type을 인자로 받을 수 있는지 찾아본다.
  API를 보지못할 경우는 각 Data Type으로 인자를 직접 빠꾸어 본다.



### java.lang.No.SuchMethodError:main
###  Exception in thread"main"
+ Class File 안에서 main() Method를 찾을수 없는 경우
> 자바 애플릿이 아닌 이상 자바 애플리케이션은 반드시 main() Method를 사용해야 합니다.
  main() Method를 빼먹지 않았는지 확인해 볼것 또한 public static void main(String [] args)형식으로 씌여졌는지도 확인
  (main Class는 반드시 위와 같은 형식으로 만들어 져야 합니다.)
  
  
  
### unreportes exception java.io.IOException(ExceptionName);must be caught or declared to be thrown
+ 예외가 발생하는데 예외를 처리해주지 않았을 경우
> 예외를 발생하는 메소드 같은 경우는 반드시 예외 처리르 해주어야 합니다. 
  예외를 발생하거나 예외 처리리를 해야하는 Method는 API를 확인해보면 알수있음
  그렇지 않다면 Compile 후 지금처럼 Error가 난 예외를 예외처리해주면 가능
  또한, 예외르 처리할 때는 Method 차원에서 throws 예외명을 이용하여 처리할 수있고 try{} catch{}구문을 이용해서 직접 처리해줄수있음
  특히, 예외도 Class이므로 반드시 예외가 들어간 패키지를 import!해주어야 합니다.
  
  
  
### Note : Calculator.java(FileName) user or overrides a deprecated API.
### Note : Recompile with-deprecation for details.
+ JDK 버전이 높아졌거나 보안들의 기타 이유로 사용이 deprecated된 Method를 사용한 경우
> 예외라기 보다 경고(실행X) JDK가 버전이 높아지거나 보안등의 이유에 따라 예전에 만들어졌지만 필요가 없어지거나 대체된 Method가 생겨남
  그런 Method를 deprecated되었다고 하는데 이것은 API상에 나와있다.
  또한 Compile -deprecation 옵션주면 어떤 Method가 deprecate됐는지 알수 있습니다. 대치되었거나 버전업된 Method를 사용하면됨
  
  
  
### MousEvent(ClassName) should be declared abstract; it does not define mouseDragged(java.awt.event.MouseEvent)
###  [Method Name(Method가 포함된 Class)] in MouseEvent(ClassName)
+ implements한 Interface의 모든 Method를 구현하지 않아서 발생됨
> Interface는 모든 Method가 선언만 되고 구현되지 않은 추상(abstract) Method입니다.
  만약 Interface를 Implements하려면 Implements한 Class가 Interface에서 선언한 모든 Method를 구현해 주어야 합니다.
  하나라도 빠질경우 Implements한 Class도 Abstract Class로 보고 Error가 발생합니다.
  Error에 구혀해 주어야할 Method Name이 나오므로 그곳에 쓰여있느 Method를 구현해 주면 됩니다.
  만약 Method를 구현해 주었는데 Error가 나면 철자 및 대소문자를 다시 확인
  

### incompatible types
### found : /null(입력한 자료형)
### required : int(요구하는 자료형)
+ 입력을 했을때 맞지 않는 DataType이나 ClassType을 입력할 경우
> incompatible 은 '성미가 맞지 않는','모순된' 이라는 뜻을 가진 단어 입니다.
  단어뜻 처럼 입력 경우 required 에 나타난 DataType 및 ClassType을 요구하는데
  found 에서 나타난 DataType 및 ClassType을 써주어서 입력을 하지 못하게 되어서 발생하는 Error입니다.
  found 에 나타난 DataType을 required 에 나타난 DataType으로 변경해 주시면 됩니다.


### package java.servlet(패키지명) does not exist
+ import!한 패키지가 존재하지 않을 경우
> import!한 패키지가 존재하지 않을 경우에 발생하는 Error입니다.
  철자와 대소문자를 먼저 확인하고 CLASSPATH 설정을 확인해 보시기 바랍니다.
  또한 그 곳에 패키지가 jar파일로 있는지도 확인해 보셔야 합니다.
  (API에 나와있는 패키지는 rt.jar에 다 있습니다.
  단 javax가 붙거나 다름으로 시작되는 확장 패키지는 설치해 주어야합니다.(javax.swing 제외))


### java.lang.NullPointerException
### Exception in thread "main"(메소드) java.lang.NullPointerException
### at java.awt.Container.addImpl(Container.java:341)... [에러가 일어난 부분]
+ 참조하거나 사용한 Class 또는 DataType이 초기화 되지 않은 경우
> 보통 이것은 awt나 배열 부분에서 자주 발생하는데 초기화를 해주지 않아서 많이 발생합니다.
  java의 varialbe들은 기본적으로(자동으로 초기화 되는 멤버필드등을 제외하고) 초기화를 요구합니다.
  error에 체크된 부분을 검토해 보시고 초기화를 해주십시요.


### ';'(빠진 부분) expected
+ 문법상으로 써야할 것을 쓰지 않은 경우 발생합니다.
> 주로 ';'을 안써주시거나 아님 '()'(괄호)를 열기만 하고 닫지 않은 실수를 할 경우 발생합니다.
  대부분 이 error가 발생한 경우는 error에 나온것을 소스에 추가해 주시면 됩니다.


### unexpected type
### required : value(요구하는 타입)
### found : class(소스상 써준 타입)
+ 써주어야 할 type이 아닌 잘못된 type을 써주었을 경우
> unexpected type 에러를 해석하면 '기대하지 않은 타입'이란 뜻을 가지고 있습니다.
  즉, 원하는 type(required)이 아닌데 잘못된 type(found)을 써준 경우 발생합니다.
  error 체크된 부분의 type을 required 에서 나타난 type으로 변경해 주시면 됩니다.


### java.lang.ArrayIndexOutOfBoundsException
### at Test.main(Test.java:10)[클래스.메소드(파일명:에러난 위치)]
### Exception in thread "main"(예외가 던져진 메소드)
+ 배열의 범위를 넘어선 값을 넣었을 경우
> 위의 error는 특이하게 Compile은 이상없이 되지만 실행을 하면 발생하는 error입니다.
  배열의 범위를 넘어설 경우에 발생하므로 error난 위치의 배열의 참조 범위를 확인해보시고
  선언해둔 배열의 범위에 맞게 조정해 주시면 됩니다.


### illegal start of expression!
+ 선언자(modifier)를 잘못 집어 넣은 경우
> error의 단어뜻을 확인해 보면 '표현의 시작이 부적격 합니다.'하고 해석할 수 있습니다.
  보통 선언자가 맞지 않거나 쓰일데가 아닌데 선언자를 줄 경우에 많이 발생합니다.
  특히 Method안에서 static 선언자를 쓴 경우에는 직격으로 볼수 있죠.
  에러가 난 부분의 선언자를 제거하거나 맞는 것인지 다시 확인해 보십시요.


### java.io.InputStream(클래스) is abstract; cannot be instantiated
+ abstract로 선언된 클래스를 직접 new 명령어를 이용하여 인스턴스화 할 경우
> abstract로 선언된 클래스를 직접 new 명령어를 이용하여 인스턴스화 할 경우에 발생하는 에러입니다.
  왜냐하면, Abstract Class는 직접 new 명령어를 이용하여 인스턴스화 할수 없기 때문입니다.(객체를 못만든다구요.)
  이 경우에는 인스턴스를 다른 방법으로 생성하시면 됩니다.
  예를 들어 인스턴스를 반환하는 Method를 이용한다거나 상속을 통해서 상속받은 Class의 인스턴스를 만들어
  직접 인스턴스를 만드는 효과를 낼수도 있구요. 원하시는 방법으로 바꾸어 보시길...


### local variable name(변수명) is accessed from within inner class; needs to be declared final
+ Local Class의 Variable를 final로 선언하지 않은 경우
> Local Class의 Variable는 Reference Variable의 참조값 변동을 방지하기 위하여 final 선언자를 붙여주어야 합니다.
  Variable에 final 선언자를 붙이면 Variable은 값을 변동할 수 없는 상수 처럼 쓰이며
  만약 이 값을 참조할 경우 자바는 이 값을 넘기는게 아니라 이 값의 복사본을 참조 값으로 넘기게 됩니다.
  그러므로 Local Class에서 참조값 변동없이 Variable를 참조할 수 있게 되는 것입니다.
  Local Class를 정의해준 곳을 살펴보고 final 선언자를 확실하게 확인하시기 바랍니다.


### inner classes cannot have static declarations
+ 내부 Class 안에서 static 선언자를 쓴 경우
> 내부 Class 안에서는 static 선언자를 쓸수 없습니다.
  내부 Class 안에서 사용된 static 선언자를 제거해 주십시요.

  
### referenceto List is ambiguous,both class java.util.List(클래스) in java.util(패키지)
### and class java.awt.List(클래스) in java.awt(패키지) match
+ Class 사용시 다른 패키지내에 동일이름의 Class들이 있어서 참조가 모호할 경우
> 예시를 보면 아시겠지만 import! 한 패키지중에 같은 이름을 사용하는 Class를 Class 이름만으로
  생성함으로서 참조가 모호해질 경우 발생하는 error입니다.
  이와 같은 경우는 import!를 하나 제거 하거나 아님 java.util.List 이런식으로
  직접 그 Class의 패키지를 같이 써줌으로서 모호성을 제거할수 있습니다.

### m()(MethodName) in B(ClassName) cannot override m()(MethodName) in A(ClassName));
### attempting to use incompatiable return type
+ Class를 상속받고서 Method를 오버라이드 하고자할때 잘못한 경우
> Class를 상속받고서 Method를 오버라이드 할 경우에는 지켜야 하는 규칙이 있습니다.
  1. Method의 이름이 같아야 합니다.
  2. Method의 파라미터 개수, DataType이 같아야 합니다.
  3. Method의 리턴형이 같아야 합니다.
  4. 상위 Method와 동일하거나 더 구체적인 Exception을 발생시켜야 합니다.
  5. 상위 Method와 동일하거나 접근범위가 더 넣은 접근 제한자를 사용해야 합니다.
   Method 오버라이드시 위 규칙을 잘 지켰는가를 다시 한번 확인해 보세요.


### getPathBetweenRows(int,int)(Method) has protected access in javax.swing.jTree(Class)
+ protected로 선언된 Method를 상속 없이 직접 불러쓸 경우
> protected로 선언되어 있는 Method는 상속하거나 같은 package에 있을 때만 쓸 수 있습니다.
  상속해서 다시 public Method로 값을 받던지 아니면
  public Method 중에서 비슷한 기능을 하는 Method가 있는지 찾아서 바꾸어주어야 합니다.


### invalid method declaration; return type required
+ 리턴 타입을 쓰지 않아 Method의 선언이 잘못된 경우
> 리턴 타입을 쓰지 않아 Method의 선언이 잘못된 경우에 발생하는 에러이므로
> 에러가 발생한 Method를 확인해보고 리턴 타입을 맞게 적어주어야 합니다.


### Error occurred during initialization of VM
### java.lang.ExceptionInInitializerError
+ static으로 선언된 Variable중 초기화가 안되어 있는 것이 있는 경우
> static으로 선언된 Variable중에 초기화가 안된게 있는 경우에 발생하는 에러이므로
  에러가 발생한 변수를 확인해보고 알맞은 초기화를 시켜주거나 Variable의 위치를
  자동 초기화가 가능한 Method 밖의 Class Variable로서 사용하게 합니다.


### Error opening registry key 'Software\JavaSoft\Java Runtime Environment'
### Error: could not find java.dll
### Error: could not find Java 2 Runtime Environment
+ 중복설치 등으로 인해 레지스트리 키값이 잘못되어 있는 경우
> 중복설치 등으로 인해 레지스트리 키값이 잘못되어 있는 경우에 발생하는 에러이므로
  레지스트리 편집기를 열어서 HKEY_LOCAL_MACHINE -> SOFTWARE -> JavaSoft에
  보시면 3개의 키가 있을 겁니다. 그중에서 첫번째 키인 Java 런타임 환경 을 마우스
  오른쪽 버튼으로 클릭하여 Java Runtime Environment로 이름을 바꿔주시면 됩니다.


### Error Registry Key 'Sofrware\JavaSofrware\Java Runtime Environment\CurrentVerison'
### has value '1.1',but '1.3' is requried.
### Error: could not find java.dll
### Error: could not find java 2 Runtime Enviroment.
+ 중복설치 등으로 인해 레지스트리 키값의 자바 버전이 잘못되어 있는 경우
> 중복설치 등으로 인해 레지스트리 키값의 자바 버전이 잘못되어 있는 경우에 발생하는 에러이므로
  레지스트리 편집기를 열어서 HKEY_LOCAL_MACHINE -> SOFTWARE -> JavaSoft -> Java Runtime Environment의 Current version의 
  값을 1.3으로 되어있는지 확인해 주시면 됩니다.


### java.lang.ClassNotFoundException: org.gjt.mm.mysql.Driver(드라이버명)
+ JDBC로 데이터 베이스에 연결하는 중 드라이버를 찾지 못할 경우
> JDBC를 연결하는 중에 드라이버를 찾지 못할 경우에 발생하는 에러이므로
  각 데이터 베이스에 맞는 드라이버가 제대로 다운로드 되었는지 확인해 보시고
  드라이버의 위치가 클래스 패스에 잡혀 있는지 확인해주시면 됩니다.
 

### Method printIn(java.lang.String)(MethodName) not found in class java.io.PrintStream(ClassName)
+ 자신이 사용한 Class의 Method가 맞지 않는(=없는)경우
> 자신이 사용한 Class의 Method가 맞지 않는(=없는) 경우에 발생하는 에러이므로
  API를 통해서 사용하고자 하는 Class와 Method를 다시 한번 확인해 봅니다.
  보통 이경우 메소드의 철자나 대소문자를 잘못 쓴 경우가 많으니 그점을 유심히 살표봅니다.
  마지막으로 철자와 대소문자도 맞는다면 메소드의 인자의 객체형을 맞게 주었는지 확인해보면 됩니다.


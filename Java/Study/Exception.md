Exception
============
+ 보통 Error, 오류 라고 하는데 Java에서는 Exception이라고 부른다.
+ 프로그램이 종료되지 않고 계속 진행이 될 수 있도록 처리 가능한 에러를 Exception이라고 한다.
+ Java에서는 이러한 예외적인 사항을 처리할 수 있도록 API를 제공하는데 java.lang.Throwable을 상속받은 java.lang.Exception이 그것이다.
+ 예외적인 사항을 처리할 수 있도록 API를 제공하는데 객체가 JVM에 의하여 생성되어 넘어오게 되고 프로그래머는 해당사항에 맞게 Exception Handling해주어야한다.


Runtime Exception
--------------
+ NullPointException : 사용하려는 객체의 변수가 null일때
+ IndexOutOfBoundsException : 지정된 범위 밖의 값을 참조하려 할 때
+ ArithmeticException : 0으로 나누었을 때


RuntimeException 이외의 Exception
--------------
+ IOException : 입출력과 관련되 Exception
+ SQLException : SQL 사용 시 발생할 수 있는 Exception
+ ClassNotFoundException : 해당 class를 찾지 못했을 때


Exception Handling
-------------------
+ 예측하고 방지하는 측면에서 사용됨
+

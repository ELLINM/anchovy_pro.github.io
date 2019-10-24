Java 컴파일&실행
-------------
1. yum install java-devel
2. touch 를 통해 java 파일 생성
3.javac 파일명.java 를 통해 컴파일
4.java 파일명(확장자 없음)으로 실행

+ ex) touch test.java -> vi test.java -> javac test.java -> java test
+ ex) 코드 본문에 args를 활용하면 덧붙여 활용이 가능함
<pre>
class test{
  public static void main(Sting [] args){
    System.out.println("Hello," + args[0]);
  }
}
</pre>


파이썬 실행
------
1.touch로 py 파일 생성
2.python 파일명.py 로 실행

 

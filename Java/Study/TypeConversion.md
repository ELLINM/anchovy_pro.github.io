int -> str
-------
<pre>String str = "";

int a = 45;

str = a+"";</pre>



str -> int
---------
<pre>int num = 0;

String str = "45";

num = (int)str; //작동하지 않음
try{ //double 형일 경우 interger를 double로 바꿔준다
num = Interger.parseInt(str);
System.out.println("숫자입니다. : " + num);
}catch(Exception e){
  System.out.println("숫자가 아닙니다.");
  }</pre>

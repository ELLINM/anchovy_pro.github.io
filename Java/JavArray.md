Array
================


Array? 배열이란?
-----------------------
+ Array는 같은 데이터 타입들의 변수를 여러개 할당 받아 사용하는 집합의 개념
+ 동일한 데이터 타입과 동일한 이름으로 정의된 각각의 변수는 자신만의 고유한 숫자로 된 Index로 구분
> Index 값은 0으로 부터 시작
+ Java Array는 모든 Primitive Type의 Data와 Reference Type을 저장할 수 있다.


Array의 생성
-----------------
+ Array를 선언하고 사용하기 위해서는 먼저 Array를 선언하고 new 키워드를 이용하여 메모리에 할당 해주어야 한다.
<pre>배열변수 선언 및 생성 문법
ex)선언
<DataType>[]<ArrayName>;
or
<DataType><ArrayName>[];

ex)생성
<ArrayName> = new <DataType>[생성개수]
 
ex)선언과 생성
<DataType>[]<ArrayName> = new <DataType>[생성개수]</pre>
 
+ Java에서는 배열을 선언할 때 [](Square Bracket)위치가 정해져 있지 않다. 즉 ArrayName의 앞이나 뒤 위치는 중요치않다.
> ex)
int[] ArrayName = new int[생성 개수];
int ArrayName[] = new int[생성 개수];

+ 배열을 선언할 때 주의할 점은 선언부에서는 배열의 크기를 지정할 수 없음 생성 시점을 지정할 수 있음


Array Initialization(배열의 초기화)
-----------------
+ Array Initialization란 생성된 Array에 실제 값을 대입하는 작업
+ Array Initialization 하지 않으면 Array의 각 요소들은 해당 DataType의 기본값으로 초기화가 이루어 진다.
> ex) int형 Array의 경우 0으로 초기화
> Array 변수 초기화 문법 ex) ArrayName[Index Num] = Data;


Array의 사용과 Length
-------------------
+ Array에 대입한 값을 사용하기 위해서는 Array Initialization와 마찬가지로 Index 번호값을 지정하여 값을 호출한다.
+ 생성된 Array 객체에는 자동을 그 배열의 개수를 저장한 Length라는 속성값이 생긴다.
> 이말은 곧 생성된 Array객체의 Length속성을 이용 Array의 길이를 알아낼 수 있다.


Arrays of Objects (객체 배열)의 선언 및 사용
---------------
+ Arrays of Objects는 생성된 Array내에 Primitive Data가 아닌 Reference Type을 넣어서 사용하는 것이다.
> ex) String[] s = new String[5] 변수 s는 String Type을 저장할 수 있는 5개의 방을 가진 배열 변수이다.

Arrays of Objects의 선언과 생성
-------------------
+ 선언 : Primitive Type과 Reference Type을 모두 포함하며 선언에서는 아직 기억장소를 할당하지 않고 단순 참조값을 할당하는 역할
+ 생성
> Array 생성 문법 1 (이미 선언이 되어있는 Array에 대해서)
<pre>ex) <Array Name> = new <Data Type>[생성 개수];</pre>

> Array 생성 문법 2 (선언과 함께 생성)
<pre>ex) <Data Type> [] <Array Name> = new <Data Type>[생성 개수];

+ [생성 개수] 에는 생성될 Array의 크기값이 들어가며 Array의 개수를 나타낸다.
+ Array Index는 일반적인 Array와 마찬가지로 0부터 시작한다.


Arrays of Objects Initialization(객체 배열의 초기화)
-------------
+ Arrays of Objects는 Array를 생성하기 위해 new를 이용하여 생성하고 Array내에 Object의 참조값을 할당 하기 위해 Object 생성을 위한 new명령을 해야한다.
+ Arrays of Objects을 Initialization시키지 않을 경우 Object type의 Default Value(기본 값)인 null로 초기화 된다.
> ex) Array Initialization 문법 1
<pre> <Array Variable Name>[0] = Data; </pre>

Array Initialization 문법 2
<pre> <Array Variable Name>[0] = new DataType(); </pre>

![Data Type Default Value] (https://i.stack.imgur.com/T4h0h.png)

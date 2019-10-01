Java.Util
======
+ java.util 패키지(Package)
  + Java 프로그래밍에 유용한 클래스들을 모아둔 것으로 대표적인 클래스로는 날짜와 관련된 Date, Calendar 가 있으며, 
    자료구조와 관련된 Collection 프레임워크 관련 클래스들이 포함
    
+ java.util 패키지에 포함되는 class
  + AbstractCollection, AbstractList, AbstractSequentialList, LinkedList, ArrayList, Vector, Stack, 
    AbstractSet, HashSet, LinkedHashSet, TreeSet, AbstractMap, HashMap, LinkedHashMap, TreeMap, 
    Arrays, BitSet, Calendar, GregorianCalendar, Collection, Date, Dictionary, Hashtable, Properties, 
    EventObject, Locale, Observable, Random, Scanner, StringTokenizer
     
 
 Date Class
 -----
 + Date와 Calandar를 사용 Locale을 추가하여 지역화 지원
 
|Method|Contents|
|------|------|
|gerYear( )|메서드만 기준이 1900년도로 설정|
|getHours( )|현재 시간을 반환 0~ 23시|
|getMinutes( )|현재 분을 반환 0 ~ 59분|
|getSeconds( )|현대 초를 반환 0 ~ 59초|
|getTime( )|현재 날자 시간 정보를 Date 클래스 형태로 반환|
|getInstance( )|Calendar 인스턴스를 생성하여 반환|
|set( )|연월일시분초에 해당되는 매개변수를 받아 set|
|get( )|해당 필드값을 반환|
|after( )|매개변수 Calendar 객체의 시간이 더 크다면 true 반환|
|befor( )|after와 반대 기능을 수행|
|equals ( )|두 객체의 날자 시간 정보가 같으면 true 반환|
|add( )|필드값에 대해 감산 및 가산|
|roll( )|필드값을 변경하지 않고 감산 가산, 범위가 해당 필드 범위사이에서 설정 일에 대한 기준은 해당 월에 따른 일수에 따라 설정|



Random Class
------
+ Random Class seed값에 의한 난수를 생성해 반환하는 클래스로 정수, 실수, 부울값(true|false) 등으로 반환이 가능

 
ArrayList Class
-------
+ 배열의 기능과 가장 비슷한 클래스로 저장공간으로 배열을 사용한다. 저장 순서가 유지되고 중복이 허용
  기존에 사용되던 Vector 클래스를 대체하는 클래스로 비동기 방식 동작으로 Vector 가 갖고 있는 처리 속도가 개선

|Method|Contents|
|------|------|
|add()|해당 데이터를 리스트에 추가한다. 인덱스(index) 사용으로 입력 순서를 변경|
|contains()|해당 데이터가 자신의 리스트에 포함되어 있는지를 확인|
|set()|해당 데이터 자체를 대체하거나 순서를 변경할 때 사용|
|get()|인덱스에 해당하는 해당 데이터를 반환|
|remove()|인덱스 혹은 자료에 의한 데이터를 삭제|
|size()|현재 리스트의 크기를 반환|


LinkedList Class
------
+ Queue 인터페이스를 상속받은 클래스로 ArrayList와 동일한 메소드를 가지고 있으며, 
  데이터 추가시 첫번째 원소와 마지막 원소에 데이터를 추가할 수 있는 addFirst(), addLast() 메소드를 가지고 있음

|Method|Contents|
|------|------|
|peek()|데이터를 반환, 복사 기능에 해당|
|poll()|데이터를 반환, 잘라내기 기능에 해당|

 
HashSet Class
------
+ 집합을 구체화하기위한 Set 인터페이스를 상속받은 클래스로 자료의 중복을 허용하지 않으며, 순서가 존재하지 않음

|Method|Contents|
|------|------|
|add()|데이터를 추가, 중복된 자료가 있는 경우 제외|

Hashtable Class
------
+ 키(key)와 값(value) 쌍을 이루는 데이터 집합으로 순서를 유지하지 않음
  값의 중복은 허용되지만 키의 중복은 허용되지 않음, 기존의 HashMap 클래스를 데체하기 위한 클래스로 비동기 방식 동작으로 처리 속도가 개선
 
|Method|Contents|
|------|------|
|put(key, value)|해당 키와 값을 저장|
|containsKey()|해당 키가 있는지 확인|
|containsValue()|해당 값이 있는지 확인|
|keys()|등록된 모든 키밧을 반환|
|get()|키에 해당하는 값을 반환|


 
 

List
-----
+ 가변성 - 속성값을 바꿀 수 있음
+ []로 선언
+ len(list) : 길이를 알려주는 함수
+ sorted(list) : 순서대로 정렬
+ sum(list) : list내부를 전부 합
+ list.index(n) : n의 위치를 검색
+ n in list : n이 list안에 있는지 확인 True or False로 반환 
+ list 반복(*) : 
<pre>
a = [1, 2, 3]
a * 3
[1, 2, 3, 1, 2, 3, 1, 2, 3]
</pre>

+ del 함수 사용해 list 요소 삭제 : 
<pre>
a = [1, 2, 3]
del a[1]
print(a)
[1, 3]
</pre>

+ 리스트에 요소 추가(append) : 
<pre>
a = [1, 2, 3]
a.append(4)
print(a)
[1, 2, 3, 4]
</pre>
리스트 안에는 어떤 자료형도 추가할 수 있다.


+ reverse : reverse 함수는 리스트를 역순으로 뒤집어 줌
-  리스트 요소들을 순서대로 정렬한 다음 다시 역순으로 정렬하는 것이 아니라 그저 현재의 리스트를 그대로 거꾸로 뒤집음
<pre>
a = ['a', 'c', 'b']
a.reverse()
print(a)
['b', 'c', 'a']
</pre>

+ insert : insert(a, b)는 리스트의 a번째 위치에 b를 삽입하는 함수
<pre>
a = [1, 2, 3]
a.insert(0, 4)
print(a)
[4, 1, 2, 3]
</pre>


+ remove : remove(x)는 리스트에서 첫 번째로 나오는 x를 삭제하는 함수
<pre>
a = [1, 2, 3, 1, 2, 3]
a.remove(3)
print(a)
[1, 2, 1, 2, 3]
</pre>


+ pop : pop()은 리스트의 맨 마지막 요소를 돌려주고 그 요소는 삭제
<pre>
a = [1,2,3]
a.pop()
3
print(a)
[1, 2]
</pre>

 - pop(x)는 리스트의 x번째 요소를 돌려주고 그 요소는 삭제한다.
<pre>
a = [1,2,3]
a.pop(1)
2
print(a)
[1, 3]
</pre>
a.pop(1)은 a[1]의 값을 끄집어낸다. 다시 a를 출력해 보면 끄집어낸 값이 삭제된 것을 확인할 수 있다.

+ count : List 안에 x가 몇 개 있는지 조사하여 그 개수를 돌려주는 함수
<pre>
a = [1,2,3,1]
a.count(1)
2
</pre>
1이라는 값이 리스트 a에 2개 들어 있으므로 2를 돌려준다.

+ extend : extend(x)에서 x에는 리스트만 올 수 있으며 원래의 a 리스트에 x 리스트를 더해줌
<pre>
a = [1,2,3]
a.extend([4,5]
print(a)
[1, 2, 3, 4, 5]
b = [6, 7]
a.extend(b)
print(a)
[1, 2, 3, 4, 5, 6, 7]
</pre>


+ for문
<pre>
for n in x : 
  print (n)
</pre>

+ if문
<pre>
if 4 in x:
  syntax
</pre>


Tuple
------
+ list와 크게 차이 없음 - 불변함 속성을 바꿀 수 없음
+ ()로 선언


Dictionary
------
+ {}로 선언
+ key와 value로 구성
+ List에서 사용할 수 있는 속성들을 사용 가능
+ Key는 고유한 값이므로 중복되는 Key 값을 설정해 놓으면 하나를 제외한 나머지 것들이 모두 무시
+ keys, values : 모든 key와 value를 확인 
<pre>
x = {
  "key" : "value"
</pre>

<pre>
x = {
  0 : "HELLO",
  1 : "NOPE",
  "HELLO" : 2019
}

for key in x:
  print("key : " + str(key))
  print("value : " + str(x[key]))
</pre>

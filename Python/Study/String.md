Python 문자열의 특징
----

Ex)
<pre>
>>>string = 'abcde
</pre>

+ 문자열 string에서 가운데 위치한 c를 x로 변경하고 싶다면
  문자열 slicing을 사용하여 요소를 변경
  주의할 점은 string의 요소를 직접 변경하지 않았다는점

<pre>
>>> new_string = string[:2] + 'x' + string[3:]
>>> new_string
'abxde'
</pre>

+ 내장함수(Built-in function)중 replace를 이용
  replace()함수 인자에 기존 문자열과 바꿀 문자열을 전달하면 바뀐 문자열을 반환
  마찬가지로 string의 요소를 직접 변경하지 않았다는점
  
  <pre>
  >>> string = 'abcde'
>>> new_string = string.replace('c','x')
>>> new_string
'abxde'
  </pre>

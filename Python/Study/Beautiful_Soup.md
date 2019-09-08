Beautiful Soup
======
+ HTML 및 XML 문서를 구문 분석하기위한 Python 패키지 
+ HTML에서 데이터를 추출하는 데 사용할 수있는 구문 분석 된 페이지에 대한 구문 분석 트리를 작성
+ 웹 스크래핑에 유용


기능
------
find(name, attrs,recursive, string, **kwargs) : 조건에 맞는 태그를 가져옴, 조건에 맞는 태그가 1개 이상이면 가장 첫번째 태그를 가져옴
<pre>
result = bs.find('p')
print(result)
</pre>

find_all(name, attrs,recursive, string, limit, **kwargs) :  조건에 맞는 모든 태그를 가져옴
<pre>
result = bs.find_all('p')
print(result)
</pre>

class 명으로 검색
<pre>
result = bs.find('tag type', class_="class name")
print(result)
</pre>

id 명으로 검색
<pre>
result = bs.find('tag type', id="id name")
print(result)
</pre>

해당 태그명 출력
<pre>
result = bs.find('tag type', id="id name")
print(result.name)
</pre>

해당 id 명 출력
<pre>
result = bs.find('tag type', id="id name")
print(result['id'])
</pre>

해당 class 명 출력
<pre>
result = bs.find('tag type', class="class name")
print(result['class'])
</pre>

태그 사이에 있는 내용 출력
<pre>
result = bs.find('tag type', class="class name")
print(result.p.text)
 #검색된 태그 내의 모든 p 태그 조회
 for tag in result.find_all('p'):
  print(tag.text)
</pre>

태그 내의 속성값 출력
<pre>
result = bs.find('a', class='a')
print(result.get('href))
</pre>





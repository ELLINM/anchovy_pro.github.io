DOM (Document Object Model)
=======
+ DOM은 넓은 의미로 웹 브라우저가 HTML 페이지를 인식하는 방식
+ document 객체와 관련된 객체의 집합 
+ Tree 구조로 형성


Tree
------
+ 하나의 root node에서 시작
+ Tree형 자료구조는 흔히 위의 root node에서 아래로 퍼져나가는 형태 
+ Tree에서는 위쪽의 node를 부모(parent) 노드 아랫쪽 노드를 자식(child)
+ root node는 가장 위에서 시작되는 node이니까 parent가 없는 node
+ children(자식)이 없는 node를 leaf node
+ tree 구조에서 root node를 포함한 모든 개개의 개체를 node라고 표현
+ head, body, title, script, h1, HEADER-1 등의 태그뿐 아니라 태그 안의 텍스트나 속성 등도 모두 node 
+ HTML Tag를 Element Node(요소 노드)라고 부르고 Element Node 안에 있는 글자를 Text Node라고 부르기도 함


문서 객체의 생성
-------
+ Web Browser가 HTML 페이지에 적혀 있는 Tag를 읽으면 생성
+ HTML 페이지에 없던 문서객체를 JavaScript를 이용해서 생성(동적으로 문서객체를 생성)
+ 처음에는 HTML 페이지에 없던 문서객체를 동적으로 생성 


DOM의 사용
------
Ex)
~~~~~~
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 문서객체 모델(DOM)</title >
<script type= "text/javascript">
    
</script>
</head>
<body>
   <h1 id ="header_1" name= "" >HEADER-1 </h1 >
   <div >
      <h1 id = "header_2">HEADER-2</h1 >
   </div >
   <hr >
   <h1 id = "clock"></h1>
</body>
</html>
~~~~~~~

1. JavaScirpt를 통한 동적으로 문서객체를 생성
   <pre>var header = document.createElement('h2'); </pre>
2. document 객체에 접근해서 <h2> 태그를 생성
   <pre>var textNode = document.createTextNode('Hello DOM');</pre>
3. document 객체에 접근해서 TextNode를 생성하고 'Hello DOM'이라는 스트링을 넣어주고 있습니다.
   <pre>header.appendChild(textNode);</pre>
4. <h2> 태그에 자식노드를 추가
   <pre>document.body.appendChild(header);</pre>
5. document객체를 통해서 body 객체에 접근
   body객체에 자식 노드를 추가 <h2> 태그를 생성해서 TextNode까지 추가했던 header

Ex) JavaScript 추가
~~~~~
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 문서객체 모델(DOM)</title >
<script type= "text/javascript">
    window.onload = function(){
       //1. 문서 객체 생성
       var header = document.createElement('h2'); //h2 태그를 생성해주는 것
       var textNode = document.createTextNode('Hello DOM');

       //2. 노드(요소/텍스트)를 연결.
       header.appendChild(textNode);

       //3. body 문서 객체에 header 문서 객체를 추가.
       document.body.appendChild(header);
    };
</script>
</head>
<body>
   <h1 id ="header_1" name= "" >HEADER-1 </h1 >
   <div >
      <h1 id = "header_2">HEADER-2</h1 >
   </div >
   <hr >
   <h1 id = "clock"></h1>
</body>
</html>
~~~~

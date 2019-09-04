from urllib.request import urlopen
from bs4 import BeautifulSoup

html = urlopen("http://www.naver.com")
bsObject = BeautifulSoup(html, "html.parser")

print(bsObject)
'''
웹 문서 전체 가져오기
<!DOCTYPE doctype html>

<html lang="ko">
<head>
<meta charset="utf-8"/>
<meta content="origin" name="Referrer"/>
<meta content="text/javascript" http-equiv="Content-Script-Type"/>
<meta content="text/css" http-equiv="Content-Style-Type"/>
<meta content="IE=edge" http-equiv="X-UA-Compatible"/>
<meta content="width=1100" name="viewport"/>
<meta content="NAVER" name="apple-mobile-web-app-title">
<meta content="index,nofollow" name="robots">
<meta content="네이버 메인에서 다양한 정보와 유용한 컨텐츠를 만나 보세요" name="description">
<meta content="네이버" property="og:title"/>
<meta content="https://www.naver.com/" property="og:url"/>
<meta content="https://s.pstatic.net/static/www/mobile/edit/2016/0705/mobile_212852414260.png" property="og:image"/>
<meta content="네이버 메인에서 다양한 정보와 유용한 컨텐츠를 만나 보세요" property="og:description">
<meta content="summary" name="twitter:card"/>
<meta content="" name="twitter:title"/>
<meta content="https://www.naver.com/" name="twitter:url"/>
<meta content="https://s.pstatic.net/static/www/mobile/edit/2016/0705/mobile_212852414260.png" name="twitter:image"/>
<meta content="네이버 메인에서 다양한 정보와 유용한 컨텐츠를 만나 보세요" name="twitter:description">
<link href="/favicon.ico?1" rel="shortcut icon" type="image/x-icon"/>
<link href="https://pm.pstatic.net/css/main_v190814.css" rel="stylesheet" type="text/css"/>
<link href="https://pm.pstatic.net/css/webfont_v170623.css" rel="stylesheet" type="text/css"/>
<link href="https://ssl.pstatic.net/sstatic/search/pc/css/api_atcmp_190612.css" rel="stylesheet" type="text/css"/>
<script src="https://pm.pstatic.net/js/c/nlog_v181107.js" type="text/javascript"></script>
<script src="https://ssl.pstatic.net/tveta/libs/assets/js/common/min/probe.min.js" type="text/javascript"></script>
<script type="text/javascript">
var nsc = "navertop.v3";
document.domain = "naver.com";
var jindoAll = "";
var iframeLazyLoad = false;
if (!!!window.console) {window.console={};window.console["log"]=function(){}}
var isLogin = false; 
function refreshLcs(etc) {etc = etc ? etc : {};if(document.cookie.indexOf("nrefreshx=1") != -1) {etc["mrf"]="1";} else {etc["pan"]="emo";}return etc;}
'''

print(bsObject.head.title)
#타이틀 가져오기 <title>NAVER</title>

for meta in bsObject.head.find_all('meta'):
    print(meta.get('content'))
 '''
 모든 메타 데이터의 내용 가져오기
 None
origin
text/javascript
text/css
IE=edge
width=1100
NAVER
index,nofollow
네이버 메인에서 다양한 정보와 유용한 컨텐츠를 만나 보세요
네이버
https://www.naver.com/
https://s.pstatic.net/static/www/mobile/edit/2016/0705/mobile_212852414260.png

 '''

print(bsObject.head.find("meta",{"name":"description"}))

'''
원하는 태그내용 가져오기
<meta content="네이버 메인에서 다양한 정보와 유용한 컨텐츠를 만나 보세요" name="description">
<meta content="네이버" property="og:title"/>
<meta content="https://www.naver.com/" property="og:url"/>
<meta content="https://s.pstatic.net/static/www/mobile/edit/2016/0705/mobile_212852414260.png" property="og:image"/>
<meta content="네이버 메인에서 다양한 정보와 유용한 컨텐츠를 만나 보세요" property="og:description">
<meta content="summary" name="twitter:card"/>
<meta content="" name="twitter:title"/>
<meta content="https://www.naver.com/" name="twitter:url"/>
<meta content="https://s.pstatic.net/static/www/mobile/edit/2016/0705/mobile_212852414260.png" name="twitter:image"/>
<meta content="네이버 메인에서 다양한 정보와 유용한 컨텐츠를 만나 보세요" name="twitter:description">
<link href="/favicon.ico?1" rel="shortcut icon" type="image/x-icon"/>
<link href="https://pm.pstatic.net/css/main_v190814.css" rel="stylesheet" type="text/css"/>
<link href="https://pm.pstatic.net/css/webfont_v170623.css" rel="stylesheet" type="text/css"/>
<link href="https://ssl.pstatic.net/sstatic/search/pc/css/api_atcmp_190612.css" rel="stylesheet" type="text/css"/>
<script src="https://pm.pstatic.net/js/c/nlog_v181107.js" type="text/javascript"></script>
<script src="https://ssl.pstatic.net/tveta/libs/assets/js/common/min/probe.min.js" type="text/javascript"></script>
<script type="text/javascript">
var nsc = "navertop.v3";
document.domain = "naver.com";
var jindoAll = "";
var iframeLazyLoad = false;
if (!!!window.console) {window.console={};window.console["log"]=function(){}}
var isLogin = false; 
function refreshLcs(etc) {etc = etc ? etc : {};if(document.cookie.indexOf("nrefreshx=1") != -1) {etc["mrf"]="1";} else {etc["pan"]="gam";}return etc;}

</script>
<title>NAVER</title>
</meta></meta></meta>

'''

print(bsObject.head.find("meta",{"name":"description"}).get('content'))
'''
meta tag의 content 내용
네이버 메인에서 다양한 정보와 유용한 컨텐츠를 만나 보세요
'''

for link in bsObject.find_all('a'):
    print(link.text.strip(), link.get('href'))
'''
모든 링크의 텍스트와 주소 가져오기
@txt@ javascript:;
기록 삭제 javascript:;
검색어저장 끄기 javascript:;
자동완성 끄기 javascript:;
기록 전체 삭제 javascript:;
완료 javascript:;
기록 전체 삭제 javascript:;
검색어저장 끄기 javascript:;
자동완성 끄기 javascript:;
닫기 javascript:;
자세히보기...
'''





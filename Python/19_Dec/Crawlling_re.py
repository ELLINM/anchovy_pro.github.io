import urllib.request
import urllib.parse
from bs4 import BeautifulSoup

'''
영어로 검색하면 정상 출력 한글로 출력하면 깨짐 ascii 코드 문제
-> 문제 해결을 위해 urllib.parse를 입력
'''

baseUrl = 'https://search.naver.com/search.naver?where=post&sm=tab_jum&query='
plusUrl = input('검색어를 입력하세요:')

'''
네이버에 파이썬 검색
url = https://search.naver.com/search.naver?sm=tab_hty.top&where=post&query=파이썬
-> 파이썬 프로그램으로 붙여넣기 하면
https://search.naver.com/search.naver?sm=tab_hty.top&where=post&query=%ED%8C%8C%EC%9D%B4%EC%8D%AC

baseurl = 'https://search.naver.com/search.naver?sm=tab_hty.top&where=post&query='
파이썬 = %ED%8C%8C%EC%9D%B4%EC%8D%AC
'''

url = baseUrl + urllib.parse.quote_plus(plusUrl)
html = urllib.request.urlopen(url).read()
soup = BeautifulSoup(html, 'html.parser')

title = soup.find_all(class_='sh_blog_title')

for i in title:
    print(i.attrs['title'])
    print(i.attrs['href'])
    print()


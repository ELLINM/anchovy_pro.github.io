from bs4 import BeautifulSoup
import urllib.parse
import urllib.request

plusUrl = urllib.parse.quote_plus(input('검색어를 입력하세요:'))

pageNum = 1
count = 1

i = input('몇페이지 크롤링 할까요 : ')

lastPage = int(i) * 10 - 9
#최대 페이지를 정해 줌

while pageNum < lastPage + 1 :
    url = f'https://search.naver.com/search.naver?date_from=&date_option=0&date_to=&dup_remove=1&nso=&post_blogurl=
    &post_blogurl_without=&query={plusUrl}&sm=tab_pge&srchby=all&st=sim&where=post&start={pageNum}'
    #formating을 해주도록함 검색어, 페이지 갯수
    
    html = urllib.request.urlopen(url).read()
    soup = BeautifulSoup(html, 'html.parser')

    title = soup.find_all(class_='sh_blog_title')

    print(f'-----{count}페이지 결과-----')
    for i in title:
        print(i.attrs['title'])
        print(i.attrs['href'])
    print()

    pageNum += 10
    count += 1
    #한바퀴 돌때 마다 페이지와 카운트 

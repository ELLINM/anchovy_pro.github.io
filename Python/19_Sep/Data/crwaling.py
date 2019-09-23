from selenium import webdriver

chrome_options = webdriver.ChromeOptions()
chrome_options.add_argument('headless')
chrome_options.add_argument("--disable-gpu")
chrome_options.add_argument("lang=ko_KR")
driver = webdriver.Chrome('C:\ChromeDriver\chromedriver.exe', chrome_options=chrome_options)

driver.implicitly_wait(10)
driver.get("https://movie.naver.com/movie/bi/mi/basic.nhn?code=167560")
driver.implicitly_wait(10)
select_genre = driver.find_element_by_css_selector('#content > div.article > div.mv_info_area > div.mv_info > dl > dd:nth-child(2) > p > span:nth-child(1) > a').text
select_country = driver.find_element_by_css_selector('#content > div.article > div.mv_info_area > div.mv_info > dl > dd:nth-child(2) > p > span:nth-child(2) > a').text
select_runningtime = driver.find_element_by_css_selector('#content > div.article > div.mv_info_area > div.mv_info > dl > dd:nth-child(2) > p > span:nth-child(3)').text
select_date = driver.find_element_by_css_selector('#content > div.article > div.mv_info_area > div.mv_info > dl > dd:nth-child(2) > p > span:nth-child(4)').text
select_director = driver.find_element_by_css_selector('#content > div.article > div.mv_info_area > div.mv_info > dl > dd:nth-child(4) > p > a').text
select_actor1 = driver.find_element_by_css_selector('#content > div.article > div.mv_info_area > div.mv_info > dl > dd:nth-child(6) > p > a:nth-child(1)').text
select_actor2 = driver.find_element_by_css_selector('#content > div.article > div.mv_info_area > div.mv_info > dl > dd:nth-child(6) > p > a:nth-child(2)').text
select_actor3 = driver.find_element_by_css_selector('#content > div.article > div.mv_info_area > div.mv_info > dl > dd:nth-child(6) > p > a:nth-child(3)').text
select_grade = driver.find_element_by_css_selector('#content > div.article > div.mv_info_area > div.mv_info > dl > dd:nth-child(8) > p > a').text
select_actor = [select_actor1, select_actor2, select_actor3]

print(select_genre)
print(select_country)
print(select_runningtime)
print(select_date)
print(select_director)
print(select_actor1)
print(select_actor2)
print(select_actor3)
print(select_actor)
print(select_grade)

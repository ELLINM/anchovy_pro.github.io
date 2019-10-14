from selenium import webdriver
from selenium.webdriver.common.keys import Keys

driver = webdriver.Chrome()
url = 'https://google.com'
driver.get(url)
#파이참은 터미널로 안된다

driver.find_element_by_css_selector('.gLFyf.gsfi').send_keys('파이썬')
driver.find_element_by_css_selector('.gLFyf.gsfi').send_keys(Keys.ENTER)
#driver.find_element_by_css_selector('.LC20lb').click()
#가장 위의 한개만 가져오려 할때
driver.find_elements_by_css_selector('.LC20lb')[2].click()
#갯수가 정해져 있기 때문에 순번을 정해 줘야함

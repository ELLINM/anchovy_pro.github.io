import cx_Oracle
import data1.crawlling


grade = data1.crawlling.select_grade
director = data1.crawlling.select_director
date = data1.crawlling.select_date
actor1 = data1.crawlling.select_actor1
actor2 = data1.crawlling.select_actor2
actor3 = data1.crawlling.select_actor3
country = data1.crawlling.select_country
genre = data1.crawlling.select_genre
time = data1.crawlling.select_runningtime

conn = cx_Oracle.connect("hr/hr@localhost")
cursor = conn.cursor()

sql = "insert into movie values (:genre, :opendate, :director, :actor1, :actor2, :actor3, :country, :grade, :runningtime)"
data = [genre, date, director, actor1, actor2, actor3, country, grade, time]
cursor.execute(sql, data)
conn.commit()
cursor.close()
conn.close()

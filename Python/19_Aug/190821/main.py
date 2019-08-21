#from animal import dog
#animal pakage에서 dog라는 module을 갖고옴
#from animal import cat

#d = dog.Dog()
#d.hi()

#c = cat.Cat()
#c.hi()

from animal import *
#animal pakage가 갖고있는 module을 다 불러옴

d = Dog()
c = Cat()

d.hi()
c.hi()

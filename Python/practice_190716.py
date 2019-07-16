# 이름과 나이를 받아라
# 나이가 10살 미만이면 "안녕" 이라고 말해라
# 나이가 10~20살이면 "안녕하세요" 라고 말해라
# 그 외에는 "안녕하십니까" 라고 말해라

def sayHello(name, age):
  if age < 10:
    print("안녕, " + name)
  elif age <= 20 and age >= 10:
    print("안녕하세요, " + name)
  elif age > 20:
    print("안녕하십니까, " + name)

sayHello("who1", 8)
sayHello("who2", 12)
sayHello("who3", 24)

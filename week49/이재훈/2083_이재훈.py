while True:
  name, age, weight = input().split()
  age = int(age)
  weight = int(weight)
  
  if name == '#' and age == 0 and weight == 0:
    break
  
  is_senior = False
  if age > 17 or weight >= 80:
    is_senior = True
  
  print(name, "Senior" if is_senior else "Junior")
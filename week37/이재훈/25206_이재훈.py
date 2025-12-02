inputs = [input().split() for _ in range(20)]

dic = {
  'A+': 4.5,
  'A0': 4.0,
  'B+': 3.5,
  'B0': 3.0,
  'C+': 2.5,
  'C0': 2.0,
  'D+': 1.5,
  'D0': 1.0,
  'F': 0.0
}

total_grade = 0
total_p = 0
for el in inputs:
  subject, point, grade = el
  point = float(point)
  
  if grade == 'P':
    continue
  
  total_grade += point * dic[grade]
  total_p += point

print(total_grade / total_p)
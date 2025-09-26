import sys

for line in sys.stdin:
  line = line.rstrip("\n")  # 개행 제거
  lower, upper, num, space = 0, 0, 0, 0
  for x in line:
    if x.islower():
      lower += 1
    elif x.isupper():
      upper += 1
    elif x.isdigit():
      num += 1
    else:
      space += 1
  print(lower, upper, num, space)
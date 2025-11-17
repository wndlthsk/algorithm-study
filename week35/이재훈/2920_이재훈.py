ASC = list(range(1, 9))
DESC = list(range(8, 0, - 1))
line = list(map(int, input().split()))

if line == ASC:
  print('ascending')
elif line == DESC:
  print('descending')
else:
  print('mixed')
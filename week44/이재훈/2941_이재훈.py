croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']

line = input()
n = len(line)

cnt = 0
no_check = 0
for idx in range(n):
  if no_check > idx:
    continue
  
  second = line[idx:idx+2]
  third = line[idx:idx+3]
  if third in croatia:
    no_check = idx + 3
  elif second in croatia:
    no_check = idx + 2
  
  cnt += 1
print(cnt)
T = int(input())

for _ in range(T):
  score = input()
  
  acc, res = 0, 0
  for x in score:
    if x == 'O':
      acc += 1
      res += acc
    else:
      acc = 0
  print(res)
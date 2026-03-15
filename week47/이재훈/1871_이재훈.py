T = int(input())
for _ in range(T):
  first, second = input().split('-')
  
  fst = 0
  for i, ch in enumerate(first):
    fst += (ord(ch) - ord('A')) * (26 ** (len(first) - (i + 1)))
  sec = int(second)
  
  if abs(fst - sec) <= 100:
    print("nice")
  else:
    print("not nice")
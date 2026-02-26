for _ in range(3):
  arr = list(map(int, input().split()))
  zero = arr.count(0)
  
  if zero == 0:
    print("E")
  elif zero == 1:
    print("A")
  elif zero == 2:
    print("B")
  elif zero == 3:
    print("C")
  else:
    print("D")
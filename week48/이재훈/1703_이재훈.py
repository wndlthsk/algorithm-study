import sys
input = sys.stdin.readline

while True:
  data = list(map(int, input().split()))
  if data[0] == 0:
    break
  
  tree = 1
  idx = 1
  
  for _ in range(data[0]):
    a = data[idx]
    b = data[idx + 1]
    idx += 2
    
    tree = tree * a - b
  
  print(tree)
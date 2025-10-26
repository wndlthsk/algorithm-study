N = int(input())

def recursion(num):
  if num == 1:
    return 1
  
  if num == 0: # 0!
    return 1
  
  child = recursion(num - 1)
  return num * child

print(recursion(N))
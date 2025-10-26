n = int(input())

def recursion(depth, n1, n2):
  if depth == n:
    return n1
  
  nxt = n1 + n2
  return recursion(depth + 1, n2, nxt)

print(recursion(0, 0, 1))
import sys
input = sys.stdin.readline

n = int(input())
digit = 10

while n >= digit:
  r = n % digit
  half = digit // 2
  
  if r >= half:
    n = n - r + digit
  else:
    n = n - r
  
  digit *= 10
print(n)
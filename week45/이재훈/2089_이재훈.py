import sys
input = sys.stdin.readline

N = int(input())

if N == 0:
  print(0)
else:
  res = ""
  while N != 0:
    remainder = N % 2
    res = str(remainder) + res
    N = (N - remainder) // -2

  print(res)

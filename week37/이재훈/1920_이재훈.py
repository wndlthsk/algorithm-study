N = int(input())
Ai = set(map(int, input().split()))
M = int(input())
exist = list(map(int, input().split()))

for e in exist:
  print(1 if e in Ai else 0)
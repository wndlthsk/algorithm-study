from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
seqA = list(map(int, input().split()))
seqB = list(map(int, input().split()))

qs = deque()
for i in range(N):
  if seqA[i] == 0:      # 큐인 경우만 의미 있음
    qs.append(seqB[i])

M = int(input())
seqC = list(map(int, input().split()))

res = []
for x in seqC:
  qs.appendleft(x)
  res.append(qs.pop())

print(*res)

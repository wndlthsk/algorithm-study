N = int(input())
Ai = list(map(int, input().split()))

d = {}
for x in Ai:
  d[x] = d.get(x, 0) + 1

res = [-1] * N
stk = [] # 인덱스 스택
for idx in range(N):
  while stk and d[Ai[idx]] > d[Ai[stk[-1]]]:
    top = stk.pop()
    res[top] = Ai[idx]
  stk.append(idx)
print(*res)
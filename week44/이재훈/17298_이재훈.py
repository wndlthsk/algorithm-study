N = int(input())
Ai = list(map(int, input().split()))

res = [-1] * N
stack = []  # 아직 오큰수를 못 찾은 인덱스들

for i in range(N):
  while stack and Ai[stack[-1]] < Ai[i]:
    idx = stack.pop()
    res[idx] = Ai[i]
  stack.append(i)
print(*res)
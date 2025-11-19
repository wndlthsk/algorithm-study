N, M = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

i = j = 0
ans = []

while i < N and j < M:
  if A[i] <= B[j]:
    ans.append(A[i])
    i += 1
  else:
    ans.append(B[j])
    j += 1

# 남은 부분 추가
ans.extend(A[i:])
ans.extend(B[j:])

print(*ans)
N, S = map(int, input().split())
seq = list(map(int, input().split()))

cnt = 0
def dfs(prevIdx, sequence):
  global cnt
  if sum(sequence) == S and sequence:  # 빈 수열 제외
    cnt += 1
  
  for i in range(prevIdx + 1, N):  # 이전 인덱스 다음부터 선택
    dfs(i, sequence + [seq[i]])
dfs(-1, [])
print(cnt)

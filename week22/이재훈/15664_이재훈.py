N, M = map(int, input().split())
seq = sorted(list(map(int, input().split())))  # 사전순 출력을 위해 정렬

result = []
def dfs(start, path):
  if len(path) == M:
    print(' '.join(map(str, path)))
    return

  prev = -1  # 직전 숫자 기억
  for i in range(start, N):
    if seq[i] == prev:
      continue  # 중복 제거
    prev = seq[i]
    dfs(i + 1, path + [seq[i]])
dfs(0, [])
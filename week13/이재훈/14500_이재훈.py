import sys
sys.setrecursionlimit(10000)

N, M = map(int, input().split())
paper = [list(map(int, input().split())) for _ in range(N)]

visited = [[False] * M for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

max_sum = 0

# 1️⃣ DFS로 4칸 탐색
def dfs(x, y, depth, total):
  global max_sum

  if depth == 4:
    max_sum = max(max_sum, total)
    return
  
  for dir in range(4):
    nx = x + dx[dir]
    ny = y + dy[dir]

    if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny]:
      visited[nx][ny] = True
      dfs(nx, ny, depth + 1, total + paper[nx][ny])
      visited[nx][ny] = False

# 2️⃣ ㅗ 모양 별도 처리
def check_extra(x, y):
  global max_sum
  # 현재 칸 + 주변 3칸 합
  wings = []
  total = paper[x][y]
  for dir in range(4):
    nx = x + dx[dir]
    ny = y + dy[dir]
    if 0 <= nx < N and 0 <= ny < M:
      wings.append(paper[nx][ny])
  
  if len(wings) >= 3:
    wings.sort(reverse=True)
    total += wings[0] + wings[1] + wings[2]
    max_sum = max(max_sum, total)

# 메인 루프
for i in range(N):
  for j in range(M):
    # dfs 시작
    visited[i][j] = True
    dfs(i, j, 1, paper[i][j])
    visited[i][j] = False

    # ㅗ 모양 확인
    check_extra(i, j)

print(max_sum)

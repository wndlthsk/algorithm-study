N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

dirs = [(0,0), (1,0), (-1,0), (0,1), (0,-1)]

def cost(x, y):
    """(x,y)를 중심으로 꽃 심을 수 있으면 비용 리턴, 아니면 INF"""
    visited = []
    total = 0
    for dx, dy in dirs:
        nx, ny = x + dx, y + dy
        if not (0 <= nx < N and 0 <= ny < N):  # 범위 밖
            return float('inf')
        if (nx, ny) in visited:  # 겹침
            return float('inf')
        visited.append((nx, ny))
        total += board[nx][ny]
    return total

res = float('inf')

# 꽃 3개 심을 수 있는 모든 조합 탐색
for i in range(1, N-1):
  for j in range(1, N-1):
    for k in range(1, N-1):
      for l in range(1, N-1):
        for a in range(1, N-1):
          for b in range(1, N-1):
            # 각각 꽃 심기
            c1 = cost(i, j)
            c2 = cost(k, l)
            c3 = cost(a, b)
            
            # 세 꽃 위치가 서로 겹치는지 확인
            if c1 == float('inf') or c2 == float('inf') or c3 == float('inf'):
              continue
            
            s1 = set((i+dx, j+dy) for dx, dy in dirs)
            s2 = set((k+dx, l+dy) for dx, dy in dirs)
            s3 = set((a+dx, b+dy) for dx, dy in dirs)
            
            if s1 & s2 or s2 & s3 or s1 & s3: # 교집합 연산
              continue
            
            res = min(res, c1 + c2 + c3)
print(res)
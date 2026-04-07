from collections import deque

def solution(land):
    n = len(land)
    m = len(land[0])
    
    visited = [[False] * m for _ in range(n)]
    col_sum = [0] * m
    
    def bfs(r, c):
        q = deque([(r, c)])
        visited[r][c] = True
        
        size = 1
        cols = set([c])
        
        while q:
            x, y = q.popleft()
            
            for dx, dy in [(0,1),(0,-1),(1,0),(-1,0)]:
                nx, ny = x + dx, y + dy
                
                if 0 <= nx < n and 0 <= ny < m:
                    if not visited[nx][ny] and land[nx][ny] == 1:
                        visited[nx][ny] = True
                        q.append((nx, ny))
                        size += 1
                        cols.add(ny)
        
        for col in cols:
            col_sum[col] += size
    
    for i in range(n):
        for j in range(m):
            if land[i][j] == 1 and not visited[i][j]:
                bfs(i, j)
    
    return max(col_sum)
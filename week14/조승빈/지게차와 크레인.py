from collections import deque
def bfs(x,y,row,col,dp):
    q = deque()
    nx = [-1,1,0,0]
    ny = [0,0,-1,1]
    tmp = []
    q.append((x,y))
    vis = [[0 for _ in range(col)]for _ in range(row)]
    vis[x][y] = 1
    while q:
        x,y = q.popleft()
        if x== row-1 or x== 0 or y==col-1 or y==0:
            return 1

        for i in range(4):
            px = x + nx[i]
            py = y + ny[i]
            if  px<0 or px>= row or py<0 or py>=col:
                continue
            if dp[px][py] == 1 and vis[px][py] == 0:
                vis[px][py] = 1
                q.append((px,py))
    return 0
def solution(storage, requests):
    answer = 0
    graph = []
    
    for s in storage:
        graph.append(list(s))
    row = len(graph)
    col = len(graph[0])
    dp = [[0 for _ in range(col)]for _ in range(row)]
    
    for req in requests:
        word = list(set(req))[0]
        flag = len(req)
        tmp = []
        for r in range(row):
            for c in range(col):
                if graph[r][c] == word and dp[r][c] == 0:
                    if flag >1 :
                        answer+=1
                        dp[r][c] = 1
                    elif flag == 1:
                        tmp.append((r,c))
        record = []
        for t in tmp:
            x,y  = t
            if bfs(x,y,row,col,dp) == 1:
                record.append((x,y))
                answer+=1
        for rec in record:
            dp[rec[0]][rec[1]] = 1
        
    return row*col - answer
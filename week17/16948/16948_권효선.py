
COPY
#BFS
import sys
from collections import deque
 
#체스판의 크기 입력 받기
n = int(sys.stdin.readline())
#체스판에 모든 값을 -1으로 설정해서 만들기
graph = [[-1 for _ in range(n)] for _ in range(n)]
#r1,c1,r2,c2 입력 받기
r1,c1,r2,c2=map(int,sys.stdin.readline().split())
 
#데스나이트가 이동할 수 있는 방법
d = [(-2, -1), (-2, 1), (0, -2), (0, 2), (2, -1), (2, 1)]
 
def bfs(r1,c1):
    #큐 구현
    queue = deque()
    #큐에 r1,c2 집어 넣기
    queue.append((r1,c1))
    #0으로 설정
    graph[r1][c1]=0
    while queue:#큐가 빌때까지
        r1,c1 = queue.popleft()#큐에서 꺼냄
        for dr,dc in d:
            nr = r1+dr
            nc = c1+dc
            #넣은 값이 체스판을 넘어 가는 경우 무시
            if nr<0 or nc<0 or nr>=n or nc>=n:
                continue
            #체스판에 처음 접근 한 경우에만 방금 있었던 이동 거리 +1 && 큐에 삽입
            if graph[nr][nc]==-1:
                graph[nr][nc]=graph[r1][c1]+1
                queue.append((nr,nc))
 
#함수 실행
bfs(r1,c1)
print(graph[r2][c2])

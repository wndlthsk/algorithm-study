from collections import deque
N = int(input())
vis = [[0 for _ in range(1001)]for _ in range(1001)]
q = deque()
vis[1][0] = 1
q.append((1,0,0))
while q:
    screen,clip,cnt = q.popleft()
    if screen == N:
        print(cnt)
        break
    if vis[screen][screen] == 0:
        vis[screen][screen] = 1
        q.append((screen,screen,cnt+1))
    if screen+clip<=1000 and vis[screen+clip][clip] == 0: 
        vis[screen+clip][clip] = 1
        q.append((screen+clip,clip,cnt+1))
    if screen-1 >= 1 and vis[screen-1][clip] == 0: 
        vis[screen-1][clip] = 1
        q.append((screen-1,clip,cnt+1))

    
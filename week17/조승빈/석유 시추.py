from collections import deque
def solution(land):
    answer = 0
    ans ={}
    q= deque()
    nx = [-1,1,0,0]
    ny = [0,0,-1,1]
    mapX = len(land)
    mapY = len(land[0])
    arr = [0]* mapY
    for x in range(mapX):
        for y in range(mapY):
            if land[x][y] == 1:
                cnt = 0
                location=[]
                location.append((x,y))
                land[x][y] = 0
                q.append((x,y))
                #bfs로 한덩어리의 석유량을 계산
                while q:
                    pX,pY= q.popleft()
                    land[pX][pY] = 0 #방문처리
                    cnt+=1
                    for i in range(4):
                        moveX = pX+nx[i]
                        moveY = pY+ny[i]
                        if moveX<0 or moveX >= mapX or moveY<0 or moveY>=mapY:
                            continue
                        if land[moveX][moveY] == 1:
                            q.append((moveX,moveY))
                            land[moveX][moveY] = 0 #방문처리를 할 때 꼭 넣을때 해라
                            location.append((moveX,moveY))
               
                memo = set()
                for i in location:
                    pox,poy =i
                    if poy not in memo: #같은(중복된 열이면) 스킵
                        memo.add(poy)
                        arr[poy]+=cnt
        
    return max(arr)
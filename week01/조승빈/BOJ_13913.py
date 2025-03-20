from collections import deque
path = [-1] * 100001
memo=[0] * 100001
n,m = map(int, input().split())
q=deque()
q.append((n,0))
answer = []
memo[n] = 1
while q:
    pos,time= q.popleft()
    
    if pos== m:
        print(time)
        while path[pos] != -1:
            
            answer.append(pos)
            pos = path[pos]
        answer.append(n)
        for a in reversed(answer):
            print(a,end=" ")
        print()
        break
    if 0<=pos*2<=100000 and memo[pos*2] ==0:
        path[pos*2] = pos
        memo[pos*2]= 1
        q.append((pos*2,time+1))
    if 0<=pos-1<=100000 and memo[pos-1] ==0:
        path[pos-1] = pos
        memo[pos-1]= 1
        q.append((pos-1,time+1))
    if 0<=pos+1<=100000 and memo[pos+1] ==0:
        path[pos+1] = pos
        memo[pos+1]= 1
        q.append((pos+1,time+1))
    
    

from collections import deque

def solution(progresses, speeds):
    answer = []
    
    q = deque()
    for p, s in zip(progresses, speeds):
        day = (100 - p + s - 1) // s
        q.append(day)
    
    while q:
        deploy = q.popleft()
        count = 1
        
        while q and q[0] <= deploy:
            q.popleft()
            count += 1
        
        answer.append(count)
    
    return answer
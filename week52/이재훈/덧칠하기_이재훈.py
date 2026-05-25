def solution(n, m, section):
    paints = [True] * n
    for x in section:
        paints[x-1] = False
    
    cnt = 0
    for idx in range(n):
        if paints[idx]:
            continue
        
        paints[idx:idx+m] = [True] * m
        cnt += 1
    
    return cnt
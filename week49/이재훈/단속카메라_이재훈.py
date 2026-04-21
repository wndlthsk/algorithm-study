def solution(routes):
    srt = sorted(routes, key=lambda x: (x[1], x[0]))
    
    cnt = 0
    curIndex = float('-inf')
    for s, e in srt:
        if curIndex < s:
            curIndex = e
            cnt += 1
    
    return cnt
def solution(t, p):
    n = len(p)
    cnt = 0
    for i in range(0, len(t) - n + 1):
        substr = t[i : i+n]
        if int(substr) <= int(p):
            cnt += 1
    
    return cnt
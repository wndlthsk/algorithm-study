def solution(d, budget):
    srt = sorted(d)
    
    cnt = 0
    acc = 0
    for x in srt:
        if acc + x <= budget:
            acc += x
            cnt += 1
    
    return cnt
def solution(lines):
    cm = 0
    for x in range(-100, 101):
        cnt = 0
        for s, e in lines:
            if s <= x < e:
                cnt += 1
        
        if cnt >= 2:
            cm += 1
    
    return cm
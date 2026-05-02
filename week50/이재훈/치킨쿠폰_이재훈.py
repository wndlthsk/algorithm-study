def solution(chicken):
    cnt = 0
    while chicken >= 10:
        tmp = chicken // 10
        cnt += tmp
        
        chicken = (chicken % 10) + tmp
        
    return cnt
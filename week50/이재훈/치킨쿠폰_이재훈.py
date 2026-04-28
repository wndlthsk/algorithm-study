def solution(chicken):
    cnt = 0
    
    while chicken >= 10:
        new = chicken // 10
        cnt += new
        chicken = new + (chicken % 10)
    
    return cnt
def solution(num):
    if num == 1: return 0

    digit = num
    cnt = 0
    while digit != 1:
        if cnt > 500:
            return -1

        if digit % 2 == 0:
            digit = digit // 2
        else:
            digit = digit * 3 + 1
        
        cnt += 1
    
    return cnt
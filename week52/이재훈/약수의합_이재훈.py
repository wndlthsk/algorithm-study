def solution(n):
    res = 0
    num = n
    while num > 0:
        if n % num == 0:
            res += num
        num -= 1
    
    return res
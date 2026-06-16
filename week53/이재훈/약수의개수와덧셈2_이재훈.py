def solution(left, right):
    res = 0
    for num in range(left, right+1):
        root = int(num ** 0.5)
        if root ** 2 == num:
            res -= num
        else:
            res += num
    
    return res
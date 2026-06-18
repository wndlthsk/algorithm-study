def solution(a, b):
    res = 0
    for x, y in zip(a, b):
        res += x * y
    
    return res
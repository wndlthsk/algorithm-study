def solution(a, b):
    if a > b:
        a, b = b, a
    if a == b:
        return a
    
    n = b - a   # 항의 개수: n + 1
    return a * (n + 1) + n*(n+1)//2
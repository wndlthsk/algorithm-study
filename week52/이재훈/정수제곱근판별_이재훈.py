def solution(n):
    sqrt = int(n ** 0.5)
    if sqrt ** 2 == n:
        return (sqrt + 1) ** 2
        
    return -1
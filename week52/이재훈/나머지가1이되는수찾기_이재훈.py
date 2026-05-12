def solution(n):
    x = n
    min_x = float('inf')
    while x > 1:
        x -= 1
        
        if n % x == 1:
            min_x = min(min_x, x)
    
    return min_x
def solution(n):
    target = bin(n).count('1')
    
    while True:
        n += 1
        
        if bin(n).count('1') == target:
            return n
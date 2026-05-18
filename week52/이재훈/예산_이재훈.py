def solution(d, budget):
    d.sort()
    
    cnt = 0
    total = 0
    
    for price in d:
        total += price
        
        if total > budget:
            break
            
        cnt += 1
    
    return cnt
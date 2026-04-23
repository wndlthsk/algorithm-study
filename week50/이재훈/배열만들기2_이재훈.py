def solution(l, r):
    order = {'0', '5'}
    
    res = []
    i = l
    while i <= r:
        if set(str(i)) <= order:
            res.append(i)
        i += 1
    
    if not res:
        res = [-1]
    
    return res
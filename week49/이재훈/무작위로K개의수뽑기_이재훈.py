def solution(arr, k):    
    res = []
    for el in arr:
        if el not in res:
            res.append(el)
            
            if len(res) == k:
                break
    
    while len(res) < k:
        res.append(-1)
    
    return res

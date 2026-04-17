def solution(arr, queries):
    res = []
    for s, e, k in queries:
        cur = -1
        tmp = []
        for el in arr[s:e+1]:
            if el > k:
                tmp.append(el)
        if tmp:
            cur = min(tmp)
        
        res.append(cur)
    
    return res
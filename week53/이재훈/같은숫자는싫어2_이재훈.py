def solution(arr):
    res = []
    prev = ''
    for x in arr:
        if prev != x:
            res.append(x)
        prev = x
    
    return res
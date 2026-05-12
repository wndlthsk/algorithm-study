def solution(arr, divisor):
    res = []
    for x in arr:
        if x % divisor == 0:
            res.append(x)
    
    return sorted(res) if res else [-1]
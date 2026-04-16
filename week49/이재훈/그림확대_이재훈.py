def solution(picture, k):
    res = []
    def mul(cur):
        tmp = []
        for x in cur:
            tmp.append(k * x)
        
        for _ in range(k):
            res.append(''.join(tmp))
        
    for p in picture:
        mul(p)

    return res

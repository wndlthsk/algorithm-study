def solution(a, b, c, d):
    l = [a, b, c, d]
    
    d = {}
    for x in l:
        d[x] = d.get(x, 0) + 1
    
    if len(d) == 1:
        return a * 1111
    elif len(d) == 2:
        num = []
        for k, cnt in d.items():
            num.append((cnt, k))
        
        srt = sorted(num)
        if srt[0][0] == 1:
            p, q = srt[1][1], srt[0][1]
            return (10 * p + q) ** 2
        else:
            p, q = srt[0][1], srt[1][1]
            return (p + q) * abs(p - q)
    elif len(d) == 3:
        num = []
        for k, v in d.items():
            if v == 2:
                continue
            num.append(k)
        return num[0] * num[1]
    elif len(d) == 4:
        return min(l)
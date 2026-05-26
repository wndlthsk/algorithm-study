def solution(s):
    res = []
    idx = 0
    for ch in s:
        if ch == ' ':
            res.append(ch)
            idx = 0
            continue
            
        if idx % 2 == 0:
            res.append(ch.upper())
        else:
            res.append(ch.lower())
        
        idx += 1
        
    return ''.join(res)
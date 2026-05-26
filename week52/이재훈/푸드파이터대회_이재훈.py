def solution(food):
    res = ''
    for i, v in enumerate(food):
        if i == 0:
            continue
        
        res += str(i) * (v//2)
    
    return '0'.join([res, res[::-1]])
def solution(absolutes, signs):
    res = 0
    for num, s in zip(absolutes, signs):
        if s:
            res += num
        else:
            res -= num
    
    return res
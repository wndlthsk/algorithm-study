def solution(array, commands):
    res = []
    for x in commands:
        i, j, k = x
        srt = sorted(array[i-1:j])
        res.append(srt[k-1])
    
    return res